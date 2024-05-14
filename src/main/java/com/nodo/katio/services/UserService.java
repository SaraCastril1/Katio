// PASO 2: Lógica de programación

package com.nodo.katio.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.nodo.katio.repositories.UserRepository;



import com.nodo.katio.interfaces.BaseUserService;
import com.nodo.katio.models.User;

@Service
public class UserService implements BaseUserService{
    
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public User addUser(User user) {                                                                
        try{
            // if(user.getPasshash().length() > 15)
            // {
            //     user.setPasshash(blake3Formatter(user.getPasshash()));
            //     user = userRepository.saveAndFlush(user);
            // }
            user.setPasshash(blake3Formatter(user.getPasshash()));
            user = userRepository.saveAndFlush(user);
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }    
        return user;
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByName(String name) {
        return userRepository.findByName(name);
    }


    //Encriptación en una sola dirección
    private String blake3Formatter(String value)  throws NoSuchAlgorithmException
    {
        final MessageDigest md = MessageDigest.getInstance("SHA3-512");
        byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
        String sha3Hex = bytesToHex(hash);
        return sha3Hex;
    }

    private String bytesToHex(byte[] hash){
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while(hexString.length() < 64){
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
    
    
    
}
