package com.perscholas.spring01.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perscholas.spring01.models.SpringGreeting;

public class SpringGreetingApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/perscholas/spring01/bean_def/BeanDef.xml");

		SpringGreeting sg = context.getBean("springGreeting", SpringGreeting.class);
		System.out.println(sg.returnHello());
		context.close();
	}

}
