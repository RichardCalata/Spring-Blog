package com.codeup.blog.models;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name="ads")
public class Ad {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;
}