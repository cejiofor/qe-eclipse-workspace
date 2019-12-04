package com.perscholas.rest_controllers.models;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private Integer studentId;
	private String name;
	private String email;
	private List<String> courses;
	
	public Student() {}
	
	public Student(Integer studentId, String name, String email) {
		this.studentId = studentId;
		this.name = name;
		this.email= email;
		this.courses = new ArrayList<String>();
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
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
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
}
