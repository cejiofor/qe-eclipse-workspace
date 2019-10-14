package com.perscholas.javaproject06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.perscholas.javaproject06.Course;
import com.perscholas.javaproject06.MariaDBConnection;

public class CourseDAO {
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
	
	public void createCourse(Course course) {
		int id = course.getId();
		String name = course.getCourse_name();
		String description = course.getCourse_description();
		
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Create a connection to the mariaDB database
		Connection sqlConnect = null;
		PreparedStatement insertStmt = null;
		String sqlQuery = null;
		String courseQuery = null;
		Statement newQuery = null;
		ResultSet results = null;
		
		try {
			sqlConnect = mariaDB.getConnection();
			// SQL query to be run to receive data from SQL table
			sqlQuery = "INSERT INTO courses (id, name, description) values (?, ?, ?)";
			
			// Statement needed to run the sql query
			insertStmt = sqlConnect.prepareStatement(sqlQuery);

			// Set parameters for the prepared statement
			insertStmt.setInt(1, id);
			insertStmt.setString(2, name);
			insertStmt.setString(3, description);
			
			
			// run the sql query and return the results to a ResultSet variable
			insertStmt.executeUpdate();
//	 
			sqlConnect.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public void getCourses() {
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Create a connection to the mariaDB database
		Connection sqlConnect = null;
		String courseQuery = null;
		Statement newQuery = null;
		ResultSet results = null;
		
		try {
			sqlConnect = mariaDB.getConnection();
			
			// SQL query to be run to receive data from SQL table
			courseQuery = "SELECT * FROM courses";
			
			// Statement needed to run the sql query
			newQuery = sqlConnect.createStatement();
			
			// run the sql query and return the results to a ResultSet variable
			results = newQuery.executeQuery(courseQuery);
			
			// iterate through the java result set and set student properties from ArrayList properties
			while (results.next())
			{
				Course course = new Course();
				course.setId(results.getInt("id"));
				course.setCourse_name(results.getString("name"));
				course.setCourse_description(results.getString("description"));
				System.out.println(course.toString());
			}
			 
			sqlConnect.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void getCourse(String name) throws SQLException {
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Declare variables needed to manage connection and read data
		Connection sqlConnect = null;
		PreparedStatement selectStmt = null;
		String selectQuery = null;
		ResultSet results = null;
		
		
		// SQL query to be run to add student data to SQL table
		selectQuery = "SELECT * FROM courses WHERE name = ?";
				
			
		try {
			sqlConnect = mariaDB.getConnection();
			
			// Statement needed to run the sql query
			selectStmt = sqlConnect.prepareStatement(selectQuery);
			selectStmt.setString(1, name.toString());
			
	
			// run the sql query 
			results = selectStmt.executeQuery();
			
			while (results.next())
			{
				Course course = new Course();
				course.setId(results.getInt("id"));
				course.setCourse_name(results.getString("name"));
				course.setCourse_description(results.getString("description"));
				System.out.println(course.toString());
			}
			
		} 
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (sqlConnect != null) {
				sqlConnect.close();
			}
		}
	}
	
	public Boolean updateCourse(Course course) throws SQLException {
		int id = course.getId();
		String name = course.getCourse_name();
		String description = course.getCourse_description();
		
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();

		// Declare variables needed to manage connection and read data
		Connection sqlConnect = null;
		PreparedStatement updateStmt = null;
		String sqlQuery = null;
		String courseQuery = null;
		Statement newQuery = null;
		int results = -1;
		
		// SQL query to be run to add student data to SQL table
		String updateString = "UPDATE courses "
				+ "set name = ?, "
				+ "description = ? "
				+ "where id = "
				+ "(Select min(id) from courses)";
		
		
		try {
			sqlConnect = mariaDB.getConnection();
			
			// Statement needed to run the sql query
			updateStmt = sqlConnect.prepareStatement(updateString);

			// Set parameters for the prepared statement
			updateStmt.setString(1, course.getCourse_name());
			updateStmt.setString(2, course.getCourse_description());
			
			// run the sql query
			results = updateStmt.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
			e.printStackTrace();
		}finally {
			if (updateStmt != null) {
				updateStmt.close();
			}
			if (sqlConnect != null) {
				sqlConnect.close();
			}
		}
		if (results >0) {
			return false;
		}
		return true;
	}
	public boolean removeCourse(int id) throws SQLException {
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Declare variables needed to manage connection and read data
		Connection sqlConnect = null;
		PreparedStatement removeStmt = null;
		int results = -1;
		String removeQuery = null;
		
		// SQL query to be run to add student data to SQL table
		removeQuery = "DELETE FROM courses where id = ?";
				
			
		try {
			sqlConnect = mariaDB.getConnection();
			
			// Statement needed to run the sql query
			removeStmt = sqlConnect.prepareStatement(removeQuery);
	
			// Set parameters for the prepared statement
			removeStmt.setInt(1, id);
			
			// run the sql query 
			results = removeStmt.executeUpdate();
			// Returns: either (1) the row count for SQL Data Manipulation Language (DML) statements or 
			// (2) 0 for SQL statements that return nothing
			
		} 
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (removeStmt != null) {
				removeStmt.close();
			}
			if (sqlConnect != null) {
				sqlConnect.close();
			}
		}
		if (results >0) {
			return false;
		}
		return true;
	}
	
	
}
