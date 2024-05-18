package com.nodo.katio.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.nodo.katio.dto.BookByAuthor;
import com.nodo.katio.interfaces.BaseBookService;
import com.nodo.katio.models.Book;
import com.nodo.katio.repositories.BookByAuthorRepository;
import com.nodo.katio.repositories.BookRepository;

@Service
public class BookService implements BaseBookService {

    private BookRepository bookRepository;
    private BookByAuthorRepository bookByAuthorRepository;

    public BookService(BookRepository bookRepository, BookByAuthorRepository bookByAuthorRepository){
        this.bookRepository = bookRepository;
        this.bookByAuthorRepository = bookByAuthorRepository;
    }
    

    @Override
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(long id) {
        return bookRepository.findById(id);
    }


    @Override
    public Iterable<Book> getBooksByName(String name) {
        return bookRepository.findByName(name);
    }

    @Override
    public Iterable<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    @Override
    public Iterable<Book> getBooksByEdition(String edition) {
        return bookRepository.findByEdition(edition);
    }


    // BOOKS BY AUTHORS ------------------------------------------------------------------

    @Override
    public Iterable<Book> getBooksByAuthorId(long id) {
        return bookRepository.findByAuthorId(id);
    }

    @Override
    public Iterable<BookByAuthor> getBooksByAuthorName(String name) {
        return bookByAuthorRepository.findByAuthorName(name); 
    }

    
        


    
}
