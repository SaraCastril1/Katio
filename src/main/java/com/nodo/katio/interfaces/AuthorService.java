package com.nodo.katio.interfaces;

import com.nodo.katio.models.Author;

public interface AuthorService {

    Iterable<AuthorService> getAllUsers();

    <User> User addAutorService(Author Author);
}