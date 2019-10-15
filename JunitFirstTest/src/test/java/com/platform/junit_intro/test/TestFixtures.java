package com.platform.junit_intro.test;


import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/*
 *  Second design goal: The framework must help us lower the cost of writing tests by reusing code

    Share Similar Objects with use of @Before and @After
        The @Before annotated method will run prior to each test
        The @After annotated method will run after each test
    Share Expensive Set-ups with use of @BeforeClass and @AfterClass
        The @BeforeClass annotated method will only run once prior to all of the tests and must be static
        The @AfterClass annotated method will only run once after all of the tests and also must be static
 */

public class TestFixtures {

	// The @BeforeClass method will run once before all tests
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Setting up BeforeAfterTest test class @ " + LocalTime.now());
	}

	// The @AfterClass method will run once after all tests
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Completing BeforeAfterTest test class @ " + LocalTime.now());
	}

	// The @Before method will run prior to each test method
	@Before
	public void setUp() throws Exception {
		System.out.println("Setting up test method @ " + LocalTime.now());
	}

	// The @After method will run after each test method
	@After
	public void tearDown() throws Exception {
		System.out.println("Tearing down test method @ " + LocalTime.now());
	}
	
	/* Here we see an example of the use of a rule to instantiate a TestName
	 * object which will allow us to return each test method name using the getMethodName()
	 * method. Rules will be discussed more in another section.
	 */
	@Rule public TestName name = new TestName();

	@Test
	public void testOne() {
		System.out.println(name.getMethodName());
		assertTrue(Math.sqrt(25) == 5);
	}
	
	@Test
	public void testTwo() {
		System.out.println(name.getMethodName());
		assertFalse(Math.pow(2, 2) == 5);
	}

}