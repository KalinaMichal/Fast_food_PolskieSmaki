/*tworzymy tabelkę directors*/
CREATE TABLE directors (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
surname VARCHAR(30),
pesel VARCHAR(30),
date_of_birth DATE,
nationality VARCHAR(30) NOT NULL,
phone VARCHAR(30),
address VARCHAR(30),
salary INT NOT NULL, 
branch_id INT NOT NULL);
/* Klucze obce */
ALTER TABLE directors ADD FOREIGN KEY (branch_id) REFERENCES branches( id ); 

/* Dodawanie dyrectora do bazy */
/* schemat naszej funkcji pensja, branch_id, position_id, work_time, login, hasło, imię, nazwisko, pesel, dateOfBirth, nationality, telefon, adres*/
DROP PROCEDURE IF EXISTS insert_director;
DELIMITER $$
CREATE PROCEDURE insert_director(  IN na VARCHAR(30), IN su VARCHAR(30), IN pe VARCHAR(30), IN da DATE, IN nat VARCHAR(30), IN phone VARCHAR(30), IN addr VARCHAR(30), IN s INT, IN bID INT, IN l VARCHAR(30), IN p VARCHAR(30)  )
	BEGIN
    DECLARE directorID INT;
    INSERT INTO directors (name, surname, pesel, date_of_birth, nationality, phone, address, salary, branch_id) VALUES (na, su, pe, da, nat, phone, addr, s, bID);
    SET directorID = last_insert_id();
    INSERT INTO directors_login_data VALUES (directorID, l, md5(p) );
	END $$
DELIMITER ;

call insert_director( 'Jan', 'Kowalski', '11111111111', '1999-11-15', 'Polska', '999999999', 'Wroclaw', 5000, 1, 'login', 'haslo');
