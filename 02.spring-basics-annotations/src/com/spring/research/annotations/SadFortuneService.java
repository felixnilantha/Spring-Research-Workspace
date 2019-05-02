package com.spring.research.annotations;

import com.spring.research.annotations.interfaces.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Today is a not so lucky day !!!";
	}

}
