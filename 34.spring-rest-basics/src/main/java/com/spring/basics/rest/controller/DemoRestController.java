package com.spring.basics.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/test",  produces = "text/html;charset=UTF-8")
public class DemoRestController {

	@GetMapping("/hello")
	public String restDemo() {
		return "Demo rest controller !!";
	}

}
