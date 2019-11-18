package com.perscholas.request_mapping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.perscholas.request_mapping")
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		/* The InternalResourceViewResolver constructor is overloaded and includes 
		 * a version which accept two strings that represent a prefix and a suffix. 
		 * This takes the place of setting these explicitly like in previous 
		 * examples (e.g., resolver.setPrefix("/WEB-INF/views/"). */
		InternalResourceViewResolver resolver = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
		return resolver;
	}
		
}
