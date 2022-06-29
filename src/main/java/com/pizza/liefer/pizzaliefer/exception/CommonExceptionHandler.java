package com.pizza.liefer.pizzaliefer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pizza.liefer.pizzaliefer.model.ErrorResponse;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> exception(Exception ex) {

		return new ResponseEntity<ErrorResponse>(new ErrorResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
