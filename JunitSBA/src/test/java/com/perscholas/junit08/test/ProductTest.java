package com.perscholas.junit08.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import com.perscholas.junit08.Product;

//Demonstrate the use of a mock object to instantiate the Product abstract class. Test one of the methods.


public class ProductTest {
	private static Product mockProduct;
	
	@BeforeClass
	public static void setUp() {
	    mockProduct = Mockito.mock(
		  	      Product.class, 
		  	      Mockito.CALLS_REAL_METHODS);
	}
	
	@Test
	public void setNameTest() {
		mockProduct.setName("Laptop");
		assertEquals("Laptop", mockProduct.getName());
		
	}
	

}
