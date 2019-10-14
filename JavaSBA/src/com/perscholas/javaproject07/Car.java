package com.perscholas.javaproject07;

public class Car {
	private int ID;
	private double price;
	private String description;
	
	public Car() {
		
	}
	public Car(int ID, double price, String description) {
		this.ID = ID;
		this.price = price;
		this.description = description;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
