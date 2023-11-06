package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // these annotation do work of these
						// three annotations
						// @Configuration  @EnableAutoConfiguration  @ComponentScan

public class MySpringBootA1Application {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootA1Application.class, args);
	}

}
