package com.sandhi.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@PropertySource("classpath:app.properties")
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.sandhi")
@EnableTransactionManagement
public class AppConfig  implements WebMvcConfigurer 
{
	@Value("${mysql.userName}")
	private String userName;
	
	@Value("${mysql.password}")
	private String password;
	
	@Value("${mysql.url}")
	private String url;
	
	@Value("${mysql.driver}")
	private String driver;
	
	@Value("${mail.mailHost}")
	private String mailHost;
	
	@Value("${mail.mailUserName}")
	private String mailUserName;
	
	@Value("${mail.mailPassword}")
	private String mailPassword;
	
	@Value("${mail.mailPort}")
	private String mailPort;
	
	
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
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);
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
		sessionFactory.setDataSource(dataSource()); 							
		sessionFactory.setPackagesToScan(new String[] { "com.sandhi.domain" });  
																			     
		sessionFactory.setHibernateProperties(hibernateProperties());   		
		return sessionFactory;
	}

	
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
	
	@Bean
	public JavaMailSender getJavaMailSender()		
	{
		JavaMailSenderImpl javaMailSender= new JavaMailSenderImpl();
		
		javaMailSender.setHost(mailHost);					
		javaMailSender.setUsername(mailUserName);			
		javaMailSender.setPassword(mailPassword);			
		javaMailSender.setPort(Integer.parseInt(mailPort)); 
		
		Properties mailProperties = getMailProperties();		//using a helper method below to set security properties(we could have also created
																//the properties object here and set its value) but this is a good practice
		
		javaMailSender.setJavaMailProperties(mailProperties); 	//adding properties to our mailSender 
		
		return javaMailSender;
	}
	
	/*A HELPER method that returns a properties object(to be added to JavamailSender object)*/
	private Properties getMailProperties() 
	{
		Properties mailProperties= new Properties();
		mailProperties.put("mail.smtp.starttls.enable",true);    /*these are some security protocols that must be set to true for gmail*/
		mailProperties.put("mail.smtp.ssl.trust",true);			 /*these are encryption protocols and must be set as value for properties*/
											 					 /*Object and then the property object must be added to the mail sender*/
		return mailProperties;
	}

}
