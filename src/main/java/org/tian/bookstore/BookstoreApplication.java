package org.tian.bookstore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tian.bookstore.models.Author;
import org.tian.bookstore.models.FavoriteRating;
import org.tian.bookstore.models.FavoriteRatingKey;
import org.tian.bookstore.models.Genre;
import org.tian.bookstore.models.book.Book;
import org.tian.bookstore.models.userAccount.User;
import org.tian.bookstore.repository.AuthorRepository;
import org.tian.bookstore.repository.BookRepository;
import org.tian.bookstore.repository.FavoriteRatingRepository;
import org.tian.bookstore.repository.GenreRepository;
import org.tian.bookstore.repository.UserAccountRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner userAccountDemo(UserAccountRepository accountRepository, BookRepository b, FavoriteRatingRepository frr, AuthorRepository ar, GenreRepository gr) {
		return (args) -> {

            // create books
			User ua = accountRepository.save(new User("John", "john@m.com"));
			Genre g1 = gr.save(new Genre("Technology"));
			Author a1 = ar.save(new Author("Bob"));
			Book book1 = new Book("Thinking in Java");
			List<Author> authorList = new ArrayList();
			authorList.add(a1);
			book1.setAuthor(authorList);
			
			List<Genre> genreList = new ArrayList();
			genreList.add(g1);
			book1.setGenres(genreList);
			
			Book savedBook = b.save(book1);
			
			
			System.out.println("Book id: " + savedBook.getId());
			FavoriteRatingKey frKey1 = new FavoriteRatingKey(ua.getId(), savedBook.getId());
			FavoriteRating fr1 = new FavoriteRating(frKey1, ua, savedBook, 4);
			frr.save(fr1);
			List<FavoriteRating> list = (ArrayList)frr.findAll();
			
			System.out.println(list.get(0).getId().bookId);
			

		};
	}
	
	
	
	
}
