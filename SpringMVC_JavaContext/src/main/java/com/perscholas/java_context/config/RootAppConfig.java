package com.perscholas.java_context.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.perscholas.java_context.beans.CourseRepository;

@Configuration
public class RootAppConfig {
	@Bean
	public CourseRepository courseRepository() {
		return new CourseRepository();
	}
}