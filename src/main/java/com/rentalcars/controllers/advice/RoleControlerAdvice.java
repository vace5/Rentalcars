package com.rentalcars.controllers.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.rentalcars.exceptions.ErrorMessage;
import com.rentalcars.exceptions.RoleNotFoundException;

@ControllerAdvice
public class RoleControlerAdvice {

	  @ExceptionHandler(RoleNotFoundException.class)
	  public ResponseEntity<ErrorMessage> resourceNotFoundException(RoleNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        LocalDateTime.now(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }
	
}
