package com.demo.utility;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedular {
	
	@Scheduled(cron = "10,12,25,17 20 13 * * *")
	public void checkSchedule() {
      
      System.out.println("sai");
	}
}