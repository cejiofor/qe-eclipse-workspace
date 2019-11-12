package com.perscholas.xml_context.beans;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
	
	// Attributes
	private String responsePage;
	private List<String> courses;

	// Constructors
	public CourseRepository() {
		courses = new ArrayList<String>();
		courses.add("Application Support Management");
		courses.add("Data Engineering");
		courses.add("Quality Engineering and Assurance");
		this.responsePage = "CoursesPage";
	}
	
	// Getters and Setters
	public String getResponsePage() {
		return responsePage;
	}
	public void setResponsePage(String message) {
		this.responsePage = message;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
}
