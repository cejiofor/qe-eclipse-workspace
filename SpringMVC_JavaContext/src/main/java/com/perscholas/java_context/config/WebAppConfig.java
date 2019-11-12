package com.perscholas.java_context.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.perscholas.java_context.beans.ApplicationService;
import com.perscholas.java_context.beans.RegistrationService;

@Configuration
@ComponentScan("com.perscholas.java_context")
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	@Bean
	public ApplicationService applicationService() {
		return new ApplicationService();
	}
	@Bean
	public RegistrationService registrationService() {
		return new RegistrationService();
	}
}