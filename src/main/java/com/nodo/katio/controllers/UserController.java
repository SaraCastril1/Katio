// PASO 1: Agente de trancito que recibe las conexiones

package com.nodo.katio.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    
    @PutMapping("/signup")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try{
            new UserService(userRepository).addUser(user);
            return new ResponseEntity<String>("El usuario ha sido creado correctamente", HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<String>("El usuario no pudo ser creado.\n Revise sus valores de entrada.", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        var userByEmail = new UserService(userRepository).getLoggedUser(user.getEmail(),
                user.getPasshash());

        if (userByEmail != null) {
            return new ResponseEntity<String>("Usuario correctamente loggeado", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Usuario o contraseña incorrecta", HttpStatus.BAD_REQUEST);
        }

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
    public ResponseEntity<Iterable<User>> getUserByName(@RequestBody User user) {
        var response = new UserService(userRepository).getUsersByName(user.getName());
        return new ResponseEntity<Iterable<User>>(response, HttpStatus.OK);
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<Optional<User>> getUserByEmail(@RequestBody User user) {
        var response = new UserService(userRepository).getUserByEmail(user.getEmail());
        return new ResponseEntity<Optional<User>>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        var updatedUser = new UserService(userRepository);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }



    @PutMapping("/update/{username}")
    public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody User updatedUser) {
        var userService = new UserService(userRepository);
        User my_updatedUser = userService.updateUserByUsername(username, updatedUser);
        if (my_updatedUser != null) {
            return new ResponseEntity<>(my_updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }


   
} 