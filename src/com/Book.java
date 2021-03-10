package com;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	private int isbn;
	private String title;
	private double price;
	@ManyToOne
	@JoinColumn(name="AuthorID", nullable=false)
	private Author author;
	
	public Book() {
		
	}
	public Book(int isbn, String title, double price,Author author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.author=author;
	
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", author=" + author + "]";
	}
	
	
	

}
