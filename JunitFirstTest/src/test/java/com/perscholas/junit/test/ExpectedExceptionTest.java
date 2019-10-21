package com.perscholas.junit.test;


import java.io.FileNotFoundException;
import java.sql.SQLException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExpectedExceptionTest {
	/* This example uses the @Test optional parameter to test
	 * for an exception.
	 */
	@Test(expected = FileNotFoundException.class)
	public void throwFileNotFound() throws FileNotFoundException {
		/* The following line would be replaced with code that would be 
		 * expected to throw a FileNotFoundException.
		 */
		throw new FileNotFoundException();
	}

	// This example uses a rulee
	@Rule
	public ExpectedException ee = ExpectedException.none();
	
	@Test
	public void throwSQLException() throws SQLException {
		ee.expect(SQLException.class);
		/* The following line would be replaced with code that would be 
		 * expected to throw an SQLException.
		 */
		throw new SQLException();
	}
	
}
