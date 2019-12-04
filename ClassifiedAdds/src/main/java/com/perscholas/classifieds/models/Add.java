package com.perscholas.classifieds.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Add {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addId;
	@Size(min=5, max=35, message="Item name must be betwen 5 and 35 characters long.")
	@NotBlank(message="Item name field cannot be empty.")
	private String item;
	@DecimalMin("0.01") 
	private double price;
	private Boolean available;
	
	public Add() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Add(Integer id,
			@Size(min = 5, max = 35, message = "Item name must be betwen 5 and 35 characters long.") @NotBlank(message = "Item name field cannot be empty.") String item,
			@DecimalMin("0.01") double price, Boolean available) {
		super();
		this.addId = id;
		this.item = item;
		this.price = price;
		this.available = available;
	}
	public Integer getAddId() {
		return addId;
	}
	public void setAddId(Integer id) {
		this.addId = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
	
}
