package org.tian.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.tian.bookstore.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{
	
	public Author findByauthorName(String name);
}
