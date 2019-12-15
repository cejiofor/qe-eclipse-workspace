package com.perscholas.testng_project;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleClassTests01 {
	private static SimpleClass sc = null;
	
	@BeforeClass
	public static void setUp() {
		sc = new SimpleClass();
	}
	
	@Test
	public void returnTrue() {
		assertTrue(sc.returnTrue());
	}
	
	@Test
	public void returnFalse() {
		assertFalse(sc.returnFalse());
	}
}
