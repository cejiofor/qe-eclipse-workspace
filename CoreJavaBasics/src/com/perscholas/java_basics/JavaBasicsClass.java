package com.perscholas.java_basics;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.*;

class JavaBasicsClass {
	public static void variablesPractice() {
		int i = 4;
		int j = 5;
		int sum = i+j;
		System.out.printf("%d + %d = %d%n",i,j,sum);

		double a = 2.5;
		double b = 3.5;
		double sumAB = a+b;
		System.out.printf("%.2f + %.2f = %.2f%n",a,b,sumAB);
	
		int e = 4;
		double f = 5.5;
		double sumXY = e+f;
		System.out.printf("%d + %.2f = %.2f%n",e,f,sumXY);
		
		int c = 4;
		int d = 5;
		int result = Math.max(c,d)/Math.min(c,d);
		System.out.printf("%d/%d = %d%n",d,c,result);
		double D = d + 0.5;
		
		double newResult = Math.max(c,D)/Math.min(c,D);
		System.out.println(c+" "+D+" "+newResult);
		System.out.printf("%.2f/%d = %.2f%n",D,c,newResult);
		
		int x;
		int y;
		x = 5;
		y = 6;
		
		double q = y/x;
		System.out.println(q);
		double Y = (double) y;
		q = Y/x;
		System.out.println(q);
		
		final double CONST_NUM = 35;
		System.out.println(CONST_NUM);
		
		double coffee = 2.45;
		double tea = 1.34;
		double cookie = 3.30;
		
		double subtotal;
		double totalSale;
		
		subtotal = 3*coffee + 5*tea + 2*cookie;
		final double SALES_TAX = 0.05;
		
		totalSale = subtotal *(1+SALES_TAX);
		System.out.println(totalSale);
		
	
	}
	
	public static void stringPractice() {
		double coffee = 2.45;
		double tea = 1.34;
		double cookie = 3.30;
		
		double subtotal;
		double totalSale;
		
		subtotal = 3*coffee + 5*tea + 2*cookie;
		final double SALES_TAX = 0.05;
		
		totalSale = subtotal *(1+SALES_TAX);
		System.out.printf("%nCoffee 3 @ %.2f = %.2f%nTea 5 @ %.2f = %.2f%nCookie 2 @ %.2f = %.2f%nSubtotal: $%.2f%nSales Tax: $%.2f%nTotal: $%.2f%n",coffee,coffee*2,tea,tea*2,cookie,cookie*2,subtotal,subtotal*SALES_TAX,totalSale);
		
		String firstName = "Chris";
		String lastName = new String("Bob");
		String fullName = firstName + " " + lastName;
		System.out.println(fullName);
		fullName = firstName.concat(" ").concat(lastName);
		System.out.println(fullName);
		System.out.println(firstName.length());
		System.out.println(lastName.length());
		System.out.println(fullName);
		
		String one = "Hello";
		String two = "Hello";
		String three = "World";
		String four = "world";
		
		System.out.println(one.equals(two));
		System.out.println(three.equals(four));
		System.out.println(three.equalsIgnoreCase(four));
		
		String helloWorld = "Hello World";
		System.out.println(helloWorld.charAt(6));
		System.out.println(helloWorld.substring(6));
		
		Scanner usrInput = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int numOne = usrInput.nextInt();
		System.out.println("Enter another integer: ");
		int numTwo = usrInput.nextInt();
		int sum = numOne + numTwo;
		System.out.print("Integer Sum: ");
		System.out.println(sum);
		usrInput.close();
	}
	
