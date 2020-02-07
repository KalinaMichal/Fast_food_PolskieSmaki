/*tworzymy tabelkę workers*/
CREATE TABLE workers(
id INT AUTO_INCREMENT PRIMARY KEY,
salary INT NOT NULL,
branch_id INT NOT NULL,
position_id INT NOT NULL,
work_time ENUM ('full','half','quater') );

/*Indexy*/
ALTER TABLE workers ADD INDEX index_salary USING BTREE (salary);
ALTER TABLE workers ADD INDEX index_work_time USING BTREE (work_time);

/* Klucze obce */
ALTER TABLE workers ADD FOREIGN KEY (branch_id) REFERENCES branches( id );
ALTER TABLE workers ADD FOREIGN KEY (position_id) REFERENCES positions( id );

/* Dodawanie pracownika do bazy */
/* schemat naszej funkcji pensja, branch_id, position_id, work_time, login, hasło, imię, nazwisko, pesel, dateOfBirth, nationality, telefon, adres*/
DROP PROCEDURE IF EXISTS insert_worker;
DELIMITER $$
CREATE PROCEDURE insert_worker(IN s INT, IN bID INT, IN pID INT, IN wT ENUM ('full','half','quater'), IN l VARCHAR(30), IN p VARCHAR(30), IN na VARCHAR(30), IN su VARCHAR(30), IN pe VARCHAR(30), IN da DATE, IN nat VARCHAR(30), IN phone VARCHAR(30), IN addr VARCHAR(30)  )
	BEGIN
    DECLARE workerID INT;
    INSERT INTO workers ( salary, branch_id, position_id, work_time) VALUES (s, bID, pID, wt);
    SET workerID = last_insert_id();
    INSERT INTO workers_login_data VALUES (workerID, l, md5(p) );
    INSERT INTO workers_data VALUES ( workerID, na, su, pe, da, nat, phone, addr);
	END $$
DELIMITER ;

CREATE VIEW view_workers as (SELECT * FROM workers INNER JOIN workers_data ON workers.id = workers_data.worker_id); 

/* wkładamy dane */
call insert_worker( 1500, 1, 1, 'full', 'login', 'haslo', 'Jan', 'Kowalski', '11111111111','1999-01-01','Polska', '999111333', 'Wroclaw');