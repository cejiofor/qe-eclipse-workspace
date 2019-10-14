package com.perscholas.javaproject10;

import java.util.Scanner;

public class Store {
	//Create a main application where the user can add a table and/or chair to a shopping cart and then check out.
	//Print each item with subtotal after each is added and then print the purchase (shopping cart) subtotal, sales tax and purchase total after the user checks out.
	
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Scanner sc = new Scanner(System.in);
		
		String storeMenu = "Select an item from the menu";
		String menu = "1 - Table\n2 - Chair\n3 - Checkout";
		System.out.println(storeMenu);
		System.out.println(menu);
		
		int item = sc.nextInt();
		int itemQuantity;
		while (item != 3) {
			switch (item) {
				case 1:	
					System.out.println("What size tables would you like? 60in or 84in?");
					System.out.print("Enter 60 or 84: ");
					int size = sc.nextInt();
					System.out.print("What shape would you like: ");
					String shape = sc.next();
					
					System.out.print("How many would you like: ");
					itemQuantity = sc.nextInt();
					
					Table newTable = new Table(shape, size);
					
					cart.addItem(newTable,itemQuantity);
					System.out.println(cart.printItemSummary(newTable));
					break;
				case 2:
					System.out.println("Would you like a custom color for your chair?");
					System.out.print("Enter yes or no: ");
					String choice = sc.next();
					Boolean color = choice.equals("y")|| choice.equals("yes");
					
					System.out.print("How many would you like: ");
					itemQuantity = sc.nextInt();
					
					Chair newChair= new Chair(color);
					
					cart.addItem(newChair,itemQuantity);
					System.out.println(cart.printItemSummary(newChair));
			}
			System.out.println(menu);
			item = sc.nextInt();	
		} 
		
		cart.checkOut();
		sc.close();
	}
}
