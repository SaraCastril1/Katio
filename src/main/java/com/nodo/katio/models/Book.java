package com.nodo.katio.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String isbn10;
    private String isbn13;
    private Date published;
    private String edition;
    private String genre;
    private String deweyIndex;
    private long authorId;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIsbn10() {
        return isbn10;
    }
    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }
    public String getIsbn13() {
        return isbn13;
    }
    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }
    public Date getPublished() {
        return published;
    }
    public void setPublished(Date published) {
        this.published = published;
    }
    public String getEdition() {
        return edition;
    }
    public void setEdition(String edition) {
        this.edition = edition;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getDeweyIndex() {
        return deweyIndex;
    }
    public void setDeweyIndex(String deweyIndex) {
        this.deweyIndex = deweyIndex;
    }
    public long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }


    
}
