package com.spring.research;

import com.spring.research.interfaces.Coach;
import com.spring.research.interfaces.FortuneService;

public class BaseballCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;

	// define a constructor for dependency injection
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practise";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get the fortune
		return fortuneService.getFortune();
	}

}
