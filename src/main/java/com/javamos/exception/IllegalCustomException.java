package com.javamos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalCustomException extends IllegalArgumentException {
	public IllegalCustomException(String msg) {
		super(msg);
	}
}
