package com.example.demo.aspect.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.aspect.aspect.LogBeginEndControllerAspect;
import com.example.demo.aspect.aspect.LogBeginEndServiceAspect;


@Configuration
public class LoggerConfigurator {

	@Bean
	public Logger controllerLogger() {
		return LoggerFactory.getLogger("aspect-demo.logger.controller");
	}
	
	@Bean
	public Logger serviceLogger() {
		return LoggerFactory.getLogger("aspect-demo.logger.service");
	}

	@Bean
	public Logger executionTimeLogger() {
		return LoggerFactory.getLogger("exec.time.logger");
	}
	
	@Bean
	public LogBeginEndControllerAspect logBeginEndControllerAspect() {
		return new LogBeginEndControllerAspect(controllerLogger());
	}

	@Bean
	public LogBeginEndServiceAspect logBeginEndServiceAspect() {
		return new LogBeginEndServiceAspect(serviceLogger());
	}

}
