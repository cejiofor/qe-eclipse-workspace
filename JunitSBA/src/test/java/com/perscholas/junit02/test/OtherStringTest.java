package com.perscholas.junit02.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class OtherStringTest {
	static String testString;
	
	@BeforeClass
	public static void setUp() {
		testString = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
	}
	
	@Test
	public void splitTest() {
		String[] strArr = testString.split(" - ");
		for (int i = 0; i<strArr.length; i++) {
			assertEquals(strArr[i],Character.toString(testString.charAt(i)));
		}
	}
	
	@Test
	public void joinTest() {
		String[] strArr = new String[] {"Per Scholas","211 N Ervay St. #700","Dallas, TX 75201"};
		String newString = String.join(" - ", strArr);
		assertEquals(newString, testString);
	}
}
