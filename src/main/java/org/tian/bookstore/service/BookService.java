package org.tian.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tian.bookstore.models.book.Book;
import org.tian.bookstore.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Optional<Book> findById(long id){
		return bookRepository.findById(id);
	}
	
	public Book addNewBook(Book book) {
		Book book1 = null;
		try {
			book1 = bookRepository.save(book);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return book1;
		
	}

}
