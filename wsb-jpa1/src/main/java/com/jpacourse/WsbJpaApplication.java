package com.jpacourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.jpacourse.persistence.dao")
public class WsbJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsbJpaApplication.class, args);
	}
}
