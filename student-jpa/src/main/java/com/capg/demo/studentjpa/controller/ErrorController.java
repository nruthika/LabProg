package com.capg.demo.studentjpa.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.demo.studentjpa.exceptions.StudentAgeException;
import com.capg.demo.studentjpa.exceptions.StudentAlreadyExists;
import com.capg.demo.studentjpa.exceptions.StudentNotFoundException;
import com.capg.demo.studentjpa.model.ErrorResponse;

@RestControllerAdvice
public class ErrorController {
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {StudentNotFoundException.class})
	public ErrorResponse handleStudentNotFoundException(Exception ex , HttpServletRequest req)
	{
		return new ErrorResponse(new Date(),ex.getMessage(),HttpStatus.BAD_REQUEST.getReasonPhrase(),HttpStatus.BAD_REQUEST.ordinal(),req.getRequestURI().toString());
	}
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {StudentAlreadyExists.class})
	public ErrorResponse handleStudentAlreadyExistsException(Exception ex , HttpServletRequest req)
	{
		return new ErrorResponse(new Date(),ex.getMessage(),HttpStatus.BAD_REQUEST.getReasonPhrase(),HttpStatus.BAD_REQUEST.ordinal(),req.getRequestURI().toString());
	}
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {StudentAgeException.class})
	public ErrorResponse handleStudentAgeException(Exception ex , HttpServletRequest req)
	{
		return new ErrorResponse(new Date(),ex.getMessage(),HttpStatus.BAD_REQUEST.getReasonPhrase(),HttpStatus.BAD_REQUEST.ordinal(),req.getRequestURI().toString());
	}


}
