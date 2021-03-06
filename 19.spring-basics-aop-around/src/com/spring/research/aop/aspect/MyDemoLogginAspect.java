package com.spring.research.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.research.aop.dao.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {

	@Around("execution(* com.spring.research.aop.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=========>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// excecute the method
		Object result = theProceedingJoinPoint.proceed();
		
		
		// get end timestamp
		long end = System.currentTimeMillis(); 
		
		// compute the duration
		long duration = (long) ((end - begin)/1000.0);
		
		// bla bla bla
		
		System.out.println("\n==============> Duration: " + duration + " seconds");
		

		return result;
	}

	@After("execution(* com.spring.research.aop.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {

		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=========>> Executing @After (Finally) on method: " + method);

	}

	@AfterThrowing(pointcut = "execution(* com.spring.research.aop.dao.AccountDAO.findAccount(..))", throwing = "theExc")
	public void afterThrowingAccountService(JoinPoint theJoinPoint, Throwable theExc) {

		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=========>> Executing @AfterThrowing on method: " + method);
		// result
		System.out.println("\n=========>> Throwable: " + theExc);

	}

	@AfterReturning(pointcut = "execution(* com.spring.research.aop.dao.AccountDAO.findAccount(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=========>> Executing @AfterReturning on method: " + method);

		// result
		System.out.println("\n=========>> Result: " + result);

		// modify the data
		convertToUpperCase(result);

		System.out.println("\n=========>> Upper Case Result: " + result);

	}

	private void convertToUpperCase(List<Account> result) {

		for (Account tempAccount : result) {
			String theUpperCase = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperCase);

		}

	}

	@Before("com.spring.research.aop.aspect.AOPExpressions.excludeGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n =======>>> Executing @Before Advice on addAccount()");

		// dispaly the method signature

		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("Method : " + methodSignature.getReturnType());

		// display method arguments

		Object[] args = theJoinPoint.getArgs();

		for (Object tempArgs : args) {

			System.out.println(tempArgs);

			if (tempArgs instanceof Account) {
				Account theAccount = (Account) tempArgs;
				System.out.println("Account Name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}

		}

	}

}
