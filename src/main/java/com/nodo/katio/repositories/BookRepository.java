package com.nodo.katio.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nodo.katio.models.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Query(nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE id = :id")
    Book findById(@Param("id") long id);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE name LIKE %:name%")
    Iterable<Book> findByName(@Param("name") String name);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE genre LIKE %:genre%")
    Iterable<Book> findByGenre(@Param("genre") String genre);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE edition LIKE %:edition%")
    Iterable<Book> findByEdition(@Param("edition") String edition);
}


