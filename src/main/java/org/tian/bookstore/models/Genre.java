package org.tian.bookstore.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.tian.bookstore.models.book.Book;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue
	@Column(name="genreId")
	private long id;
	
	@Column(unique=true)
	private String genreName;
	
	@ManyToMany(mappedBy = "genres")
	private Set<Book> books;

	public Genre() {}
	
	public Genre(String genreName) {
		super();
		this.genreName = genreName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
	
}
