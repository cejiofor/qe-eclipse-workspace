package com.platform.junit_intro.test;

import static org.junit.Assert.assertTrue;
// import org.junit.*;
import org.junit.Test;

import com.platform.junit_into.SimpleClass;


public class SimpleClassTest {
	@Test
	public void returnTrueTest() {
		SimpleClass sc = new SimpleClass();
		assertTrue(sc.returnTrue());
	}
}
