package com.example.demo.aspect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.aspect.service.ExampleService;

@Controller
public class ExampleController1 {

	@Autowired
	private ExampleService exampleService;
	
	@GetMapping("first/service")
	public ResponseEntity<String> firstService(){
		String result = getExampleService().buildMessage("First");
		return ResponseEntity.ok(result);
	}
	
	private ExampleService getExampleService() {
		return exampleService;
	}
	
}
