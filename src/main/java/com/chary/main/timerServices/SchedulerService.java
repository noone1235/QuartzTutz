package com.chary.main.timerServices;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.calendar.HolidayCalendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chary.main.TimerInfo.TimerInfo;
import com.chary.main.util.TimerUtil;

//import com.chary.main.controller.HelloWorld;

@Service
public class SchedulerService {
	
	private static final Logger log=LoggerFactory.getLogger(SchedulerService.class);
	
	@Autowired
	private final Scheduler scheduler;

	public SchedulerService(Scheduler scheduler) {
		super();
		this.scheduler = scheduler;
	}
	
	public void schedule(final Class jobClass) {
		
		
		HolidayCalendar holidays = new HolidayCalendar();
		holidays.addExcludedDate( new Date(2022, 9, 14) );
		holidays.addExcludedDate( new Date(2022, 9, 17) );
		
	    final JobDetail jobDetail =TimerUtil.buildJobDetail(jobClass);
		final Trigger jobTrigger=TimerUtil.buildTrigger(jobClass);
		
	    try {
			scheduler.addCalendar("calender", holidays, false, false);
			scheduler.scheduleJob(jobDetail,jobTrigger);
		}
		catch(SchedulerException e) {
			log.error(e.getMessage(),e);
		}
	} 
	
	@PostConstruct
	public void start() {
		try {
			scheduler.start();
		}
		catch(Exception e) {log.error(e.getMessage(),e);}
	}
	
	@PreDestroy
	public void stop() {
		try {
			scheduler.shutdown();
		}
		catch(Exception e) {log.error(e.getMessage(),e);}
	}
}
