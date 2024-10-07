package com.gotrybe.booking.exception;

public class InvalidBookiingException extends RuntimeException {

	public InvalidBookiingException() {
		super(); 
	}

	public InvalidBookiingException(String message, Throwable cause) {
		super(message, cause); 
	}

	public InvalidBookiingException(String message) {
		super(message); 
	}

	public InvalidBookiingException(Throwable cause) {
		super(cause); 
	}

	
	
}
