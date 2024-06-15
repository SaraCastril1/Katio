package com.nodo.katio.services;
import org.springframework.stereotype.Service;

import com.nodo.katio.interfaces.BaseAuthorService;
import com.nodo.katio.models.Author;
import com.nodo.katio.models.Book;
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
    public Author addAuthor(Author author) throws Exception {
        authorRepository.saveAndFlush(author);
        return author;
    }

    @Override
    public Author getAuthorById(long id) {
        return authorRepository.findById(id);
    }


    @Override
    public Iterable<Author> getAuthorsByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public Iterable<Author> getAuthorsByLastname(String lastname) {
        return authorRepository.findByLastname(lastname);
    }

    @Override
    public Iterable<Author> getAuthorsByCountry(String country) {
        return authorRepository.findByCountry(country);
    }
    
}
