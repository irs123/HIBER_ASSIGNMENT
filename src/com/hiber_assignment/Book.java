package com.hiber_assignment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import org.hibernate.mapping.Set;

import antlr.collections.List;
@Entity
public class Book {
	@Id
	private int book_id;
	private String book_name;
	private int book_price;
	
	
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	

}
