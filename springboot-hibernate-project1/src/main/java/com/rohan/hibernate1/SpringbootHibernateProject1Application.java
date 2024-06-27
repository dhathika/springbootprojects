package com.rohan.hibernate1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringbootHibernateProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHibernateProject1Application.class, args);
	}

}
