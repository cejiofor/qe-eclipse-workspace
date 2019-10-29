package com.perscholas.java_basics;
/* Code Introduction
 * Descriptions
 * Assumptions
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JavaArrayPractice {
	List<Integer> intArr = new ArrayList<Integer>();
	
	public int[] getIntArr(int n) {
		int[] intArr = new int[n];
		
		Random rand = new Random();
		for (int i = 0; i<n; i++) {
			intArr[i] = rand.nextInt(550)+300;
		}
		return intArr;
	}
	
	public int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    public void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    }
    
    
    //These will be search algorithms, have onle larege search function, that breaks int 3 swithc stastments that call 3 diffrent methods
    // POst sort and seach alogrithms on github
    
    
    public void findExact(int num, int[] arr) {
    	boolean contains = false;
    	for (int i: arr) {
    		if (i == num) {
    			contains = true;
    			System.out.println("Score exisits: "+contains);
    			return;
    		}
    	}
    	System.out.println("Score exisits: "+contains);
		return;
    }
    
    public void lessThanArr(int num, int[] arr) {
    	List<Integer> ints = new ArrayList<Integer>();
    	for(int score:arr) {
			 if (score < num) {
				ints.add(score);
			}
		}
    	System.out.println(Arrays.toString(ints.toArray()));
    }    
    
    public void greaterThanArr(int num, int[] arr) {
    	List<Integer> ints = new ArrayList<Integer>();
    	for(int score:arr) {
			 if (score > num) {
				ints.add(score);
			}
		}
    	System.out.println(Arrays.toString(ints.toArray()));
    }
    
    
	
	public static void main(String[] args) {
		JavaArrayPractice javaPractice = new JavaArrayPractice();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter lenth of array: ");
		int n = sc.nextInt();
		
		int[] intArr = javaPractice.getIntArr(n);
		System.out.println(Arrays.toString(intArr));
		javaPractice.sort(intArr, 0, intArr.length-1);
		System.out.println(Arrays.toString(intArr));
		int diff = intArr[intArr.length-1]-intArr[0];
		System.out.println(diff);
		
		System.out.println("Enter exact score: ");
		int exact = sc.nextInt();
		javaPractice.findExact(exact, intArr);
		
		System.out.println("Enter min score: ");
		int min = sc.nextInt();
		javaPractice.greaterThanArr(min, intArr);
		
		System.out.println("Enter max score: ");
		int max = sc.nextInt();
		javaPractice.lessThanArr(max, intArr);

	}

}
