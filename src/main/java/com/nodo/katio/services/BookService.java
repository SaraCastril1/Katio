package com.nodo.katio.services;

import java.util.ArrayList;

import com.nodo.katio.dto.BookByAuthor;
import com.nodo.katio.interfaces.BaseBookService;
import com.nodo.katio.models.Book;
import com.nodo.katio.repository.BookRepository;
import com.nodo.katio.repository.BookByAuthorRepository;

public class BookService<BooksByAuthorRepository> implements BaseBookService {

    private BookRepository _bookRepository;
    private BooksByAuthorRepository _BooksByAuthorRepository;

    public BookService(BookRepository bookRepository) {
        _bookRepository = bookRepository;
    }

    public BookService(BooksByAuthorRepository booksByAuthorRepository) {
        _BooksByAuthorRepository = booksByAuthorRepository;
    }

    @Override
    public Iterable<Book> getAllBooks() {
        var bookList = _bookRepository.findAll();
        return bookList;
    }

    @Override
    public Iterable<Book> getAllBooksByAuthor(int idAuthor) {
        var booklist = _bookRepository.findByAuthorId(idAuthor);
        return booklist;
    }

    @Override
    public Iterable<BookByAuthor> getAllBooksByAuthor(String Name, String Lastname) {

        Iterable<BookByAuthor> bookList = new ArrayList<BookByAuthor>();

        if (Lastname.length() > 0 && Name.length() <= 0) {
            bookList = (Iterable<BookByAuthor>) ((BookRepository) _BooksByAuthorRepository)
                    .findByAuthorLastName(Lastname);

        } else if (Lastname.length() <= 0 && Name.length() > 0) {
            bookList = ((BookByAuthorRepository) _BooksByAuthorRepository).findByAuthorName(Name);
        } else {
            bookList = ((BookByAuthorRepository) _BooksByAuthorRepository).findByAuthorFullName(Lastname, Name);
        }

        return bookList;
    }

    @Override
    public Iterable<Book> getBooksByName(String Name) {
        var bookList = _bookRepository.findByName(Name);
        return bookList;
    }

    public BookRepository get_bookRepository() {
        return _bookRepository;
    }

    public void set_bookRepository(BookRepository _bookRepository) {
        this._bookRepository = _bookRepository;
    }

    public BooksByAuthorRepository get_BooksByAuthorRepository() {
        return _BooksByAuthorRepository;
    }

    public void set_BooksByAuthorRepository(BooksByAuthorRepository _BooksByAuthorRepository) {
        this._BooksByAuthorRepository = _BooksByAuthorRepository;
    }

}
