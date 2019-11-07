package com.perscholas.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StarGraph {
//	Given an array such as {1,5,2,4,3}, print out a star graph such as:
//
//		 *   
//		 * * 
//		 * **
//		 ****
//		*****
	
	public static Integer[] arr = {1,5,2,4,3};
	
	public static void graph(Integer[] arr) {
		List<Integer> arrList = Arrays.asList(arr);
		Integer maxNum = Collections.max(arrList);
		for (int i=maxNum; i>0; i--) {
			for (int j=0; j<arrList.size(); j++) {
				if (arrList.get(j) >= i) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		graph(arr);

	}

}
