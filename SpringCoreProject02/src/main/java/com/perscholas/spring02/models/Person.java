package com.perscholas.spring02.models;

import com.perscholas.spring02.greeting_interface.GreetingService;

public class Person {
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
