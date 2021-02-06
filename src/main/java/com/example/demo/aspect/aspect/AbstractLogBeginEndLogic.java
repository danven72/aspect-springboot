package com.example.demo.aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;


@Aspect
public abstract class AbstractLogBeginEndLogic {

	private final static String BEGIN = "BEGIN";
	private final static String END = "END";

	protected final static String COMMON_PACKAGES = "com.example.demo.aspect";
		
	protected Logger logger;
	
	
	protected AbstractLogBeginEndLogic(Logger logger) {
		this.logger = logger;
	}
	
	public void printBegin(JoinPoint joinPoint) {
		
		logger.info(buildPrintString(joinPoint, BEGIN));
	}
	
	public void printEnd(JoinPoint joinPoint) {
		
		logger.info(buildPrintString(joinPoint, END));
	}
	
	private String buildPrintString(JoinPoint joinPoint, String value) {
		StringBuilder sb = new StringBuilder();
		sb.append("[")
		  .append(joinPoint.getTarget().getClass().getName())
		  .append("]:: - ")
		  .append(joinPoint.getSignature().toShortString())
		  .append(" - ")
		  .append(value);
		
		return sb.toString();
	}

}
