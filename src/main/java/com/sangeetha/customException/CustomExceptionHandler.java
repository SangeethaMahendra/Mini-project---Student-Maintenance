package com.sangeetha.customException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<ErrorDetails> idNotFoundException(RecordNotFoundException ie , WebRequest wq )
	{
		ErrorDetails errorDetails = new ErrorDetails(ie.getMessage(), "404" , new Date());
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND); 
		
	}
}
