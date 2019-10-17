package com.perscholas.junit.exceptions;

public class MaximumQuantityExceededException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MaximumQuantityExceededException() {};
	public MaximumQuantityExceededException(String message) {
		super(message);
	}
}
