package com.example.demo.controllers;

import com.example.demo.exceptions.BookIdMismatchException;
import com.example.demo.exceptions.WrongBookDataException;
import com.example.demo.models.Book;
import com.example.demo.services.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/api/books")
    public Iterable findAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/api/books/{bookTitle}")
    public List findByTitle(@PathVariable String bookTitle){
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/api/book/{uuid}")
    public Book findByUuid(@PathVariable String uuid){
        return bookRepository.findByUuid(uuid);
    }

    @PostMapping("/api/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book){
        if(book.getTitle() == null || book.getAuthor() == null ||
            book.getTitle().trim() == "" || book.getAuthor().trim() == "")
            throw new WrongBookDataException("The book title and book author should not be null");
        return bookRepository.save(book);
    }

    @DeleteMapping("/api/book/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String uuid){
        bookRepository.deleteByUuid(uuid);
    }

    @PutMapping("/api/book/{uuid}")
    public Book updateBook(@RequestBody Book book, @PathVariable String uuid){
        if(book.getUuid() == null || !book.getUuid().equals(uuid)){
            throw new BookIdMismatchException("UUID: "+ uuid);
        }
        return bookRepository.save(book, uuid);
    }


}