	public static void operatorsPractice() {
		// Convert numbers to binary

//	    1 - 0000 0001 - 1
//	    8 - 0000 1000 - 8
//	    33 - 0010 0001 - 1 32
//	    78 - 0100 1110 - 2 4 8 64
//	    787 - 0001 0001 0011 512 256 16 2 1 		
//	    33,987 - 1000 0100 1000 0011 32768 1024 128 64 3 1
		System.out.println(Integer.toBinaryString(1));
		System.out.println(Integer.toBinaryString(8));
		System.out.println(Integer.toBinaryString(33));
		System.out.println(Integer.toBinaryString(78));
		System.out.println(Integer.toBinaryString(787));
		System.out.println(Integer.toBinaryString(33987));

//	    0010 - 2
//	    1001 - 1 8 -9
//	    0011 0100 - 4 16 32 - 52
//	    0111 0010 - 2 16 32 64 - 114
//	    0010 0001 1111 - 31 512 - 543
//	    0010 1100 0110 0111 - 7 32 64 1024 2048 8192 11367
		System.out.println(Integer.parseInt("0010", 2));
		System.out.println(Integer.parseInt("1001", 2));
		System.out.println(Integer.parseInt("00110100", 2));
		System.out.println(Integer.parseInt("01110010", 2));
		System.out.println(Integer.parseInt("001000011111", 2));
		System.out.println(Integer.parseInt("0010110001100111", 2));
		
		
		
//		Write a program that declares 3 int variables x, y, and z. Assign 7 to x and 17 to y. Write comment that indicates what you predict will be the result of the bitwise & operation on x and y. Now use the bitwise & operator to derive the decimal and binary values and assign the result to z.

//		Now, with the preceding values, use the bitwise | operator to calculate the “or” value between x and y. As before, write a comment that indicates what you predict the values to be before printing them out.


//		Write a program that declares an integer variable, assigns a number and uses a postfix increment operator to increase the value. Print the value before and after the increment operator.


//		Write a program that demonstrates at least 3 ways to increment a variable by 1 and does this multiple times. Assign a value to an integer variable, print it, increment by 1, print it again, increment by 1 and then print again.


//		Write a program that declares 2 integer variables, x and y, and then assigns 5 to x and 8 to y. Create another variable sum and assign the value of ++x added to y and print the result. Notice the value of sum (should be 14). Now change the increment operator to postfix (x++) and re-run the program. Notice what the value of sum is. The first configuration incremented x and then calculated the sum while the second configuration calculated the sum and then incremented x.
}
	
	public static void controlFlowPractice() {
		//Write a program that declares 1 integer variable x, and then assigns 7 to it. Write an if statement to print out “Less than 10” if x is less than 10. Change x to equal 15 and notice the result (console should not display anything).

 

//Write a program that declares 1 integer variable x, and then assigns 7 to it. Write an if-else statement that prints out “Less than 10” if x is less than 10 and “Greater than 10” if x is greater than 10. Change x to 15 and notice the result.
//
// 
//
//Write a program that declares 1 integer variable x, and then assigns 15 to it. Write an “if-else-if” statement that prints out “Less than 10” if x is less than 10, “Between 10 and 20” if x is greater than 10 but less than 20 and “Greater than or equal to 20” if x is greater than or equal to 20. Change x to 50 and notice the result.
//
// 
//
//Write a program that declares 1 integer variable x, and then assigns 15 to it. Write an if-else statement that prints “Out of range” if the number is less than 10 or greater than 20 and prints “In range” if between 10 and 20 (including equal to 10 or 20). Change x to 5 and notice the result.
//
// 
//
//Write a program that uses if-else-if statements to print out grades A, B, C, D, F according to the following criteria:
//
//A: 90-100
//
//B: 80-89
//
//C: 70-79
//
//D: 60-69
//
//F: <60
//
//Use the Scanner class to accept a number score from the user to determine the letter grade. Print out “Score out of range.” if the score is less than 0 or greater than 100.
//
// 
//
//Write a program that accepts an integer between 1 and 7 from the user. Use a switch statement to print out the corresponding weekday. Print “Out of range” if the number is less than 1 or greater than 7. Don’t forget to include “break” statements in each of your cases.
	}		
	
