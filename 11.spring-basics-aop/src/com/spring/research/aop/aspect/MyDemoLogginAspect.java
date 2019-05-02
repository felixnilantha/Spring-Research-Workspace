package com.spring.research.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {

	// @Before("execution(public void
	// com.spring.research.aop.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	//	@Before("execution(void add*())")
	//@Before("execution(* add*(com.spring.research.aop.dao.Account))")
	//@Before("execution(* add*(com.spring.research.aop.dao.Account, ..))")
	//@Before("execution(* add*(..))")
	@Before("execution(* com.spring.research.aop.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n =======>>> Executing @Before Advice on addAccount()");

	}

}
