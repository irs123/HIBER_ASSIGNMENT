package com.hiber_assignment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class AuthorAddress {
	@Id
	private int author_id;
	private String author_address;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Author author;
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_address() {
		return author_address;
	}
	public void setAuthor_address(String author_address) {
		this.author_address = author_address;
	}
	

}