	public static void loopPractice() {
//		Write a program that uses a for-loop to loop through the numbers 1-10 and prints out each number.
//
//		Write a program that uses a while-loop to loop through the numbers 0-100 in increments of 10 and prints out each number.
//
//		Write a program that uses a do-while-loop to loop through the numbers 1-10 and prints out each number.
//
//		 
//
//		Write a program that uses a for-loop to loop through the numbers 1-100. Print out each number if is a multiple of 5, but do not print out any numbers between 25 and 75. Use the “continue” statement to accomplish this.
//
//		 
//
//		Write a program that uses a for-loop to loop through the numbers 1-100. Print out each number if is a multiple of 5, but do not print out any numbers greater than 50. Use the “break” keyword to accomplish this.
//
//		 
//
//		Write a program that uses nested for-loops to output the following:
//
//		Week 1:
//
//		Day 1
//
//		Day 2
//
//		Day 3
//
//		Day 4
//
//		Day 5
//
//		Week 2:
//
//		Day 1
//
//		Day 2
//
//		Day 3
//
//		Day 4
//
//		Day 5
//
//		 
//
//		Write a program that returns all the available palindromes within 10 and 200. The following output will be produced:
//
//		11, 22, 33, 44, 55, 66, 77, 88, 99, 101, 111, 121, 131, 141, 151, 161, 171, 181, 191,
//
//		 
//
//		Write a program that prints the Fibonacci Sequence from 0 to 50. The following output will be produced: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,
//
//		 
//
//		Write a program that nests a for-loop inside another. Print out the inner and outer variable (e.g., i or j) in the inner loop (e.g., System.out.println("Inner loop: i: " + i + ", j: " + j);).
	}

	public static void moreStringPractice()
	{
//			Write a program that creates a StringBuilder object named sb and initializes it with “Hello”. Print out sb. Now use the append( ) method to append “ World!” to sb and print out sb again. Append “ World” again to sb. Print out sb. Next, use the insert( ) method to insert the string “ New” in between “Hello” and “ World”. Next, use the replace( ) method to change “ New” to “ Old”. Print the result. Finally, use the reverse( ) method to reverse the entire string.
//
//			 
//
//			Write a program that uses a loop to reverse the characters of a String object (e.g., “hello” becomes “olleh”.
//
//			 
//
//			Write a program that uses loops without the reverse( ) method to take a multi-word string and reverse each word but keep the same word order in the string (e.g., “Hello world!” would become “olleH !dlrow”).
	}
	 
	public static void arrayPractice() {
//	Write a program that creates an array of integers with length of 3. Assign the values 1, 2 and 3 to to the indexes. Print out each index.


//	Write a program that returns the middle element in an array. Give the following values to the integer array: {13, 5, 7, 68, 2} and produce the following output: 7


//	Write a program that creates an array of String type and initializes it with the strings “red”, “green”, “blue” and “yellow”. Print out the array length. Make a copy using the clone( ) method. Use the Arrays.toString( ) method on the new array to verify that the original array was copied.


//	Write a program that creates an integer array with 5 elements (i.e., numbers). The numbers can be any integers.  Print out the value at the first index, the last index using length - 1 as the index. Now try printing the value at index = length ( e.g., myArray[myArray.length - 1] ).  Notice the type of exception which is produced. Now try to assign a value to the array index 5. You should get the same type of exception.


//	Write a program where you create an integer array with a length of 5. Loop through the array and assign the value of the loop control variable (e.g., i) to the corresponding index in the array.
//
//		 
//
// Write a program where you create an integer array of 5 numbers. Loop through the array and assign the value of the loop control variable multiplied by 2 to the corresponding index in the array.
//
//		 
//
// Write a program where you create an array of 5 elements. Loop through the array and print the value of each element, except for the middle (index 2) element.


// Write a program that creates a String array of 5 elements and swaps the first element with the middle element without creating a new array.
		
		
//	Write a program to sort the following int array in ascending order: {4, 2, 9, 13, 1, 0}. Print the array in ascending order, print the smallest and the largest element of the array. The output will look like the following:
//	Array in ascending order: 0, 1, 2, 4, 9, 13
//	The smallest number is 0, The biggest number is 13
		
		// Bubble sort
		// Check the number at the current index to the number in the next index
		// Move the larger number towards the end of the array
		// Loop over the array moving the largest element to the last index
		// At the end of the array, loop again, comparing all numbers except the last sorted
		
		int[] rawArr = {4, 2, 9, 13, 1, 0};
		int[] sortedArr = rawArr.clone();
		int temp = 0;
		
		for (int i = 0; i<sortedArr.length-1; i++) {
			for (int j = 0; j<sortedArr.length-i-1; j++) {
				if (sortedArr[j] > sortedArr[j+1]) {
					temp = sortedArr[j];
					sortedArr[j] = sortedArr[j+1];
					sortedArr[j+1] = temp;
				}
			} 
		}

		System.out.println(Arrays.toString(rawArr));
		System.out.println(Arrays.toString(sortedArr));
		
		
//	Create an array that includes an integer, 3 strings, and 1 double. Print the array.
		Object[] objArray = new Object[] {5, "The", "dog", "Ate", 3.45};
		System.out.println(Arrays.toString(objArray));
	}

