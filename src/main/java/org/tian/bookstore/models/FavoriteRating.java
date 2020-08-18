package org.tian.bookstore.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.tian.bookstore.models.book.Book;
import org.tian.bookstore.models.userAccount.User;

@Entity
public class FavoriteRating {

	@EmbeddedId
	private FavoriteRatingKey id;
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name="userId")
	User userAccount;
	
	@ManyToOne
	@MapsId("bookId")
	@JoinColumn(name="bookId")
	Book books;
	
	int rating;
		
	
	public FavoriteRating() {
	} 
	

	public FavoriteRating(FavoriteRatingKey id, User userAccount, Book books, int rating) {
		super();
		this.id = id;
		this.userAccount = userAccount;
		this.books = books;
		this.rating = rating;
	}


	public FavoriteRatingKey getId() {
		return id;
	}


	public void setId(FavoriteRatingKey id) {
		this.id = id;
	}


	public User getUserAccount() {
		return userAccount;
	}


	public void setUserAccount(User userAccount) {
		this.userAccount = userAccount;
	}


	public Book getBooks() {
		return books;
	}


	public void setBooks(Book books) {
		this.books = books;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	
	
	
	
}
