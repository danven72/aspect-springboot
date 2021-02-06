package com.example.demo.aspect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.aspect.service.ExampleService;

@Controller
public class ExampleController2 {

	@Autowired
	private ExampleService exampleService;
	
	
	@GetMapping("second/service")
	public ResponseEntity<String> secondService(){
		String result = getExampleService().buildMessage("Second");
		return ResponseEntity.ok(result);
	}

	private ExampleService getExampleService() {
		return exampleService;
	}
	
}
