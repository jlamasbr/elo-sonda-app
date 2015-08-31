package br.com.elo.sonda.api.error;

public class BadRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final String code;
	private final Object[] messageParams;
	
	public BadRequestException(String code, Object ... messageParams) {
		this.code = code;
		this.messageParams = messageParams;
	}

	public String getCode() {
		return code;
	}

	public Object[] getMessageParams() {
		return messageParams;
	}
	
	
	
}
