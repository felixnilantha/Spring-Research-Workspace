package com.spring.research.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {

	

	@Before("com.spring.research.aop.aspect.AOPExpressions.excludeGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n =======>>> Executing @Before Advice on addAccount()");

	}

	
	
	

}
