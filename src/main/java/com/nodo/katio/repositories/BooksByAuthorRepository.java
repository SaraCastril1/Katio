package com.nodo.katio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nodo.katio.dto.BookByAuthor;

public interface BooksByAuthorRepository extends JpaRepository<BookByAuthor, Long> {
    
    @Query(nativeQuery = true,
        value =
            "SELECT " +
                "book_id, book_name, isbn13, "+
                "author_name, author_lastName " +
            "FROM Authors" +
            "JOIN books ON author_id" +
            "WHERE " +
                "authors.lastname LIKE %:lastname%")
    Iterable<BookByAuthor> findByAuthorLastName(@Param("lastname") String lastname);

    @Query(nativeQuery = true,
        value =
            "SELECT " +
                "book_id, book_name, isbn13, "+
                "author.lastname as Author_Name " +
            "FROM authors" +
            "JOIN books ON books.author_id " +
            "WHERE " +
                "authors.name LIKE %:name%")
    Iterable<BookByAuthor> findByAuthorName(@Param("name") String name);

    @Query(nativeQuery = true,
        value =
            "SELECT " +
                "book_id, book_name, isbn13, "+
                "author.lastName as Author_Name " +
            "FROM authors" +
            "JOIN books ON books.author_id " +
            "WHERE " +
                "authors.lastname LIKE %:lastname% OR authors.name LIKE %:name%")
    Iterable<BookByAuthor> findByAuthorFullName(@Param("lastname") String lastname, @Param("name") String name);
}