package com.perscholas.junit.dao.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assume.assumeThat;
import static org.junit.Assume.assumeTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.perscholas.junit.dao.MariaDBConnection;
import com.perscholas.junit.dao.Product;
import com.perscholas.junit.dao.ProductDAO;

//Test Fixtures, Assume, Parameterized Test: Create a package that includes a Product class with 3 fields - productId, productName, price. 
//Set up the pom.xml file with MariaDB, JUnit, and Hamcrest dependencies. Create a product table in MariaDB with matching columns. Create a Product DAO class to perform all of the CRUD operations. Create a test class to test the DAO. The DAO class should include one method that returns a list. 
//Use the @BeforeClass method to set up the database and test the connection. Use the @AfterClass method to close the resources (e.g., Connection, Statement/PreparedStatement, ResultSet). 
//Test each of CRUD methods. Use the “assumeThat” method in each of the test methods to confirm that the database is connected. 
//You will need to insert some records for some of the operations and then delete any test data after the test is completed. 
//Use a parameterized test to test the insert method. Use at least 4 different JUnit assert statements and 5 different Hamcrest matchers.




public class ProductDAOTest {
	// Declare variables need to test database connection
	private static Boolean mariaDBOnline;
	private static MariaDBConnection mariaDB = null;
	private static Connection conn = null;
	private static ProductDAO p_dao = null;
	private Product product;
	
	@BeforeClass
	public void testDatabaseConnection() throws SQLException{
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
	
	@Before
	public void setUp() throws SQLException{
		assumeTrue(mariaDBOnline);
//		assumeThat(conn, not(null));
	}
	
	@After
	public void tearDown() {
		
	}
	
	@AfterClass
	public void cleanUp() throws SQLException {
		conn.close();
	}

	
	@Test
	public void getProductsTest() {
		// Check to see if returns a list
		// check list to see if it has some name
		
	}
	
	@Test
	public void getProductTest() {
		// check to see that a product is returned
		// run a method on product, make sure it matches
		
	}
	
	@Test
	public void updateProductTest() {
		// check to see that product has change
		// check for updated product id after the fact
		
	}
	
	@Test
	public void removeProductTest() {
		// check to see that number of prducts is less
		// check to see that get product by name fails
		
	}

}
