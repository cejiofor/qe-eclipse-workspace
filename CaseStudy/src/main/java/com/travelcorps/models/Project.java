package com.travelcorps.models;

import java.util.Date;
import java.util.List;

public class Project {
	private int projectID;
	private String orgID;
	private String city;
	private String country;
	private Date startDate;
	private Date endDate;
	private List<Skill> skills;

	public Project() {
	}
	
	public Project(int projectID, String orgID, String city, String country, Date startDate, Date endDate, List<Skill> skills) {
		this.projectID = projectID;
		this.orgID = orgID;
		this.city = city;
		this.country = country;
		this.startDate = startDate;
		this.endDate = endDate;
		this.skills = skills;
		 
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getOrgID() {
		return orgID;
	}

	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

}

