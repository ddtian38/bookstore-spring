package org.tian.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.tian.bookstore.models.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

	public Genre findBygenreName(String genre);
}
