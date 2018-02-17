/**
 * 
 */
package com.ahmetalbayrak.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author Ahmet
 *
 */
@Entity
@Table(name="books2")
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="isbn")
	private int isbn;
	
	@Column(name="bookName")
	private String bookName;	


	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	
	
}
