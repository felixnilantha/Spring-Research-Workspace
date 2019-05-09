package com.springboot.basics.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {
	
	@Value("${student.name}")
	private String studentName;
	@Value("${student.subject}")
	private String studentSubject;

	@GetMapping("/")
	public String basic() {
		return "Spring Boot Basics  Start up page ...";
	}
	@GetMapping("/reload")
	public String reload() {
		return "Spring Boot Basics  Reloading the page ...";
	}

	@GetMapping("/team/info")
	public String teamInfor() {
		return "Student " + studentName + " subject is " + studentSubject;
	}	
}
