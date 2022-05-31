package org.serratec.java2backend.borracharia.exception;

public class CarroException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public CarroException() {
		super();
	}
	
	public CarroException(String message) {
		super(message);
	}
	

	public CarroException(String message, Exception cause) {
		super(message, cause);
	}
	
	public CarroException(Exception e) {
		super(e);
	}
	

}


