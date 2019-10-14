package com.perscholas.javaproject01;

import java.util.Scanner;

public class PrintUserInput {
	//JavaSBAProject_01
	//
	//Create a main class and request user input to print out to the console. You may choose any phrase to print out.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Something!: ");
		String userInput = sc.nextLine();
		
		System.out.println(userInput);
		sc.close();
	}

}
