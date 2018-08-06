package com.example.demo.services;

import com.example.demo.models.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findByTitle(String title);
    List<Book> findAll();
    Book findByUuid(String uuid);
    Boolean deleteByUuid(String uuid);
    Book save(Book book);
    Book save(Book book, String uuid);
}
