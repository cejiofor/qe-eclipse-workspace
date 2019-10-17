package com.perscholas.junit.test;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category ({ TestEnv.class })
public class ShoppingCartTests {

	@Test
	public void addProductTest() {
		System.out.println("Printed from the addProductTest method");
	}
	
	@Test
	public void removeProductTest() {
		System.out.println("Printed from the removeProductTest method");
	}
	
	@Category ({ ProductionEnv.class })
	@Test
	public void checkTimeOutTest() {
		System.out.println("Printed from the checkTimeOutTest method");
	}


}
