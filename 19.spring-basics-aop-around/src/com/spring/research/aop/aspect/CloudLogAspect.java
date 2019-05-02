package com.spring.research.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAspect {
	
	@Before("com.spring.research.aop.aspect.AOPExpressions.excludeGetterSetter()")
	public void logToCloud() {
		System.out.println("\n =======>>> Logging to Cloud");
	}

}
