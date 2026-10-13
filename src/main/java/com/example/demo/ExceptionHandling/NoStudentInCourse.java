package com.example.demo.ExceptionHandling;

public class NoStudentInCourse extends RuntimeException{
	public NoStudentInCourse(String message)
	{
		super(message);
	}
	

}
