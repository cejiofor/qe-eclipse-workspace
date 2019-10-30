package com.perscholas.servlet;

public class User {
	private int userId;
	private String name;
	private String email;
	
	public User() {
		super();
	}
	
	public User(int userID, String name, String email) {
		super();
		this.userId = userID;
		this.name = name;
		this.email = email;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userID) {
		this.userId = userID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
