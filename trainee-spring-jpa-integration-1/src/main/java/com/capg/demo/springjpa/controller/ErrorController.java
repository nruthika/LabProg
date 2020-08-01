package com.capg.demo.springjpa.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.demo.springjpa.error.TraineeAlreadyExistsException;
import com.capg.demo.springjpa.error.TraineeNotFoundException;
import com.capg.demo.springjpa.model.ErrorResponse;

@RestControllerAdvice
public class ErrorController {
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {TraineeAlreadyExistsException.class})
	public ErrorResponse handleTraineeAlreadyExistsException(Exception ex , HttpServletRequest req)
	{
		return new ErrorResponse(new Date(),ex.getMessage(),HttpStatus.BAD_REQUEST.getReasonPhrase(),HttpStatus.BAD_REQUEST.ordinal(),req.getRequestURI().toString());
	}
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {TraineeNotFoundException.class})
	public ErrorResponse handleTraineeNotFoundException(Exception ex , HttpServletRequest req)
	{
		return new ErrorResponse(new Date(),ex.getMessage(),HttpStatus.BAD_REQUEST.getReasonPhrase(),HttpStatus.BAD_REQUEST.ordinal(),req.getRequestURI().toString());
	}

}
