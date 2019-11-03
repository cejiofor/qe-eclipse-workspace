package com.perscholas.products;

public class Product {
	private int productId;
	private String productName;
	private String productDescription;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
//		System.out.println(productId);
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
}
