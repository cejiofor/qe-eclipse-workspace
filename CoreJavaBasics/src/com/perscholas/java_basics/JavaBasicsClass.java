package com.perscholas.java_basics;

import java.util.Scanner;

class JavaBasicsClass {
	public static void variablesPractice() {
		int i = 4;
		int j = 5;
		int sum = i+j;
		System.out.printf("%d + %d = %d%n",i,j,sum);

		double a = 2.5;
		double b = 3.5;
		double sumAB = a+b;
		System.out.printf("%.2f + %.2f = %.2f%n",a,b,sumAB);
	
		int e = 4;
		double f = 5.5;
		double sumXY = e+f;
		System.out.printf("%d + %.2f = %.2f%n",e,f,sumXY);
		
		int c = 4;
		int d = 5;
		int result = Math.max(c,d)/Math.min(c,d);
		System.out.printf("%d/%d = %d%n",d,c,result);
		double D = d + 0.5;
		
		double newResult = Math.max(c,D)/Math.min(c,D);
		System.out.println(c+" "+D+" "+newResult);
		System.out.printf("%.2f/%d = %.2f%n",D,c,newResult);
		
		int x;
		int y;
		x = 5;
		y = 6;
		
		int q = y/x;
		System.out.println(q);
		double Y = (double) y;
		double Q = (double) q;
		System.out.println((double) q);
		
		final double CONST_NUM = 35;
		System.out.println(CONST_NUM);
		
		double coffee = 2.45;
		double tea = 1.34;
		double cookie = 3.30;
		
		double subtotal;
		double totalSale;
		
		subtotal = 3*coffee + 5*tea + 2*cookie;
		final double SALES_TAX = 0.05;
		
		totalSale = subtotal *(1+SALES_TAX);
		System.out.println(totalSale);
		
	
	}
	
	public static void stringPractice() {
		double coffee = 2.45;
		double tea = 1.34;
		double cookie = 3.30;
		
		double subtotal;
		double totalSale;
		
		subtotal = 3*coffee + 5*tea + 2*cookie;
		final double SALES_TAX = 0.05;
		
		totalSale = subtotal *(1+SALES_TAX);
		System.out.printf("%nCoffee 3 @ %.2f = %.2f%nTea 5 @ %.2f = %.2f%nCookie 2 @ %.2f = %.2f%nSubtotal: $%.2f%nSales Tax: $%.2f%nTotal: $%.2f%n",coffee,coffee*2,tea,tea*2,cookie,cookie*2,subtotal,subtotal*SALES_TAX,totalSale);
		
		String firstName = "Chris";
		String lastName = new String("Bob");
		String fullName = firstName + " " + lastName;
		System.out.println(fullName);
		fullName = firstName.concat(" ").concat(lastName);
		System.out.println(fullName);
		System.out.println(firstName.length());
		System.out.println(lastName.length());
		System.out.println(fullName);
		
		String one = "Hello";
		String two = "Hello";
		String three = "World";
		String four = "world";
		
		System.out.println(one.equals(two));
		System.out.println(three.equals(four));
		System.out.println(three.equalsIgnoreCase(four));
		
		String helloWorld = "Hello World";
		System.out.println(helloWorld.charAt(6));
		System.out.println(helloWorld.substring(6));
		
		Scanner usrInput = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int numOne = usrInput.nextInt();
		System.out.println("Enter another integer: ");
		int numTwo = usrInput.nextInt();
		int sum = numOne + numTwo;
		System.out.print("Integer Sum: ");
		System.out.println(sum);
	}
	
	public static void operatorsPractice() {
		// Convert numbers to binary

//	    1 - 0000 0001
//	    8 - 0000 1000
//	    33 - 0010 0001
//	    78 - 0100 1110
//	    787 - 0000 0010 1010 0101
//	    33,987 - 1000 0100 1100 0000 0011 
		decToBinary(1);
		decToBinary(8);
		decToBinary(33);
		decToBinary(78);
		decToBinary(787);
		decToBinary(33987);
	// 
		
	}
	static void decToBinary(int n) 
    { 
        // array to store binary number 
        int[] binaryNum = new int[1000]; 
   
        // counter for binary array 
        int i = 0; 
        while (n > 0)  
        { 
            // storing remainder in binary array 
            binaryNum[i] = n % 2; 
            n = n / 2; 
            i++; 
        } 
   
        // printing binary array in reverse order 
        for (int j = i - 1; j >= 0; j--) { 
            System.out.print(binaryNum[j]);
        }
        System.out.println("");
    } 
		
		
			
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		variablesPractice();
		stringPractice();
		operatorsPractice();
		
	}

}
