package com.RestAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AnimalnotFoundException extends RuntimeException{
    
	public AnimalnotFoundException(String message) {
		super(message);
	}
}
