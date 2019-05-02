package com.spring.research.annotations;

import org.springframework.stereotype.Component;

import com.spring.research.annotations.interfaces.FortuneService;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return null;
	}

}
