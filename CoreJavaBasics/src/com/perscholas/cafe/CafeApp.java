package com.perscholas.cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CafeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub'
		// 
		
		List<Product> cart = new ArrayList<Product>();
		Scanner sc = new Scanner(System.in);
		String storeMenu = "Select an Item from the menu";
		String menu = "1 - Coffee\n2 - Espresso\n3- Cappuccino\n4 - Checkout";
		System.out.println(storeMenu);
		System.out.println(menu);
		int item = sc.nextInt();
		
		switch (item) {
			case 1:z
				Coffee newCup = new Coffee("Coffee", 3.25,"A cup of coffee",true, false);
				newCup.setQuantity(3);
				cart.add(newCup);
				System.out.println(cart);
				String itemInfo = String.format("Item: %s, Description: %s. Quantity: %d, Subtotal %.2f", newCup.getName(), newCup.getDescription(), newCup.getQuantity(), newCup.calculateProductTotal());
				System.out.println(itemInfo);
			case 2:
				Espresso newEsp = new Espresso();
				cart.add(newEsp);
			case 3:
				Cappuccino newCap = new Cappuccino();
				cart.add(newCap);
			case 4:
				
				
		}
			
		
//		String output = String.format(format, args);
		System.out.println("Item Quantity, ubtotal, total");
		
	}

}
