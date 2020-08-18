package org.tian.bookstore.controller;

import org.apache.coyote.http11.Http11AprProtocol;
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
import org.tian.bookstore.models.Genre;
import org.tian.bookstore.models.book.Book;
import org.tian.bookstore.models.book.BookForm;
import org.tian.bookstore.service.BookService;
import org.tian.bookstore.service.GenreService;

@RestController
@RequestMapping(value="/api/books/")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private GenreService genreService;
	
	@GetMapping(value="{id}")
	@ResponseBody
	public String findBookById(@PathVariable long id) {
		return "working";
	}
	
	@PostMapping()
	public ResponseEntity<?> addNewBook(@RequestBody BookForm bookForm) {
		
		Book book = bookService.addNewBook(new Book(bookForm.getTitle(), bookForm.getAuthor()));
		
		if(book == null || genreService.addGenre(bookForm) == null) return  new ResponseEntity<>("Could not add book", HttpStatus.BAD_REQUEST);
			
		
		return new ResponseEntity<>("Book added", HttpStatus.ACCEPTED);
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
