package org.tian.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tian.bookstore.models.Genre;
import org.tian.bookstore.models.book.BookForm;
import org.tian.bookstore.repository.GenreRepository;

@Service
public class GenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	private boolean checkGenreExists(String genre) {
		return genreRepository.findBygenreName(genre) == null;
	}
	
	public Genre addGenre(BookForm bookForm) {
		Genre rtnGenre = null;
		try {
			rtnGenre = genreRepository.save(new Genre(bookForm.getGenre()));
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return rtnGenre;
	}
}
