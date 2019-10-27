package com.travelcorps.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.io.IOException;
import java.sql.*;

import com.travelcorps.models.User;

public class UserDAO {
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
				// 1,2 and 3 represent column numbers/positions
				u.setUserID(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setPrimeContact(rs.getBoolean(4));
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
		String insertString = "insert into users (username, password, prime_contact) values (?,?,?)";
		
	    int ID = -1;
	    String[] COL = {"user_id"};
	    
	    MariaDBConnection mariaDB = new MariaDBConnection();
		 
	    try
	    {
	        conn = mariaDB.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        
	        stmt.setString(1, user.getUserName());
	        stmt.setString(2, user.getPassword());
	        stmt.setBoolean(3, user.getPrimeContact());
	       
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
				u.setUserID(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setPrimeContact(rs.getBoolean(4));
				
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
		String qString = "select * from users where username = ?";
		
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
				u = new User();
				u.setUserID(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setPrimeContact(rs.getBoolean(4));
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
				+ "set username = ?, password = ?, prime_contact = ? "
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
			stmt.setString(1, u.getUserName());
			stmt.setString(2, u.getPassword());
			stmt.setBoolean(3, u.getPrimeContact());
			stmt.setInt(4, u.getUserID());
			
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
//		String deleteString = "delete from users where user_id = ?";
		
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
	
	public Boolean resetAutoIncrement() throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		Integer updateResult = null;
		
		// Assign update string to variable
		String updateString = "ALTER TABLE users AUTO_INCREMENT = 3";
		
		// Create MySqlConnection class instance
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = mariaDB.getConnection();
			stmt = conn.createStatement();

			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate(updateString);
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
	
	public Boolean resetTable() throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		Integer updateResult = null;
		
		
		// Create strings that will come together to reset table as sql query
		String varname1 = ""
				+ "SET foreign_key_checks = 0;";

		String varname11 = ""
		+ "DROP TABLE IF EXISTS users;";


		String varname12 = ""
		+ "CREATE TABLE users ( "
		+ "	user_id INT PRIMARY KEY AUTO_INCREMENT NOT NULL, "
		+ "	username VARCHAR(20), "
		+ "	password VARCHAR(20), "
		+ "	prime_contact BOOL "
		+ ");";


		String varname13 = ""
		+ "INSERT INTO users (username, password, prime_contact) VALUES(\"cejiofor\", \"password\", false);";


		String varname14 = ""
		+ "INSERT INTO users (username, password, prime_contact) VALUES(\"bobdylan\", \"password\", false);";


		String varname15 = ""
		+ "INSERT INTO users (username, password, prime_contact) VALUES(\"sjobs\", \"password\", false);";


		String varname16 = ""
		+ "DROP TABLE IF EXISTS volunteers;";


		String varname17 = ""
		+ "CREATE TABLE volunteers ( "
		+ "	volunteer_id int PRIMARY KEY AUTO_INCREMENT, "
		+ "	user_id int NOT NULL, "
		+ "	volunteer_name VARCHAR(100), "
		+ "	email VARCHAR(100), "
		+ "	address VARCHAR(100), "
		+ "	FOREIGN KEY (user_id) REFERENCES users(user_id), "
		+ "	CONSTRAINT `volunteer_user_fk` FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE "
		+ ");";


		String varname18 = ""
		+ "INSERT INTO volunteers (user_id, volunteer_name, email, address) VALUES(1, \"Chris Ejiofor\", \"cejiofor@gmail.com\", \"123 Fake Street, Dallas, TX USA\");";


		String varname19 = ""
		+ "INSERT INTO volunteers (user_id, volunteer_name, email, address) VALUES(2, \"Bob Dylan\", \"bdylan@gmail.com\", \"123 Fake Road, Plano, TX USA\");";


		String varname110 = ""
		+ "INSERT INTO volunteers (user_id, volunteer_name, email, address) VALUES(3, \"Steve Jobs\", \"sjobs@gmail.com\", \"123 Fake Street, Fort Worth, TX USA\");";


		String varname111 = ""
		+ "DROP TABLE IF EXISTS orgs;";


		String varname112 = ""
		+ "CREATE TABLE orgs ( "
		+ "	org_id VARCHAR(100) PRIMARY KEY NOT NULL, "
		+ "	mission_id VARCHAR(100), "
		+ "	org_name VARCHAR(100), "
		+ "	email VARCHAR(100), "
		+ "	address VARCHAR(100), "
		+ "	user_id INT NOT NULL, "
		+ "	CONSTRAINT `orgs_user_fk` FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE "
		+ ");";


		String varname113 = ""
		+ "DROP TABLE IF EXISTS projects;";


		String varname114 = ""
		+ "CREATE TABLE projects ( "
		+ "	project_id INT PRIMARY KEY NOT NULL, "
		+ "	org_name VARCHAR(100), "
		+ "	city VARCHAR(100), "
		+ "	country VARCHAR(100), "
		+ "	startDate DATE, "
		+ "	endDate DATE, "
		+ "	skill_id VARCHAR(100), "
		+ "	address VARCHAR(100), "
		+ "	org_id VARCHAR(100) NOT NULL, "
		+ "	CONSTRAINT `projectOrg_fk` FOREIGN KEY (org_id) REFERENCES orgs (org_id) ON DELETE CASCADE "
		+ ");";


		String varname115 = ""
		+ "DROP TABLE IF EXISTS skills;";


		String varname116 = ""
		+ "CREATE TABLE skills ( "
		+ "	skill_id VARCHAR(100) PRIMARY KEY NOT NULL, "
		+ "	skill_name VARCHAR(100), "
		+ "	description VARCHAR(100) "
		+ ");";


		String varname117 = ""
		+ "DROP TABLE IF EXISTS volunteer_skills;";


		String varname118 = ""
		+ "CREATE TABLE volunteer_skills( "
		+ "	project_id VARCHAR(100) REFERENCES projects(project_id), "
		+ "	volunteer_id VARCHAR(100) REFERENCES volunteers(volunteer_id), "
		+ "	skill_id VARCHAR(100) REFERENCES skills(skill_id) "
		+ ");";


		String varname119 = ""
		+ "DROP TABLE IF EXISTS project_member;";


		String varname120 = ""
		+ "CREATE TABLE project_member( "
		+ "	project_id VARCHAR(100) REFERENCES projects(project_id), "
		+ "	org_id VARCHAR(100) REFERENCES orgs(org_id), "
		+ "	skill_id VARCHAR(100) REFERENCES skills(skill_id), "
		+ "	CONSTRAINT PRIMARY KEY (project_id, org_id) "
		+ ");";

		String varname121 = ""
				+ "SET foreign_key_checks = 1;";
		
		// Create a list of strings to loop over to rund sql queries
		List<String> sqlArr = new ArrayList<String>();
		sqlArr.add(varname1); 
		sqlArr.add(varname11);
		sqlArr.add(varname12);
		sqlArr.add(varname13);
		sqlArr.add(varname14);
		sqlArr.add(varname15); 
		sqlArr.add(varname16);
		sqlArr.add(varname17);
		sqlArr.add(varname18);
		sqlArr.add(varname19);
		sqlArr.add(varname110);
		sqlArr.add(varname111);
		sqlArr.add(varname112);
		sqlArr.add(varname113);
		sqlArr.add(varname114);
		sqlArr.add(varname115);
		sqlArr.add(varname116);
		sqlArr.add(varname117);
		sqlArr.add(varname118);
		sqlArr.add(varname119);
		sqlArr.add(varname120);
		sqlArr.add(varname121);
		
		// Create MySqlConnection class instance
		MariaDBConnection mariaDB = new MariaDBConnection();
		
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = mariaDB.getConnection();
			stmt = conn.createStatement();
			for (String s: sqlArr) {
				// Run query and assign to ResultSet
				updateResult = stmt.executeUpdate(s);
			}
			
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
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		UserDAO udao = new UserDAO();
		User newUser = new User(4, "mariah", "cell1122", false);
		udao.registerUser(newUser);
		
		List<User> newList = udao.getAllUsers();
		
		System.out.println(Arrays.toString(newList.toArray()));
	}
}
