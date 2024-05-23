package com.nodo.katio.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nodo.katio.models.Author;


@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author saveAndFlush(Author author);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM AUTHORS WHERE id = :id")
    Author findById(@Param("id") long id);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM AUTHORS WHERE name LIKE %:name%")
    Iterable<Author> findByName(@Param("name") String name);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM AUTHORS WHERE lastname LIKE %:lastname%")
    Iterable<Author> findByLastname(@Param("lastname") String lastname);

    @Query(nativeQuery = true, 
        value = "SELECT * FROM AUTHORS WHERE country LIKE %:country%")
    Iterable<Author> findByCountry(@Param("country") String country);

}
