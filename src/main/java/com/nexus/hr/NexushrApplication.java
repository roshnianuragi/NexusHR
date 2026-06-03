package com.nexus.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NexushrApplication {

	public static void main(String[] args) {

		SpringApplication.run(NexushrApplication.class, args);
	}
}