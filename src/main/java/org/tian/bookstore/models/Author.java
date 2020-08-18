package org.tian.bookstore.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.tian.bookstore.models.book.Book;

@Entity
public class Author {
	@Id
	@GeneratedValue
	@Column(name="authorId")
	private long id;
	
	private String authorName;
	
	@ManyToMany(mappedBy = "authors")
	private Set<Book> books;
	
	public Author () {}
	
	public Author(String authorName) {
		super();
		this.authorName = authorName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}


}
