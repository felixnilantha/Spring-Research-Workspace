package com.spring.research.aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "Traffic condition for the day .. ";
	}

	public String getFortune(boolean throwError) {
		
		if(throwError) {
			throw new RuntimeException("Runtime exception thrown..." + TrafficFortuneService.class);
		}
		
		return getFortune();
	}

}
