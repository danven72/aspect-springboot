package com.example.demo.aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;


@Aspect
public class LogBeginEndControllerAspect extends AbstractLogBeginEndLogic {

	private final static String EXEC_POINT_CONTROLLER = "execution(public * "+COMMON_PACKAGES+".controller.*.*(..))";
		
	
	public LogBeginEndControllerAspect(Logger logger) {
		super(logger);
	}
	
	@Override
	@Before(EXEC_POINT_CONTROLLER)
	public void printBegin(JoinPoint joinPoint) {		
		super.printBegin(joinPoint);
	}
	
	@Override
	@After(EXEC_POINT_CONTROLLER)
	public void printEnd(JoinPoint joinPoint) {
		
		super.printEnd(joinPoint);
	}
	
}
