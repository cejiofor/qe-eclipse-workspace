package com.platform.servlet_class_demo.dao;

import java.awt.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.platform.servlet_class_demo.models.Student;

//Student Data Access Object Class
public class StudentDAO {
	
	
	
	public void testConnection() {
		MariaDBConnection mariadbConnection = new MariaDBConnection();
		try {
			mariadbConnection.getConnection();
			System.out.println("Connected to MariaDB!");
		}
		catch(Exception e) {
			System.out.println("Database connection failed.");
		}
		
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		Student[] studentArr = new Student[]{};
		
		// Create ArrayList to hold values for student properties
		ArrayList<Integer> studentId = new ArrayList<Integer>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> email = new ArrayList<String>();
		ArrayList<String> courseSelected = new ArrayList<String>();
		
		StudentDAO s_dao = new StudentDAO();
		s_dao.testConnection();
		
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Create a connection to the mariaDB database
		Connection sqlConnect = mariaDB.getConnection();
		
		// SQL query to be run to receive data from SQL table
		String sqlQuery = "SELECT * FROM Students";
		
		// Statement needed to run the sql query
		Statement newQuery = sqlConnect.createStatement();
		
		// run the sq query and return the results to a ResultSet variable
		ResultSet results = newQuery.executeQuery(sqlQuery);
		
		// iterate through the java result set
		while (results.next())
		{
			studentId.add(results.getInt("student_id"));
			name.add(results.getString("name"));
			email.add(results.getString("email"));
			courseSelected.add(results.getString("course_selected"));
		}
		
		// Loop over student array and set student properties from ArrayList properties
		int i = 0;
		for(Student student: studentArr) {
			student.setStudentId(studentId.get(i));
			student.setName(name.get(i));
			student.setEmail(email.get(i));
			student.setCourseSelected(courseSelected.get(i));
			i++;
		}
		
		System.out.println(studentArr);
		sqlConnect.close();
		return;
//		Assignment -> create  a login page with username, password, and login button
//		create A TABLE users with id, username, and password
//		write a java application that make sure the username and password entered match the database
//		if so, take user to a welcome page
//		
	}

}
