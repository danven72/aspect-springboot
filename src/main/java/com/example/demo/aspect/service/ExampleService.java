package com.example.demo.aspect.service;

import org.springframework.stereotype.Service;

import com.example.demo.aspect.annotation.LogExecutionTime;

@Service
public class ExampleService {
	
	@LogExecutionTime
	public String buildMessage(String whichService) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return whichService+" Service Result";
	}
}
