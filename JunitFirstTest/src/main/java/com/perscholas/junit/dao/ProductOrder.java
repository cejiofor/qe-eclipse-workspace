package com.perscholas.junit.dao;

public class ProductOrder extends Product {
	private Double subtotal;
	private int quantity;
	
	public ProductOrder() {
		// TODO Auto-generated constructor stub
	}

	public ProductOrder(Integer productId, String productName, Double productPrice) {
		super(productId, productName, productPrice);
		// TODO Auto-generated constructor stub
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
		this.subtotal = this.getProductPrice()*this.quantity;
	}

	@Override
	public String toString() {
		return "Item: " + getProductName() + ", Quanitiy: " + quantity + ", Price: $" + getProductPrice() + " , Subtotal: $" + subtotal;
	}
	
	

}
