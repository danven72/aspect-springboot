package com.example.demo.aspect.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogExecutionTimeAspect {

	@Autowired
	private Logger executionTimeLogger;
	
	@Around("@annotation(com.example.demo.aspect.annotation.LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		 
	    Object proceed = joinPoint.proceed();
	 
	    long executionTime = System.currentTimeMillis() - start;
	 
	    executionTimeLogger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms");
	    
	    return proceed;
	}
	
}
