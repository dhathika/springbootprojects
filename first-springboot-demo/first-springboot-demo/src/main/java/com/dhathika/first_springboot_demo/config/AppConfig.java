package com.dhathika.first_springboot_demo.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.dhathika")
public class AppConfig {
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource datasource =new DriverManagerDataSource();
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		datasource.setUsername("system");
		datasource.setPassword("system");
		return datasource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate =new  JdbcTemplate();
		jdbcTemplate.setDataSource(datasource());
		return jdbcTemplate;
		
	}

}
