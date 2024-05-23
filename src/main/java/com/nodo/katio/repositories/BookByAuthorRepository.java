package com.nodo.katio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nodo.katio.dto.BookByAuthor;

public interface BookByAuthorRepository extends JpaRepository<BookByAuthor, Long> {

    @Query(nativeQuery = true, 
       value = "SELECT"+
                    "bk.id as book_id," + 
                    "bk.name as book_name, "+
                    "bk.isbn13, "+
                    "au.name as author_name, " +
                    "au.lastname as author_lastname " +
                "FROM AUTHORS au " +
                "JOIN BOOKS bk ON bk.author_Id = au.id "+
                "WHERE " +
                    "au.lastname LIKE %:lastname%")
    Iterable<BookByAuthor> findByAuthorLastname(@Param("lastname") String lastname);

    // @Query(nativeQuery = true,
    //     value =
    //         "SELECT " +
    //             "bk.id as book_id," + 
    //             "bk.name as book_name, "+
    //             "bk.isbn13, "+
    //             "au.name as author_name, " +
    //             "au.lastname as author_lastname " +
    //         "FROM authors au " +
    //         "JOIN books bk ON bk.author_Id = au.id " +
    //         "WHERE " +
    //             "au.name LIKE '%:name%' ")
    // Iterable<BookByAuthor> findByAuthorName(@Param("name") String name);

    @Query(nativeQuery = true,
    value =
        "SELECT " +
            "bk.id as book_id," + 
            "bk.name as book_name, "+
            "bk.isbn13, "+
            "au.name as author_name, " +
            "au.lastname as author_lastname " +
        "FROM authors au " +
        "JOIN books bk ON bk.author_Id = au.id " +
        "WHERE " +
            "au.name LIKE %:name%")
    Iterable<BookByAuthor> findByAuthorName(@Param("name") String name);



    @Query(nativeQuery = true,
        value =
            "SELECT " +
                "bk.id as book_id," + 
                "bk.name as book_name, "+
                "bk.isbn13, "+
                "au.name as author_name, " +
                "au.lastname as author_lastname " +
            "FROM AUTHORS au " +
            "JOIN BOOKS bk ON bk.author_Id = au.id " +
            "WHERE " +
                "au.lastname LIKE %:lastname% OR au.name LIKE %:name%")
    Iterable<BookByAuthor> findByAuthorFullName(@Param("lastname") String lastname, @Param("name") String name);


}