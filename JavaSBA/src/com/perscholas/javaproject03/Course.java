package com.perscholas.javaproject03;

//JavaSBAProject_03
//Make a class named Course and include attributes for id, course name, course description. Create a no-arg constructor and a constructor with 3 arguments. Create the getters and setters. Override the default toString method to return a String that lists out the instance data.

public class Course {
	private int id;
	private String course_name;
	private String course_description;
	
	public Course() {
		super();
	}
	
	public Course(int id, String name, String description) {
		this.id = id;
		this.course_name = name;
		this.course_description = description;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_description() {
		return course_description;
	}

	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}

	@Override
	public String toString() {
		return String.format("id: %s, Course Name: %s, Course Description: %s",this.getId(), this.getCourse_name(), this.getCourse_description());
				
	}
}
