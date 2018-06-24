package com.hiber_assignment;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

//import org.hibernate.annotations;

@Entity
public class Author {
	@Id 
	private int author_id;
	private String author_name;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@JoinColumn (name ="Book_Author")
	private Book book;
	

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}

		
	

}
