/**
 * 
 */
package com.ahmetalbayrak.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

/**
 * @author Ahmet
 *
 */
@Entity
@Table(name="userBook")
public class UserBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userBookId")
	private int userBookId;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user", joinColumns = @JoinColumn(name = "userId"))
	private User user;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "books", joinColumns = @JoinColumn(name = "isbn"))
	private Books books;
	public int getUserBookId() {
		return userBookId;
	}
	public void setUserBookId(int userBookId) {
		this.userBookId = userBookId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	
	
}
