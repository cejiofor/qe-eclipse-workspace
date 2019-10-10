package com.perscholas.cafe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
	private List<Product> cart;
	final double TAX_RATE;
	private double salesTax;
	private double subtotal;
	private double total;
	
	public ShoppingCart() {
		this.cart = new ArrayList<Product>();
		TAX_RATE = 0.07;
		
	}
	
	public void addItem(Product item, int itemQuantity, Boolean option1, Boolean option2) {
		item.setQuantity(itemQuantity);
		item.addOptions(option1, option2);
		cart.add(item);
		this.subtotal += item.calculateProductTotal();
	}
	
/*	public void addCoffee(int quantity, Boolean addMilk, Boolean addSugar) {
		Coffee cupCoffee = new Coffee();
		cupCoffee.setQuantity(quantity);
		cupCoffee.addOptions(addMilk, addSugar);
		cart.add(cupCoffee);
		this.subtotal += cupCoffee.calculateProductTotal();
	}
	
	public void addEspresso(int quantity, Boolean addShot, Boolean addMacc) {
		Espresso cupEspresso = new Espresso();
		cupEspresso.setQuantity(quantity);
		cupEspresso.addOptions(addShot, addMacc);
		cart.add(cupEspresso);		
		this.subtotal += cupEspresso.calculateProductTotal();
	}
	
	public void addCappuccino(int quantity, Boolean addPep, Boolean addWhip) {
		Cappuccino cupCappuccino = new Cappuccino();
		cupCappuccino.setQuantity(quantity);
		cupCappuccino.addOptions(addPep, addWhip);
		cart.add(cupCappuccino);
		this.subtotal += cupCappuccino.calculateProductTotal();
	}
*/	
	
	public String printItemSummary(Product item) {
		StringBuilder itemSummary = new StringBuilder();
		itemSummary.append(String.format("Item: %s, Quantity: %d, Subtotal %.2f", item.getName(), item.getQuantity(), item.calculateProductTotal()));
		itemSummary.append(System.lineSeparator());
		itemSummary.append(item.printOptions());
		return itemSummary.toString();
		
	}	
	public void checkOut() {
		salesTax = (subtotal * TAX_RATE);
		total = subtotal + salesTax; 
		
		for (Product s: this.cart) {
			System.out.println(this.printItemSummary(s));
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Purchase Subtotal: $%.2f%n", this.subtotal));
		sb.append(String.format("Sales Tax: $%.2f%n", this.salesTax));
		sb.append(String.format("Purchase Total: $%.2f%n", this.total));
		System.out.println(sb.toString());
		
		
	}
}
