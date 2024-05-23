package com.nodo.katio.interfaces;

import com.nodo.katio.dto.BookByAuthor;
import com.nodo.katio.models.Book;

public interface BaseBookService {
    Iterable<Book> getAllBooks();
    Book addBook(Book book);
    Book getBookById(long id);
    Iterable<Book> getBooksByName(String name);
    Iterable<Book> getBooksByGenre(String genre);
    Iterable<Book> getBooksByEdition(String edition);
   

    // BOOKS BY AUTHORS ----------------------------------------------------------------------
    Iterable<Book> getBooksByAuthorId(long id);
    Iterable<BookByAuthor> getBooksByAuthorName(String name);
    Iterable<BookByAuthor> getBooksByAuthorLastame(String lastname);
}
