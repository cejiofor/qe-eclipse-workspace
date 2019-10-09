package com.perscholas.cafe;

public class Espresso extends Product {
	private Boolean extraShot;
	private Boolean macchiato;
	
	public Espresso(){
		super();
		this.extraShot = false;
		this.macchiato = false;
	}
	
	public Espresso(String name, double price, String description, Boolean extraShot, Boolean macchiato){
		super(name, price, description);
		this.extraShot = false;
		this.macchiato = false;
	}

	public Boolean getExtraShot() {
		return extraShot;
	}

	public void setExtraShot(Boolean extraShot) {
		this.extraShot = extraShot;
	}

	public Boolean getMacchiato() {
		return macchiato;
	}

	public void setMacchiato(Boolean macchiato) {
		this.macchiato = macchiato;
	}
	
	@Override
	public double calculateProductTotal() {
		double extraOptions = 0.00;
		if (this.getExtraShot()) {
			extraOptions += 2.00; 
		}
		if (this.getMacchiato()) {
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
