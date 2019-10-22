package com.perscholas.junit07.test;

//Write a parameterized test to test the AddVaryingTypeCalculator class. Test for String, Character, Integer and Double types, as well as for illegal arguments. Create at least 4 sets of data and test for at least two situations that may throw an exception. Data arrays should resemble { num1, num2, expectedAnswer, expectedException }.

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.junit07.AddVaryingTypeCalculator;

@RunWith(Parameterized.class)
public class VaryingTypeTest {
	private static AddVaryingTypeCalculator addVarCalc;
	private Object num1;
	private Object num2;
	private Double expectedAnswer;
	private Exception expectedException;
	
	public VaryingTypeTest(Object num1, Object num2, Double expectedAnswer, Exception expectedException ) {
		this.num1 = num1;
		this.num2 = num2;
		this.expectedAnswer = expectedAnswer;
		this.expectedException = expectedException;
	}
	
	@Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                		{ 5, '6', 11.0, null },
                		{ 7.0, "9", 16.0, null },
                		{ "1", 'A', 10.0, new IllegalArgumentException() },
                		{ 70.0, 70.0, 140.0, null },
        				{ null, 70.0, 80.0, new NullPointerException() }
                		});
    }
	
	// Test for exception using @Rule 
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test 
	public void numberSum() throws Exception {        
		if (expectedException != null) {
			thrown.expect(expectedException.getClass());
		}
		addVarCalc = new AddVaryingTypeCalculator();
		List<Object> nums = new ArrayList();
		nums.add(num1);
		nums.add(num2);
        Double addVarSum = addVarCalc.addTwoNumbersVaryingType(nums);
		assertThat(addVarSum, equalTo(expectedAnswer));
	}

}
