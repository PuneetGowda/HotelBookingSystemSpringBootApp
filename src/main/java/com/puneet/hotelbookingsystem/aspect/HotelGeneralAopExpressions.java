package com.puneet.hotelbookingsystem.aspect;

import org.aspectj.lang.annotation.Pointcut;

// This class has general pointcut expressions that can be used in Advice for AOP
public class HotelGeneralAopExpressions {

	// This pointcut expression is for all the methods in the controller package
	@Pointcut("execution(* com.puneet.hotelbookingsystem.controller.*.*(..))")
	public void forControllerPackage() {}
	
	// This pointcut expression is for all the methods in the service package
	@Pointcut("execution(* com.puneet.hotelbookingsystem.service.*.*(..))")
	public void forServicePackage() {}

	// This pointcut expression is for all the methods in the dao package
	@Pointcut("execution(* com.puneet.hotelbookingsystem.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// This pointcut expression is for all the methods in all the packages
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forAppFlow() {}
	
	// This pointcut expression is for all the getter methods
	@Pointcut("execution(* *.get*(..))")
	public void getter() {}
	
	// This pointcut expression is for all the setter methods
	@Pointcut("execution(* *.set*(..))")
	public void setter() {}
	
	// This pointcut expression is for all the methods in the service package except for getter and setter methods
	@Pointcut("forServicePackage() && !(getter() && setter())")
	public void forServicePackageNoGetterSetter() {}
}
