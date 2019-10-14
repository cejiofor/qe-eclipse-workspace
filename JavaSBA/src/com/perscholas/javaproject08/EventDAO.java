package com.perscholas.javaproject08;


import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.perscholas.javaproject06.MariaDBConnection;

public class EventDAO {
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
	
	public void createEvent(Event newEvent) {
		int ID = newEvent.getID();
		String name = newEvent.getName();
		String description = newEvent.getDescription();
		java.util.Date eventTime = newEvent.getEventTime();

		//converted to sql date/time
		java.sql.Date sqlEventDate = new java.sql.Date(eventTime.getTime());
		
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
			sqlQuery = "INSERT INTO events (id, name, description, eventTime) values (?, ?, ?, ?)";
			
			// Statement needed to run the sql query
			insertStmt = sqlConnect.prepareStatement(sqlQuery);

			// Set parameters for the prepared statement
			insertStmt.setInt(1, ID);
			insertStmt.setString(2, name);
			insertStmt.setString(3, description);
			insertStmt.setDate(4, sqlEventDate);
			
			// run the sql query and return the results to a ResultSet variable
			insertStmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		EventDAO events = new EventDAO();
		
		String dateOneString ="12/25/2018";  
	    Date dateOne = new SimpleDateFormat("MM/dd/yyyy").parse(dateOneString);  
		Event eventOne = new Event(1, "Christmas", "A december holiday", dateOne);
		
		String dateTwoString ="01/30/1992";  
	    Date dateTwo = new SimpleDateFormat("MM/dd/yyyy").parse(dateTwoString);  
		Event eventTwo = new Event(2, "Birthday", "The day I was born", dateTwo);
		
		events.createEvent(eventOne);
		events.createEvent(eventTwo);
	}

}
