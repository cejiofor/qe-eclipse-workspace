package com.perscholas.springmvc_jpa.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student {
	// Attributes
		@Id
		@GeneratedValue
		private Integer studentId;
		
		@Size(min=2, max=25,  message="Name must be between 2 and 25 characters long.")
		@NotBlank(message="Name is required.")
		private String name;
		@Email(message="Please enter a valid email.")
		@NotBlank(message="Email is required.")
		private String email;
		private List<Course> courses;
		// Constructors
		public Student() {}
		public Student(String name, String email) {
			this();
			this.name = name;
			this.email = email;
		}
		
		// Getters and Setters
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
		public List<Course> getCourses() {
			return courses;
		}
		public void setCourses(List<Course> courses) {
			this.courses = courses;
		}
}