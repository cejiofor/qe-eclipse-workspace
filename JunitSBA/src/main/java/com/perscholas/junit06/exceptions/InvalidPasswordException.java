package com.perscholas.junit06.exceptions;

public class InvalidPasswordException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;
	
	public InvalidPasswordException() {};
	public InvalidPasswordException(String message) {
		super(message);
	}
}
