package com.nodo.katio.services;

import org.springframework.stereotype.Service;

import com.nodo.katio.interfaces.BaseBookService;
import com.nodo.katio.models.Author;
import com.nodo.katio.models.Book;
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
    public Book getBookByAuthorId(long id) {
        return bookRepository.findByAuthorId(id);
    }


    
}
