package com.spring.research.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name;

	private String serviceCode;

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass() + "DOING MY DB WORK: ADDING AN ACCOUNT");
	}

	public void doWork() {
		System.out.println(getClass() + ": DoWork()");
	}

	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
