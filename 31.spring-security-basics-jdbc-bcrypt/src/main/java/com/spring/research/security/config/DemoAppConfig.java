package com.spring.research.security.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.spring.research.security")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	@Autowired
	private Environment env;

	private Logger myLogger = Logger.getLogger(getClass().getName());

	// define bean for view resolver

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	// define a bean for datasource

	@Bean
	public DataSource securityDataSource() {

		// create connection pool;
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		// set the jdbc driver class
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		// log connection properties
		myLogger.info("<<< ==== jdbc.url=" + env.getProperty("jdbc.url") + " =====>>>");
		myLogger.info("<<< ==== jdbc.user=" + env.getProperty("jdbc.user") + " =====>>>");

		// set database connection properties
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));

		// set connection pool properties
		
		dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		dataSource.setMaxPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		dataSource.setMaxIdleTime(getIntProperty("connection.pool.initialPoolSize"));

		return dataSource;
	}

	//Utility method to convert String properties to Integer.
	
	private int getIntProperty(String propertyName) {

		String propertyValue = env.getProperty(propertyName);
		int intPropVal = Integer.parseInt(propertyValue);

		return intPropVal;

	}

}
