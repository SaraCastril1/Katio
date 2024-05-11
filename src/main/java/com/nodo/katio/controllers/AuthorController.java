package com.nodo.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.repositories.UserRepository;
import com.nodo.katio.services.UserService;

@RestController
@RequestMapping("/author")

public class AuthorController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<com.nodo.katio.models.User>> getAllUsers() {
        Iterable<com.nodo.katio.models.User> author = new UserService(userRepository).getAllUsers();
        return ResponseEntity.ok(author);
    }

    public AuthorController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}