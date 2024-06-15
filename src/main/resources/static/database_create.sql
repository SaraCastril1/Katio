-- MariaDB.
CREATE DATABASE katio
COLLATE = `uca1400_spanish_ai_ci`; 
-- Accent Insensitive Case Insensitive

Use katio;

CREATE TABLE users
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    lastname NVARCHAR(255) NOT NULL,
    email NVARCHAR(255) NOT NULL,
    phone NVARCHAR(20) NOT NULL,
    identification NVARCHAR(20) NOT NULL,
    passhash NVARCHAR(255) NOT NULL,
    INDEX email_idx(email)
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
    Dewey_Index INT UNSIGNED NOT NULL,
    author_id INT UNSIGNED NOT NULL,
    CONSTRAINT `fk_book_author`
        FOREIGN KEY (author_Id) REFERENCES Authors (Id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
);


CREATE TABLE Audiobooks
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,
    isbn10 NVARCHAR(255) NOT NULL,
    isbn13 NVARCHAR(255) NOT NULL,
    published Date NOT NULL,
    edition NVARCHAR(255) NOT NULL,
    genre NVARCHAR(255) NOT NULL,
    abridged BIT NOT NULL,
    lengthInSeconds INT UNSIGNED NOT NULL,
    path NVARCHAR(255) NOT NULL,
    author_id INT UNSIGNED NOT NULL,
    CONSTRAINT `fk_audiobooks_author`
        FOREIGN KEY (author_id) REFERENCES Authors (id)
        ON DELETE CASCADE
        ON UPDATE RESTRICT
);

CREATE TABLE Narrator
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name NVARCHAR(255) NOT NULL,    
    lastName NVARCHAR(255) NOT NULL,
    genre NVARCHAR(255) NOT NULL,
    languages NVARCHAR(255) NOT NULL    
);

CREATE TABLE Books_Authors
(
  book_id INT UNSIGNED NOT NULL,
  author_id INT UNSIGNED NOT NULL,
  CONSTRAINT `fk_books_id`
  	FOREIGN KEY (book_id) REFERENCES Books (id)
  	ON DELETE CASCADE
  	ON UPDATE RESTRICT,
  CONSTRAINT `fk_authors_id`
  	FOREIGN KEY (author_id) REFERENCES Authors (id)
  	ON DELETE CASCADE
  	ON UPDATE RESTRICT  
);

ALTER TABLE Books DROP FOREIGN KEY IF EXISTS fk_book_author;
ALTER TABLE Books DROP COLUMN IF EXISTS Author_id;


CREATE VIEW Book_author_view AS
SELECT 
	bk.id as Book_id, 
    bk.name as book_name, 
    au.id as Author_id, 
  CONCAT(au.name, " ", au.lastname) as Author_name 
FROM Books_authors ba
JOIN Books bk ON bk.id = ba.book_id
JOIN Authors au ON au.id = ba.author_id;


ALTER TABLE IF EXISTS Users 
	ADD COLUMN IF NOT EXISTS role_id nvarchar(10) NOT NULL;


-- TO DO: 
    -- 1. Agregar insert into
    -- 2. Join AS A VIEW
    -- 3. Modelo
    -- 4. Repositorio
