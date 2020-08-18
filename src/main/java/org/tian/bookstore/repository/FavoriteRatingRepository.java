package org.tian.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.tian.bookstore.models.FavoriteRating;
import org.tian.bookstore.models.FavoriteRatingKey;

public interface FavoriteRatingRepository extends CrudRepository<FavoriteRating, FavoriteRatingKey>{

}
