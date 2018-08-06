package com.example.demo.models;

import java.util.UUID;

public class Book {
    private String uuid;
    private String title;
    private String author;

    public Book(){}

    public Book(String title, String author){
        this.setTitle(title);
        this.setAuthor(author);
        this.setUuid();
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID().toString();
    }

    public void setUuid(String uuid){
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
