package com.rohan.springboot.first_springboot_project.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.rohan")
public class AppConfig {
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource datasource =new DriverManagerDataSource();
		datasource.setUrl("jdbc:mysql://localhost:3306/sys");
		datasource.setUsername("root");
		datasource.setPassword("rohan");
		return datasource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate =new  JdbcTemplate();
		jdbcTemplate.setDataSource(datasource());
		return jdbcTemplate;
		
	}

	

}
