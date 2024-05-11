package com.nodo.katio.controllers;

import java.net.ConnectException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.services.BookService;

@RestController
@RequestMapping("/katio/health")
public class HealtCheck<BookRepository> {

    @SuppressWarnings("unused")
    @Autowired
    private com.nodo.katio.repositories.BookRepository _BookRepository;

    @GetMapping("/check")
    public ResponseEntity<String> healtCheck() {
        String result = "";
        try {
            new BookService(_BookRepository).getallBooks();
            result = "Healt Check: Passed \nDatabase Connection: Passed";
        } catch (Exception ex) {
            if (ex.getCause() instanceof ConnectException) {
                result = "Health Check: Failed\n" +
                        "katio API:online\n" +
                        "Database Connection:   Failed\n" +
                        "[ERROR MESAGGE]: " + ex.getMessage();
            } else {
                result = "Health Check: Failed\n" +
                        "katio API:online\n" +
                        "[ERROR MESAGGE]: " + ex.getMessage();
            }

        }

        return new ResponseEntity<String>(result, HttpStatus.OK);

    }

}
