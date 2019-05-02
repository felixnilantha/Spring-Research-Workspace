package com.spring.research.annotations;

import org.springframework.stereotype.Component;

import com.spring.research.annotations.interfaces.FortuneService;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Today is your lucky day !!";
	}

}
