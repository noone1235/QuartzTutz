package com.chary.main.runningService;

import org.quartz.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.main.TimerInfo.TimerInfo;
import com.chary.main.controller.hello;
import com.chary.main.timerServices.SchedulerService;

@Service
public class MainService {
	@Autowired
	private final SchedulerService scheduler;
	
	public MainService(SchedulerService scheduler) {
		this.scheduler=scheduler;
	}
	
	public void HelloWorldJob() {
	
		scheduler.schedule(hello.class);
	}
	
}
