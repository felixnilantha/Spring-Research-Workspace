package com.spring.research.aop.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.research.aop.dao.Account;
import com.spring.research.aop.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		List<Account> theAccounts =null;
		try {
			boolean throwError = true;
			theAccounts = theAccountDAO.findAccount(throwError);
		} catch (Exception e) {
			System.out.println("\n\nMain Program caught exception:" + e);
		}

		// diplay

		System.out.println("\n\nMain Program: After Throwing Demo App");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");

		// close the context
		context.close();

	}

}
