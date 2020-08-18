package org.tian.bookstore.models.userAccount;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.tian.bookstore.models.FavoriteRating;

@Entity
public class User {

	@Id
	@GeneratedValue
	@Column(name="userId")
	private Long id;
	
	@Column(nullable = false, length=100)
	private String username;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@OneToMany(mappedBy = "userAccount")
    List<FavoriteRating> ratings;

	
	
	public User() {
	super();
}


	public User(String username, String emailAddress) {
		this.username = username;
		this.emailAddress = emailAddress;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public List<FavoriteRating> getRatings() {
		return ratings;
	}


	public void setRatings(List<FavoriteRating> ratings) {
		this.ratings = ratings;
	}


//	public Set<Books> getFavoriteBooks() {
//		return favoriteBooks;
//	}
//
//
//	public void setFavoriteBooks(Set<Books> favoriteBooks) {
//		this.favoriteBooks = favoriteBooks;
//	}
//	
	
	
	
	
	
}
