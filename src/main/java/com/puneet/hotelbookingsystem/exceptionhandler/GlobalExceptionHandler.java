package com.puneet.hotelbookingsystem.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// This class has the handler code for the exceptions of hotel booking system project (controller advice uses AOP to intercept requests before / after it reaches / exits the controller class)
@ControllerAdvice
public class GlobalExceptionHandler {

	// This method handles the Hotel Not Found Exception
	@ExceptionHandler
	public ResponseEntity<HotelErrorResponse> handleException(HotelNotFoundException e) {
		
		// Create new Hotel Error Response object
		HotelErrorResponse error = new HotelErrorResponse();
		
		// Set the properties
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// Return new Response Entity with error object and status code
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	// This method handles all the generic exceptions
	@ExceptionHandler
	public ResponseEntity<HotelErrorResponse> handleException(Exception e) {

		// Create new Hotel Error Response object
		HotelErrorResponse error = new HotelErrorResponse();
		
		// Set the properties
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// Return new Response Entity with error object and status code
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
