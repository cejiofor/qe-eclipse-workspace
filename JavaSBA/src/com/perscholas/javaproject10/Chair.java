package com.perscholas.javaproject10;

public class Chair extends Furniture {
	private Boolean customColor;
	
	public Chair() {
		super();
		this.setPrice(150.00);
		this.setName("chair");
	}
	public Chair(Boolean customColor) {
		super();
		this.customColor = customColor;
		this.setPrice(150.00);
		this.setName("chair");
	}
	
	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		double subtotal = this.getPrice()*this.getQuantity();
		if (this.getCustomColor()){
			subtotal += 50*this.getQuantity();
		}
		return subtotal;
		
	}
	public Boolean getCustomColor() {
		return customColor;
	}
	public void setCustomColor(Boolean customColor) {
		this.customColor = customColor;
	}

}
