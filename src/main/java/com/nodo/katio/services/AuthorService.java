package com.nodo.katio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.repositories.UserRepository;

@RestController
@RequestMapping("/Service")

public class AuthorService {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<com.nodo.katio.models.User>> getAllUsers() {
        Iterable<com.nodo.katio.models.User> services = new UserService(userRepository).getAllUsers();
        return ResponseEntity.ok(services);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}