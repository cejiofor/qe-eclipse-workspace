package org.platform.helloworld;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println("Hello World!");
		
		int i = 0;
		while(i <= 10) {
			if(i%2 == 0) {
				System.out.println(i);
			}
			i++;
		}
		System.out.println("");	
		FizzBuzz();
	}
	
	public static void FizzBuzz() {
		for (int i = 1; i<100; i++) {
			if (i%15 ==0) {
				System.out.println("Fizzbuzz");
			}
			else if (i%5 == 0) {
				System.out.println("Buzz");
			}
			else if (i%3 == 0) {
				System.out.println("Fizz");
			}
			else {
				System.out.println(i);
			}
		}
	}

}
