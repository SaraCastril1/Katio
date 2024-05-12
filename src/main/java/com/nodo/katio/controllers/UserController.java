// PASO 1: Agente de trancito que recibe las conexiones

package com.nodo.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.services.UserService;
import com.nodo.katio.models.User;
import com.nodo.katio.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> users = new UserService(userRepository).getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createdUser = new UserService(userRepository).addUser(user);

        return createdUser.getId() == 0 ? ResponseEntity.badRequest().body(createdUser)
                : ResponseEntity.ok(createdUser);
    }

    // @PutMapping("/update/{id}")
    // public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody
    // User updatedUser) {
    // User existingUser = userRepository.findById(id).orElseThrow(() -> new
    // ResourceNotFoundException("User not found with id: " + id));

    // existingUser.setName(updatedUser.getName());
    // existingUser.setEmail(updatedUser.getEmail());
    // existingUser.setLastname(updatedUser.getLastname());
    // existingUser.setPhone(updatedUser.getPhone());
    // existingUser.setIdentification(updatedUser.getIdentification());
    // existingUser.setPasshash(updatedUser.getPasshash());

    // existingUser = userRepository.save(existingUser); // Save updated user

    // return ResponseEntity.ok(existingUser);
    // }

}