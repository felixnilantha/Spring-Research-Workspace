package com.spring.research.annotations.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.research.annotations.SwimCoach;
import com.spring.research.annotations.config.SportConfig;

public class SwimConfigDempApp {

	public static void main(String[] args) {

		// read spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		// call the method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("Email :" + theCoach.getEmail());
		System.out.println("Team :" + theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
