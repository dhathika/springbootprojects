package com.dhathika.bootdemo.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.dhathika.bootdemo.model.Employee;

@Configuration
@ComponentScan("com.dhathika.bootdemo")
public class AppConfig {
	
	static Logger log = LogManager.getLogger(AppConfig.class);

	@Bean
	public DriverManagerDataSource dataSource() {
		log.info("datasource bean entry");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("system");
		dataSource.setPassword("system");
		log.info("datasource bean exit");
		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setAnnotatedClasses(Employee.class);
		sessionFactory.setPackagesToScan("com.dhathika.bootdemo");
		try {
			sessionFactory.afterPropertiesSet();
			} catch (IOException e) {
			 log.error(e.getMessage());
			}
		return sessionFactory.getObject();
	}

   @Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}
    @Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate hibernateTemplate = new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionFactory());
		return hibernateTemplate;
}
    
    @Bean
    public HibernateTransactionManager hibTransMan() {
  	return new HibernateTransactionManager(sessionFactory());
    }
}

