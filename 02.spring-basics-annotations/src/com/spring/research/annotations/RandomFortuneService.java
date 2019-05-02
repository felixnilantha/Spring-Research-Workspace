package com.spring.research.annotations;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.spring.research.annotations.interfaces.FortuneService;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data = {"Someone is looking up to you. Do not let that person down !!",
							 "No snowflake in an avalanche ever feels responsible !!",
							 "If you eat something and nobody sees you eat it, it has no calories !!",
							 "Three can keep a secret, if you get rid of two !!"};
	
	private Random random = new Random();

	@Override
	public String getFortune() {
		
		int index = random.nextInt(data.length);
		String theFortune = data[index];
		return theFortune;
	}

}
