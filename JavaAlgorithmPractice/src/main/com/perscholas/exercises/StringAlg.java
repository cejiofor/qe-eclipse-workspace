package com.platform.dsalgorithm;

public class StringAlg{
	// Method to practice common String methods
	public void strMethodsPractice() {
		String demo = "Hello 2019 QE02!"; // don't have to use the new keyword with strings
		String demo2 = demo.concat("qwerty");
		System.out.println(demo.subSequence(0, 2));
		System.out.println(demo2);
		System.out.println(demo.contains("John"));
		String[] strArr = demo.split(" ");
		for (String str : strArr) {
			System.out.println(str);
		}
	}
	
	// Method to return array of words from string
	public String[] returnWords() {
		String demo = "Hello 2019 QE02!";
		String[] strArr = demo.split(" ");
		return strArr;
	}

	// Create a method that takes the string "" and prints "llo 201"
	public static void printSub() {
		String helloQE = "Hello 2019 QE02!";
		String subHelloQE = helloQE.substring(2, 9);
		System.out.println(subHelloQE);
	}

	// Create method to split a string into an array of lines, with three words on each line
	// Return the array of strings
	public String[] stringToArray(String str) {
		String[] strArr = str.split(";");
		return strArr;

	}

	//	Create a method to split the string into an array. 
	//	Then split each line in the array to create an array of arrays with each nested array having three strings/words. 
	//	Return this array.
	public String[][] stringToNestedArray(String str) {
		//Create an array of string from first string
		String[] strArr = stringToArray(str);
		
		//Create empty 2D array using the length of strArr for the first dimension
		String[][] nestedArr = new String[strArr.length][];//List[strArr.length];
		
		// Loop over array and split the string in strArr, setting the new array to an index in the nested array
		for(int i = 0;i<strArr.length; i++) {
			String[] wordArr = strArr[i].split(",");
			nestedArr[i] = wordArr;
		}
		return nestedArr;
	}
	
	public static void main(String[] args) {
		StringAlg sa = new StringAlg();
		
		sa.printSub();
//      
		String sample = "red,green,blue;square,triangle,circle;dog,cat,bird";
		sa.stringToArray(sample);
		sa.stringToNestedArray(sample);
	}
	

}
