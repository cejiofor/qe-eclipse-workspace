package com.platform.servlet_class_demo.models;

public class Student {
	private int studentId;
	private String name;
	private String email;
	private String courseSelected;
	
	//Constructor
	
	
	// Getters and Setters
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public String getCourseSelected() {
		return courseSelected;
	}
	public void setCourseSelected(String courseSelected) {
		this.courseSelected = courseSelected;
	}
	
	
	
}
