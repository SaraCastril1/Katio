package com.nodo.katio.interfaces;

import com.nodo.katio.models.Book;

public interface BaseBookService {
    Iterable<Book> getAllBooks();
    Iterable<Book> getBooksByName(String name);
}
