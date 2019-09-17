package org.platform.testproject;

import java.util.Arrays;
public class Variables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 5;
		int y = 6;
		String myName = "Chris";
		System.out.println(x+y+myName);
		
		int[] arr = new int[] {1,2,3,4,5};
		System.out.println(Arrays.toString(arr));
		
		for (int i = 0; i<arr.length; i++) {
			System.out.println("Index :" + i);
			System.out.println(arr[i]);
		}
		
		ForLoops();
		Alogorithm();
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
	
	public static void Alogorithm() {
		int[] Bil = {5,4,7,6,9};
		int n = 5;
		int i;
		int j;
		int temp;
		System.out.println("Unsorted Array: "+Arrays.toString(Bil));
		
		for (i=1; i<= n-1; i++) {
			for (j=n-1; j >= i; j--) {
				if (Bil[j]<Bil[j-1]){
					temp = Bil[j];
					Bil[j] = Bil[j-1];
					Bil[j-1] = temp;
				}
				else
					continue;
			}
		}

		System.out.println("Sorted Array: "+Arrays.toString(Bil));
		
	}
	
	public static void StudentScores() {
//		Write a Java Application that allows the user to enter 
//		24 students scores and store them in an Array. 
//		The application should sort the scores and print out
//		the minimum and maximum scores.
		
		Scanner StudentScore = new Scanner(System.in);
		
		
	}
}


