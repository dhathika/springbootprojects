package com.rohan.hibernate1.config;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.rohan.hibernate1.pojo.Student;

@Configuration
@ComponentScan("com.rohan.hibernate1")
public class AppConfig {
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/sys");
		dataSource.setUsername("root");
		dataSource.setPassword("rohan");
		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setAnnotatedClasses(Student.class);
		sessionFactory.setPackagesToScan("com.rohan.hibernate1");
		try {
			sessionFactory.afterPropertiesSet();
			} catch (IOException e) {
			  e.printStackTrace();
			}
		return sessionFactory.getObject();
	}

   @Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
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
