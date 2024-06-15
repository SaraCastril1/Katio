// PASO 2: Lógica de programación

package com.nodo.katio.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
// import java.security.SecureRandom;
// import java.util.Base64;
// import java.util.Formatter;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.nodo.katio.repositories.UserRepository;

import com.nodo.katio.interfaces.BaseUserService;
import com.nodo.katio.models.User;

@Service
public class UserService implements BaseUserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    // @Override
    // public User addUser(User user) {
    // try{
    // if(user.getPasshash().length() > 15 )
    // {
    // user.setPasshash(blake3Formatter(user.getPasshash()));
    // user = userRepository.saveAndFlush(user);
    // }

    // }
    // catch(Exception ex){
    // System.out.println("[ERROR]: {}" + ex.getMessage());
    // }
    // return user;
    // }

    @Override
    public User addUser(User user) throws Exception {

        var isUser = userRepository.findByEmail(user.getEmail());
        if (user.getPasshash().length() < 15 || !isUser.isEmpty()) {
            throw new Exception("[ERROR]: Email already exists or password hash is too short");
        } 
        user.setPasshash(blake3Formatter(user.getPasshash()));
        user = userRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Iterable<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Encriptación en una sola dirección
    private String blake3Formatter(String value) throws NoSuchAlgorithmException {

        final MessageDigest md = MessageDigest.getInstance("SHA3-512");
        byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
        String sha3Hex = bytesToHex(hash);
        return sha3Hex;

    }

    private String bytesToHex(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    // // este metodo generea la llave unica para la encriptacion
    // private String GenerateSalt() {
    // SecureRandom salt = new SecureRandom();
    // byte[] bytesSalt = new byte[16];
    // salt.nextBytes(bytesSalt);

    // return Base64.getEncoder().encodeToString(bytesSalt);
    // }

    // // metodo para hashear la contraseña
    // public static String hashPassword(String plainTextPassword) {
    // String saltedPassword = plainTextPassword;
    // try {
    // MessageDigest md = MessageDigest.getInstance("SHA3-512");
    // byte[] hashedBytes = md.digest(saltedPassword.getBytes());
    // return byteArrayToHexString(hashedBytes);
    // } catch (NoSuchAlgorithmException e) {
    // throw new RuntimeException(e);
    // }
    // }

    // // metodo que parsea a string el array e bites que se hasheo en el metodo
    // anterior
    // private static String byteArrayToHexString(byte[] bytes) {
    // try (Formatter formatter = new Formatter()) {
    // for (byte b : bytes) {
    // formatter.format("%02x", b);
    // }
    // return formatter.toString();
    // }
    // }

    // public static boolean validatePassword(String plainTextPassword, String
    // storedHash) throws NoSuchAlgorithmException {
    // String hashedPassword = blake3Formatter(plainTextPassword);
    // return hashedPassword.equals(storedHash);
    // }

    @Override
    public User getLoggedUser(String email, String passhash){
        try{
            String validPassword = blake3Formatter(passhash);
            var loggedUser = userRepository.findLoggedUser(email, validPassword);
            return loggedUser.orElse(null);
        }catch(Exception ex){
            return null;
        }
        
    }

    @Override
    public User updateUserByUsername(String username, User updatedUser) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User myUser = optionalUser.get(); // Si el usuario existe, obtiene el usuario actual de optionalUsuario.

            if (updatedUser.getName() != null) {
                myUser.setName(updatedUser.getName());
            }
            if (updatedUser.getLastname() != null) {
                myUser.setLastname(updatedUser.getLastname());
            }
            if (updatedUser.getEmail() != null) {
                myUser.setEmail(updatedUser.getEmail());

                // if (userRepository.findByEmail(updatedUser.getEmail()).isEmpty()){
                // System.out.println("Dirección de correo electronico a actualizar ya está en
                // uso");
                // }
            }
            if (updatedUser.getPhone() != null) {
                myUser.setPhone(updatedUser.getPhone());
            }
            if (updatedUser.getIdentification() != null) {
                myUser.setIdentification(updatedUser.getIdentification());
            }

            return userRepository.saveAndFlush(myUser);
        } else {
            return null; // Usuario no encontrado
        }
    }

}
