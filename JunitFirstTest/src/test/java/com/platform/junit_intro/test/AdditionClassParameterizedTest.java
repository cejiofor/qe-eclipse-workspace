package com.platform.junit_intro.test;


import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.platform.junit_into.AdditionClass;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

// Annotate class with @RunWith(Parameterized.class)
@RunWith(Parameterized.class)
public class AdditionClassParameterizedTest {
	// Declare atttibutes
	private static AdditionClass additionClass;
	private double num1 = 0;
	private double num2 = 0;
	private double testSum = 0;
	private Boolean confirmation;

	/* Create the constructor. The order of arguments in the parentheses
	 * determines the parameter position in the two-dimensional Object arrays.
	 * Parameter1 = argument num1, Parameter2 = argument num2,
	 * Parameter3 = argument testSum, Parameter4 = argument confirmation*/
	public AdditionClassParameterizedTest(double num1, double num2,
			double testSum, Boolean confirmation) {
		this.num1 = num1;
		this.num2 = num2;
		this.testSum = testSum;
		this.confirmation = confirmation;
	}

	/* Set up the parameters. The confirmation parameter is null and will
	 * be assigned in the actual test method depending on accuracy of
	 * the addition result. */
	@Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                		{ 1, 1, 2, null },
                		{ 2, 2, 4, null },
                		{ 3, 3, 6, null },
                		{ 4, 4, 15, null }
                		});
    }

    // Create the static class variable additionClass to run the test methods
    @BeforeClass
    public static void setUp() {
    	additionClass = new AdditionClass();
    }

    // Run the test
    @Test
    public void additionClassTest() {
    	double actual = additionClass.addTwoNumbers(num1, num2);

    	if (actual == testSum) {
    		confirmation = true;
        	assertThat(actual, equalTo(testSum));
    	} else {
    		confirmation = false;
        	assertThat(actual, not(equalTo(testSum)));
    	}

    	System.out.printf("%.2f + %.2f = %.2f is %s\n",
    			num1, num2, testSum, Boolean.toString(confirmation));

    }
}