package com.gotrybe.notification.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super();
 	}

	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
 	}

	public ResourceNotFoundException(String message) {
		super(message);
 	}

}
