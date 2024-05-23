// PASO 1: Agente de trancito que recibe las conexiones

package com.nodo.katio.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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


    // @PostMapping("/login")
    // public ResponseEntity<?> login(@RequestBody User user) throws NoSuchAlgorithmException{
    //     var loggedUser = new UserService(userRepository).getLoggedUser(user.getEmail(), user.getPasshash());
    //     if(loggedUser != null){
    //         return new ResponseEntity<>(loggedUser, HttpStatus.OK);
    //     }else{
    //         return new ResponseEntity<String>("¡Email o contraseña incorrecta!", HttpStatus.BAD_REQUEST);
    //     }
        
    // }

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) throws NoSuchAlgorithmException {
        Optional<User> response = Optional.ofNullable(new UserService(userRepository).getLoggedUser(user.getEmail(), user.getPasshash()));
        
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    

   
} 