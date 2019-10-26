package com.travelcorps.models;

public class User {
	private int userID;
	private String userName;
	private String password;
	private Boolean primeContact;
	
	public User() {
	}
	
	public User(int userID, String userName, String password, Boolean primeContact) {
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.primeContact = false;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", primeContact="
				+ primeContact + "]";
	}
	
}
