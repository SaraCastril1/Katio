package com.nodo.katio.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    
    private String name;
    private Integer authorId;
    private String isbn;
    private Date publishedDate;
    private Integer edition;

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Date getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }
    public Integer getEdition() {
        return edition;
    }
    public void setEdition(Integer edition) {
        this.edition = edition;
    }


    
}
