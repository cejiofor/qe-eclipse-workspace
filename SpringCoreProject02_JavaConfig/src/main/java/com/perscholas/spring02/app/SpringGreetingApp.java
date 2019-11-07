package com.perscholas.spring02.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.perscholas.spring02.config.GreetingConfig;
import com.perscholas.spring02.models.Person;


public class SpringGreetingApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(GreetingConfig.class);
		
		Person p = context.getBean("person", Person.class);
		System.out.println(p.getGreetingService().sayHello());
		System.out.println(p.getGreetingService().sayWelcome());
		context.close();
	}

}
