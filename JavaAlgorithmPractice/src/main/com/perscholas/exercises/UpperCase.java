package com.perscholas.exercises;
<<<<<<< HEAD
import java.util.Arrays;
=======

import java.util.Arrays;

>>>>>>> dbb170b1a22430cbfbaea715c8fa9c37745eccd5
public class UpperCase {
	/* Write an application with a method that takes a string with multiple words 
	 * (such as a sentence) and capitalizes each word and returns the string.
	 * Example: The string "red green blue cyan magenta yellow" would output:
	 * Red Green Blue Cyan Magenta Yellow
	 */
	
	public static String upperCaseSentence(String s) {
		String[] strArr = s.split(" ");
		for (int i=0; i<strArr.length; i++) {
			String capitalizd = strArr[i].substring(0,1).toUpperCase() + strArr[i].substring(1);
			strArr[i] = capitalizd;
		}
		
		String newString = String.join(" ", strArr);
		System.out.println(newString);
		return newString;
	}
	
	public static void main(String[] args) {
		String test = "red green blue cyan magenta yellow";
		upperCaseSentence(test);
	}

<<<<<<< HEAD
}
=======
}
>>>>>>> dbb170b1a22430cbfbaea715c8fa9c37745eccd5
