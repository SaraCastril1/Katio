package com.nodo.katio.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nodo.katio.dto.BookByAuthor;
import com.nodo.katio.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM Books WHERE Author_Id = ?1")
    Iterable<Book> findByAuthorId(@Param("Author_Id") int authorId);

    @Query(nativeQuery = true, value = "SELECT " + //
            "au.id, bk.id as 'Id', bk.Name as 'Book_Name', bk.ISBN13, au.Name as 'Authors name', au.Lastname as 'Authors last name', CONCAT(au.Name, ' ', au.Lastname) as 'Author' "
            + //
            "FROM Authors au " +
            "JOIN Books bk ON bk.author_id = au.id " + //
            "WHERE " + //
            "au.Lastname LIKE :lastname")
    Iterable<BookByAuthor> findByAuthorLastName(@Param("lastname") String lastname);

    @Query(nativeQuery = true, value = "SELECT * FROM BOOKS WHERE Name LIKE %:name%")
    Iterable<Book> findByName(@Param("name") String name);
}