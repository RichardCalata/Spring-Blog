package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public Post(){}

    public long getId() { return id; }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public long setId() {return id;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
