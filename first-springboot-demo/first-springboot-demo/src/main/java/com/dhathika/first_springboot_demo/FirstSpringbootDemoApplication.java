package com.dhathika.first_springboot_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dhathika.first_springboot_demo.config.AppConfig;
import com.dhathika.first_springboot_demo.pojo.Employee;

@SpringBootApplication
public class FirstSpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringbootDemoApplication.class, args);
    

	}

}
