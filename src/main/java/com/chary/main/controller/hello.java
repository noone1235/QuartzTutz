package com.chary.main.controller;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class hello implements Job {

	private static final Logger log=LoggerFactory.getLogger(hello.class);
	
	@Override
	public void execute(JobExecutionContext context) {
		//System.out.println("Hello World");
		log.info("Hello World");
	}
	
}
