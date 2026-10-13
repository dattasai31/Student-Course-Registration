package com.example.demo.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private int studentID;
	@NotBlank(message="Student name cannot be empty")
	private String studentName;
	@NotBlank(message="Course name cannot be empty")
	private String courseName;
	@Email(message="Enter valid email")
	private String email;
	@Min(value=18,message="Student age must be 18 years")
	private int age;

}
