package com.chary.main.util;

import org.quartz.CalendarIntervalScheduleBuilder;
import org.quartz.CronScheduleBuilder;
import org.quartz.DailyTimeIntervalScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.calendar.AnnualCalendar;

import com.chary.main.TimerInfo.TimerInfo;
import com.chary.main.controller.hello;

public class TimerUtil {
	private TimerUtil() {
	}

	public static JobDetail buildJobDetail(final Class jobClass) {
		  JobDetail job = JobBuilder.newJob(hello.class)
			      .withIdentity("myJob", "group1") // name "myJob", group "group1"
			      .build();

		return job;
	}

	public static Trigger buildTrigger(final Class jobClass) {
		
		return TriggerBuilder.newTrigger().withIdentity(jobClass.getSimpleName()).modifiedByCalendar("calender").withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(17, 53)).build();			}
}
