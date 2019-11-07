package chp5;

public class Factorial {
	public static int factorial(int n) {
		if (n>1) {
			return n*factorial(n-1);
		}
//		if (n==0)
//			return 1;
		else
			return n;
			
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(6));
	}
	
}
