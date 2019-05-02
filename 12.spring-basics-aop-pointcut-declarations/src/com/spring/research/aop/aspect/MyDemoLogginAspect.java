package com.spring.research.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	@Pointcut("execution(* com.spring.research.aop.dao.*.*(..))")
	private void forDaoPackage() {
	}

	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n =======>>> Executing @Before Advice on addAccount()");

	}
	
	@Before("forDaoPackage()")
	public void perfomApiAnalytics() {
		System.out.println("\n =======>>> Performing API analytics");
	}

}
