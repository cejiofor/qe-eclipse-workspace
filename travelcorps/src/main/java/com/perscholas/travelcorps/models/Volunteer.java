package com.perscholas.travelcorps.models;

import java.util.ArrayList;
import java.util.List;

public class Volunteer extends User {
	private int volunteerID;
	private String volunteerName;
	private String email;
	private String address;
	private List<Skill> skills;
	
	public Volunteer() {
		super();
	}
	
	public Volunteer(int volunteerID, String volunteerName, String email, String address) {
		super();
		this.volunteerID = volunteerID;
		this.volunteerName = volunteerName;
		this.email = email;
		this.address = address;
		this.skills = new ArrayList<Skill>();	
	}
	
	public Volunteer(User user, String volunteerName, String email, String address) {
		this.setUserId(user.getUserId());
		this.setUserName(user.getUserName());
		this.setPassword(user.getPassword());
		this.setPrimeContact(user.getPrimeContact());
		this.volunteerID = user.getUserId();
		this.volunteerName = volunteerName;
		this.email = email;
		this.address = address;
		this.skills = new ArrayList<Skill>();	
	}
	
	
//	@Override
//	public int getUserID() {
//		return userID;
//	}
//	
//	@Override
//	public void setUserID(int userID) {
//		this.userID = userID;
//	}
	
	public int getVolunteerID() {
		return volunteerID;
	}

	public void setVolunteerID(int volunteerID) {
		this.volunteerID = volunteerID;
	}

	public String getVolunteerName() {
		return volunteerName;
	}

	public void setVolunteerName(String volunteerName) {
		this.volunteerName = volunteerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Volunteer [volunteerID=" + volunteerID + ", volunteerName=" + volunteerName + ", email=" + email
				+ ", address=" + address + ", skills=" + skills + ", toString()=" + super.toString() + "]";
	}
	
	

}
