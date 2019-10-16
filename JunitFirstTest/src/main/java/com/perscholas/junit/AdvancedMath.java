package com.perscholas.junit;
import java.util.HashMap;
//Hamcrest: Write a class that includes 5 methods with a combination of math functions that return values and other methods that return lists and maps. Use at least 10 different Hamcrest matchers to test the methods.
import java.util.Map; 

public class AdvancedMath {

	BasicMath bm = new BasicMath();
	
	public AdvancedMath() {
	}
	
	public int fx(int x) {
		int slope = 5;
		int intercept = 3;
		return bm.add(intercept, bm.multiply(slope, x)); 
	};
	
	public double average(int[] array) {
		int total = 0;
		for(int i: array) {
			total = bm.add(i, total);
		}
		return bm.divide((double) total, array.length); 
	}
	
	public int power(int num, int pow) {
		int total = 1;
		for(int i =0; i<pow; i++) {
			total = bm.multiply(num, total);
		}
		return total; 
	}
	
	public Map<Double, Double> spacedPoints(double slope, double intercept, int numPoints){
		Map<Double, Double> points = new HashMap();
		
		
		return points;
	}
	 
}
;