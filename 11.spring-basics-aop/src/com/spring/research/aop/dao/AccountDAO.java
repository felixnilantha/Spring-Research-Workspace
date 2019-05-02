package com.spring.research.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + "DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void doWork() {
		System.out.println(getClass() + ": DoWork()");
	}
	

}
