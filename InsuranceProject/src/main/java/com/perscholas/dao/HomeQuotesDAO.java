package com.perscholas.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.models.Home;
import com.perscholas.models.HomeQuote;

public class HomeQuotesDAO {
	public Boolean addHomeQuotes() 
			throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Integer queryResult = null;
		
		// Assign insert statement string to variable
		String varname1 = ""
				+ "drop table if exists homequotes;";
		String varname11 = ""
		+ "CREATE TABLE homequotes AS "
		+ "  (SELECT homes.*, "
		+ "  			quotes.quoteId, "
		+ "  			quotes.yearlyPremium, "
		+ "			quotes.active "
		+ "   FROM  quotes "
		+ "         INNER JOIN homes "
		+ "         ON quotes.homeId = homes.homeId);";
		
		// Create a list of strings to loop over to rund sql queries
		List<String> sqlArr = new ArrayList<String>();
		sqlArr.add(varname1); 
		sqlArr.add(varname11);
		
		
		MariaDBConnection mariaDB = new MariaDBConnection();
		
	    try
	    {
	        conn = mariaDB.getConnection();
	        stmt = conn.createStatement();
	        for (String s: sqlArr) {
				// Run query and assign to ResultSet
	        	queryResult = stmt.executeUpdate(s);
			}

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
        if (queryResult > 0) {
        	System.out.println("true");
        	return true;
        }
        System.out.println("false");
		return false;
	}
	
	public List<HomeQuote> getHomeQuotes() throws SQLException {
		// List to store all Homes
		List<HomeQuote> homequotesList = new ArrayList();
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
			selectQuery = "SELECT * FROM homequotes";
			
			// Statement needed to run the sql query
			selectStmt = sqlConnect.createStatement();
			
			// run the sql query and return the results to a ResultSet variable
			results = selectStmt.executeQuery(selectQuery);
			
			// iterate through the java result set and set student properties from ArrayList properties
			while (results.next())
			{
				HomeQuote homequote = new HomeQuote();
				homequote.setHomeId(results.getInt("homeId"));
				homequote.setUserId(results.getInt("userId"));
				homequote.setAddress1(results.getString("address1"));
				homequote.setAddress2(results.getString("address2"));
				homequote.setState(results.getString("state"));
				homequote.setCity(results.getString("city"));
				homequote.setZip(results.getInt("zip"));
				homequote.setHomeValue(results.getDouble("homeValue"));
				homequote.setQuoteId(results.getInt("quoteId"));
				homequote.setYearlyPremium(results.getDouble("yearlyPremium"));
                homequote.setActive(results.getBoolean("active"));
                homequotesList.add(homequote);
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
		return homequotesList;
	}
}