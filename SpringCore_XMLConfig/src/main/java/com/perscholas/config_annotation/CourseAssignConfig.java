package com.perscholas.config_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.perscholas.spring_beans.CourseDescriber;

@Configuration
public class CourseAssignConfig {
	@Bean
	public CourseDescriber courseDescriber() {
		return new CourseDescriber();
	}
}