package com.springboot.basics.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {

	@GetMapping("/")
	public String basic() {
		return "Spring Boot Basics  Start up page ...";
	}

}
