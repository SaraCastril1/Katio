package com.nodo.katio.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookByAuthor {
    
    @Id
    @Column(name="book_id")
    private long book_id;

    @Column(name="book_name")
    private String book_name;

    @Column(name="isbn13")
    private String isbn13;

    @Column(name="author_name")
    private String author_name;

    @Column(name="author_lastname")
    private String author_lastname;

    public long getBook_id() {
        return this.book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return this.book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getIsbn13() {
        return this.isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getAuthor_name() {
        return this.author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_lastname() {
        return this.author_lastname;
    }

    public void setAuthor_lastname(String author_lastname) {
        this.author_lastname = author_lastname;
    }

    
}