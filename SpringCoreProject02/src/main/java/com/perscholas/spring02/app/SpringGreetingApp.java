package com.perscholas.spring02.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perscholas.spring02.greeting_interface.impl.SpanishGreeting;
import com.perscholas.spring02.models.Person;


public class SpringGreetingApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/perscholas/spring02/bean_def/BeanDef.xml");
		Person p = context.getBean("person", Person.class);
		System.out.println(p.getGreetingService().sayHello());
		System.out.println(p.getGreetingService().sayWelcome());
		context.close();
	}

}
