package com.perscholas.models;

import java.time.LocalDateTime;

public class Event {
	private int eventId;
	private String title;
	private String description;
	private String location;
	private LocalDateTime dateTime;
	private int memberId;
	
	public Event() {
		super();
	}
	
	public Event(String title, String description, String location, LocalDateTime dateTime, int memberId) {
		super();
		this.title = title;
		this.description = description;
		this.location = location;
		this.dateTime = dateTime;
		this.memberId = memberId;
	}

	
	public Event(int eventId, String title, String description, String location, LocalDateTime dateTime, int memberId) {
		super();
		this.eventId = eventId;
		this.title = title;
		this.description = description;
		this.location = location;
		this.dateTime = dateTime;
		this.memberId = memberId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	
}
