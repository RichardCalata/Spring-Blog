package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

}
