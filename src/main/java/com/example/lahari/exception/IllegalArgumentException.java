package com.example.lahari.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class IllegalArgumentException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6132848657696726298L;

	public IllegalArgumentException(String message){
        super(message);
    }
}
