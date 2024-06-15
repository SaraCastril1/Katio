package com.nodo.katio.interfaces;


import com.nodo.katio.models.Author;

public interface BaseAuthorService {
    Iterable<Author> getAllAuthors();
    Author addAuthor(Author author) throws Exception;
    Author getAuthorById(long id);
    Iterable<Author> getAuthorsByName(String name);
    Iterable<Author> getAuthorsByLastname(String lastname);
    Iterable<Author> getAuthorsByCountry(String country);

}
