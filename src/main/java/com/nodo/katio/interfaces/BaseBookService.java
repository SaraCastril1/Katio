package com.nodo.katio.interfaces;


import com.nodo.katio.models.Book;

public interface BaseBookService {
    Iterable<Book> getAllBooks();
    Book getBookById(long id);
    Iterable<Book> getBooksByName(String name);
}
