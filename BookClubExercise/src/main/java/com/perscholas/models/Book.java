package com.perscholas.models;

import java.time.LocalDate;

public class Book {
	private int bookId;
	private String title;
	private String synopsis;
	private String author;
	private LocalDate publicationDate;
	private int memberId;
	
	public Book() {
		super();
	}

	public Book(String title, String synopsis, String author, LocalDate publicationDate, int memberId) {
		super();
		this.title = title;
		this.synopsis = synopsis;
		this.author = author;
		this.publicationDate = publicationDate;
		this.memberId = memberId;
	}

	public Book(int bookId, String title, String synopsis, String author, LocalDate publicationDate, int memberId) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.synopsis = synopsis;
		this.author = author;
		this.publicationDate = publicationDate;
		this.memberId = memberId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	
	
	
	
}
