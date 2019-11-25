package com.perscholas.travelcorps.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	@Id
	@GeneratedValue
	private int userId;
	
	@Size(min=2, max=25,  message="Name must be between 2 and 25 characters long.")
	@NotBlank(message="User Name is required.")
	private String userName;
	
	@Size(min=8, message="Password must be at least 8 characters long.")
	@NotBlank(message="passoword is required.")
	private String password;
	
	private Boolean primeContact;
	
	public User() {
	}
	
	public User(String userName, String password, Boolean primeContact) {
		super();
		this.userName = userName;
		this.password = password;
		this.primeContact = primeContact;
	}

	public User(int userId, String userName, String password, Boolean primeContact) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.primeContact = false;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getPrimeContact() {
		return primeContact;
	}

	public void setPrimeContact(Boolean primeContact) {
		this.primeContact = primeContact;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", primeContact="
				+ primeContact + "]";
	}
	
}
