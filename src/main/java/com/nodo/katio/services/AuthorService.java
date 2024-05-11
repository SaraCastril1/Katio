
package com.nodo.katio.services;

import com.nodo.katio.repositories.AuthorRepository;
import com.nodo.katio.interfaces.BaseAuthorService;
import com.nodo.katio.models.Author;

public class AuthorService implements BaseAuthorService {

    private AuthorService AuthorService;

    public AuthorService getAuthorService() {
        return AuthorService;
    }

    public void setAuthorService(AuthorService authorService) {
        AuthorService = authorService;
    }

    @SuppressWarnings("rawtypes")
    public AuthorService(AuthorRepository userRepository, AuthorService Authors) {
        this.AuthorService = Authors;
    }
    /*
     * @Override
     * public Iterable<BaseAuthorService> getAllUsers() {
     * return AuthorRepository.findAll();
     * }
     * 
     * @Override
     * public Author Author(Author Author) {
     * try {
     * // if(user.getPasshash().length() > 15)
     * // {
     * // user.setPasshash(blake3Formatter(user.getPasshash()));
     * // user = userRepository.saveAndFlush(user);
     * // }
     * Author.setPasshash(blake3Formatter(Author.getPasshash()));
     * Author = (com.nodo.katio.models.Author)
     * AuthorRepository.saveAndFlush(Author);
     * 
     * } catch (Exception ex) {
     * ex.printStackTrace();
     * }
     * return Author;
     * }
     * 
     * // Encriptación en una sola dirección
     * private String blake3Formatter(String value) throws NoSuchAlgorithmException
     * {
     * final MessageDigest md = MessageDigest.getInstance("SHA3-512");
     * byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
     * String sha3Hex = bytesToHex(hash);
     * return sha3Hex;
     * }
     * 
     * private String bytesToHex(byte[] hash) {
     * BigInteger number = new BigInteger(1, hash);
     * StringBuilder hexString = new StringBuilder(number.toString(16));
     * while (hexString.length() < 64) {
     * hexString.insert(0, '0');
     * }
     * return hexString.toString();
     * }
     * 
     * @Override
     * public <User> User addAutorService(com.nodo.katio.models.Author Author) {
     * // TODO Auto-generated method stub
     * throw new
     * UnsupportedOperationException("Unimplemented method 'addAutorService'");
     * }
     */

    @Override
    public Iterable<Author> getAllUsers() {
        return AuthorService.findAll();
    }

    private Iterable<Author> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Author addAutorService(Author author) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAutorService'");
    }
}
