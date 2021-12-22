package com.ibm.academia.apirest.ruleta.exceptions;

public class BadRequestException extends RuntimeException {

	

	public BadRequestException(String message) {
		
		super(message);
	}
	
	private static final long serialVersionUID = 3661382608651008240L;
}
