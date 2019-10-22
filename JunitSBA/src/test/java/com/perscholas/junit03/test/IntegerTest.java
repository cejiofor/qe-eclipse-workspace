package com.perscholas.junit03.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntegerTest {
	@Test
	public void toBinaryStringTest(){
		int i = 9;
		String expected = "1001"; 
		String actual = Integer.toBinaryString(i);
		assertEquals(expected, actual);
	}
}
