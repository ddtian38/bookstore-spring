package org.tian.bookstore.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tian.bookstore.models.Genre;
import org.tian.bookstore.models.book.BookForm;
import org.tian.bookstore.repository.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genreRepository;
	
    private static Logger logger = LoggerFactory.getLogger(GenreService.class);

	
	public Genre findGenre(BookForm bookForm) {
		Genre genre =  genreRepository.findBygenreName(bookForm.getGenre());
		if(genre == null) genre = genreRepository.save(new Genre(bookForm.getGenre()));
		return genre;
	}
	
}
