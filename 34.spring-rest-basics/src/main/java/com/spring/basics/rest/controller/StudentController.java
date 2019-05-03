package com.spring.basics.rest.controller;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.basics.rest.entity.Student;
import com.spring.basics.rest.error.StudentErrorResponse;
import com.spring.basics.rest.error.StudentNotFoundException;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StudentController {

	private List<Student> theStudents;

	// load data
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();

		theStudents.add(new Student("Peter", "Drinkwater"));
		theStudents.add(new Student("Kevin", "Roothill"));
		theStudents.add(new Student("Simon", "Beautiful"));

	}

	@GetMapping("/students")
	public List<Student> getStudents() {

		return theStudents;
	}

	// end point for get a single stude
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// validate student against the list size

		if (studentId >= theStudents.size() || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}

		return theStudents.get(studentId);
	}
	
	

}
