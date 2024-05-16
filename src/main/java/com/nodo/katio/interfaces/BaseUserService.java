package com.nodo.katio.interfaces;

import com.nodo.katio.models.User;


public interface BaseUserService {
    Iterable<User> getAllUsers();
    User addUser(User user);
    User getUserById(long id);
    Iterable<User> getUsersByName(String name);
}