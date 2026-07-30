package com.example.final_proj_training.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(
	        IllegalArgumentException ex) {

	    ErrorResponse error = new ErrorResponse(
	    		LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());

	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {

	    ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage());

	    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InsufficientStockException.class)
	public ResponseEntity<ErrorResponse> handleInsufficientStock(
	        InsufficientStockException ex) {

	    ErrorResponse error = new ErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), ex.getMessage());

	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {

	    ErrorResponse error = new ErrorResponse(
	            LocalDateTime.now(),
	            HttpStatus.INTERNAL_SERVER_ERROR.value(),"Something went wrong");

	    return new ResponseEntity<>(error,
	            HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateResource(
	        DuplicateResourceException ex) {

	    ErrorResponse error = new ErrorResponse(LocalDateTime.now(),
	            HttpStatus.CONFLICT.value(),
	            ex.getMessage()
	    );

	    return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
}
