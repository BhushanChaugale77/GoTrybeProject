package com.gotrybe.notification.exception;

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

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
		Map<String,Object> errorDetails = new HashMap<>();
		
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("details", request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<Object> handleInvalidRequestException(InvalidRequestException ex, WebRequest request){
		Map<String,Object> errorDetails = new HashMap<>();
		
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("details", request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);		
	}
	
	@ExceptionHandler(ServiceUnavailableException.class)
	public ResponseEntity<Object> handleServiceUnavailableException(ServiceUnavailableException ex, WebRequest request){
		Map<String, Object> errorDetails = new HashMap<>();
		
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("details", request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGlobalException(Exception ex, WebRequest request){
		Map<String,Object> errorDetails = new HashMap<>();
		
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("details", request.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
