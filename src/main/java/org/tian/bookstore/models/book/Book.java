package org.tian.bookstore.models.book;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.tian.bookstore.models.Author;
import org.tian.bookstore.models.FavoriteRating;
import org.tian.bookstore.models.Genre;

@Entity
public class Book {
	@Id
	@GeneratedValue
	@Column(name="bookId")
	private Long id;
	
	@Column(nullable = false, length=100, unique=true)
	private String bookTitle;
	
	@Column(nullable=false, length=100)
	private String author;
	
	@OneToMany(mappedBy = "books")
    List<FavoriteRating> ratings;
	
	@ManyToMany
	@JoinTable(
	  name = "book_genres",
	  joinColumns = @JoinColumn(name = "bookId"), 
	  inverseJoinColumns = @JoinColumn(name = "genreId"))
	List<Genre> genres;
	
	
	@ManyToMany
	@JoinTable(
	  name = "book_authors",
	  joinColumns = @JoinColumn(name = "bookId"), 
	  inverseJoinColumns = @JoinColumn(name = "authorId"))
	List<Author> authors;

	
	public Book() {}

	public Book(String bookTitle, String author) {
		this.bookTitle = bookTitle;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public List<Author> getAuthor() {
		return authors;
	}

	public void setAuthor(List<Author>  authors) {
		this.authors = authors;
	}

	public List<FavoriteRating> getRatings() {
		return ratings;
	}

	public void setRatings(List<FavoriteRating> ratings) {
		this.ratings = ratings;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	
}
