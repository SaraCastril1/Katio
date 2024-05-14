package com.nodo.katio.interfaces;

import java.util.Optional;

import com.nodo.katio.models.Author;

public interface BaseAuthorService {
    Iterable<Author> getAllAuthors();
     Optional<Author> getAuthorById(Long id);
}
