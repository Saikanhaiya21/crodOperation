package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudentinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentinfoApplication.class, args);
	}

}
