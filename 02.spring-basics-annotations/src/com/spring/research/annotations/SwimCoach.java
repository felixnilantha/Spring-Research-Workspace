package com.spring.research.annotations;

import org.springframework.beans.factory.annotation.Value;

import com.spring.research.annotations.interfaces.Coach;
import com.spring.research.annotations.interfaces.FortuneService;

public class SwimCoach implements Coach {
	
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	private FortuneService fortuneService;

	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up. !!!";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
	

}
