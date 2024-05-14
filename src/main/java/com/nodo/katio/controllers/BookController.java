package com.nodo.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.models.Book;
import com.nodo.katio.repositories.BookRepository;
import com.nodo.katio.services.BookService;


@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        Iterable<Book> books = new BookService(bookRepository).getAllBooks();
        return ResponseEntity.ok(books);
    }


    @GetMapping("/getByName")
    public ResponseEntity<Iterable<Book>> getBookByName(@RequestBody Book book) {
        var response = new BookService(bookRepository).getBooksByName(book.getName());
        return new ResponseEntity<Iterable<Book>>(response, HttpStatus.OK);
    }

}