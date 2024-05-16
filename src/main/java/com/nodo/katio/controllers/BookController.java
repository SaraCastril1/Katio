package com.nodo.katio.controllers;

import java.util.Optional;

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
@RequestMapping("/katio/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        Iterable<Book> books = new BookService(bookRepository).getAllBooks();
        return ResponseEntity.ok(books);
    }

   @GetMapping("/getById")
    public ResponseEntity<Book> getBookById(@RequestBody Book book) {
        Optional<Book> response = Optional.ofNullable(new BookService(bookRepository).getBookById(book.getId()));
        
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<Iterable<Book>> getBookByName(@RequestBody Book book) {
        var response = new BookService(bookRepository).getBooksByName(book.getName());
        return new ResponseEntity<Iterable<Book>>(response, HttpStatus.OK);
    }

    @GetMapping("/getByGenre")
    public ResponseEntity<Iterable<Book>> getBookByGenre(@RequestBody Book book) {
        var response = new BookService(bookRepository).getBooksByGenre(book.getGenre());
        return new ResponseEntity<Iterable<Book>>(response, HttpStatus.OK);
    }

    @GetMapping("/getByEdition")
    public ResponseEntity<Iterable<Book>> getBookByEdition(@RequestBody Book book) {
        var response = new BookService(bookRepository).getBooksByEdition(book.getEdition());
        return new ResponseEntity<Iterable<Book>>(response, HttpStatus.OK);
    }

    // BOOKS BY AUTHORS ----------------------------------------------------------------------
    @GetMapping("/getByAuthorId")
    public ResponseEntity<Book> getBookByAuthorId(@RequestBody Book book) {
        Optional<Book> response = Optional.ofNullable(new BookService(bookRepository).getBookByAuthorId(book.getAuthorId()));
        
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}