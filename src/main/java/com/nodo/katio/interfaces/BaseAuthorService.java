package com.nodo.katio.interfaces;

import com.nodo.katio.models.Author;

public interface BaseAuthorService {

    Iterable<Author> getAllUsers();

    Author addAutorService(Author author);
}