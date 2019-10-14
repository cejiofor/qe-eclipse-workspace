package com.perscholas.javaproject10;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Furniture> cart;
	final double TAX_RATE;
	private double salesTax;
	private double subtotal;
	private double total;
	
	public ShoppingCart() {
		this.cart = new ArrayList<Furniture>();
		TAX_RATE = 0.07;
		
	}
	
	public void addItem(Furniture item, int itemQuantity) {
		item.setQuantity(itemQuantity);
		cart.add(item);
		this.subtotal += item.calculatePrice();
	}
	
	public String printItemSummary(Furniture item) {
		StringBuilder itemSummary = new StringBuilder();
		itemSummary.append(String.format("Item: %s, Quantity: %d, Subtotal %.2f", item.getName(), item.getQuantity(), item.calculatePrice()));
		itemSummary.append(System.lineSeparator());
		return itemSummary.toString();
		
	}	
	public void checkOut() {
		salesTax = (subtotal * TAX_RATE);
		total = subtotal + salesTax; 
		
		for (Furniture item: this.cart) {
			System.out.println(this.printItemSummary(item));
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Purchase Subtotal: $%.2f%n", this.subtotal));
		sb.append(String.format("Sales Tax: $%.2f%n", this.salesTax));
		sb.append(String.format("Purchase Total: $%.2f%n", this.total));
		System.out.println(sb.toString());
		
		
	}
}
