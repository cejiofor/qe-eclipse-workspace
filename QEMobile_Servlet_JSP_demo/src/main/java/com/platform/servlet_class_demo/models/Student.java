package com.platform.servlet_class_demo.models;

public class Student {
	private int studentId;
	private String name;
	private String email;
	private String courseSelected;
	
	//Constructor
	public Student() {
		
	}
	public Student(String name, String email, String courseSelected) {
		this.name = name;
		this.email = email;
		this.courseSelected = courseSelected;
	}
	
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
	
	@Override
	public String toString() {
		String printStmt =  String.format("ID: %d, Name: %s, Email: %s, Course: %s", studentId, name, email, courseSelected);
		return printStmt;
	}
	
	
}
