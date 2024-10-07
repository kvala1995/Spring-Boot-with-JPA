package com.RestAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {
 
	@ExceptionHandler(AnimalnotFoundException.class)
	public ResponseEntity<ErrorMessage> generateIt(AnimalnotFoundException ex){
		ErrorMessage err = new ErrorMessage();
		err.setMessage(ex.getMessage());
		err.setCode("c0192");
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
}
