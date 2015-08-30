package br.com.elo.sonda.api.error.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.elo.sonda.api.error.response.BadRequestResponse;
import br.com.elo.sonda.api.error.response.Error;

/**
 * Controller para capturar as exceções lancadas pela api e encapsular elas em
 * uma mensagem amigavel para o client da api.
 * 
 * @author jlamas
 *
 */
@ControllerAdvice
public class ExceptionHandlerController {

	private static final Logger LOG = Logger.getLogger(ExceptionHandlerController.class);
	
	@Autowired
	MessageSource messages;

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody String handlerInternalServerError(Throwable t,HttpServletRequest request) throws IOException {
		LOG.error("EVT=InternalServerError");
		LOG.error("error on process request.",t);
		return "internalServerError";
	}

	/**
	 * Método que encapsula os erros de validacoes de api em uma mensagem
	 * padronizada para o client.
	 * 
	 * @param eMethodArgumentNotValidException
	 *            e - exception contendo todos os erros de validacao da
	 *            requisicao.
	 * @return {@link BadRequestResponse} response - resposta com todos os erros
	 *         e seus respectivos codigos.
	 * @throws IOException 
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody BadRequestResponse handlerBadRequest(MethodArgumentNotValidException e, HttpServletRequest request, @RequestBody Object requestBody) throws IOException {
		BadRequestResponse response = new BadRequestResponse();
		response.setErrors(buildErrorMessages(e));
		LOG.info("EVT=BadRequest, response=" + response);
		return response;
	}

	/**
	 * Método que encapsula erros ao realizar o parser do request do client da
	 * api.
	 * 
	 * @return {@link BadRequestResponse} response - resposta informando que o
	 *         ocorreu um erro de parser.
	 * @throws IOException 
	 */

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody BadRequestResponse handlerNotReadableException(HttpServletRequest request) throws IOException {
		BadRequestResponse response = new BadRequestResponse();
		Error error = new Error("0001", messages.getMessage("0001", null, LocaleContextHolder.getLocale()));
		response.setErrors(Arrays.asList(error));
		LOG.info("EVT=BadRequest, response=" + response);
		return response;
	}

	/**
	 * Método responsável por extrair e montar as mensagens que deverão ser
	 * exibidas na resposta de acordo com a exception de validacao. As mensagens
	 * são extraidas do arquivo messages.properties de acordo com o codigo
	 * passado no parametro message das anotatios do beanvalidation.
	 * 
	 * @param e
	 *            - Exception de validacao do bean validation contendo todos os
	 *            erros de validacao.
	 * @return - Lista contendo as mensagens e codigos de validacao.
	 */
	private List<Error> buildErrorMessages(MethodArgumentNotValidException e) {
		BindingResult bindingResult = e.getBindingResult();
		List<FieldError> errors = bindingResult.getFieldErrors();
		List<Error> apiErrors = new ArrayList<>();
		for (FieldError error : errors) {
			String message = messages.getMessage(error.getDefaultMessage(), error.getArguments(),
					LocaleContextHolder.getLocale());
			apiErrors.add(new Error(error.getDefaultMessage(), message));
		}
		return apiErrors;
	}
}
