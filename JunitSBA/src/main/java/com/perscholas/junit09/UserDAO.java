package com.perscholas.junit09;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.junit05.User;

//Test Fixtures, Assume: Use the User class from item #5. Set up the pom.xml file with MariaDB, JUnit, and Hamcrest dependencies. 
//Create a users table in MariaDB with matching columns. 
//Create a User DAO class to perform all of the CRUD operations. 


public class UserDAO {
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
	
	public List<User> getAllUsers() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User u = null;
		List<User> userList = null;

		// Assign query string to a variable
		String qString = "select * from users";

		// Create MySqlConnection class instance
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Begin try/catch block to query the database
		try
		{
			// Connect to database
			conn = mariaDB.getConnection();
			// If the connection fails the application won't make it to this point
			System.out.println("Connected to database.");
			// Create Statement instance/object
			stmt = conn.createStatement();
		
			// Run query and assign to the ResultSet instance
			rs = stmt.executeQuery(qString);
			//Create list to hold User objects
			userList = new ArrayList<User>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				u = new User();
				
				// Assign columns/fields to related fields in the User object
				u.setUserId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setJavaScore(rs.getDouble(4));
				u.setSqlScore(rs.getDouble(5));
				
				// Add the user to the list
				userList.add(u);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
		finally
		{
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return userList;
	}
	
	public Integer registerUser(User user) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "insert into users (name, password, javaScore, sqlScore) values (?,?,?,?)";
		
	    int ID = -1;
	    String[] COL = {"user_id"};
	    
	    MariaDBConnection mariaDB = new MariaDBConnection();
		 
	    try
	    {
	        conn = mariaDB.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        
	        stmt.setString(1, user.getName());
	        stmt.setString(2, user.getPassword());
	        stmt.setDouble(3, user.getJavaScore());
	        stmt.setDouble(4, user.getSqlScore());
	        
	        stmt.executeUpdate();
	        
	        rs = stmt.getGeneratedKeys();
	        if(rs != null && rs.next()) {
	            ID = rs.getInt(1);
	        }
	        System.out.println(ID);
	    }
	    catch (SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		finally
		{
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	    
		return ID;
	}
	
	public User getUserById(int userId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User u = null;
		
		// Assign query string to variable
		String qString = "select * from users where user_id = ?";
		
		// Create MySqlConnection class instance
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = mariaDB.getConnection();
			stmt = conn.prepareStatement(qString);
			
			// Set query parameters (?)
			stmt.setInt(1, userId); // user_id if from String parameter passed to method
			
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setJavaScore(rs.getDouble(4));
				u.setSqlScore(rs.getDouble(5));
				
			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
		finally
		{
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return u;
	}
	
	public User getUserByName(String name) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User u = null;
		
		// Assign query string to variable
		String qString = "select * from users where name = ?";
		
		// Create MySqlConnection class instance
		MariaDBConnection mariaDB = new MariaDBConnection();
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = mariaDB.getConnection();
			stmt = conn.prepareStatement(qString);
			
			// Set query parameters (?)
			stmt.setString(1, name); // user_id if from String parameter passed to method
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				u = new User();;
				u.setUserId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setJavaScore(rs.getDouble(4));
				u.setSqlScore(rs.getDouble(5));
				
			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			System.out.println(e.getStackTrace());
		}
		finally
		{
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return u;
	}
	
	public Boolean updateUser(User u) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		
		// Assign update string to variable
		String updateString = "update users "
				+ "set name = ?, password = ?, javaScore = ?, sqlScore = ? "
				+ "where user_id = ?";
		
		// Create MySqlConnection class instance
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = mariaDB.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			// Set query parameters (?)
			stmt.setString(1, u.getName());
	        stmt.setString(2, u.getPassword());
	        stmt.setDouble(3, u.getJavaScore());
	        stmt.setDouble(4, u.getSqlScore());
	        stmt.setInt(5, u.getUserId());
			    
			
			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		finally
		{
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		if (updateResult > 0) {
			return true;
		}
		return false;
	}
	
	public Boolean removeUser(int userId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		
		// Assign delete string to variable
		String deleteString = "delete from users where user_id = ?";
		
		// Create MySqlConnection class instance
		MariaDBConnection mariaDB = new MariaDBConnection();
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = mariaDB.getConnection();
			stmt = conn.prepareStatement(deleteString);
			
			// Set query parameters (?)
			stmt.setInt(1, userId);
			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		finally
		{
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		if (updateResult > 0) {
			return true;
		}
		return false;
	}
}
