package com.gotrybe.notification.exception;

public class InvalidRequestException extends RuntimeException {

	public InvalidRequestException() {
		super();
 	}

	public InvalidRequestException(String message, Throwable cause) {
		super(message, cause);
 	}

	public InvalidRequestException(String message) {
		super(message);
 	}

}
