package com.perscholas.spring02.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.perscholas.spring02.greeting_interface.GreetingService;

public class Person {
	@Autowired
	@Qualifier("spanish")
	private GreetingService greetingService;

	public Person() {
		super();
	}
	
	public Person(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}

	public GreetingService getGreetingService() {
		return greetingService;
	}

	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
	
	
}
