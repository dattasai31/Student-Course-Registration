package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
@Validated
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping("/view")
	public List<Student> viewAllStudents()
	{
		return service.viewAllStudents();
	}
	
	@GetMapping("/find/{id}")
	public Student findStudentByID(@PathVariable int id)
	{
		return service.findStudentByID(id);
	}
	
	@PostMapping("/add/{id}")
	public String addStudents(@PathVariable int id,@Valid @RequestBody Student s)
	{
		return service.addStudents(id, s);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		return service.deleteStudent(id);
	}
	
	@PutMapping("/update/{id}")
	public String updateStudent(@PathVariable int id,@Valid @RequestBody Student s)
	{
		return service.updateStudent(id, s);
	}
	
	@PatchMapping("/updatecourse/{id}/{coursename}")
	public String updateCourse(@PathVariable int id,@PathVariable String coursename)
	{
		return service.updateCourse(id, coursename);
	}
	
	@GetMapping("/studentbycourse/{coursename}")
	public List<Student> studentByCourseName(@PathVariable String coursename)
	{
		return service.studentByCourseName(coursename);
	}
	
	@GetMapping("/studentcount/{coursename}")
	public String countByCourse(@PathVariable String coursename)
	{
		return service.countByCourse(coursename);
	}
	
	@GetMapping("/count")
	public String count()
	{
		return service.count();
	}
	
	
	

}
