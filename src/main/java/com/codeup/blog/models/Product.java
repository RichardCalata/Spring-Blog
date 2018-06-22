package com.codeup.blog.models;

import javax.persistence.*;

@Entity
public class Product {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    public Product(){}

    public Product(String title, String description){
        this.title = title;
        this.description = description;
    }

    public Product(long id, String title, String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }
}
