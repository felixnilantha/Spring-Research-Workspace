package com.spring.research.crud.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLogginAspect {

	// setup logger

	@SuppressWarnings("unused")
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declaration(s)
	@Pointcut("execution(* com.spring.research.crud.controller.*.*(..))")
	private void forControllerPackage() {

	}

	@Pointcut("execution(* com.spring.research.crud.service.*.*(..))")
	private void forControllerService() {

	}

	@Pointcut("execution(* com.spring.research.crud.dao.*.*(..))")
	private void forControllerDAO() {

	}

	@Pointcut("forControllerPackage() || forControllerService() || forControllerDAO()")
	private void foraAppFlow() {

	}

	// add @Before advice
	@Before("foraAppFlow()")
	public void before(JoinPoint theJoinPoint) {

		// display methods
		String theMethod = theJoinPoint.getSignature().toShortString();
		// display arguments
		myLogger.info("=============>> in @Before: calling method: " + theMethod + "\n");

		// get the arguments

		Object[] args = theJoinPoint.getArgs();

		// display the arguments
		for (Object tempArg : args) {
			myLogger.info("================>> arguments: " + tempArg + "\n");
		}
	}

	// add @After returning advice

	@AfterReturning(pointcut = "foraAppFlow()", returning = "theResult"

	)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {

		// display methods
		
		// display methods
		String theMethod = theJoinPoint.getSignature().toShortString();
		// display arguments
		myLogger.info("=============>> in @After Returning: calling method: " + theMethod + "\n");

		// display data returned
		myLogger.info("==============>> result: " + theResult + "\t\n");
		

	}

}
