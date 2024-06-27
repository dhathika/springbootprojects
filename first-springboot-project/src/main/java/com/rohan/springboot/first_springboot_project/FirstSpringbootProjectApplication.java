package com.rohan.springboot.first_springboot_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rohan.springboot.first_springboot_project.config.AppConfig;
import com.rohan.springboot.first_springboot_project.pojo.Student;

@SpringBootApplication
public class FirstSpringbootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringbootProjectApplication.class, args);
		
		
	}

}
