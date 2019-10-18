package com.perscholas.junit.dao;

public class Product {
	private Integer productId;
	private String productName;
	private Double productPrice;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(Integer productId, String productName, Double productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		
	}
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}
	
	

}
