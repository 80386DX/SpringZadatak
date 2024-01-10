package com.heliant.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringZadatakApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZadatakApplication.class, args);
	}

}
