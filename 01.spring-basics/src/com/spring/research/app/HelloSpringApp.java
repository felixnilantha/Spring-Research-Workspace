package com.spring.research.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.research.interfaces.Coach;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve the bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);

		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call methods for fortune
		System.out.println(theCoach.getDailyFortune());
		// close the context
		context.close();

	}

}
