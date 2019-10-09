package com.perscholas.cafe;

import java.util.Scanner;

public class CafeApp {

	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Scanner sc = new Scanner(System.in);
		String storeMenu = "Select an item from the menu";
		String menu = "1 - Coffee\n2 - Espresso\n3 - Cappuccino\n4 - Checkout";
		System.out.println(storeMenu);
		System.out.println(menu);
		int item = sc.nextInt();
		int cupQuantity;
		while (item != 4) {
			switch (item) {
				case 1:
					Coffee cupCoffee = new Coffee();
			
					System.out.println("Would you like milk? Select 1 for Yes, 2 for No");
					Boolean milk = (sc.nextInt() == 1);
					System.out.println("Would you like sugar? Select 1 for Yes, 2 for No");
					Boolean sugar = (sc.nextInt() == 1);;
					
					System.out.println("How many would you like?");
					cupQuantity = sc.nextInt();
					
					cart.addItem(cupCoffee,cupQuantity, milk, sugar);
					System.out.println(cart.printItemSummary(cupCoffee));
					break;
				case 2:
					Espresso cupEspresso = new Espresso();
					System.out.println("Would you like an extra shot? Select 1 for Yes, 2 for No");
					Boolean shot = (sc.nextInt() == 1);
					System.out.println("Would you like a macciato? Select 1 for Yes, 2 for No");
					Boolean macc = (sc.nextInt() == 1);;
					
					System.out.println("How many would you like?");
					cupQuantity = sc.nextInt();
					
					cart.addItem(cupEspresso, cupQuantity, shot, macc);
					System.out.println(cart.printItemSummary(cupEspresso));
					break;
				case 3:
					Cappuccino cupCappuccino = new Cappuccino();
					System.out.println("Would you like an peppermint? Select 1 for Yes, 2 for No");
					Boolean pep = (sc.nextInt() == 1);
					System.out.println("Would you like a whipped cream? Select 1 for Yes, 2 for No");
					Boolean whip = (sc.nextInt() == 1);;
					
					System.out.println("How many would you like?");
					cupQuantity = sc.nextInt();
					
					cart.addItem(cupCappuccino, cupQuantity, pep, whip);
					System.out.println(cart.printItemSummary(cupCappuccino));
			}
			System.out.println(menu);
			item = sc.nextInt();	
		} 
		
		cart.checkOut();
		sc.close();
		
	}

}
