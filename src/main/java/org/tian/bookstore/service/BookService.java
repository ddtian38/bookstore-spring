package org.tian.bookstore.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tian.bookstore.models.book.Book;
import org.tian.bookstore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
    private static Logger logger = LoggerFactory.getLogger(BookService.class);

	
	public Optional<Book> findById(long id){
		return bookRepository.findById(id);
	}
	
	public Book findByBookTitle(Book book) {
		return bookRepository.findBybookTitle(book.getBookTitle());
	}
	
	public void addAuthorToBook() {
		
	}
	
	public void addGenreToBook() {
		
	}
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

}
