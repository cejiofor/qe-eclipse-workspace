package com.perscholas.rest_controllers.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.perscholas.rest_controllers.models.Student;

@Configuration
@ComponentScan("com.perscholas.rest_controllers")
public class WebAppConfig implements WebMvcConfigurer{
	@Bean
	InternalResourceViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
	@Bean
	ObjectMapper objectMapper() {
		// INDENT_OUTPUT allows for "pretty printing" of JSON data
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	//this bean creates a map which will emulate database records
	@Bean
	Map<Integer, Student> studentMap(){
		Map<Integer, Student> sMap = new HashMap<>();
		Student student;
		// Create first student record
		student = new Student(1, "John", "john@perscholas.org");
		student.getCourses().add("Application Developer");
		student.getCourses().add("Data Engineering");
		sMap.put(student.getStudentId(), student);
		// Create second student record
		student = new Student(2, "Jane", "jane@perscholas.org");
		student.getCourses().add("Data Engineering");
		student.getCourses().add("Quality Engineering and Assurance");
		sMap.put(student.getStudentId(), student);
		// Create second student record
		student = new Student(3, "Chris", "chris@perscholas.org");
		student.getCourses().add("Quality Engineering and Assurance");
		student.getCourses().add("Application Developer");
		student.getCourses().add("Data Engineering");
		sMap.put(student.getStudentId(), student);
		return sMap;
		
	}

}
