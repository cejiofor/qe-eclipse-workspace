package com.travelcorps.dao.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
import com.travelcorps.models.User;

public class UserDAOTest {
	private static Boolean mariaDBOnline;   
	private static MariaDBConnection mariaDB = null;
	private static Connection conn = null;
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
	public void registerUserTest() throws ClassNotFoundException, SQLException, IOException {
		assumeThat(mariaDBOnline, is(true));
		
		List<User> userList = udao.getAllUsers();
		int initListSize = userList.size();
		numOfUsers = userList.get(initListSize-1).getUserID();
		
		user = new User(numOfUsers+1, "mariah", "cell1122", false);
		Integer newUserID = udao.registerUser(user);

		userList = udao.getAllUsers();
		int newListSize = userList.size();

		assertThat(newListSize, greaterThan(initListSize));
		assertThat(numOfUsers+1, is(newUserID));
		assertThat(udao.getUserById(newUserID).getUserName(), is("mariah"));
		assertThat(udao.getUserById(newUserID).getUserName(), is(not("bdylan")));
		assertThat(udao.getUserById(newUserID).getUserName(), is(not("sjobs")));
	}
	
	@Test
	public void getUserByIdTest() throws ClassNotFoundException, IOException, SQLException {
		assumeThat(mariaDBOnline, is(true));
		
		assumeThat(mariaDBOnline, is(true));
		int userID = 2;
		user = udao.getUserById(userID);
		assertThat(user.getUserID(), is(userID));
	}
	
	@Test
	public void getUserByNameTest() throws ClassNotFoundException, IOException, SQLException {
		assumeThat(mariaDBOnline, is(true));
		String userName = "bdylan";
		user = udao.getUserByName(userName);
		assertNull(user);
		
		userName = "bobdylan";
		user = udao.getUserByName(userName);
		String testName = user.getUserName();
		assertNotNull(user);
		assertTrue(testName instanceof String);
		assertThat(testName, containsString(userName));
	}
	
	@Test
	public void updateUserTest() throws ClassNotFoundException, IOException, SQLException {
		assumeThat(mariaDBOnline, is(true));
		
		User userUpdate = new User(2, "rdylan", "securePass0rd##", true);
		Boolean updated = udao.updateUser(userUpdate);
		User testUser = udao.getUserById(2);
		
		assertTrue(updated);
		assertNotNull(udao.getUserByName("rdylan"));
		assertThat(testUser.getUserName(), is("rdylan"));
		assertThat(testUser.getUserID(), is(2));	
	}
	@Test
	public void removeUserTest() throws SQLException, IOException {
		assumeThat(mariaDBOnline, is(true));

		int initListSize = udao.getAllUsers().size();
		
		Boolean removed = udao.removeUser(2);
		List<User> newUserList = udao.getAllUsers();
		int newListSize = newUserList.size();
		
		assertTrue(removed);
		assertNotNull(removed);
		assertThat(newListSize, lessThan(initListSize));
	}
}
