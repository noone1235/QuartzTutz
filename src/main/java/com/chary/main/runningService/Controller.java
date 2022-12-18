package com.chary.main.runningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private final MainService service;

	public Controller(MainService service) {
		this.service = service;
	}

	@RequestMapping("/helloWorld")
	public void runHelloWorld(){
		service.HelloWorldJob();
	}
}
