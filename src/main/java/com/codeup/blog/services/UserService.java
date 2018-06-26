package com.codeup.blog.services;

import com.codeup.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    private UserRepository users;

    @Autowired
    public UserService(UserRepository users){this.users = users; }

    public UserRepository getUsers() { return users ;}
}

