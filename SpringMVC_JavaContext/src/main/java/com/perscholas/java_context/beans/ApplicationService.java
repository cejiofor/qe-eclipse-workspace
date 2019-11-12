package com.perscholas.java_context.beans;


// The bean classes are simple java classes that emulate services (classes that provide business logic) and repositories (provides a mechanism for database operations):

public class ApplicationService {
	// Attributes
	private String responsePage;

	// Constructors
	public ApplicationService() {
		this.responsePage = "ApplicationPage";
	}
	
	// Getters and Setters
	public String getResponsePage() {
		return responsePage;
	}
	public void setResponsePage(String responsePage) {
		this.responsePage = responsePage;
	}
}