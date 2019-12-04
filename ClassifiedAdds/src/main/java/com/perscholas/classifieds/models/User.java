package com.perscholas.classifieds.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	@Id
	@GeneratedValue
	private Integer userId;
	@Size(min=2, max=25,  message="Name must be between 2 and 25 characters long.")
	@NotBlank(message="Name is required.")
	private String name;
	@Size(min=8, max=25,  message="Passowrd must be between 8 and 25 characters long.")
	@NotBlank(message="Password is required.")
	private String password;
	private List<Add> orders;
	
	public User() {
		super();
	}

	public User(
			@Size(min = 2, max = 25, message = "Name must be between 2 and 25 characters long.") @NotBlank(message = "Name is required.") String name,
			@Size(min = 8, max = 25, message = "Passowrd must be between 8 and 25 characters long.") @NotBlank(message = "Password is required.") String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public User(Integer userId,
			@Size(min = 2, max = 25, message = "Name must be between 2 and 25 characters long.") @NotBlank(message = "Name is required.") String name,
			@Size(min = 8, max = 25, message = "Passowrd must be between 8 and 25 characters long.") @NotBlank(message = "Password is required.") String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Add> getOrders() {
		return orders;
	}

	public void setOrders(List<Add> orders) {
		this.orders = orders;
	}
	
	
}
