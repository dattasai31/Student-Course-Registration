package com.example.demo.ExceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,String> handleFieldException(MethodArgumentNotValidException ex)
	{
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->
		{
			errors.put(error.getField(), error.getDefaultMessage());
		}
				);
		return errors;
	}
	
	@ExceptionHandler(StudentNotFound.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleStudentNotFoundException(StudentNotFound s)
	{
		return s.getMessage();
	}
	
	@ExceptionHandler(NoStudentInCourse.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleNoStudentInCourse(NoStudentInCourse n)
	{
		return n.getMessage();
	}
	
	@ExceptionHandler(DuplicateStudentFound.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleDuplicateStudentFound(DuplicateStudentFound d)
	{
		return d.getMessage();
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleGeneralException(Exception e)
	{
		return "Something went wrong";
	}
	

}
