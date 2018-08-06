package com.example.demo.services;

import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class BookRepositoryImpl implements BookRepository {

    List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findByTitle(String title) {
        Stream<Book> booksTitle = books.stream()
                .parallel()
                .filter(item -> item.getTitle().contains(title));
        return booksTitle.collect(Collectors.toList());
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findByUuid(String uuid) {
        Optional<Book> book = books.parallelStream()
                .findAny()
                .filter(item -> item.getUuid().equals(uuid));
        if(!book.isPresent())
            throw new BookNotFoundException("UUID: "+ uuid);
        return book.get();
    }

    @Override
    public Boolean deleteByUuid(String uuid) {
        int bookIndex = findIndexByUuid(uuid);
        books.remove(bookIndex);
        return true;
    }

    @Override
    public Book save(Book book) {
        book.setUuid();
        books.add(book);
        return book;
    }

    @Override
    public Book save(Book book, String uuid) {
        int bookIndex = findIndexByUuid(uuid);
        books.set(bookIndex, book);
        return book;
    }

    private int findIndexByUuid(String uuid) {
        int[] index = IntStream.range(0, books.size())
                .parallel()
                .filter(i -> books.get(i).getUuid().equals(uuid))
                .toArray();
        if(index.length <= 0) throw new BookNotFoundException("UUID: "+ uuid);
        return index[0];
    }

}
