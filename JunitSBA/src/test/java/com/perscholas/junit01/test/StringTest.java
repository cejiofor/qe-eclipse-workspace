package com.perscholas.junit01.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.internal.matchers.Matches;

//Test the following methods of the String class: length(), equalsIgnoreCase(String), contentEquals(String Builder), charAt(int), contains(String), startsWith(String), startsWith(String, int), endsWith(String), substring(int, int) and toLowerCase(). Use at least four different JUnit assert methods. Use the test string "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201".

public class StringTest {
	static String testString;
	
	@BeforeClass
	public static void setUp() {
		testString = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
	}
	
	@Test
	public void lengthTest() {
		int expected = 53;
		int actual = testString.length();
		assertSame(expected, actual);
	}
	
	@Test
	public void equalsIgnoreCaseTest() {
		String otherString = "per scholas - 211 n ervay st. #700 - dallas, tX 75201";
		Boolean equal = testString.equalsIgnoreCase(otherString);
		assertEquals(testString.toLowerCase(), otherString.toLowerCase());
		assertEquals(testString.toUpperCase(), otherString.toUpperCase());
		
	}
	
	@Test
	public void contentEqualsTest() {
		StringBuilder sb = new StringBuilder();
		sb.append(testString.substring(0, 20));
		sb.append(testString.substring(20));
		Boolean testSB = testString.contentEquals(sb);
		assertTrue(testSB);
	}
	
	@Test
	public void charAtTest() {
		int i = 5;
		char expected = 'c';
		char actual = testString.charAt(i);
		assertSame(expected, actual);
	}
	
	@Test
	public void containsTest() {
		Boolean actual = testString.contains("alla");
		assertTrue(actual);
		assertNotNull(actual);
	}
	
	
	@Test
	public void startsWithTest() {
		String otherString = "Per Sc";
		assertThat(testString, startsWith(otherString));
	}
	
	@Test
	public void startsWithTest2() {
		Boolean falseStart = testString.startsWith("Scoh", 4);
		assertFalse(falseStart);
	}
	
	@Test
	public void endsWithTest() {
		Boolean falseEnd = testString.endsWith("2201");
		assertFalse(falseEnd);
	}
	
	@Test
	public void  substringTest() {
		String actual = testString.substring(4, 12);
		assertEquals("Scholas ", actual);
	}
	
	@Test
	public void toLowerCaseTest() {
		char[] charArr = testString.toCharArray();
		for(int i = 0; i<charArr.length;i++) {
			if (!Character.isLowerCase(charArr[i])) {
				charArr[i] = Character.toLowerCase(charArr[i]);
			}
		}
		assertEquals(testString.toLowerCase(), String.valueOf(charArr));
		assertNotNull(testString.toLowerCase());
	}
}


