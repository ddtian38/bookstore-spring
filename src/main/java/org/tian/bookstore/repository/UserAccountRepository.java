package org.tian.bookstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.tian.bookstore.models.userAccount.User;

public interface UserAccountRepository extends CrudRepository<User, Long> {

}
