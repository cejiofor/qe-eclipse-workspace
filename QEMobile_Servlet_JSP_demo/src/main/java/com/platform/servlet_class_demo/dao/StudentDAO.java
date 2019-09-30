package com.platform.servlet_class_demo.dao;

import java.awt.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public void createStudent(String name, String email, String course) throws SQLException, ClassNotFoundException, IOException {
		ArrayList<Student> studentList = new ArrayList<>();
		
		// Create a new instance of the student class
		Student newStudent = new Student();
		newStudent.setName(name);
		newStudent.setEmail(email);
		newStudent.setCourseSelected(course);
		
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Create a connection to the mariaDB database
		Connection sqlConnect = null;
		PreparedStatement insertStmt = null;
		String sqlQuery = null;
		String studentQuery = null;
		Statement newQuery = null;
		ResultSet results = null;
		
		try {
			sqlConnect = mariaDB.getConnection();
			// SQL query to be run to receive data from SQL table
			sqlQuery = "INSERT INTO students (name, email, course_selected) values (?, ?, ?)";
			
			// Statement needed to run the sql query
			insertStmt = sqlConnect.prepareStatement(sqlQuery);

			// Set parameters for the prepared statement
			insertStmt.setString(1, name);
			insertStmt.setString(2, email);
			insertStmt.setString(3, course);
			
			// run the sql query and return the results to a ResultSet variable
			insertStmt.executeUpdate();
			
			//Check and return updated list of students
			// SQL query to be run to receive data from SQL table
			studentQuery = "SELECT * FROM Students";
			
			// Statement needed to run the sql query
			newQuery = sqlConnect.createStatement();
			
			// run the sql query and return the results to a ResultSet variable
			results = newQuery.executeQuery(studentQuery);
			
			// iterate through the java result set and set student properties from ArrayList properties
			while (results.next())
			{
				Student student = new Student();
				student.setStudentId(results.getInt("student_id"));
				student.setName(results.getString("name"));
				student.setEmail(results.getString("email"));
				student.setCourseSelected(results.getString("course_selected"));
				studentList.add(student);
				System.out.println(student.toString());
			}
			 
			sqlConnect.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void getStudents() {
		
	}
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		ArrayList<Student> studentList = new ArrayList<Student>();
		
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
		
		// run the sql query and return the results to a ResultSet variable
		ResultSet results = newQuery.executeQuery(sqlQuery);
		
		// iterate through the java result set and set student properties from ArrayList properties
		while (results.next())
		{
			Student student = new Student();
			student.setStudentId(results.getInt("student_id"));
			student.setName(results.getString("name"));
			student.setEmail(results.getString("email"));
			student.setCourseSelected(results.getString("course_selected"));
			studentList.add(student);
			System.out.println(student.toString());
		}
		sqlConnect.close();
		
		s_dao.createStudent("Test", "test@test.com", "Test Course");
		
		return;	
	}

}
