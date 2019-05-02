package com.spring.research.aop.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.research.aop.dao.Account;
import com.spring.research.aop.dao.AccountDAO;
import com.spring.research.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		Account myAccount = new Account();
		// call the business method

		System.out.println("\nAccount DAO\n");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("foobarServiceCode");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		System.out.println("\nName : " + name);
		System.out.println("\nService Code : " + code);

		System.out.println("\nMembership Account DAO\n");
		theMembershipDAO.addMember();
		theMembershipDAO.goToSleep();

		// close the context
		context.close();

	}

}
