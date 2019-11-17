package com.perscholas.config_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.perscholas.spring_beans.CourseDescriber;
import com.perscholas.spring_beans.Student;

public class CourseAssignmentApp {
	public static void main(String[] args) {

		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(CourseAssignConfig.class);
		CourseDescriber cd = context.getBean(CourseDescriber.class);
		
		Student student1 = new Student("John","john1234","ASM");
		Student student2 = new Student("Jane","jane1234","QEA");
		
		System.out.printf("Name: %s\nCourse: %s\nCourse Description: %s\n",
				student1.getName(), student1.getCourse(), 
				cd.getDescription(student1.getCourse()));
		System.out.printf("Name: %s\nCourse: %s\nCourse Description: %s\n",
				student2.getName(), student2.getCourse(), 
				cd.getDescription(student2.getCourse()));
		context.close();
	}
}
