package com.spring.research.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.research.CricketCoach;

public class SetterDempApp {

	public static void main(String[] args) {
		
		//load the spring configuration file 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve the bean from the container 
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		// close the context
		context.close();

	}

}
