package com.nodo.katio.services;

import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.stereotype.Service;

import com.nodo.katio.interfaces.BaseAuthorService;
import com.nodo.katio.models.Author;
import com.nodo.katio.models.User;
import com.nodo.katio.repositories.AuthorRepository;

@Service
public class AuthorService implements BaseAuthorService {

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    

    @Override
    public Iterable<Author> getAllAuthors() {
        return authorRepository.findAll();
    }



    @Override
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    
}
