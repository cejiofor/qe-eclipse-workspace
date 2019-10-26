package com.travelcorps.dao.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.travelcorps.dao.MariaDBConnection;
import com.travelcorps.dao.UserDAO;
import com.travelcorps.dao.VolunteerDAO;
import com.travelcorps.models.User;
import com.travelcorps.models.Volunteer;


public class VolunteerDAOTest {
	private static Boolean mariaDBOnline;   
	private static MariaDBConnection mariaDB = null;
	private static Connection conn = null;
	private static VolunteerDAO vdao = null;
	private static UserDAO udao = null;
	private static Volunteer volunteer = null;
	private static Integer numOfVolunteers = null;
	
	
	@BeforeClass
	public static void openDatabaseConnection() throws SQLException{
		vdao = new VolunteerDAO();
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
		vdao.resetTable();
	}
	
	@Test
	public void getAllVolunteersTest() throws SQLException, ClassNotFoundException, IOException 	{
		assumeThat(mariaDBOnline, is(true));
		List<Volunteer> volunteerList = vdao.getAllVolunteers();
		assertTrue(volunteerList instanceof List);
		assertTrue(volunteerList.get(0) instanceof Volunteer);
		assertThat(volunteerList.get(0).getVolunteerID(),is(1));
	}
	
	@Test
	public void registerVolunteerTest() throws ClassNotFoundException, SQLException, IOException 	{
		assumeThat(mariaDBOnline, is(true));
		
		List<Volunteer> volunteerList = vdao.getAllVolunteers();
		int initListSize = volunteerList.size();
		numOfVolunteers = volunteerList.get(initListSize-1).getVolunteerID();
		
		UserDAO udao = new UserDAO();
		User newUser = new User(numOfVolunteers+1, "mariah", "cell1122", false);
		udao.registerUser(newUser);
		
		volunteer = new Volunteer(newUser, "Mariah", "mariah@gmail.com", "123 Fake Street");
		Integer newUserID = vdao.registerVolunteer(volunteer);

		volunteerList = vdao.getAllVolunteers();
		int newListSize = volunteerList.size();
		

		assertThat(newListSize, greaterThan(initListSize));
		assertThat(numOfVolunteers+1, is(newUserID));
		assertThat(vdao.getVolunteerById(newUserID).getVolunteerName(), is("Mariah"));
		assertThat(vdao.getVolunteerById(newUserID).getVolunteerName(), is(not("Bob Dylan")));
		assertThat(vdao.getVolunteerById(newUserID).getVolunteerName(), is(not("Steve Jobs")));
	}

	@Test
	public void getVolunteerByIdTest() throws ClassNotFoundException, IOException, SQLException 
	{
		assumeThat(mariaDBOnline, is(true));
		int volID = 2;
		volunteer = vdao.getVolunteerById(volID);
		assertThat(volunteer.getUserID(), is(volID));
	}
	
	@Test
	public void getVolunteerByNameTest() throws ClassNotFoundException, IOException, SQLException 	{
		assumeThat(mariaDBOnline, is(true));
		
		String volName = "Bob Dylan";
		
		volunteer = vdao.getVolunteerByName(volName);
		String testName = volunteer.getVolunteerName();
		
		assertNotNull(volunteer);
		assertTrue(testName instanceof String);
		assertThat(testName, containsString(volName));
		
	}

	@Test
	public void updateVolunteerTest() throws ClassNotFoundException, SQLException, IOException
	{
		assumeThat(mariaDBOnline, is(true));
		
		Volunteer volunteerUpdate = new Volunteer(3, "Robert Dylan", "rdylan@gmail.com", "3456 New Street");
		Boolean updated = vdao.updateVolunteer(volunteerUpdate);
		Volunteer testVolunteer = vdao.getVolunteerById(3);
		
		assertTrue(updated);
		assertNotNull(vdao.getVolunteerByName("Robert Dylan"));
		assertThat(testVolunteer.getVolunteerName(), is("Robert Dylan"));
		assertThat(testVolunteer.getVolunteerID(), is(3));		
	}
	
	@Test
	public void removeUserTest() throws SQLException, IOException, ClassNotFoundException 
	{
		assumeThat(mariaDBOnline, is(true));
		int initListSize = vdao.getAllVolunteers().size();
		
		Boolean removed = vdao.removeVolunteer(2);
		List<Volunteer> newUserList = vdao.getAllVolunteers();
		int newListSize = newUserList.size();
		
		assertTrue(removed);
		assertNotNull(removed);
		assertThat(newListSize, lessThan(initListSize));
	}

}
