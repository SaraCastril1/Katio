package com.nodo.katio.interfaces;

import com.nodo.katio.dto.BookByAuthor;
import com.nodo.katio.models.Book;

public interface BaseBookService {
    Iterable<Book> getAllBooks();

    Iterable<Book> getAllBooksByAuthor(int idAuthor);

    Iterable<BookByAuthor> getAllBooksByAuthor(String Name, String Lastname);

    Iterable<Book> getBooksByName(String Name);
}
