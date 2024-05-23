// PASO 1: Agente de trancito que recibe las conexiones

package com.nodo.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.services.AuthorService;
import com.nodo.katio.services.UserService;

import java.util.Optional;

import com.nodo.katio.models.Author;
import com.nodo.katio.models.User;
import com.nodo.katio.repositories.AuthorRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/katio/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Author>> getAllAuthors(){
        Iterable<Author> Authors = new AuthorService(authorRepository).getAllAuthors();
        return ResponseEntity.ok(Authors);
    }

    @PutMapping("/add")
    public ResponseEntity<Author> addUser(@RequestBody Author author) {
        Author createdAuthor = new AuthorService(authorRepository).addAuthor(author);
        
        return createdAuthor.getId() == 0 ? 
                ResponseEntity.badRequest().body(createdAuthor) :
                ResponseEntity.ok(createdAuthor);
    }

    @GetMapping("/getById")
    public ResponseEntity<Author> getAuthorById(@RequestBody Author author) {
        Optional<Author> response = Optional.ofNullable(new AuthorService(authorRepository).getAuthorById(author.getId()));
        
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<Iterable<Author>> getAuthorByName(@RequestBody Author author) {
        var response = new AuthorService(authorRepository).getAuthorsByName(author.getName());
        return new ResponseEntity<Iterable<Author>>(response, HttpStatus.OK);
    }

    @GetMapping("/getByLastname")
    public ResponseEntity<Iterable<Author>> getAuthorByLastname(@RequestBody Author author) {
        var response = new AuthorService(authorRepository).getAuthorsByLastname(author.getLastname());
        return new ResponseEntity<Iterable<Author>>(response, HttpStatus.OK);
    }

    @GetMapping("/getByCountry")
    public ResponseEntity<Iterable<Author>> getAuthorByCountry(@RequestBody Author author) {
        var response = new AuthorService(authorRepository).getAuthorsByCountry(author.getCountry());
        return new ResponseEntity<Iterable<Author>>(response, HttpStatus.OK);
    }

    
} 