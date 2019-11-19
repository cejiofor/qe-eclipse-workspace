package com.perscholas.springmvc_jpa.config;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.perscholas.springmvc_jpa.hibernate_session.HibernateUtil;

@Configuration
@ComponentScan("com.perscholas.springmvcjdbctemplate")
@PropertySource("classpath:/application.properties")
public class RootAppConfig {
	@Autowired
	@Qualifier("mariaDbHibernateUtil")
	HibernateUtil hibernateUtil;
	
	@Bean("hibernateSession")
	public Session hibernateSession() {
		return hibernateUtil.getSessionFactory().openSession();
	}
//	/* The Environment instance is a bean created and managed by the Spring 
//	 * framework to hold profiles and properties. In this case, we are interested 
//	 * in properties placed in the file "application.preperties" that include 
//	 * details of the databased connection (e.g., driver, url, username and 
//	 * password). The annotation "@PropertySource" indicates to the Spring 
//	 * framework where it can find the file that includes these properties. */
//	@Autowired
//	private Environment env;
//
//	public DataSource mariaDbDataSource() {
//		/* DriverManagerDataSource is an implementation of the DataSource
//		 * interface. DataSource implementations are the preferred method 
//		 * for connecting to a database. The object returned will be passed 
//		 * to the NamedParameterJdbcTemplate bean. */
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		ds.setDriverClassName(env.getRequiredProperty("mariadb.driver"));
//		ds.setUrl(env.getRequiredProperty("mariadb.url"));
//		return ds;
//	}
//	@Bean("mariaDbJdbcTemplate")
//	public NamedParameterJdbcTemplate getMariaDbJdbcTemplate() {
//		/* This class allows for the use of named parameters in query strings 
//		 * in place of "?" placeholders. It will be used in the controller to 
//		 * perform JDBC operations on the Student model. */
//		return new NamedParameterJdbcTemplate(mariaDbDataSource());
//	}
}