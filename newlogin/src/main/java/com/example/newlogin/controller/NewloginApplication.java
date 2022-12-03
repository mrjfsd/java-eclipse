package com.example.newlogin.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.newlogin")
public class NewloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewloginApplication.class, args);
	}

}
