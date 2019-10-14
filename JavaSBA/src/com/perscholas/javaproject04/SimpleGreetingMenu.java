package com.perscholas.javaproject04;
//JavaSBAProject_04
//Create a simple menu application with 4 options. Prompt the user to make a selection. Each option will print a string: “Good morning.”, “Good afternoon”,  “Good evening” and “Good night”. If the user selects option 4 (“Good night.”) then the application will end.

import java.util.Scanner;

public class SimpleGreetingMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int greetingSelected;
		
		do {
			System.out.println("Select from the following menu:\n1 for Greeting #1 \n2 for Greeting #2\n3 for Greeting #3\n4 for Greeting #4");
			System.out.print("Option: ");
			greetingSelected = sc.nextInt();
			switch (greetingSelected){
			case 1:
				System.out.println("Good morning");
				break;
			case 2:
				System.out.println("Good afternoon");
				break;
			case 3:
				System.out.println("Good evening");
				break;
			case 4:
				System.out.println("Good night");
				break;
			default:
				System.out.println("Not a valid selection, try again!");
				
			}
			System.out.println();
		} while (greetingSelected != 4);
		
		
		sc.close();
	}

}
