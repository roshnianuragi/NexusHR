package com.nexus.hr.scheduler;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

	// RUN EVERY 1 MINUTE

//	@Scheduled(cron = "0 * * * * *")
//	public void runTask() {
//
//		System.out.println("Cron Job Running : " + LocalDateTime.now());
//	}

	// RUN EVERY 10 SECONDS

//	@Scheduled(cron = "*/10 * * * * *")
//	public void everyTenSeconds() {
//
//		System.out.println("Running every 10 seconds");
//	}
}