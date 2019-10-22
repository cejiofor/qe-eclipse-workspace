package com.perscholas.junit09.test;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.junit.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.perscholas.junit05.User;
import com.perscholas.junit09.MariaDBConnection;
import com.perscholas.junit09.UserDAO;

//Create a test class to test the DAO. The DAO class should include one method that returns a list. 
//Use the @BeforeClass method to set up the database and test the connection. Test each of CRUD methods. 
//Use the “assumeThat” method in each of the test methods to confirm that the database is connected. 
//
//You will need to insert some records for some of the operations and then delete any test data after the test is completed. 
//Use at least 4 different JUnit assert Satements and 5 different Hamcrest matchers.


public class UserDAOTest {
	// Declare variables need to test database connection
	private static Boolean mariaDBOnline;
	private static MariaDBConnection mariaDB = null;
	private static Connection conn = null;
	private static UserDAO u_dao = null;
	private static User user = null;
	private static Integer userRecords = 0;
	
	
	@BeforeClass
	public static void openDatabaseConnection() throws SQLException{
		u_dao = new UserDAO();
		
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
	
	@Before
	public void setUp() throws SQLException, ClassNotFoundException, IOException{
		User userOne = new User(1, "Bob", "password", 89.0, 99.0);
		User useTwo = new User(2, "Mariah", "passwor0", 92.0, 94.0);
		User userThree = new User(3, "Ashley", "paSsword", 95.0, 85.0);
		u_dao.registerUser(userOne);
		u_dao.registerUser(useTwo);
		u_dao.registerUser(userThree);
		userRecords += 3;
	}
	
	@After
	public void cleanUp() throws SQLException, IOException {
		List<User> userList = u_dao.getAllUsers();
		for (int i = 0; i<userList.size(); i++) {
			u_dao.removeUser(i+1);
		}
	}

	
	@Test
	public void getAllUsersTest() throws SQLException, ClassNotFoundException, IOException 	{
		assumeThat(mariaDBOnline, is(true));
		
		List<User> userList = u_dao.getAllUsers();
		
		assertTrue(userList instanceof List);
		assertTrue(userList.get(0) instanceof User);
		assertThat(userList.get(0).getUserId(),is(userRecords-2));
	}
	
	@Test
	public void getUserById() throws ClassNotFoundException, IOException, SQLException {
		assumeThat(mariaDBOnline, is(true));
		User testUser = u_dao.getUserById(userRecords);
		String name = testUser.getName();
		System.out.println(name);
		assertEquals(name, "Mariah");
		assertThat(name, containsString("riah"));
	}
	
	@Test
	public void registerUserTest() throws ClassNotFoundException, SQLException, IOException {
		assumeThat(mariaDBOnline, is(true));
		User newUser = new User(userRecords+1, "Chris", "eatsFood", 99.0, 99.0);
		Integer newUserID = u_dao.registerUser(newUser);
		
		List<User> userList = u_dao.getAllUsers();
		assertThat(userRecords, lessThan(newUserID));
		assertThat(u_dao.getUserById(newUserID).getName(), is(not("Ashley")));
		assertThat(u_dao.getUserById(newUserID).getName(), is(not("Bob")));
		assertThat(u_dao.getUserById(newUserID).getName(), is(not("Mariah")));
		
	}
	
	@Test
	public void updateUserTest() throws ClassNotFoundException, SQLException, IOException {
		assumeThat(mariaDBOnline, is(true));
		User updatedUser = new User(userRecords, "Ashle", "paSSword", 95.0, 95.0);
		Boolean updated = u_dao.updateUser(updatedUser);
		
		List<User> userList = u_dao.getAllUsers();
		System.out.println(Arrays.toString(userList.toArray()));
		assertThat(userList.get(4).getSqlScore(), both(greaterThan(90.0)).and(lessThan(100.0)));
		assertThat(userList.get(4).getSqlScore(), is(95.0));
		
	}
	
	@Test
	public void removeUserTest() throws SQLException, IOException, ClassNotFoundException {
		assumeThat(mariaDBOnline, is(true));
		int initListSize = u_dao.getAllUsers().size();
		
		Boolean removed = u_dao.removeUser(userRecords);
		List<User> newUserList = u_dao.getAllUsers();
		int newListSize = newUserList.size();
		
		assertTrue(removed);
		assertNotNull(removed);
		assertThat(newListSize, lessThan(initListSize));
	}
}
