package com.example.demo.aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;


@Aspect
public class LogBeginEndServiceAspect extends AbstractLogBeginEndLogic {

	private final static String EXEC_POINT_SERVICES = "execution(public * "+COMMON_PACKAGES+".service.*.*(..))";
		
	public LogBeginEndServiceAspect(Logger logger) {
		super(logger);
	}
		
	@Override
	@Before(EXEC_POINT_SERVICES)
	public void printBegin(JoinPoint joinPoint) {
		super.printBegin(joinPoint);
	}
	
	@Override
	@After(EXEC_POINT_SERVICES)
	public void printEnd(JoinPoint joinPoint) {
		
		super.printEnd(joinPoint);
	}
}
