package com.perscholas.models;

public class Member {
	private int memberId;
	private String name;
	private String email;
	private String password;
	private String favoriteGenre;
	
	public Member() {
		super();
	}

	public Member(String name, String email, String password, String favoriteGenre) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.favoriteGenre = favoriteGenre;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFavoriteGenre() {
		return favoriteGenre;
	}

	public void setFavoriteGenre(String favoriteGenre) {
		this.favoriteGenre = favoriteGenre;
	}
	
	
	
	

}
