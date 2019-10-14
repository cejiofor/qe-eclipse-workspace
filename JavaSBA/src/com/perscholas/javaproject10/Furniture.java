package com.perscholas.javaproject10;
//JavaSBAProject_10
//
//Create an abstract class named Furniture with the fields productId, name, price, color, and quantity. Include the abstract method calculatePrice().
//Make two subclasses called Table and chair.
//Add the field shape and length to the Table class and type and customColor (boolean) to the Chair class.
//Make a no-arg constructor and a constructor with arguments for each subclass.

//The price for the table will be $200 for 60 inches and $450 for 84 inches length.
//The price for chairs will be $150 with an added $50 cost for a custom color.
//Create a main application where the user can add a table and/or chair to a shopping cart and then check out.
//Print each item with subtotal after each is added and then print the purchase (shopping cart) subtotal, sales tax and purchase total after the user checks out.

public abstract class Furniture {

	private int productId;
	private String name;
	private double price;
	private String color;
	private int quantity;
	
	public Furniture() {
		
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public abstract double calculatePrice();
}
