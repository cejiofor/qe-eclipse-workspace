package com.perscholas.cafe;

public class Cappuccino extends Product {
	private Boolean peppermint;
	private Boolean whippedCream;
	
	public Cappuccino() {
		super();
		this.peppermint = false;
		this.whippedCream = false;
	}
	
	public Cappuccino(String name, double price, String description, Boolean peppermint, Boolean whippedCream) {
		super(name, price, description);
		this.peppermint = false;
		this.whippedCream = false;
	}
	
	public Boolean getPeppermint() {
		return peppermint;
	}

	public void setPeppermint(Boolean peppermint) {
		this.peppermint = peppermint;
	}

	public Boolean getWhippedCream() {
		return whippedCream;
	}

	public void setWhippedCream(Boolean whippedCream) {
		this.whippedCream = whippedCream;
	}

	@Override
	public double calculateProductTotal() {
		double extraOptions = 0.00;
		if (this.getPeppermint()) {
			extraOptions += 2.00; 
		}
		if (this.getWhippedCream()) {
			extraOptions += 1.00; 
		}
		return this.getPrice()*this.getQuantity()+extraOptions;
		
	}

	@Override
	public void addOptions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printOptions() {
		// TODO Auto-generated method stub
		
	}

}
