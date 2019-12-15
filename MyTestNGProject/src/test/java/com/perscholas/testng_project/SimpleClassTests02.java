package com.perscholas.testng_project;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleClassTests02 {
	private static SimpleClass sc = null;
	
	@BeforeClass
	public static void setUp() {
		sc = new SimpleClass();
	}
	
	@Test
	public void returnList() {
		List<String> colors = sc.returnList();
		assertThat(colors, hasItem("red"));
	}
	
	@Test
	public void returnMap() {
		Map<String, String> names = sc.returnHashMap();
		assertTrue(names.containsValue("Jane"));
	}
}
