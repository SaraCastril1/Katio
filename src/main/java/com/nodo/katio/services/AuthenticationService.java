package com.nodo.katio.services;

// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nodo.katio.models.User;
import com.nodo.katio.repositories.UserRepository;

@Service
public class AuthenticationService {

    // private final UserRepository userRepository;
    // private final PasswordEncoder passwordEncoder;
    // private final AuthenticationManager authenticationManager;

    // public AuthenticationService(
    //     UserRepository userRepository,
    //     AuthenticationManager authenticationManager,
    //     PasswordEncoder passwordEncoder
    // ) {
    //     this.authenticationManager = authenticationManager;
    //     this.userRepository = userRepository;
    //     this.passwordEncoder = passwordEncoder;
    // }

    // public User signup(User input) {
    //     input.setPasshash(passwordEncoder.encode(input.getPassword()));
    //     return userRepository.saveAndFlush(input);
    // }

    // public User authenticate(LoginUser input) {
    //     authenticationManager.authenticate(
    //             new UsernamePasswordAuthenticationToken(
    //                     input.getEmail(),
    //                     input.getPassword()
    //             )
    //     );

    //     return userRepository.findByUserName(input.getEmail())
    //             .orElseThrow();
    // }
}