package com.perscholas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.models.Home;

public class HomeDAO {
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
	
	public Integer createHome(Home home) throws SQLException {
		int userId =  home.getUserId();
		String address1 = home.getAddress1();
		String address2 = home.getAddress2();
		String city = home.getCity();
		String state = home.getState();
		int zip = home.getZip();
		int yearBuilt = home.getYearBuilt();
		double homeValue = home.getHomeValue();
		
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		//Declare SQL variables to manage connection and read data
		Connection sqlConnect = null;
		PreparedStatement insertStmt = null;
		String sqlQuery = null;
		Integer result = null;
		
		try {
			//Create a connection to MariaDB database
			sqlConnect = mariaDB.getConnection();
			
			
			// SQL query to be run to receive data from SQL table
			sqlQuery = "INSERT INTO homes (userId, address1, address2, city, state, zip, yearBuilt, homeValue) values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			// Statement needed to run the sql query
			insertStmt = sqlConnect.prepareStatement(sqlQuery);

			// Set parameters for the prepared statement
			insertStmt.setInt(1, userId);
			insertStmt.setString(2, address1);
			insertStmt.setString(3, address2);
			insertStmt.setString(4, city);
			insertStmt.setString(5, state);
			insertStmt.setInt(6, zip);
			insertStmt.setInt(7, yearBuilt);
			insertStmt.setDouble(8, homeValue);
			
			
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
	
	public List<Home> getHomes() throws SQLException {
		// List to store all Homes
		List<Home> homeList = new ArrayList();
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
			selectQuery = "SELECT * FROM homes";
			
			// Statement needed to run the sql query
			selectStmt = sqlConnect.createStatement();
			
			// run the sql query and return the results to a ResultSet variable
			results = selectStmt.executeQuery(selectQuery);
			
			// iterate through the java result set and set student properties from ArrayList properties
			while (results.next())
			{
				Home home = new Home();
				home.setHomeId(results.getInt("homeId"));
				home.setUserId(results.getInt("userId"));
				home.setAddress1(results.getString("address1"));
				home.setAddress2(results.getString("address2"));
				home.setState(results.getString("state"));
				home.setCity(results.getString("city"));
				home.setZip(results.getInt("zip"));
				home.setHomeValue(results.getDouble("homeValue"));
				homeList.add(home);
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
		return homeList;
	}
	
	public Home getHome(String address1) throws SQLException {
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Declare SQL variables needed to manage connection and read data
		Connection sqlConnect = null;
		PreparedStatement selectStmt = null;
		String selectQuery = null;
		ResultSet results = null;
		Home home = new Home();;
			
		try {
			//Create a connection to MariaDB database
			sqlConnect = mariaDB.getConnection();
			
			// SQL query to be run to get Home from SQL table
			selectQuery = "SELECT * FROM homes WHERE address1 = ?";
			
			// Statement needed to run the sql query
			selectStmt = sqlConnect.prepareStatement(selectQuery);
			selectStmt.setString(1, address1.toString());
			
			// run the sql query 
			results = selectStmt.executeQuery();
			
			while (results.next())
			{
				System.out.println(home.toString());
		
				home.setHomeId(results.getInt("homeId"));
				home.setUserId(results.getInt("userId"));
				home.setAddress1(results.getString("address1"));
				home.setAddress2(results.getString("address2"));
				home.setState(results.getString("state"));
				home.setCity(results.getString("city"));
				home.setZip(results.getInt("zip"));
				home.setHomeValue(results.getDouble("homeValue"));
				
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
		return home;
		
	}
	
	public Boolean updateHome(Home home) throws SQLException {
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();

		// Declare SQL variables needed to manage connection and read data
		Connection sqlConnect = null;
		PreparedStatement updateStmt = null;
		String updateQuery = null;
		int results = -1;
		
		try {
			// SQL query to be run to udpate Home data in SQL table
			updateQuery = "UPDATE homes "
					+ "set userId = ?, "
					+ "address1 = ?, "
					+ "address2 = ?, "
					+ "city = ?, "
					+ "state = ?, "					
					+ "zip = ?, "
					+ "yearBuilt = ?, "
					+ "homeValue = ? "
					+ "where homeId = ?";
			
			//Create a connection to MariaDB database
			sqlConnect = mariaDB.getConnection();
			
			// Statement needed to run the sql query
			updateStmt = sqlConnect.prepareStatement(updateQuery);

			// Set parameters for the prepared statement
			updateStmt.setInt(1, home.getUserId());
			updateStmt.setString(2, home.getAddress1());
			updateStmt.setString(3, home.getAddress2());
			updateStmt.setString(4, home.getCity());
			updateStmt.setString(5, home.getState());
			updateStmt.setInt(6, home.getZip());
			updateStmt.setInt(7, home.getYearBuilt());
			updateStmt.setDouble(8, home.getHomeValue());

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
	
	public boolean removeHome(int id) throws SQLException {
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
			removeQuery = "DELETE FROM Homes where homeId = ?";
			
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
