package com.perscholas.junit.test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.junit.Product;
import com.perscholas.junit.exceptions.MaximumQuantityExceededException;

@RunWith(Parameterized.class)
public class MaximumQuantityExceededExceptionTest{
	//Declare Attributes
	private static Product product;
	private static Integer availableQuantity;
	private static Class<? extends Exception> expectedException;

	//Constructor, with arguements following order or parameters to be run in 2D Object array
	public MaximumQuantityExceededExceptionTest(int availableQuantityquantiti) {
		//  
	}
	
	//Set up the parameters in a 2d object
	@Parameters()
	public static Collection<Object[]> data() {
		return Arrays.asList(
				new Object[][] {
								{26},
								{500}	
								});
	}
	
	// Create static class variable to run test methods for Product class
	@BeforeClass
	public static void setUp() {
		product = new Product();
		System.out.println(product.toString());
	}
	
    /* Rules are discussed more in depth in another lesson, but here is an
     * example of one application. */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void productTest() throws MaximumQuantityExceededException {
        // Setup expected exception
        if (expectedException != null) {
            thrown.expect(expectedException);
        }

        product.setAvailableQuantity(26);;
    }
	
//	@After
//	public void reset() throws IllegalArgumentException, MaximumQuantityExceededException {
//		product.setAvailableQuantity(25);
//	}
	
//	
//    // Run the test
//    @Test
//    public void productTest() {
//    	double actual = additionClass.addTwoNumbers(num1, num2);
//
//    	if (actual == testSum) {
//    		confirmation = true;
//        	assertThat(actual, equalTo(testSum));
//    	} else {
//    		confirmation = false;
//        	assertThat(actual, not(equalTo(testSum)));
//    	}
//
//    	System.out.printf("%.2f + %.2f = %.2f is %s\n",
//    			num1, num2, testSum, Boolean.toString(confirmation));
//
//    }
}
