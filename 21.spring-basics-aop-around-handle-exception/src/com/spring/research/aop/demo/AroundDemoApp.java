package com.spring.research.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.research.aop.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theTrafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\n<==== Running with a delay ===>\n");
		
		String data = theTrafficFortuneService.getFortune();
		
		System.out.println("\nTraffic fortune : " + data);
		
		// close the context
		context.close();

	}

}
