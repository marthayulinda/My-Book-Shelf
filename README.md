Sebelum penggunaan, pastikan device sudah memiliki Aplikasi NetBeans dan pastikan program JDBC (MariaDB dan SQLYog) sudah tersedia pada device.

Tahap penggunaan Aplikasi MyBookShelf:
1. Buka file "app_k19.sql" pada SQLYog
2. Eksekusi query satu per satu dengan memblok kode berikut.
	--Pertama, blok dan run kode:
			CREATE DATABASE IF NOT EXISTS proyek_pbokel_19;

	--Kedua, lakukan hal yang sama pada kode:
			USE proyek_pbokel_19;

	--Ketiga, blok dan run kode:
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

	--Untuk memastikan tabel yang di-create sudah tersedia pada database, eksekusi query:
			SELECT * FROM myBook

Buka aplikasi NetBeans pada device, kemudian open project dari file
Aplikasi sudah dapat dijalankan

Demo vidio link : https://youtu.be/n0Mmu8baySg
