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
import org.junit.BeforeClass;
import org.junit.Test;

import com.travelcorps.dao.MariaDBConnection;
import com.travelcorps.dao.OrganizationDAO;
import com.travelcorps.models.Organization;

public class OrganizationDAOTest {
	private static Boolean mariaDBOnline;   
	private static MariaDBConnection mariaDB = null;
	private static Connection conn = null;
	private static OrganizationDAO odao = null;
	private static Organization org = null;
	private static Integer numOfOrgs = null;
	
	
	@BeforeClass
	public static void openDatabaseConnection() throws SQLException{
		odao = new OrganizationDAO();
		
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
		odao.resetTable();
	}
	
	@Test
	public void getAllOrgsTest() throws SQLException, ClassNotFoundException, IOException 	{
		assumeThat(mariaDBOnline, is(true));
		List<Organization> orgList = odao.getAllOrgs();
		assertTrue(orgList instanceof List);
		assertTrue(orgList.get(0) instanceof Organization);
		assertThat(orgList.get(0).getOrgID(),is(1));
	}
	
//	@Test
//	public void registerOrganizationTest() throws ClassNotFoundException, SQLException, IOException 	{
//		assumeThat(mariaDBOnline, is(true));
//		
//		List<Organization> orgList = odao.getAllOrgs();
//		int initListSize = orgList.size();
//		numOfOrgs = orgList.get(initListSize-1).getOrgID();
//		
//		org = new Organization("BCBS", "www.org.com", "Read learna nd grow", "main@bcbs.org", "123 Fake Street");
//		Integer newOrgID = odao.registerOrg(org);
//
//		orgList = odao.getAllOrgs();
//		int newListSize = orgList.size();
//		
//
//		assertThat(newListSize, greaterThan(initListSize));
//		assertThat(numOfOrgs+1, is(newOrgID));
//		assertThat(odao.getOrgById(newOrgID).getOrgName(), is("Mariah"));
//		assertThat(odao.getOrgById(newOrgID).getOrgName(), is(not("Bob Dylan")));
//		assertThat(odao.getOrgById(newOrgID).getOrgName(), is(not("Steve Jobs")));
//	}
//
//	@Test
//	public void getOrgByIdTest() throws ClassNotFoundException, IOException, SQLException 
//	{
//		assumeThat(mariaDBOnline, is(true));
//		int orgID = 2;
//		org = odao.getOrgById(orgID);
//		assertThat(org.getOrgID(), is(orgID));
//	}
//	
//	@Test
//	public void getOrganizationByNameTest() throws ClassNotFoundException, IOException, SQLException 	{
//		assumeThat(mariaDBOnline, is(true));
//		
//		String orgName = "Bob Dylan";
//		
//		org = odao.getOrgByName(orgName);
//		String testName = org.getOrgName();
//		
//		assertNotNull(org);
//		assertTrue(testName instanceof String);
//		assertThat(testName, containsString(orgName));
//		
//	}
//
//	@Test
//	public void updateOrganizationTest() throws ClassNotFoundException, SQLException, IOException
//	{
//		assumeThat(mariaDBOnline, is(true));
//		
//		Organization orgUpdate = new Organization(3, "Robert Dylan", "rdylan@gmail.com", "3456 New Street");
//		Boolean updated = odao.updateOrg(orgUpdate);
//		Organization testOrganization = odao.getOrgById(3);
//		
//		assertTrue(updated);
//		assertNotNull(odao.getOrgByName("Robert Dylan"));
//		assertThat(testOrganization.getOrgName(), is("Robert Dylan"));
//		assertThat(testOrganization.getOrgID(), is(3));		
//	}
//	
//	@Test
//	public void removeUserTest() throws SQLException, IOException, ClassNotFoundException 
//	{
//		assumeThat(mariaDBOnline, is(true));
//		int initListSize = odao.getAllOrgs().size();
//		
//		Boolean removed = odao.removeOrg(2);
//		List<Organization> newUserList = odao.getAllOrgs();
//		int newListSize = newUserList.size();
//		
//		assertTrue(removed);
//		assertNotNull(removed);
//		assertThat(newListSize, lessThan(initListSize));
//	}

}
