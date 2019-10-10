package com.perscholas.cafe;

public class Cappuccino extends Product {
	private Boolean peppermint;
	private Boolean whippedCream;
	
	public Cappuccino() {
		super();
		this.setName("Cappuccino");
		this.setDescription("A cappuccino");
		this.setPrice(2.75);
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
	public void addOptions(Boolean addPep, Boolean addWhip) {
		// TODO Auto-generated method stub
		this.setPeppermint(addPep);
		this.setWhippedCream(addWhip);
	}

	@Override
	public String printOptions() {
		String pepStatus;
		String whipStatus;
		
		if (this.getPeppermint()) {
			pepStatus = "Yes (Add $2)";
		} else {
			pepStatus = "No";
		}
		
		if (this.getWhippedCream()) {
			whipStatus = "Yes (Add $1)";
		} else {
			whipStatus = "No";
		}

		String printOut = String.format("\tPeppermint: %s   Whipped Cream: %s",pepStatus, whipStatus);
		return printOut;
	}

}
