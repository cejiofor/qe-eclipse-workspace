package com.perscholas.spring02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.perscholas.spring02.greeting_interface.impl.EnglishGreeting;
import com.perscholas.spring02.greeting_interface.impl.SpanishGreeting;
import com.perscholas.spring02.models.Person;

@Configuration
public class GreetingConfig {
	
	@Bean("person")
	public Person person() {
		return new Person();
	}
	
	@Bean("english")
	public EnglishGreeting englishGreeting()
	{
		return new EnglishGreeting();	
	}
	
	@Bean("spanish")
	public SpanishGreeting spanishGreeting()
	{
		return new SpanishGreeting();	
	}
}
