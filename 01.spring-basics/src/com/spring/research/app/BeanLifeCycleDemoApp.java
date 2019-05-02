package com.spring.research.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.research.interfaces.Coach;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file 
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beansLifeCycleApplicationContext.xml");
		
		// retrieve the bean for spring container
		
		Coach theCoach  = context.getBean("myCoach", Coach.class);
		
		
		System.out.println(theCoach.getDailyWorkout());
		
		context.close();
		
	}

}
