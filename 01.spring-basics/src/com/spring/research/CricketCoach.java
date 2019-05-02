package com.spring.research;

import com.spring.research.interfaces.Coach;
import com.spring.research.interfaces.FortuneService;

public class CricketCoach implements Coach{

	private FortuneService fortuneService;
	
	private String emailAddress;
	
	private String team;
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practise fast bowling for 15 minutes";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	// for setter injection
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter constructor - setFortuneService");
		this.fortuneService = fortuneService;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter constructor - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter constructor - setTeam");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	
	
}
