package org.platform.testproject;
import java.io.*;
import java.util.*;
public class Variables {

	public static void main(String[] args) throws IOException {		
//		ForLoops();
		
		// int[] Bil = {5,4,7,6,9};
		// int[] sortedArr = BubbleSort(Bil);
		
		// StudentScoresFile();
		StudentScores();
	}
	
	public static void ForLoops() {
		//Here is the basic for-loop we discussed this morning. Your assignment is to 
		//reverse the loop so that the output is "5 4 3 2 1". After that, see if you 
		//can figure out how to change the increment for each loop to 2 using the 
		//original forward loop so that the output is "1 3 5".
		
		int[] arr = new int[] {1,2,3,4,5};
		
		for (int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
		
		for (int i = 0; i < arr.length; i+=2 ) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
	
	public static int[] BubbleSort(int[] arr) {
		int n = arr.length;
		int temp;
		System.out.println("Unsorted Array: "+Arrays.toString(arr));
		
		for (int i=1; i<= n-1; i++) {
			for (int j=n-1; j >= i; j--) {
				if (arr[j]<arr[j-1]){
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
				else
					continue;
			}
		}
		System.out.println("Sorted Array: "+Arrays.toString(arr));
		return arr;
		
	}
	
	public static void StudentScoresFile() throws IOException {
//		Write a Java Application that allows the user to enter 
//		24 students scores and store them in an Array. 
//		The application should sort the scores and print out
//		the minimum and maximum scores.

		// Set up a random generator that will be used to generate random interger scores up to 100
		Random rand = new Random();

		// Initialize and array of length 24 to hold the student scores
		int[] scores = new int[24];
		
		// Create an empty file to hold the student scores
		File infile = new File("scores.txt");
		// Create a printwriter object to write the student scores to a new line in the scores.txt file
		PrintWriter scoreFile = new PrintWriter(infile);
		
		// Loop to add a random integer to the previously created file
		for (int i = 0; i< 24; i++) {
			int score = rand.nextInt(100);
			scoreFile.println(score);

			// Set the score for the give index in the scores array
			scores[i] = score ;
		}

		scoreFile.close();

		// create an array of the sorted scores, sorted using the BubbleSort method
		int[] sortedScores = BubbleSort(scores);

		// Print the maximum and minimum scores from the sorted array, the first number being the least and the last number being the greatest
		System.out.println("Max Score: "+sortedScores[0]+ " Min Score: "+sortedScores[scores.length-1]);
	}

	public static void StudentScores() {
		// Initialize and array of length 24 to hold the student scores
		int[] scores = new int[4];
		
		// Set up a scanner to accept student score input 
		Scanner scoreQuery = new Scanner(System.in);

		// Loop through to add each score input to array
		for (int i = 0; i< scores.length; i++) {
			System.out.printf("Enter the score for Student #%d: %n",i+1);
			int score = scoreQuery.nextInt();  
			scores[i] = score;
		}

		// Create a new array with sorted values, then print the max and min values from the sorted array
		int[] sortedScores = BubbleSort(scores);
		System.out.println("Max Score: "+sortedScores[0]+ " Min Score: "+sortedScores[scores.length-1]);
	}
}


