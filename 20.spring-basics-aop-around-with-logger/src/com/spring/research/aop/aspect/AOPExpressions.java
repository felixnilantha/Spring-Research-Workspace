package com.spring.research.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

	@Pointcut("execution(* com.spring.research.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.spring.research.aop.dao.*.get*(..))")
	public void getter() {
	}

	@Pointcut("execution(* com.spring.research.aop.dao.*.set*(..))")
	public void setter() {
	}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void excludeGetterSetter() {
	}

}
