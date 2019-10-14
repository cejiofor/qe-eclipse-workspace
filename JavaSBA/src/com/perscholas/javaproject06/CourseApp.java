package com.perscholas.javaproject06;

import java.sql.SQLException;

//JavaSBAProject_06
//Make a Course DAO and write a method to make a connection to MariaDB. Write a main method to verify that the connection has been made.
//Add all of the CRUD methods to the Course DAO.
//Create a driver class to demonstrate each method:
	//Insert 3 courses into the database.
	//Retrieve/read all courses and print them using a loop
	//Find 1 course by name and print the details of the course.
	//Update the first course in the database.
	//Delete a course by ID

public class CourseApp {
	public static void main(String[] args) throws SQLException {
		CourseDAO c_dao = new CourseDAO();
		c_dao.testConnection();
		
		Course courseOne = new Course(12100, "Intro to Engineering", "Basic engineering principles");
		Course courseTwo = new Course(33106, "Physics", "Advanced physics course");
		Course courseThree = new Course(78100, "Chemistry", "Freshman chemistry");
		
		c_dao.createCourse(courseOne);
		c_dao.createCourse(courseTwo);
		c_dao.createCourse(courseThree);
		c_dao.getCourses();
		System.out.println();
		
		c_dao.getCourse("Physics");
		System.out.println();
		
		Course courseOneUpdate = new Course(12100, "Intro to Civil Engineering", "Basic civil engineering principles");
		c_dao.updateCourse(courseOneUpdate);
		c_dao.getCourses();
		System.out.println();
		
		c_dao.removeCourse(12100);
		c_dao.getCourses();
		System.out.println();
	}
}
