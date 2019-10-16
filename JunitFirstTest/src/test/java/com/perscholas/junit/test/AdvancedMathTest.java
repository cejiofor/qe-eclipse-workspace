package com.perscholas.junit.test;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import com.perscholas.junit.BasicMath;
import com.perscholas.junit.AdvancedMath;

public class AdvancedMathTest {
	static BasicMath bm;
	static AdvancedMath am;
	@BeforeClass
	public static void setUp() {
		// TODO Auto-generated constructor stub
		bm = new BasicMath();
		am = new AdvancedMath();
		
	}
	
	@Test
	public void fxTest() {
		int x = 10;
		int expected = 5*x+3;
		int actual = am.fx(x);
		System.out.printf("Expected: %d, Actual: %d%n",expected, actual);
		assertThat(expected, is(equalTo(actual)));
		assertThat(actual, is(notNullValue()));
	}
	
	@Test
	public void averageTest() {
		int[] arr = {5,5,10,10,5};
		double expected = 7.0;
		double actual =  am.average(arr);
		System.out.printf("Expected: %.2f, Actual: %.2f%n",expected, actual);
		assertTrue(expected == actual);
		assertThat(actual, not(7));
		assertThat(actual,allOf(greaterThan(5.0),lessThan(10.0)));

	}
	
	@Test
	public void powerTest() {
		int a = 4;
		int b = 3;
		int expected = 64;
		int actual = am.power(a, b);
		System.out.printf("Expected: %d, Actual: %d%n",expected, actual);
		assertNotNull(actual);
		
	}
	
	@Test
	public void spacedPointsTest() {
		double a = 4;
		double b = 2;
		double actual = bm.divide(a, b);
		assertNotEquals(2.1, actual);
	}
	
}
