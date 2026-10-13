package com.example.demo.ExceptionHandling;

public class DuplicateStudentFound extends RuntimeException {
	public DuplicateStudentFound(String message)
	{
		super(message);
	}

}
