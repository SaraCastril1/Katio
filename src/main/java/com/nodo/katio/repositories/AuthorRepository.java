package com.nodo.katio.repositories;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nodo.katio.repositories.UserRepository;
import com.nodo.katio.services.UserService;

@RestController
@RequestMapping("/repository")

public class AuthorRepository 
    
}


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<com.nodo.katio.models.User>> getAllUsers(){
        Iterable<com.nodo.katio.models.User> repository = new UserService(userRepository).getAllUsers();
        return ResponseEntity.ok(repository);  
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
}
