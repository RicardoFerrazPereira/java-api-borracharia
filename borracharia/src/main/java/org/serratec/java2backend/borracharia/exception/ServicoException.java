package org.serratec.java2backend.borracharia.exception;

public class ServicoException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public ServicoException() {
		super();
	}
	
	public ServicoException(String message) {
		super(message);
	}
	
	public ServicoException(String message, Exception cause) {
		super(message, cause);
	}
	
	public ServicoException(Exception e) {
		super(e);
	}

}
