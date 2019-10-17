package com.perscholas.junit.test;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category ({TestEnv.class})
public class ProductTests {

	@Test
	public void createProductTest() {
		System.out.println("Printed from the createProductTest method");
	}
	
	@Category ({ ProductionEnv.class })
	@Test
	public void restockInventoryTest() {
		System.out.println("Printed from the restockInventoryTest method");
	}

}
