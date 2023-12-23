CREATE DATABASE IF NOT EXISTS proyek_pbokel_19;
USE proyek_pbokel_19;

CREATE TABLE IF NOT EXISTS myBook (
    `ISBN` INT NOT NULL PRIMARY KEY,
    `title` VARCHAR(50) NOT NULL,
    `author` VARCHAR(50) NOT NULL,
    `publisher` VARCHAR(50) NOT NULL,
    `year` INT NOT NULL,
    `currentPages`INT NOT NULL DEFAULT 0,
    `totalPages` INT NOT NULL,
    `status` TINYINT(1) NOT NULL DEFAULT 0,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DROP DATABASE proyek_pbokel_19`mybook`
DROP TABLE myBook

SELECT * FROM myBook