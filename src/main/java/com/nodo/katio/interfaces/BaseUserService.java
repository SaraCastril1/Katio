package com.nodo.katio.interfaces;

import java.util.Optional;

import com.nodo.katio.models.User;


public interface BaseUserService {
    Iterable<User> getAllUsers();
    User addUser(User user) throws Exception;
    User getUserById(long id);
    Iterable<User> getUsersByName(String name);
    Optional<User> getUserByEmail(String email);
    User getLoggedUser(String email, String passhash);
    User updateUserByUsername(String username, User updatedUsuario);
    
}