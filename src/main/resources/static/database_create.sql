-- MariaDB
CREATE DATABASE katio3
COLLATE = `uca1400_spanish_ai_ci`; 
-- Accent Insensitive Case Insensitive

Use katio3;

CREATE TABLE users
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    lastname NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) NOT NULL,
    phone NVARCHAR(20) NOT NULL,
    identification NVARCHAR(20) NOT NULL,
    passhash NVARCHAR(255) NOT NULL,
    INDEX email_idx(Email)
);

CREATE TABLE Authors
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    lastname NVARCHAR(255) NOT NULL,
    country NVARCHAR(255) NOT NULL,
    birthdate DATE NOT NULL,
    INDEX apellido_ix(lastname)
);

CREATE TABLE Books
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    isbn10 NVARCHAR(255) NOT NULL,
    isbn13 NVARCHAR(255) NOT NULL,
    published DATE NOT NULL,
    edition NVARCHAR(255) NOT NULL,
    genre NVARCHAR(255) NOT NULL,
    dewey_Index INT UNSIGNED NOT NULL,
    author_Id INT UNSIGNED NOT NULL,
    CONSTRAINT `fk_book_author`
        FOREIGN KEY (author_Id) REFERENCES Authors (Id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
);