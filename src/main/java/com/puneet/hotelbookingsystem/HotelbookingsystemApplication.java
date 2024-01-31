package com.puneet.hotelbookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HotelbookingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelbookingsystemApplication.class, args);
	}

}
