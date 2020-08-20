package org.tian.bookstore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tian.bookstore.models.Author;
import org.tian.bookstore.models.book.BookForm;
import org.tian.bookstore.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
    private static Logger logger = LoggerFactory.getLogger(BookService.class);

	
	public Author addAuthor(BookForm bookForm) {
		Author author = authorRepository.findByauthorName(bookForm.getAuthor());
		if(author == null) author = authorRepository.save(new Author(bookForm.getAuthor()));
		return author;
	}
}
