package com.perscholas.javaproject10;

public class Table extends Furniture {
	private String shape; 
	private double length;
	//The price for the table will be $200 for 60 inches and $450 for 84 inches length.
	public Table() {
		super();
		this.setName("table");
	}
	public Table(String shape,  double length) {
		super();
		this.setName("table");
		this.shape = shape;
		this.length = length;
		if (this.length == 60) {
			this.setPrice(200.00);
		}
		else if (this.length == 84) {
			this.setPrice(450.00);
		}
	}
	
	
	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Table(double price, String shape, double length) {
		super();
		this.shape = shape; 
		this.length = length;
		this.setPrice(price);
	}
	@Override
	public double calculatePrice() {
		double subtotal = this.getPrice()*this.getQuantity();
		return subtotal;
		
	}

}
