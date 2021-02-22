package com.sandhi.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.sandhi")
@EnableTransactionManagement
public class AppConfig  implements WebMvcConfigurer 
{

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	/* OBJECT OF DATASOURCE(required in bean of SessionFactory) */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/notes");
		dataSource.setUsername("root");
		dataSource.setPassword("triparnarai8");
		return dataSource;
	}

	/* OBJECT OF HIBERNATE PROPERTIES(required in bean of SessionFactory) */
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}

	/* OBJECT OF SESSION FACTORY */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource()); 							 // Providing object dataSource
		sessionFactory.setPackagesToScan(new String[] { "com.sandhi.domain" });  // Providing the Pacage to scan for
																			     // annotated classes
		sessionFactory.setHibernateProperties(hibernateProperties());   		 // providing the Object of hibernate Propertis
		return sessionFactory;
	}

	/* OBJECT OF TRANSACTION MANAGER(needed to activate featurs of @Transactional)*/
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	
	
	/*ADDING RESOURCE HANDLERS(static resources like css,images,js file etc), It is mandatory to
	  for our config class to Implement "WebMvcConfigurer" to use (override) this method*/
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		registry
		.addResourceHandler("/URLToReachResourceFolder/**") 	/*-->src/main/webapp*/
		.addResourceLocations("/resources/");					/*adding resource location*/
	}
	
}
