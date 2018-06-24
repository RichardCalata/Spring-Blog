package com.codeup.blog.repositories;

import com.codeup.blog.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


public interface UserRepository extends CrudRepository<User, Long> {


User findOne(Long id);
}
