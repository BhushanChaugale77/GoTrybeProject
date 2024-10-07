package com.gotrybe.booking.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.naming.ServiceUnavailableException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BookingNotFoundException.class)
	public ResponseEntity<Object> handleBookingNotFoundException(BookingNotFoundException ex, WebRequest request){
		Map<String, Object> errorDetails = new HashMap<>();
		
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("details", request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(InvalidBookiingException.class)
	public ResponseEntity<Object> handleInvalidBookingException(InvalidBookiingException ex, WebRequest request){
		Map<String, Object> errorDetails = new HashMap<>();
		
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("details", request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(ServiceUnavailableException.class)
	public ResponseEntity<Object> handleserviceUnavailableException(ServiceUnavailableException ex, WebRequest request){
		Map<String, Object> errorDetails = new HashMap<>();
		
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("details", request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.SERVICE_UNAVAILABLE);	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request){
		Map<String, Object> errorDetails = new HashMap<>();
		
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("details", request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
