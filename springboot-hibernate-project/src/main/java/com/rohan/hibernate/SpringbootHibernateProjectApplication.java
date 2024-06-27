package com.rohan.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringbootHibernateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateProjectApplication.class, args);
	}

}
