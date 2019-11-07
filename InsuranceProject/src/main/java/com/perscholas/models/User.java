package com.perscholas.models;

import java.time.LocalDate;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String userEmail; 
	private String userPassword; 
	private LocalDate userDOB;
	public User() {
		super();
	}

	
	public User(int userId, String firstName, String lastName, String userEmail, String userPassword,
			LocalDate userDOB) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userDOB = userDOB;
	}

	public User(String firstName, String lastName, String userEmail, String userPassword, LocalDate userDOB) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userDOB = userDOB;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public LocalDate getUserDOB() {
		return userDOB;
	}
	public void setUserDOB(LocalDate userDOB) {
		this.userDOB = userDOB;
	}




}
