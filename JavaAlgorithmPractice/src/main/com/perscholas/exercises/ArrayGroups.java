package com.perscholas.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArrayGroups {
/*	
 * Given an array of integers, shuffle the array and divide the array into subarrays of n size.
 * Make any left over values in the last array null.
 * Example:
 * Given the array:
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25]
 * and group/subarray size of 7,
 * 
 * The output could be:
 * [ [10, 1, 3, 12, 19, 4, 20], [25, 13, 11, 21, 7, 8, 2], [6, 14, 17, 23, 22, 5, 18], [24, 15, 9, 16, null, null, null] ]
 */
	
	public static Integer[][] shuffleSub(int[] nums, int n) {
		List<Integer[]> arrList = new ArrayList<>();
		List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
		int reps = nums.length/n;
		int remainder = nums.length%n;
		Random rand = new Random();
		while(numList.size()>0) {
			Integer[] innerArr = new Integer[n];
			for(int i=0; i<n; i++) {
				if (numList.size()>0) {
					int index = rand.nextInt(numList.size());
					innerArr[i] = numList.get(index);
					numList.remove(index);
				}
				else {
					break;
				}
				
			}
			arrList.add(innerArr);
		}
		
		return arrList.toArray(new Integer[][] {});
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
		System.out.println();
		Integer[][] result = shuffleSub(nums, 7);
		System.out.println(Arrays.deepToString(result));
	}
}
