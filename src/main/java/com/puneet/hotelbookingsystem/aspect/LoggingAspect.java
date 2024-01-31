package com.puneet.hotelbookingsystem.aspect;

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

import com.puneet.hotelbookingsystem.dto.HotelDTO;
import com.puneet.hotelbookingsystem.entity.Hotel;

// This class has aspect oriented programming methods to log the details of the methods in the packages of the project
@Aspect
@Component
@Order(1)
public class LoggingAspect {

	// Initialize the logger
	private Logger logger = Logger.getLogger(getClass().getName());

	// This method advice executes after each method returns (it runs just before
	// the @After advice)
	@AfterReturning(pointcut = "com.puneet.hotelbookingsystem.aspect.HotelGeneralAopExpressions.forAppFlow()", returning = "result")
	public void afterReturningAdvice(JoinPoint joinPoint, List<HotelDTO> result) {

		// Log the method signature of the target method
		String method = joinPoint.getSignature().toShortString();
		logger.info("Executing @AfterReturning advice on method " + method);

		// Log the data returned by the target method
		logger.info("Result is " + result);

	}

	// This method executes before the execution of getListOfHotels method in
	// HotelService class (it runs before the @Before advice)
	@Around("execution(* com.puneet.hotelbookingsystem.service.HotelService.getListOfHotels(..))")
	public Object aroundGetListOfHotelsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		// Log the method signature of the target method
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("Executing @Around advice on method " + method);

		// Create an object to store the object returned after calling the target method
		Object result = null;

		try {
			// Call the target method
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {

			// Log the exception
			logger.severe("In Around advice, An exception occurred " + e);

			// result = "An exception occurred";

			// Re-throw the exception
			throw e;
		}

		// Log the returned object
		logger.info("Result " + result);

		// Return the object
		return result;
	}

	// This method executes after the getListOfHotels method in service package
	// throws an exception
	@AfterThrowing(pointcut = "execution(* com.puneet.hotelbookingsystem.service.HotelService.getListOfHotels(..))", throwing = "ex")
	public void afterReturningGetListOfHotelsAdvice(JoinPoint joinPoint, Throwable ex) {

		// Log the method signature
		String method = joinPoint.getSignature().toShortString();
		logger.info("Executing @AfterThrowing advice on method " + method);

		// Log the exception
		logger.severe("Exception is " + ex);

	}

	// This method executes after the getListOfHotels method in service package
	// finishes executing
	@After("execution(* com.puneet.hotelbookingsystem.service.HotelService.getListOfHotels(..))")
	public void afterGetListOfHotelsAdvice(JoinPoint joinPoint) {

		// Log the method signature of the target method
		String method = joinPoint.getSignature().toShortString();
		logger.info("Executing @After advice on method " + method);

	}

	// This method executes before each method of service package unless they are
	// getter and setters. It also logs the arguments if the object argument is
	// instance of Hotel
	@Before("com.puneet.hotelbookingsystem.aspect.HotelGeneralAopExpressions.forServicePackageNoGetterSetter()")
	public void beforeAddNewHotelAdvice(JoinPoint joinPoint) {

		// Log the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		logger.info("Executing @Before Advice on method " + methodSignature);

		// Get the arguments
		Object[] args = joinPoint.getArgs();

		// Loop through the arguments
		for (Object arg : args) {

			// If the argument is an instance of Hotel object, Log the hotel name and
			// location
			if (arg instanceof Hotel) {
				Hotel hotel = (Hotel) arg;
				logger.info(
						"Hotel name " + hotel.getHotel_name() + " and hotel locations is " + hotel.getHotel_location());
			}
		}

	}
}
