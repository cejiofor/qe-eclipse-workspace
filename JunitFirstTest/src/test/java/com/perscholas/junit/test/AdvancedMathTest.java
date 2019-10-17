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

import java.util.Map;

import org.junit.*;

import com.perscholas.junit.BasicMath;
import com.perscholas.junit.AdvancedMath;

public class AdvancedMathTest {
	static BasicMath bm;
	static AdvancedMath am;
	@BeforeClass
	public static void setUp() {
		bm = new BasicMath();
		am = new AdvancedMath();
		
	}
	
	@Test
	public void fxTest() {
		int x = 10;
		int slope = 5;
		int intercept = 3;
		int expected = 5*x+3;
		int actual = (int) am.fx(x, slope, intercept);
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
		double slope = 1;
		double intercept = 0;
		Map<Double, Double> actual = am.spacedPoints(slope,intercept,11);
		assertNotEquals(2.1, actual);
	}	
}

/* 

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;

import org.hamcrest.Matcher;
import org.hamcrest.collection.IsMapContaining;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junitExe.com.HamcrestClass;
import junitExe.com.SimpleClass;

public class HamcrestClassTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void sumHamTest() {
	//	HamcrestClass simple = new HamcrestClass();
			int a = 4;
			int b = 3;
			int actual = HamcrestClass.sum(a, b);
			int expected = 7;
		
			assertThat(expected, is(notNullValue() ) );
			 assertThat(actual,is(HamcrestClass.sum(4, 3)));
			 assertThat(actual,is(expected));
		        assertThat(expected, allOf(greaterThan(a), lessThan(8)));
	}

	@Test
	public void subHamTest() {
	//	HamcrestClass simple = new HamcrestClass();
			int a = 4;
			int b = 3;
			int actual = HamcrestClass.sub(a, b);
			int expected = 1;
		
			assertThat(expected, is(notNullValue() ) );
			 assertThat(actual,is(HamcrestClass.sub(4, 3)));
			 assertThat(actual,is(expected));
		        assertThat(a, allOf(greaterThan(expected), lessThan(5)));
	}
	
	@Test
	public void multHamTest() {
		//HamcrestClass simple = new HamcrestClass();
			int a = 4;
			int b = 3;
			int actual = HamcrestClass.mult(a, b);
			int expected = 12;
		
			assertThat(expected, is(notNullValue() ) );
			 assertThat(actual,is(HamcrestClass.mult(4, 3)));
			 assertThat(actual,is(expected));
		        assertThat(expected, allOf(greaterThan(a), greaterThan(b)));
	}
	
	
	
	 @Test
	    public void listtest() {
		// HamcrestClass simple = new HamcrestClass();
	        assertThat(HamcrestClass.listNames(), hasItem("Amira"));
	    
	 }
	    @Test
	    public void mapmathTest() {
	    	HamcrestClass simple = new HamcrestClass();
	        assertThat(HamcrestClass.mapName(), IsMapContaining.hasKey(3));
	   
	    }
}
*/