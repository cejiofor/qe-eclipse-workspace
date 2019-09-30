package com.platform.simpleloginapp.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class SimpleLoginDAO {
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
	
	
	public Boolean userExisits(String usrname) throws ClassNotFoundException, IOException, SQLException {
			// Declare, instantiate, and initialize a new mariaDB connection object
			MariaDBConnection mariaDB = new MariaDBConnection();
			
			// Create a connection to mariaDB
			Connection sqlConnect = mariaDB.getConnection();
			
			//Create s SQL string query that will run on the sql database 
			String sqlQuery = "SELECT username FROM Users";
			
			//Create a statement object to send the String query to SQL
			Statement query = sqlConnect.createStatement();
			
			ResultSet usernames = query.executeQuery(sqlQuery);
			
			ArrayList<String> validUsers = new ArrayList<String>();
			
			while(usernames.next()) {
				validUsers.add(usernames.getString("username"));
				
				System.out.println(usernames.getString("username"));
			}
		
			sqlConnect.close();
			
			return validUsers.contains(usrname);
	}
	
	public HashMap<String, String> validUsers() throws ClassNotFoundException, IOException, SQLException {
		// Declare, instantiate, and initialize a new mariaDB connection object
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Create a connection to mariaDB
		Connection sqlConnect = mariaDB.getConnection();
		
		//Create s SQL string query that will run on the sql database 
		String sqlQuery = "SELECT username, password FROM Users";
		
		//Create a statement object to send the String query to SQL
		Statement query = sqlConnect.createStatement();
		
		ResultSet results = query.executeQuery(sqlQuery);
		
		ArrayList<String> validUsers = new ArrayList<String>();
		HashMap<String, String> userMap = new HashMap<>(); 
		
		while(results.next()) {
			
			userMap.put(results.getString("username"), results.getString("password"));
			
			System.out.println(results.getString("username")+ results.getString("password"));
		}
	
		sqlConnect.close();
		
		return userMap;
}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		SimpleLoginDAO testLogin = new SimpleLoginDAO();
		testLogin.testConnection();
		
		// Declare, instantiate, and initialize a new mariaDB connection object
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Create a connection to mariaDB
		Connection sqlConnect = mariaDB.getConnection();
		
		//REVIEW
//		try {
//			Connection sqlConnect = mariaDB.getConnection();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		//Create s SQL string query that will run on the sql database 
		String sqlQuery = "SELECT username FROM Users";
		
		//Create a statement object to send the String query to SQL
		Statement query = sqlConnect.createStatement();
		
		ResultSet usernames = query.executeQuery(sqlQuery);
		
		ArrayList<String> validUsers = new ArrayList<String>();
		
		while(usernames.next()) {
			validUsers.add(usernames.getString("username"));
			
			System.out.println(usernames.getString("username"));
		}
		
		sqlConnect.close();
		
		
		
	}
}

