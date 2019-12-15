package com.perscholas.springmvcjdbctemplate.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan("com.perscholas.springmvcjdbctemplate")
@PropertySource("classpath:/application.properties")
public class RootAppConfig {
	/* The Environment instance is a bean created and managed by the Spring 
	 * framework to hold profiles and properties. In this case, we are intereted 
	 * in properties placed in the file "application.preperties" that include 
	 * details of the databased connection (e.g., driver, url, username and 
	 * password). The annotation "@PropertySource" indicates to the Spring 
	 * framework where it can find the file that includes these properties. */
	@Autowired
	private Environment env;

	public DataSource mariaDbDataSource() {
		/* DriverManagerDataSource is an implementation of the DataSource
		 * interface. DataSource implementations are the preferred method 
		 * for connecting to a database. The object returned will be passed 
		 * to the NamedParameterJdbcTemplate bean. */
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getRequiredProperty("mariadb.driver"));
		ds.setUrl(env.getRequiredProperty("mariadb.url"));
		return ds;
	}
	@Bean("mariaDbJdbcTemplate")
	public NamedParameterJdbcTemplate getMariaDbJdbcTemplate() {
		/* This class allows for the use of named parameters in query strings 
		 * in place of "?" placeholders. It will be used in the controller to 
		 * perform JDBC operations on the Student model. */
		return new NamedParameterJdbcTemplate(mariaDbDataSource());
	}
	
	@Bean
	public DataSource hsqldbDataSource() {
		// EmbeddedDatabaseBuilder is an API for constructing an EmbeddedDatabase
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		/* EmbeddedDatabase is a subinterface of DataSource. The 
		 * EmbeddedDatabaseBuilder will run the scripts located in the 
		 * "src/main/resources" source folder in the paths specified in the 
		 * "addScript" method calls. The application data will begin in the states 
		 * specified in the scripts each time the application is launched. The 
		 * "ddl.sql" script will create a table "students" while the "dml.sql" 
		 * script will insert records into the table. */
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.HSQL)
				.addScript("sql/ddl.sql")
				.addScript("sql/dml.sql")
				.build();
		return db;
	}
	@Bean("hsqldbJdbcTemplate")
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		return new NamedParameterJdbcTemplate(hsqldbDataSource());
	}
}