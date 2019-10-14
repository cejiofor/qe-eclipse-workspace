package com.travelcorps.models;

public class Skill {
	private int skillID;
	private String skillName;
	private String description;
	
	public Skill() {
	}
	
	public Skill(int skillID, String skillName, String description) {
		this.skillID = skillID;
		this.skillName = skillName;
		this.description = description;
	}

	public int getSkillID() {
		return skillID;
	}

	public void setSkillID(int skillID) {
		this.skillID = skillID;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
