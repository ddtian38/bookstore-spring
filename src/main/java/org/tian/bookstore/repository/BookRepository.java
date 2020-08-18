package org.tian.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.tian.bookstore.models.book.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
