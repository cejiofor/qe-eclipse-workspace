package com.perscholas.junit;

//Assert: Write a class that has 4 methods that perform basic math operations and then use 4 different assert statements to test the class.

/*//Test Suites: Create a test suite to run both of the test classes associated with item 1 and 2 above.

//Exceptions, Write tests for the class provided below. Provide at least one example each of using an optional parameter and using a rule (@Rule) to test for an exception.  Product.javaPreview the document
 
//Test Fixtures, Assume, Parameterized Test: Create a Java project named "JUnit_Exercises". Convert it to a Maven project and create a package that includes a Product class with 3 fields - productId, productName, price. Set up the pom.xml file with MariaDB, JUnit, and Hamcrest dependencies. Create a product table in MariaDB with matching columns. Create a Product DAO class to perform all of the CRUD operations. Create a test class to test the DAO. The DAO class should include one method that returns a list. Use the @BeforeClass method to set up the database and test the connection. Use the @AfterClass method to close the resources (e.g., Connection, Statement/PreparedStatement, ResultSet). Test each of CRUD methods. Use the “assumeThat” method in each of the test methods to confirm that the database is connected. You will need to insert some records for some of the operations and then delete any test data after the test is completed. Use a parameterized test to test the insert method. Use at least 4 different JUnit assert statements and 5 different Hamcrest matchers.
*/

public class BasicMath {

	public int add(int numOne, int numTwo) {
		int sum = numOne + numTwo;
		return sum;
	}
	public int subtract(int numOne, int numTwo) {
		int diff = numOne - numTwo;
		return diff;
	}
	public int multiply(int numOne, int numTwo) {
		int product = numOne * numTwo;
		return product;
	}
	public double divide(double numOne, double numTwo) {
		double divisor = numOne/numTwo;
		return divisor;
	}
}
