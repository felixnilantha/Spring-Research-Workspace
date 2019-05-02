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

	@Pointcut("execution(* com.spring.research.aop.dao.*.get*(..))")
	private void getter() {
	}

	@Pointcut("execution(* com.spring.research.aop.dao.*.set*(..))")
	private void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void excludeGetterSetter() {
	}

	@Before("excludeGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n =======>>> Executing @Before Advice on addAccount()");

	}

	@Before("excludeGetterSetter()")
	public void perfomApiAnalytics() {
		System.out.println("\n =======>>> Performing API analytics");
	}

}
