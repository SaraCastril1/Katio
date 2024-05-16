package com.nodo.katio.services;


import java.math.BigInteger;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.nodo.katio.interfaces.BaseBookService;
import com.nodo.katio.models.Book;
import com.nodo.katio.models.User;
import com.nodo.katio.repositories.BookRepository;

@Service
public class BookService implements BaseBookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
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


    
}
