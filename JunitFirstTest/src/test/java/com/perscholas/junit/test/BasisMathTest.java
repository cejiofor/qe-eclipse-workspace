package com.perscholas.junit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import com.perscholas.junit.BasicMath;

public class BasisMathTest {
	static BasicMath bm;
	@BeforeClass
	public static void setUp() {
		// TODO Auto-generated constructor stub
		bm = new BasicMath();
		
	}
	
	@Test
	public void addTest() {
		int a = 4;
		int b = 2;
		assertEquals(a+b, bm.add(a,b));
	}
	
	@Test
	public void subtractTest() {
		int a = 4;
		int b = 2;
		int expected = a-b;
		int actual =  bm.subtract(a, b);
		assertTrue(expected == actual);
	}
	
	@Test
	public void multiplyTest() {
		int a = 4;
		int b = 2;
		int actual = bm.multiply(a, b);
		assertNotNull(actual);
	}
	
	@Test
	public void divideTest() {
		double a = 4;
		double b = 2;
		double actual = bm.divide(a, b);
		assertNotEquals(2.1, actual);
	}
	
}
