package com.example.demo.aspect.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;

/**
 * Esempio di Aspect per Log Begin poi rifattorizzato, nonpiù usato
 * @author Danilo.Ventura
 *
 * @param <TLogger>
 */
@Aspect
public class LogBeginEndAspect<TLogger> {

	private final static String BEGIN = "BEGIN";
	private final static String END = "END";
	private final static String COMMON_PACKAGES = "com.example.demo.aspect";
	private final static String EXEC_POINT_CONTROLLER = "execution(public * "+COMMON_PACKAGES+".controller.*.*(..))";
	private final static String EXEC_POINT_SERVICES = "execution(public * "+COMMON_PACKAGES+".service.*.*(..))";
	
	private Logger logger;
	
	
	public LogBeginEndAspect(Logger logger) {
		this.logger = logger;
	}
	
	
	@Before(EXEC_POINT_CONTROLLER + " || " + EXEC_POINT_SERVICES)
	public void printBegin(JoinPoint joinPoint) {
		
		logger.info(buildPrintString(joinPoint, BEGIN));
	}
	
	@After(EXEC_POINT_CONTROLLER + " || " + EXEC_POINT_SERVICES)
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
