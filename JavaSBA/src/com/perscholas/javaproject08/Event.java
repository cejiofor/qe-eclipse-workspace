package com.perscholas.javaproject08;

import java.util.Date;

//JavaSBAProject_08
//
//Write an application that includes an Event class that has event ID, name, description, and date/time (java.util.Date). Create an “events” table and save the event data to a database (date must be converted to java.sql.Data.
public class Event {
	private int ID;
	private String name;
	private String description;
	private Date eventTime;
	
	public Event () {
		
	}
	public Event(int ID, String name, String description, Date eventTime) {
		this.ID = ID;
		this.name = name;
		this.description = description;
		this.eventTime = eventTime;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getEventTime() {
		return eventTime;
	}
	public void setEventTime(Date eventTime) {
		this.eventTime = eventTime;
	}
}
