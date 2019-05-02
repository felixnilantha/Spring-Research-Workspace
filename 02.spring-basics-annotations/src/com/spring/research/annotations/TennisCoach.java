package com.spring.research.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spring.research.annotations.interfaces.Coach;
import com.spring.research.annotations.interfaces.FortuneService;

/* 
 	@Component("tennisCoach") 
 	removed explicit bean id will make spring use the default
	bean id which is the same name as the class name with the 
	lower case first letter 	
	*/
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	public TennisCoach() {
		System.out.println("TennisCoach::inside default constructor !!");
	}

	/*
	 * @Autowired public TennisCoach(FortuneService fortuneService) {
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println("TennisCoach :: inside setFortuneService !!");
	 * this.fortuneService = fortuneService; }
	 */
	
	//@Autowired
	public void doSomething(FortuneService fortuneService) {
		System.out.println("TennisCoach :: inside doSomething !! () method");
		this.fortuneService = fortuneService;
	}
	
	// define init method
	@PostConstruct
	public void doStartUp() {
		System.out.println("TennisCoach: inside doStartp method ->()" );
		
	}
	
	
	// define destroy method
	@PreDestroy
	public void doCleanUp() {
		System.out.println("TennisCoach: inside doCleanUp method ->()" );
	}
	

}
