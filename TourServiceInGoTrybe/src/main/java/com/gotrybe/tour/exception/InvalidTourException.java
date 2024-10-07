package com.gotrybe.tour.exception;

public class InvalidTourException extends RuntimeException {

	public InvalidTourException() {
		super();
 	}

	public InvalidTourException(String message, Throwable cause) {
		super(message, cause);
 	}

	public InvalidTourException(String message) {
		super(message);
 	}

	public InvalidTourException(Throwable cause) {
		super(cause);
 	}

}
