package com.travelcorps.models;

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
	
	public Volunteer(String volunteerName, String email, String address) {
		super();
		this.volunteerID = this.getUserID();
		this.volunteerName = volunteerName;
		this.email = email;
		this.address = address;
		this.skills = new ArrayList<Skill>();
		
	}

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
	
	

}
