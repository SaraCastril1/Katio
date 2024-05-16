package com.nodo.katio.interfaces;

import com.nodo.katio.models.Book;

public interface BaseBookService {
    Iterable<Book> getAllBooks();
    Book getBookById(long id);
    Iterable<Book> getBooksByName(String name);
    Iterable<Book> getBooksByGenre(String genre);
    Iterable<Book> getBooksByEdition(String edition);

    // BOOKS BY AUTHORS ----------------------------------------------------------------------
    Book getBookByAuthorId(long id);
}
