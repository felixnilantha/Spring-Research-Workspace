package com.spring.research.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.research.interfaces.Coach;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file 
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beansScopeApplicationContext.xml");
		
		// retrieve the bean for spring container
		
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alfaCoach = context.getBean("myCoach", Coach.class);
		
		// check if they are the same
		
		boolean result = (theCoach ==  alfaCoach);
		
		System.out.println("\nPoiting to the same object: " + result);
		System.out.println("\nMemory location for the coach: " + theCoach);
		System.out.println("\nMemory location for the alfaCoach: " + alfaCoach + "\n");
		
		context.close();
		
	}

}
