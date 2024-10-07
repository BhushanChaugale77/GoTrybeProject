package com.gotrybe.tour.exception;

public class TourNotFoundException extends RuntimeException {

	public TourNotFoundException() {
		super();
 	}

	public TourNotFoundException(String message, Throwable cause) {
		super(message, cause);
 	}

	public TourNotFoundException(String message) {
		super(message);
 	}

	public TourNotFoundException(Throwable cause) {
		super(cause);
 	}

}
