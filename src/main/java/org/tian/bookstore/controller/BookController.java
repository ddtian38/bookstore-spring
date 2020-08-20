package org.tian.bookstore.controller;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.tian.bookstore.models.Author;
import org.tian.bookstore.models.Genre;
import org.tian.bookstore.models.book.Book;
import org.tian.bookstore.models.book.BookForm;
import org.tian.bookstore.service.AuthorService;
import org.tian.bookstore.service.BookService;
import org.tian.bookstore.service.GenreService;

@RestController
@RequestMapping(value="/api/books/")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private AuthorService authorService;
	
    private static Logger logger = LoggerFactory.getLogger(BookController.class);

	
	@GetMapping(value="{id}")
	public String findBookById(@PathVariable long id) {
		return "working";
	}
	
	@PostMapping()
	public ResponseEntity<?> addNewBook(@RequestBody BookForm bookForm) {
		
		Book bookExists = bookService.findByBookTitle(new Book(bookForm.getTitle()));
		
		if(bookExists != null) return  new ResponseEntity<>("Book " + bookExists.getBookTitle() + " already exists.", HttpStatus.BAD_REQUEST);
		
		Book newBook = new Book(bookForm.getTitle());
		
		Genre genre = genreService.findGenre(bookForm);
		
		if(genre != null) {
			List<Genre> genreList = new ArrayList<>();
			genreList.add(genre);
			newBook.setGenres(genreList);
		}
		
		Author author = authorService.addAuthor(bookForm);

		if(author != null) {
			List<Author> authorList = new ArrayList<>();
			authorList.add(author);
			newBook.setAuthor(authorList);
		}
		 
		 newBook = bookService.addBook(newBook);
		
		if(newBook != null) return new ResponseEntity<>("Book added", HttpStatus.ACCEPTED);
		
		return  new ResponseEntity<>("Book " + bookForm.getTitle() + " could not be added.", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(value="{id}")
	@ResponseBody
	public String updateBookById(@PathVariable long id) {
		return "working";
	}
	
	@DeleteMapping(value="{id}")
	@ResponseBody
	public String deleteBookById(@PathVariable long id) {
		return "working";
	}
	

}
