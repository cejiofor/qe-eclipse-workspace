package com.platform.dsalgorithm;

import java.util.Arrays;
import java.util.List;

public class CharlieString {
	public String[] returnWords() {
		String demo = "Hello 2019 QE02!";
		String[] strArr = demo.split(" ");
		return strArr;
	}
	
	public String returnStringFromArray() {
		String[] wordArr = returnWords();
		String joinedArray = String.join("-", wordArr);
		return joinedArray;
	}
	
	// Array to List demonstration
	public List<String> arrayToListDemo() {
		String demo = "Hello 2019 QE02!";
		String[] strArr = demo.split(" ");
		/* Even though List is an interface, we can instantiate it 
		 * by passing the return value from the Arrays.asList() method. 
		 * It will behave similar to an ArrayList in this example 
		 * so we will treat it as such when working with it. */
		List<String> stringList = Arrays.asList(strArr);
		System.out.println("Contents of stringList: " + stringList);
		System.out.println("Loop Through stringList:");
		for (String s : stringList) {
			System.out.println("    " + s);
		}
		return stringList;
	}
	
	public static void main(String[] args) {
		CharlieString sa = new CharlieString();
		System.out.println("Array from String: " + Arrays.toString(sa.returnWords()));
		System.out.println("Joined Array: " + sa.returnStringFromArray());
		sa.arrayToListDemo();
	}
}
