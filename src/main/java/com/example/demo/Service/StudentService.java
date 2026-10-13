package com.example.demo.Service;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.ExceptionHandling.DuplicateStudentFound;
import com.example.demo.ExceptionHandling.NoStudentInCourse;
import com.example.demo.ExceptionHandling.StudentNotFound;
import com.example.demo.Model.Student;
@Service
public class StudentService {
	
	
	private Map<Integer,Student> student=new LinkedHashMap<>();
	
	public StudentService()
	{
		student.put(101, new Student(101,"Rahul","CSE","rahul@gmail.com",19));
		student.put(102, new Student(102,"Viraj","ECE","viraj@gmail.com",18));
		student.put(103, new Student(103,"Kiram","Civil","kiran@gmail.com",19));
	}
	
	// method to display all students
	public List<Student> viewAllStudents()
	{
		return new ArrayList<>(student.values());
	}
	
	// method to find student by ID
	public Student findStudentByID(int id)
	{
		Student s=student.get(id);
		if(s==null)
		{
			throw new StudentNotFound("No Student found with this ID");
		}
		return s;
	}
	
	// method to add students
	public String addStudents(int id,Student s)
	{
		if(student.containsKey(id))
		{
			throw new DuplicateStudentFound("Another student already registered with this ID");
		}
		s.setStudentID(id);
		student.put(id, s);
		return "Student registered successfully";
		
	}
	
	// method to delete student
	public String deleteStudent(int id)
	{
		Student s=findStudentByID(id);
		student.remove(id);
		return "Student record deleted successfully";
	}
	
	// method to update student details
	public String updateStudent(int id,Student s)
	{
		Student st=findStudentByID(id);
		s.setStudentID(id);
		student.put(id, s);
		return "Student details updated successfully";
	}
	
	// method to update course
	public String updateCourse(int id,String coursename)
	{
		Student stu=findStudentByID(id);
		stu.setCourseName(coursename);
		return "Student course details updated successfully";
	}
	
	// method to find student details who all are in same course
	public List<Student> studentByCourseName(String coursename)
	{
		List<Student> result=new ArrayList<>();
		for(Student s:student.values())
		{
			if(s.getCourseName().equalsIgnoreCase(coursename))
			{
				result.add(s);
			}
		}
		if(result.isEmpty())
		{
			throw new NoStudentInCourse("No student registered in this course");
		}
		return result;
	}
	
	// method to count number of students enrolled in a course
	public String countByCourse(String coursename)
	{
		int count=0;
		for(Student s:student.values())
		{
			if(s.getCourseName().equalsIgnoreCase(coursename))
			{
				count++;	
			}
		}
		return "Total students registered in this course: "+count;
	}
	
	// method to count the total number of students
	public String count()
	{
		return "Total number of students: "+student.size();
	}
	
	
	

}
