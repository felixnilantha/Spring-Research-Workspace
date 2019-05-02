package com.spring.basics.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.basics.rest.entity.Student;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StudentController {

	@GetMapping("/students")
	public List<Student> getStudents(){

		List<Student> theStudents = new ArrayList<Student>();
		
		theStudents.add(new Student("Peter", "Drinkwater"));
		theStudents.add(new Student("Kevin", "Roothill"));
		theStudents.add(new Student("Simon", "Beautiful"));
		
		return theStudents;
	}
	


	
	
}
