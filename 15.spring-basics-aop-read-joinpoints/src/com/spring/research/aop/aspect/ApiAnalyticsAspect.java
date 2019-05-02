package com.spring.research.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {
	
	@Before("com.spring.research.aop.aspect.AOPExpressions.excludeGetterSetter()")
	public void perfomApiAnalytics() {
		System.out.println("\n =======>>> Performing API analytics");
	}

}
