package com.nodo.katio.interfaces;

import com.nodo.katio.models.User;

import java.util.Optional;

public interface BaseUserService {
    
    Iterable<User> getAllUsers();
    User addUser(User user);
    Optional<User> getUserById(Integer id);
}