package com.nodo.katio.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.dto.BookByAuthor;
import com.nodo.katio.models.Book;
import com.nodo.katio.repositories.BookRepository;
import com.nodo.katio.repositories.BookByAuthorRepository;
import com.nodo.katio.services.BookService;




@RestController
@RequestMapping("/katio/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookByAuthorRepository bookByAuthorRepository;


    @GetMapping("/getall")
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        Iterable<Book> books = new BookService(bookRepository, bookByAuthorRepository).getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PutMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book createdBook = new BookService(bookRepository, bookByAuthorRepository).addBook(book);
        
        return createdBook.getId() == 0 ? 
                ResponseEntity.badRequest().body(createdBook) :
                ResponseEntity.ok(createdBook);
    }

   @GetMapping("/getById")
    public ResponseEntity<Book> getBookById(@RequestBody Book book) {
        Optional<Book> response = Optional.ofNullable(new BookService(bookRepository, bookByAuthorRepository).getBookById(book.getId()));
        
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<Iterable<Book>> getBookByName(@RequestBody Book book) {
        var response = new BookService(bookRepository, bookByAuthorRepository).getBooksByName(book.getName());
        return new ResponseEntity<Iterable<Book>>(response, HttpStatus.OK);
    }

    @GetMapping("/getByGenre")
    public ResponseEntity<Iterable<Book>> getBookByGenre(@RequestBody Book book) {
        var response = new BookService(bookRepository, bookByAuthorRepository).getBooksByGenre(book.getGenre());
        return new ResponseEntity<Iterable<Book>>(response, HttpStatus.OK);
    }

    @GetMapping("/getByEdition")
    public ResponseEntity<Iterable<Book>> getBookByEdition(@RequestBody Book book) {
        var response = new BookService(bookRepository, bookByAuthorRepository).getBooksByEdition(book.getEdition());
        return new ResponseEntity<Iterable<Book>>(response, HttpStatus.OK);
    }

    @GetMapping("/getByAuthorId")
    public ResponseEntity<Iterable<Book>> getBookByAuthorId(@RequestBody Book book) {
        var response = new BookService(bookRepository, bookByAuthorRepository).getBooksByAuthorId(book.getAuthorId());
        return new ResponseEntity<Iterable<Book>>(response, HttpStatus.OK);
    }

    // BOOKS BY AUTHORS ----------------------------------------------------------------------
    @GetMapping("/getByAuthorName/{name}")
    public ResponseEntity<Iterable<BookByAuthor>> getBooksByAuthorName(@PathVariable("name") String name) {
        var response = new BookService(bookRepository, bookByAuthorRepository).getBooksByAuthorName(name);
        return new ResponseEntity<Iterable<BookByAuthor>>(response, HttpStatus.OK);
    }

    @GetMapping("/getByAuthorLastname/{lastname}")
    public ResponseEntity<Iterable<BookByAuthor>> getBooksByAuthorLastname(@PathVariable("lastname") String lastname) {
        var response = new BookService(bookRepository, bookByAuthorRepository).getBooksByAuthorName(lastname);
        return new ResponseEntity<Iterable<BookByAuthor>>(response, HttpStatus.OK);
    }



}