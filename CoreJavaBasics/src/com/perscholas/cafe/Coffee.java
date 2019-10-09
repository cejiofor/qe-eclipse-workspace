package com.perscholas.cafe;

public class Coffee extends Product {
	private Boolean milk;
	private Boolean sugar;
	
	public Coffee(){
		super();
		this.milk = false;
		this.sugar = false;
	}
	
	public Coffee(String name, double price, String description, Boolean milk, Boolean sugar){
		super(name, price, description);
		this.milk = false;
		this.sugar = false;
	}

	public Boolean getMilk() {
		return milk;
	}

	public void setMilk(Boolean milk) {
		this.milk = milk;
	}

	public Boolean getSugar() {
		return sugar;
	}

	public void setSugar(Boolean sugar) {
		this.sugar = sugar;
	}
	
	@Override
	public double calculateProductTotal() {
		return this.getPrice()*this.getQuantity();
	}
	
	public void addOptions() {
		
	}
	
	public void printOptions() {
		
	}
}
