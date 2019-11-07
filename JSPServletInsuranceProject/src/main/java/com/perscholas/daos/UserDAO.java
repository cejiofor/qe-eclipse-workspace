package com.perscholas.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.models.User;

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
	
	public Integer createUser(User user) throws SQLException {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String userEmail = user.getUserEmail();
		String userPassword = user.getUserPassword();
		LocalDate userDOB = user.getUserDOB();
		
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		//Declare SQL variables to manage connection and read data
		// String createQuery = null;
		// Statement createStmt = null;
		Connection sqlConnect = null;
		PreparedStatement insertStmt = null;
		String sqlQuery = null;
		Integer result = null;
		
		try {
			//Create a connection to MariaDB database
			sqlConnect = mariaDB.getConnection();
			
			
			// SQL query to be run to receive data from SQL table
			sqlQuery = "INSERT INTO users (firstName, lastName, userEmail, userPassword, userDOB) values (?, ?, ?, ?, ?)";
			
			// Statement needed to run the sql query
			insertStmt = sqlConnect.prepareStatement(sqlQuery);

			// Set parameters for the prepared statement
			insertStmt.setString(1, firstName);
			insertStmt.setString(2, lastName);
			insertStmt.setString(3, userEmail);
			insertStmt.setString(4, userPassword);
			insertStmt.setDate(5, Date.valueOf(userDOB));
			
			
			// run the sql query and return the new ID to a result variable
			result = insertStmt.executeUpdate();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		finally {
				
			if (insertStmt != null) {
				insertStmt.close();
			}
			if (sqlConnect != null) {
				sqlConnect.close();
			}
		}
		return result;
		
	}
	
	public List<User> getUsers() throws SQLException {
		// List to store all Users
		List<User> userList = new ArrayList();
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		//Declare SQL variables manage connection and read data
		Connection sqlConnect = null;
		String selectQuery = null;
		Statement selectStmt = null;
		ResultSet results = null;
		
		try {
			//Create a connection to MariaDB database
			sqlConnect = mariaDB.getConnection();
			
			// SQL query to be run to receive data from SQL table
			selectQuery = "SELECT * FROM users";
			
			// Statement needed to run the sql query
			selectStmt = sqlConnect.createStatement();
			
			// run the sql query and return the results to a ResultSet variable
			results = selectStmt.executeQuery(selectQuery);
			
			// iterate through the java result set and set student properties from ArrayList properties
			while (results.next())
			{
				User user = new User();
				user.setUserId(results.getInt("userId"));
				user.setFirstName(results.getString("firstName"));
				user.setLastName(results.getString("lastName"));
				user.setUserEmail(results.getString("userEmail"));
				user.setUserPassword(results.getString("userPassword"));
				user.setUserDOB(results.getDate("userDOB").toLocalDate());
				userList.add(user);
			}
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		finally {
			if (results != null) {
				results.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (sqlConnect != null) {
				sqlConnect.close();
			}
		}
		return userList;
	}
	
	public User getUser(String userEmail) throws SQLException {
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Declare SQL variables needed to manage connection and read data
		Connection sqlConnect = null;
		PreparedStatement selectStmt = null;
		String selectQuery = null;
		ResultSet results = null;
		User user = new User();;
			
		try {
			//Create a connection to MariaDB database
			sqlConnect = mariaDB.getConnection();
			
			// SQL query to be run to get User from SQL table
			selectQuery = "SELECT * FROM users WHERE userEmail = ?";
			
			// Statement needed to run the sql query
			selectStmt = sqlConnect.prepareStatement(selectQuery);
			selectStmt.setString(1, userEmail.toString());
			
			// run the sql query 
			results = selectStmt.executeQuery();
			
			while (results.next())
			{
				System.out.println(user.toString());
				user.setUserId(results.getInt("userId"));
				user.setFirstName(results.getString("firstName"));
				user.setLastName(results.getString("lastName"));
				user.setUserEmail(results.getString("userEmail"));
				user.setUserPassword(results.getString("userPassword"));
				user.setUserDOB(results.getDate("userDOB").toLocalDate());
				
			}
			
		} 
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			if (results != null) {
				results.close();
			}
			if (selectStmt != null) {
				selectStmt.close();
			}
			if (sqlConnect != null) {
				sqlConnect.close();
			}
		}
		return user;
		
	}
	
	public Boolean updateUser(User user) throws SQLException {
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();

		// Declare SQL variables needed to manage connection and read data
		Connection sqlConnect = null;
		PreparedStatement updateStmt = null;
		String updateQuery = null;
		int results = -1;
		
		try {
			// SQL query to be run to udpate User data in SQL table
			updateQuery = "UPDATE users "
					+ "set firstName = ?, "
					+ "lastName = ?, "
					+ "userEmail = ?, "
					+ "userPassword = ?, "
					+ "userDOB = ? "
					+ "where userId = ?";
			
			//Create a connection to MariaDB database
			sqlConnect = mariaDB.getConnection();
			
			// Statement needed to run the sql query
			updateStmt = sqlConnect.prepareStatement(updateQuery);

			// Set parameters for the prepared statement
			updateStmt.setString(1, user.getFirstName());
			updateStmt.setString(2, user.getLastName());
			updateStmt.setString(3, user.getUserEmail());
			updateStmt.setString(4, user.getUserPassword());
			updateStmt.setDate(5, Date.valueOf(user.getUserDOB()));
			updateStmt.setInt(5,user.getUserId());
			
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
			return true;
		}
		return false;
	}
	
	public boolean removeUser(int id) throws SQLException {
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Declare SQL variables needed to manage connection and read data
		Connection sqlConnect = null;
		String removeQuery = null;
		PreparedStatement removeStmt = null;
		int results = -1;
			
		try {
			//Create a connection to MariaDB database
			sqlConnect = mariaDB.getConnection();
			
			// SQL query to be run to add student data to SQL table
			removeQuery = "DELETE FROM Users where userId = ?";
			
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
			return true;
		}
		return false;
	}
	
}
