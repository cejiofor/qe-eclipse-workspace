package com.travelcorps.dao.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.travelcorps.dao.MariaDBConnection;
import com.travelcorps.dao.UserDAO;
import com.travelcorps.dao.VolunteerDAO;
import com.travelcorps.models.User;
import com.travelcorps.models.Volunteer;

public class UserDAOTest {
	private static Boolean mariaDBOnline;   
	private static MariaDBConnection mariaDB = null;
	private static Connection conn = null;
	private static VolunteerDAO v_dao = null;
	private static UserDAO udao = null;
	private static User user = null;
	private static Integer numOfUsers = null;
	
	@BeforeClass
	public static void openDatabaseConnection() throws SQLException{
		udao = new UserDAO();
		try {
			mariaDB = new MariaDBConnection();
			conn = mariaDB.getConnection();
			mariaDBOnline = true;
			System.out.println("Connected to MariaDB!");
		}
		catch(Exception e) {
			mariaDBOnline = false;
			System.out.println("Database connection failed. Tests will be skipped");
		}
	}
	
	@AfterClass
	public static void closeDatabaseConnection() throws SQLException {
		try {
            if(conn != null) {
                conn.close();
    			mariaDBOnline = false;
                System.out.println("Connection closed");
            }
        }
        catch(Exception e) {
        	System.out.println("Error: " + e.getMessage());
        }
	}
	
	
	@After
	public void cleanUp() throws ClassNotFoundException, SQLException, IOException {
		udao.resetTable();
	}

	@Test
	public void getAllUsersTest() throws SQLException {
		assumeThat(mariaDBOnline, is(true));
		List<User> userList = udao.getAllUsers();
		assertThat(userList instanceof List, is(true));
		assertTrue(userList.get(0) instanceof User);
		assertThat(userList.get(0).getUserName(), equalTo("cejiofor"));
	}
	
	@Test
	public void registerUserTest() {
		assumeThat(mariaDBOnline, is(true));
		
	}
	@Test
	public void getUserByIdTest() {
		assumeThat(mariaDBOnline, is(true));
		
	}
	@Test
	public void getUserByNameTest() {
		assumeThat(mariaDBOnline, is(true));
		
	}
	@Test
	public void updateUserTest() {
		assumeThat(mariaDBOnline, is(true));
		
	}
	@Test
	public void removeUserTest() {
		assumeThat(mariaDBOnline, is(true));
		
	}
}
