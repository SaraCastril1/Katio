// PASO 1: Agente de trancito que recibe las conexiones

package com.nodo.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.services.UserService;

import java.util.List;
import java.util.Optional;

import com.nodo.katio.models.User;
import com.nodo.katio.repositories.UserRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
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

    @GetMapping ("/get_by_id/{id}")
    public Optional<User> getUserById(@PathVariable("id") Integer id){
        return new UserService(userRepository).getUserById(id);
   }

   
} 