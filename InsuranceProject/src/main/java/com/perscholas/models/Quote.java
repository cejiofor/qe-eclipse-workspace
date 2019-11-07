package com.perscholas.models;

import java.time.LocalDate;

public class Quote {
	private int quoteId;
	private int homeId;
	private double yearlyPremium;
	private LocalDate startDate;
	private LocalDate expiration;
	private boolean active;
	
	public Quote(int quoteId, int homeId, double yearlyPremium, LocalDate startDate, LocalDate expiration,
			boolean active) {
		super();
		this.quoteId = quoteId;
		this.homeId = homeId;
		this.yearlyPremium = yearlyPremium;
		this.startDate = startDate;
		this.expiration = expiration;
		this.active = active;
	}
	public Quote() {
		super();
	}
	public Quote(int homeId, double yearlyPremium, LocalDate startDate, LocalDate expiration, boolean active) {
		super();
		this.homeId = homeId;
		this.yearlyPremium = yearlyPremium;
		this.startDate = startDate;
		this.expiration = expiration;
		this.active = active;
	}
	public int getQuoteId() {
		return quoteId;
	}
	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}
	public int getHomeId() {
		return homeId;
	}
	public void setHomeId(int homeId) {
		this.homeId = homeId;
	}
	public double getYearlyPremium() {
		return yearlyPremium;
	}
	public void setYearlyPremium(double yearlyPremium) {
		this.yearlyPremium = yearlyPremium;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getExpiration() {
		return expiration;
	}
	public void setExpiration(LocalDate expiration) {
		this.expiration = expiration;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
