// PASO 1: Agente de trancito que recibe las conexiones

package com.nodo.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.services.AuthorService;

import java.util.Optional;

import com.nodo.katio.models.Author;
import com.nodo.katio.repositories.AuthorRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;
    
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Author>> getAllAuthors(){
        Iterable<Author> Authors = new AuthorService(authorRepository).getAllAuthors();
        return ResponseEntity.ok(Authors);
    }

    @GetMapping ("/get_by_id/{id}")
    public Optional<Author> getAuthorById(@PathVariable("id") Long id){
        return new AuthorService(authorRepository).getAuthorById(id);
   }

    
} 