package com.nodo.katio.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.models.Book;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping("/getall")
    public ResponseEntity<Book> getAll() {
        return new ResponseEntity<Book>(new Book(), HttpStatus.OK);
    }

}
