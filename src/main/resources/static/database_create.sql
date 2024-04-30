-- MariaDB
CREATE DATABASE katio2
COLLATE = `uca1400_spanish_ai_ci`; 
-- Accent Insensitive Case Insensitive

Use katio2;

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