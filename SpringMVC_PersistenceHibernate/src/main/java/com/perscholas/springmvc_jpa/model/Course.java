package com.perscholas.springmvc_jpa.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer courseId;
	@Size(min=1, max=3, message="Short name must be between 1 and 3 characters long.")
	@NotBlank(message="Short name field cannot be empty.")
	private String code;
	@Size(min=5, max=35, message="Name must be betwen 5 and 35 characters long.")
	@NotBlank(message="Long name field cannot be empty.")
	private String name;
	@Min(5)
	private Integer maxSize;
	private List<Student> roster;
	
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(Integer maxSize) {
		this.maxSize = maxSize;
	}
	public List<Student> getRoster() {
		return roster;
	}
	public void setRoster(List<Student> roster) {
		this.roster = roster;
	}
}
