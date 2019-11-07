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

import com.perscholas.models.Quote;

public class QuoteDAO {
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
	
	public Integer createQuote(Quote quote) throws SQLException {
        int homeId = quote.getHomeId();
        double yearlyPremium = quote.getYearlyPremium();
        LocalDate starDate = quote.getStartDate();
        LocalDate expiration = quote.getExpiration();
        Boolean active = quote.isActive();
		
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
			sqlQuery = "INSERT INTO quotes (homeId, yearlyPremium, startDate, expiration, active) values (?, ?, ?, ?, ?)";
			
			// Statement needed to run the sql query
			insertStmt = sqlConnect.prepareStatement(sqlQuery);

			// Set parameters for the prepared statement
			insertStmt.setInt(1, homeId);
			insertStmt.setDouble(2, yearlyPremium);
			insertStmt.setDate(3, Date.valueOf(starDate));
            insertStmt.setDate(4, Date.valueOf(expiration));
            insertStmt.setBoolean(5, active);
			
			
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
	
	public List<Quote> getQuotes() throws SQLException {
		// List to store all Quotes
		List<Quote> quoteList = new ArrayList();
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
			selectQuery = "SELECT * FROM quotes";
			
			// Statement needed to run the sql query
			selectStmt = sqlConnect.createStatement();
			
			// run the sql query and return the results to a ResultSet variable
			results = selectStmt.executeQuery(selectQuery);
			
			// iterate through the java result set and set student properties from ArrayList properties
			while (results.next())
			{
				Quote quote = new Quote();
				quote.setQuoteId(results.getInt("quoteId"));
				quote.setHomeId(results.getInt("homeId"));
				quote.setYearlyPremium(results.getDouble("yearlyPremium"));
				quote.setStartDate(results.getDate("startDate").toLocalDate());
                quote.setExpiration(results.getDate("expiration").toLocalDate());
                quote.setActive(results.getBoolean("active"));
				quoteList.add(quote);
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
		return quoteList;
	}
	
	public Quote getQuote(String name) throws SQLException {
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Declare SQL variables needed to manage connection and read data
		Connection sqlConnect = null;
		PreparedStatement selectStmt = null;
		String selectQuery = null;
		ResultSet results = null;
		Quote quote = new Quote();;
			
		try {
			//Create a connection to MariaDB database
			sqlConnect = mariaDB.getConnection();
			
			// SQL query to be run to get Quote from SQL table
			selectQuery = "SELECT * FROM quotes WHERE name = ?";
			
			// Statement needed to run the sql query
			selectStmt = sqlConnect.prepareStatement(selectQuery);
			selectStmt.setString(1, name.toString());
			
			// run the sql query 
			results = selectStmt.executeQuery();
			
			while (results.next())
			{
				System.out.println(quote.toString());
				quote.setQuoteId(results.getInt("quoteId"));
				quote.setHomeId(results.getInt("homeId"));
				quote.setYearlyPremium(results.getDouble("yearlyPremium"));
				quote.setStartDate(results.getDate("startDate").toLocalDate());
                quote.setExpiration(results.getDate("expiration").toLocalDate());
                quote.setActive(results.getBoolean("active"));
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
		return quote;
		
	}
	
	public Boolean updateQuote(Quote quote) throws SQLException {
		// Create an instance of the mariaDB connection
		MariaDBConnection mariaDB = new MariaDBConnection();

		// Declare SQL variables needed to manage connection and read data
		Connection sqlConnect = null;
		PreparedStatement updateStmt = null;
		String updateQuery = null;
		int results = -1;
		
		try {
			// SQL query to be run to udpate Quote data in SQL table
			updateQuery = "UPDATE quotes "
					+ "set homeId = ?, "
					+ "yearlyPremium = ?, "
					+ "startDate = ?, "
					+ "expiration = ?, "
					+ "active = ? "
					+ "where quoteId = ?";
			
			//Create a connection to MariaDB database
			sqlConnect = mariaDB.getConnection();
			
			// Statement needed to run the sql query
			updateStmt = sqlConnect.prepareStatement(updateQuery);

			// Set parameters for the prepared statement
			updateStmt.setInt(1, quote.getHomeId());
			updateStmt.setDouble(2, quote.getYearlyPremium());
			updateStmt.setDate(3, Date.valueOf(quote.getStartDate()));
            updateStmt.setDate(4, Date.valueOf(quote.getExpiration()));
            updateStmt.setBoolean(5, quote.isActive());
			
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
	
	public boolean removeQuote(int id) throws SQLException {
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
			removeQuery = "DELETE FROM Quotes where quoteId = ?";
			
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
