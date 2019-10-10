package com.perscholas.cafe;

public class Coffee extends Product {
	private Boolean milk;
	private Boolean sugar;
	
	public Coffee(){
		super();
		this.setName("Coffee");
		this.setDescription("A cup of coffee");
		this.setPrice(2.00);
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
	
	@Override
	public void addOptions(Boolean setMilk, Boolean setSugar) {
		this.setMilk(setMilk);
		this.setSugar(setSugar);
	}
	
	public String printOptions() {
		String milkStatus;
		String sugarStatus;
		
		if (this.getMilk()) {
			milkStatus = "Yes";
		} else {
			milkStatus = "No";
		}
		
		if (this.getSugar()) {
			sugarStatus = "Yes";
		} else {
			sugarStatus = "No";
		}
		String printOut = String.format("\tMilk: %s   Sugar: %s", milkStatus, sugarStatus);
		return printOut;
		
	}

}
