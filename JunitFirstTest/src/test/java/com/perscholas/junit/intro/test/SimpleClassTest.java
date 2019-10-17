package com.perscholas.junit.intro.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.perscholas.junit.intro.SimpleClass;

public class SimpleClassTest {
	private static SimpleClass sc;
	
	@BeforeClass
	public static void createSimpleClass() {
		sc = new SimpleClass();
	}
	
	@Test
	public void returnTrueTest() {
		SimpleClass sc = new SimpleClass();
		boolean actual = sc.returnTrue();
		assertTrue(actual);
	}
	
	@Test
	public void returnNullTest() {
		SimpleClass sc = new SimpleClass();
		Object actual = sc.returnNull();
//		assertTrue(actual == null);
		assertNull(actual);
	}
	
	@Test
	public void returnNotNullTest() {
		Object actual = sc.returnNotNull();
		assertNotNull(actual);
	}
	
	@Test
	public void returnOneTest() {
		int actual = sc.returnOne();
		assertTrue(actual == 1);
	}
	
	@Test 
	public void returnListTest() {
		List<String> actual = sc.returnList();
		List<String> expected = new ArrayList<String>();
		expected.add("red");
		expected.add("green");
		expected.add("blue");
		assertThat(actual, is(expected)); //Hamcrest
	}
	
	public void returnObjectsTest() {
		Object obj1 = sc.returnNotNull();
		Object obj2 = sc.returnNotNull();
		assertThat(obj1, sameInstance(obj2));
	}
	
	@Test 
	public void returnHashMapTest() {
		Map<String,String> actual = sc.returnHashMap();
		Map<String,String> testMap = new HashMap<String, String>();
		
	}

}