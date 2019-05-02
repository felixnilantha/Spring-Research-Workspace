package com.spring.research.annotations.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.research.annotations.interfaces.Coach;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve been from spring container
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alfaCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (theCoach == alfaCoach);
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for theCoach: " + theCoach);
		System.out.println("\nMemory location for alfaCoach: " + alfaCoach);
		
		// close context
		
		context.close();


	}

}
