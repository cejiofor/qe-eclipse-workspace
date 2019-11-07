package com.perscholas.spring02.greeting_interface.impl;

import com.perscholas.spring02.greeting_interface.GreetingService;

public class SpanishGreeting implements GreetingService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Hola";
	}

	@Override
	public String sayWelcome() {
		return "Bienvenidos";
	}

}
