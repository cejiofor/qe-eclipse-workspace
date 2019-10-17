package com.perscholas.junit;

// 1. Assert: Write a class that has 4 methods that perform basic math operations and then use 4 different assert statements to test the class.

public class BasicMath {

	public int add(int numOne, int numTwo) {
		int sum = numOne + numTwo;
		return sum;
	}
	public int subtract(int numOne, int numTwo) {
		int diff = numOne - numTwo;
		return diff;
	}
	public double multiply(double numOne, double x0) {
		double product = numOne * x0;
		return product;
	}
	public double divide(double numOne, double numTwo) {
		double divisor = numOne/numTwo;
		return divisor;
	}
}
