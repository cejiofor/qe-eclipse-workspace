package com.platform.dsalgorithm.test;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import com.platform.dsalgorithm.StringAlg;

public class StringAlgsTest{
	
	private static StringAlg sa;
	private static String sample;
	
	@BeforeClass
	public static void setup() {
		sa = new StringAlg();
		sample = "red,green,blue;square,triangle,circle;dog,cat,bird";
		
	}

    @Test
    public void stringToArrayTest(){
        assertTrue(sa.stringToArray(sample).length == 3);
    }
    
    @Test
    public void stringToNestedArrayTest(){
    	// Test array made with stringToNestedArray() method
    	String[][] testArr = sa.stringToNestedArray(sample);
    	
    	//Check the length of the array
        assertTrue(sa.stringToNestedArray(sample).length == 3);
        
        // Check the length of each nested array
        for (String[] arr:sa.stringToNestedArray(sample)) {
        	assertTrue(arr.length == 3);
        }
        
        //Confirm the presence of the word in the nested array
        assertTrue(Arrays.asList(testArr[1]).contains("triangle"));
        // CAN DO USEING JUST LISTS/ARRAYLIST!!!, DONT NEED TO CONVERT TO LIST
    }

}
