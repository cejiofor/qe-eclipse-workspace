package com.perscholas.rest_controllers.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perscholas.rest_controllers.models.Student;

@RestController
public class RestControllerDemo {
	private Map<Integer, Student> studentMap;
	private ObjectMapper mapper;
	
	@Autowired
	public RestControllerDemo(Map<Integer, Student> studentMap, ObjectMapper mapper) {
		this.mapper = mapper;
		this.studentMap = studentMap;
	}
	
	@GetMapping("/student/{id}")
	public String getStudent(@PathVariable Integer id) throws JsonProcessingException{
		/* The ObjectMapper class is part of the Jackson library which 
		 * provides the ability to read and write JSON either to or from 
		 * POJOs or to or from a JSON Tree Model. In this case we will write a 
		 * JSON string from a Student object and return it as part of the HTTP 
		 * response. You can read more about ObjectMapper at the following 
		 * website: https://fasterxml.github.io/jackson-databind/javadoc/2.7/com
         * /fasterxml/jackson/databind/ObjectMapper.html */
		
		if (studentMap.get(id) != null) {
			Student student = studentMap.get(id);
			/* The student properties are returned to the client (e.g., browser) 
			 * as a JSON string. */
			return mapper.writeValueAsString(student);
		}
		
		// The error String is returned to the web client
		return "Student ID not found";
	}
	
	@GetMapping("/getAllStudents")
	public String getAllStudents() throws JsonProcessingException{
		return mapper.writeValueAsString(this.studentMap);
	}
	

}
