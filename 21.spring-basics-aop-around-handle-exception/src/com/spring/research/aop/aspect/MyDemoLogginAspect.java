package com.spring.research.aop.aspect;

import java.util.List;
import java.util.logging.Logger;

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
	
	private static Logger myLogger = Logger.getLogger(MyDemoLogginAspect.class.getName());

	@Around("execution(* com.spring.research.aop.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=========>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// excecute the method
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			//myLogger.warning(e.getMessage());
			//result= "Log the custom message for the error, ....";
			
			// rethrow the exception
			throw e;
			
		}
		
		
		// get end timestamp
		long end = System.currentTimeMillis(); 
		
		// compute the duration
		long duration = (long) ((end - begin)/1000.0);
		
		// bla bla bla
		
		myLogger.info("\n==============> Duration: " + duration + " seconds");
		

		return result;
	}

	@After("execution(* com.spring.research.aop.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {

		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=========>> Executing @After (Finally) on method: " + method);

	}

	@AfterThrowing(pointcut = "execution(* com.spring.research.aop.dao.AccountDAO.findAccount(..))", throwing = "theExc")
	public void afterThrowingAccountService(JoinPoint theJoinPoint, Throwable theExc) {

		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=========>> Executing @AfterThrowing on method: " + method);
		// result
		myLogger.info("\n=========>> Throwable: " + theExc);

	}

	@AfterReturning(pointcut = "execution(* com.spring.research.aop.dao.AccountDAO.findAccount(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=========>> Executing @AfterReturning on method: " + method);

		// result
		myLogger.info("\n=========>> Result: " + result);

		// modify the data
		convertToUpperCase(result);

		myLogger.info("\n=========>> Upper Case Result: " + result);

	}

	private void convertToUpperCase(List<Account> result) {

		for (Account tempAccount : result) {
			String theUpperCase = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperCase);

		}

	}

	@Before("com.spring.research.aop.aspect.AOPExpressions.excludeGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n =======>>> Executing @Before Advice on addAccount()");

		// dispaly the method signature

		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("Method : " + methodSignature.getReturnType());

		// display method arguments

		Object[] args = theJoinPoint.getArgs();

		for (Object tempArgs : args) {

			myLogger.info(tempArgs.toString());

			if (tempArgs instanceof Account) {
				Account theAccount = (Account) tempArgs;
				myLogger.info("Account Name: " + theAccount.getName());
				myLogger.info("Account level: " + theAccount.getLevel());
			}

		}

	}

}
