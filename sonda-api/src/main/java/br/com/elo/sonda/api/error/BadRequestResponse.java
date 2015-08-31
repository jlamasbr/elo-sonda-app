package br.com.elo.sonda.api.error;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BadRequestResponse {

	private String httpStatus = "400";

	@JacksonXmlElementWrapper(localName="errors")
	@JacksonXmlProperty(localName = "error")
	private List<ErrorVO> errors;

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	public List<ErrorVO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorVO> errors) {
		this.errors = errors;
	}

	@Override
	public String toString() {
		return "BadRequestResponse [httpStatus=" + httpStatus + ", errors=" + errors + "]";
	}
	
	

}
