package com.gotrybe.report.exception;

public class ReportNotFoundException extends RuntimeException {

	public ReportNotFoundException() {
		super();
 	}

	public ReportNotFoundException(String message, Throwable cause) {
		super(message, cause);
 	}

	public ReportNotFoundException(String message) {
		super(message);
 	}

	public ReportNotFoundException(Throwable cause) {
		super(cause);
 	}

	
	
}
