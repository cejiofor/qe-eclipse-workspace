package com.perscholas.javaproject03;

import java.util.Scanner;

//Create a main class and request user input to initialize the Course class. Print out the course toString method to display the user’s input.

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int id;
		String name;
		String description;
		
		System.out.println("Course Generator.");
		System.out.print("Enter Course ID: ");
		id = sc.nextInt();
		System.out.print("Enter Course Name: ");
		name = sc.next();
		sc.nextLine();
		System.out.print("Enter Course Description: ");
		description = sc.nextLine();
		
		Course newCourse = new Course(id, name, description);
		System.out.println("Course Created! Course Information:");
		System.out.println(newCourse.toString());
		sc.close();

	}

}