	public static void regExpPractice() {
		Pattern pattern = Pattern.compile("found");
		String sample = "sdffdsfoundsdfljkjsdfoundsdklfoweirufoundcvb";
		Matcher matcher = pattern.matcher(sample);

		while (matcher.find()) {
			System.out.println("Found one!");
		}
		
//	Write a program that creates a String variable and initializes it with a phrase or series of words such as “Don’t repeat yourself”. Use the String split( ) method to split the words into a String array and loop through the array and print each word. Try different characters as splitters such as 2 spaces, a comma, an asterisk, etc.

		
//	Write a program which creates the following array:
	// String[ ] names = new String[ ] {“Doe,John”, “Doe ,Jane”, “Doe , James”, “Doe, Joan” }
//	Now produce the following output with no spaces before or after each name (hint: use the String method trim( ) ):
//	First Name:John
//	Last Name:Doe
// 	First Name:Jane
//	Last Name:Doe
//	First Name:James
//	Last Name:Doe
//	First Name:Joan
//	Last Name:Doe

		
//	Create the following array of strings:
//	String[] searchFound = {"youhavefoundme", "youdidntfindme", "notinthisone", "itisfoundhere"};
//	Write a program that uses the Pattern and Matcher classes along with a for loop to produce the following ouput:
//		I found it! :  youhavefoundme
//		I found it! :  itisfoundhere

//	Write a program that returns the number of times the character 'o' occurs in the string "Hello World". The following output will be produced: 2


//	Write a program that tests if a string represents a valid css hexidecimal color such as “#2255aa” or “#253”.
		
	}

	public static void myAge() throws ParseException {
		// Get & print the current date & time
//		String dataStr = "2011-10-06T12: 00: 00-08: 00";
//		SimpleDateFormat dataParser = new SimpleDateFormat ("dd / MM / yyyy HH: mm: ss", Locale.US);
//		Date date;
//		date = dataParser.parse (dataStr);
//		System.out.println (dataParser.format (date));
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter your DOB, Format as Month Day, Year");
//		String DOB = sc.next();
		String DOB = "01/30/1992";
		
		//DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
//		DateFormat df = new SimpleDateFormat("MMMM dd, yyyy");
//		DateTimeFormatter df = new DateTimeFormatter("MM/dd/yyyy");
		LocalDate birthDate = LocalDate.parse(DOB);
		System.out.println(birthDate);
		
		LocalDate currentDate = LocalDate.now();
		System.out.println("The current date & time is " + currentDate);
		
		Period period = Period.between(birthDate, currentDate);
		long diff = Math.abs(period.getDays());
		System.out.println(diff);	
	}
	
	public static void main(String[] args) throws ParseException {
//		variablesPractice();
//		stringPractice();
//		operatorsPractice();
//		controlFlowPractice();
//		loopPractice();
//		moreStringPractice();
//		arrayPractice();
//		regExpPractice();
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		String s = dtf.format(currentDateTime);
		System.out.println("Today's date is: " + s);
		// Create a LocalDate object and print it
		LocalDate platformLaunchDate = LocalDate.of(2018, 3, 5);
		System.out.println("Platform launch date: " + platformLaunchDate);
		// Compare 2 LocalDate objects
		LocalDate today = LocalDate.now();
		int c = today.compareTo(platformLaunchDate);
		if (c > 0) {
			System.out.println("Today is later than Platform Dallas launch date");
		}
		// Calculate difference between 2 LocalDateTime objects
		LocalDateTime platformLaunchTime = LocalDateTime.of(2018, 03, 5, 9, 0);
		long t = ChronoUnit.MINUTES.between(platformLaunchTime, currentDateTime);
		System.out.println("Minutes since Platform launch: " + t);
		
		
		// Get & print the current date & time
		Date currentTime = new Date();
		System.out.println("The current date & time is " + currentTime);
		// Print the current date & time in a specified format
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
		String currentTimeString = sdf.format(currentTime);
		System.out.println(currentTimeString);
		
		System.out.println();
		myAge();
		
	}
}
