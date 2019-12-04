package com.perscholas.config.models;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perscholas.spring_beans.CourseDescriber;
import com.perscholas.spring_beans.Student;

public class StudentApp {
	public static void main(String[] args) throws NoSuchBeanDefinitionException, IOException {

		  AbstractApplicationContext context = new ClassPathXmlApplicationContext
				  ("com/perscholas/config/beans/StudentAppConfig.xml");
		  try
	      {
			  /* Here we retrieve two managed beans from the context (i.e., Spring 
			   * framework. */
	          StudentDAO s_dao = context.getBean("s_dao", StudentDAO.class);
	          CourseDescriber crsDesc = context.getBean("courseDescriber", 
	        		  CourseDescriber.class);
	          
	          List<Student> retrievedList = s_dao.getAllStudents();
	          
	          for (Student s : retrievedList) {
	        	  System.out.println("Name: " + s.getName());
	        	  System.out.println("Course: " + s.getCourse());
	        	  System.out.println("Description: " + crsDesc.getDescription(s.getCourse()));
	          }
	      }
	      catch( NoSuchBeanDefinitionException e)
	      {
	    	  System.out.println(e);
	      }
	      finally
	      {
	    	  context.close();
	      }
	   }
}
