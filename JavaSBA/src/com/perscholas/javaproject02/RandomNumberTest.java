package com.perscholas.javaproject02;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberTest {
	//JavaSBAProject_02
	//Write a Java application that generates a random number and asks the user to guess the number within a range. If the user's guess is higher than the random number, the program should display "Too high, try again." If the user's guess is lower than the random number, the program should display "Too low, try again." The program should use a loop that repeats until the user correctly guesses the random 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		Boolean correctGuess = false;
		int randNumber = rand.nextInt(101);
		int userGuess;
		System.out.println(randNumber);
		
		while (!correctGuess) {
			System.out.print("Guess the number between 0 and 100: ");
			userGuess = sc.nextInt();
			if (userGuess > randNumber) {
				System.out.println("Too High, try again.");
			}
			else if (userGuess < randNumber) {
				System.out.println("Too low, try again.");
			}
			else {
				System.out.println("You got it!");
				correctGuess = true;
			}
			
		}
		sc.close();
		
		
	}

}
