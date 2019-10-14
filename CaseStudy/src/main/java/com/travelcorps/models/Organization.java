package com.travelcorps.models;

import java.util.ArrayList;
import java.util.List;

public class Organization extends User{
	private int orgID;
	private String orgName;
	private String website;
	private String email;
	private String address;
	private String mission;
	private List<Project> projects;
	
	public Organization() {
		super();
	}
	
	public Organization(String orgName, String website, String email, String address, String mission) {
		super();
		this.orgID = this.getUserID();
		this.orgName = orgName;
		this.website = website;
		this.email = email;
		this.address = address;
		this.mission = mission;
		this.projects = new ArrayList<Project>();
		
	}

	public int getOrgID() {
		return orgID;
	}

	public void setOrgID(int orgID) {
		this.orgID = orgID;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
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

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	

}
