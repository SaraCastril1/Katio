// PASO 1: Agente de trancito que recibe las conexiones

package com.nodo.katio.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.services.UserService;
import com.nodo.katio.models.User;
import com.nodo.katio.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/katio/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/getall")
    public ResponseEntity<Iterable<User>> getAllUsers(){
        Iterable<User> users = new UserService(userRepository).getAllUsers();
        return ResponseEntity.ok(users);
    }
    @PutMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = new UserService(userRepository).addUser(user);
        
        return createdUser.getId() == 0 ? 
                ResponseEntity.badRequest().body(createdUser) :
                ResponseEntity.ok(createdUser);
    }

    @GetMapping("/getById")
    public ResponseEntity<User> getUserById(@RequestBody User user) {
        Optional<User> response = Optional.ofNullable(new UserService(userRepository).getUserById(user.getId()));
        
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getByName")
    public ResponseEntity<Iterable<User>> getBookByName(@RequestBody User user) {
        var response = new UserService(userRepository).getUsersByName(user.getName());
        return new ResponseEntity<Iterable<User>>(response, HttpStatus.OK);
    }

   
} 