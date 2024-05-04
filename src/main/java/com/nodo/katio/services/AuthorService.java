
package com.nodo.katio.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Service;
import com.nodo.katio.repositories.AuthorRepository;
import com.nodo.katio.models.Author;

@Service
public class AuthorService implements AuthorService {

    @SuppressWarnings({ "rawtypes", "unused" })
    private AuthorRepository AuthorRepository;

    public AuthorService(@SuppressWarnings("rawtypes") AuthorRepository userRepository) {
        this.AuthorRepository = AuthorRepository;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterable<Author> getAllUsers() {
        return AuthorRepository.findAll();
    }

    @Override
    public Author Author(Author Author) {
        try {
            // if(user.getPasshash().length() > 15)
            // {
            // user.setPasshash(blake3Formatter(user.getPasshash()));
            // user = userRepository.saveAndFlush(user);
            // }
            Author.setPasshash(blake3Formatter(Author.getPasshash()));
            Author = (com.nodo.katio.models.Author) AuthorRepository.saveAndFlush(Author);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Author;
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

    @SuppressWarnings("rawtypes")
    public AuthorRepository getAuthorRepository() {
        return AuthorRepository;
    }

    public void setAuthorRepository(AuthorRepository authorRepository) {
        AuthorRepository = authorRepository;
    }

}
