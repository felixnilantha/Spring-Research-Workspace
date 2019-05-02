package com.spring.research.aop.aspect;

import org.aspectj.lang.JoinPoint;
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

	

	@Before("com.spring.research.aop.aspect.AOPExpressions.excludeGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n =======>>> Executing @Before Advice on addAccount()");
		
		// dispaly the method signature
		
		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Mthod : " + methodSignature.getReturnType());
		
		// display method arguments 
		
		Object[] args = theJoinPoint.getArgs();

		for (Object tempArgs: args) {
			
			System.out.println(tempArgs);
			
			if (tempArgs instanceof Account) {
				Account theAccount = (Account)tempArgs;
				System.out.println("Account Name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
			
		}
		
	}

	
	
	

}
