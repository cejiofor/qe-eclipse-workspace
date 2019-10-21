package com.perscholas.junit.test;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.perscholas.junit.Product;

import com.perscholas.junit.exceptions.MaximumQuantityExceededException;
import com.perscholas.junit.exceptions.InsufficientQuantityException;


// Edge cases
//setName - use other characters
	// name char != non-alphanumeric characters - illegalarg
//SetDescription
	// length <100 hcars - illegalargs
// SetAvailablequantitu
	// quantit > 500 = maxexceeded
	// quanity < 1 - illegalarg
// reduceAvailableQuantity
	// numbersold > numavail - insufficentquality
// restock inventory
	// numItems <1 - illegalargs
	// numitem+avalqualt > 500 - mamxquantexceed
public class ProductExceptionTest {
	private static Product product;
	
	
	@BeforeClass
	public static void setUp() {
		product = new Product();
	}
	
	/* Use the @Test optional parameter to test for the MaximumQuantityExceededException  
	 */
	@Test(expected = MaximumQuantityExceededException.class)
	public void throwMaximumQuantityExceededException() throws MaximumQuantityExceededException {
		product.setAvailableQuantity(590);
		throw new MaximumQuantityExceededException();
		
	}

	@Rule
	public ExpectedException ee = ExpectedException.none();
	
	@Test
	public void throwInsufficientQuantityException() throws InsufficientQuantityException{
		ee.expect(InsufficientQuantityException.class);
		product.reduceAvailableQuantity(50);
		throw new InsufficientQuantityException();
	}
}
