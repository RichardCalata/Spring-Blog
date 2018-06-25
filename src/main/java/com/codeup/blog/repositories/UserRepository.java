package com.codeup.blog.repositories;

import com.codeup.blog.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


public interface UserRepository extends CrudRepository<User, Long> {

@Query(nativeQuery = true, value= "SELECT * FROM user LIMIT 1")
User first();
}
