package com.nodo.katio.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nodo.katio.models.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(nativeQuery = true, 
        value = "SELECT * FROM BOOKS WHERE name LIKE %:name%")
    Iterable<Book> findByName(@Param("name") String name);
}


