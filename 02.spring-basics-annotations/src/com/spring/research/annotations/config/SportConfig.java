package com.spring.research.annotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.spring.research.annotations.SadFortuneService;
import com.spring.research.annotations.SwimCoach;
import com.spring.research.annotations.interfaces.Coach;
import com.spring.research.annotations.interfaces.FortuneService;

@Configuration
//@ComponentScan("com.spring.research.annotations")
@PropertySource("classpath:spring-research.propoerties")
public class SportConfig {
	
	
	// define bean for our sad fortune service
	// Method name is the bean id
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
		
	}

}
