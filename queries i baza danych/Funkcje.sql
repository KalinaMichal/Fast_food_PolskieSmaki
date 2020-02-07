/***********/
/*PROCEDURY*/
/***********/


/*UPDATE*/
DROP PROCEDURE IF EXISTS update_director;
DELIMITER $$
CREATE PROCEDURE update_director(  IN idx INT(11), IN namex VARCHAR(30), IN surnamex VARCHAR(30), IN peselx VARCHAR(30), IN date_of_birthx DATE, IN nationalityx VARCHAR(30), IN phonex VARCHAR(30), IN addressx VARCHAR(30), IN salaryx INT(11), IN branchidx INT(11))
	BEGIN
    UPDATE directors 
    SET directors.surname=surnamex, directors.pesel=peselx, directors.date_of_birth=date_of_birthx, directors.nationality=nationalityx, directors.phone=phonex, directors.address=addressx, directors.salary=salaryx, directors.branch_id=branchidx 
    WHERE directors.id=idx;
	END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS update_worker;
DELIMITER $$
CREATE PROCEDURE update_worker(  IN idx INT(11), IN salaryx INT(11),IN branchidx INT(11),IN positionidx INT(11), IN worktimex VARCHAR(30),IN namex VARCHAR(30), IN surnamex VARCHAR(30), IN peselx VARCHAR(30), IN date_of_birthx DATE, IN nationalityx VARCHAR(30), IN phonex VARCHAR(30), IN addressx VARCHAR(30))
	BEGIN
    UPDATE workers_data
    SET workers_data.surname=surnamex, workers_data.name=namex, workers_data.pesel=peselx, workers_data.date_of_birth=date_of_birthx, workers_data.nationality=nationalityx, workers_data.phone=phonex, workers_data.address=addressx 
    WHERE workers_data.worker_id=idx;
        UPDATE workers     
        SET workers.salary=salaryx, workers.branch_id=branchidx, workers.position_id=positionidx          
        WHERE workers.id=idx;
	END $$
DELIMITER ;


/*DELETE*/
call delete_director(10);
DROP PROCEDURE IF EXISTS delete_director;
DELIMITER $$
CREATE PROCEDURE delete_director(  IN idx INT(11))
	BEGIN
    DELETE FROM directors_login_data
    WHERE director_id =idx;
    DELETE FROM directors
    WHERE directors.id=idx;
	END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS delete_worker;
DELIMITER $$
CREATE PROCEDURE delete_worker(  IN idx INT(11))
	BEGIN
    DELETE FROM workers_data
    WHERE worker_id =idx;
    DELETE FROM workers_login_data
    WHERE worker_id =idx;
    DELETE FROM workers
    WHERE id=idx;
	END $$
DELIMITER ;

/*INSERT*/
DROP PROCEDURE IF EXISTS insert_worker;
DELIMITER $$
CREATE PROCEDURE insert_worker 
(IN salaryx INT(11),IN branchidx INT(11),IN positionidx INT(11), IN worktimex VARCHAR(30),IN namex VARCHAR(30), IN surnamex VARCHAR(30), IN peselx VARCHAR(30), IN date_of_birthx DATE, IN nationalityx VARCHAR(30), IN phonex VARCHAR(30), IN addressx VARCHAR(30), IN loginx VARCHAR(30), IN passwordx VARCHAR(30))
BEGIN
    DECLARE workerID INT;
    INSERT INTO workers (salary, branch_id, position_id, work_time)
    VALUES (salaryx, branchidx, positionidx,worktimex);
    
    SET workerID = last_insert_id();
    
    INSERT INTO workers_data VALUES (workerID, namex, surnamex,peselx,date_of_birthx, 	nationalityx,phonex,addressx);
    
    INSERT INTO workers_login_data VALUES (workerID, loginx, md5(passwordx));
 
	END $$
DELIMITER ;

/*Rise Salary*/
DROP PROCEDURE IF EXISTS riseSalary;
DELIMITER $$
CREATE PROCEDURE riseSalary(IN branchid INT(20), IN x FLOAT(11) )
BEGIN
	DECLARE marker int DEFAULT 0;
    DECLARE pMax int;
    DECLARE osobaId int;
    DECLARE salary int;
    DECLARE koniec int default 0;
    DECLARE complete int default 1;
    DECLARE cursor_wyplata CURSOR FOR (SELECT w1.id, w1.salary, p.max_salary
    FROM workers AS w1 INNER JOIN positions AS p ON p.id = w1.position_id
    WHERE w1.branch_id = branchid);
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET koniec = 1;
    SET x=((x/100)+1);
    /*Sprawdzam czy warunki początkowe są okej*/
    SET marker = (SELECT count(*)
					FROM workers AS w1 INNER JOIN positions AS p ON w1.position_id = p.id
                    WHERE w1.salary *x  >= p.max_salary AND branchid=branch_id);
    IF marker = 0
    THEN
		DROP TEMPORARY TABLE IF EXISTS wynik;
		CREATE TEMPORARY TABLE wynik ( osoba int, zarobki int);
        OPEN cursor_wyplata;
        START TRANSACTION;
			salary_loop: LOOP
				FETCH cursor_wyplata INTO osobaId, salary, pMax;
				IF (koniec)
                THEN
					LEAVE salary_loop;
				END IF;
				IF (salary * x < pMax) THEN
					INSERT INTO wynik VALUES(osobaId, salary * x);
				ELSE
					SET complete = FALSE;
					LEAVE salary_loop;
				END IF;
			END LOOP;
    CLOSE cursor_wyplata;
    IF(complete = TRUE)
    THEN
		UPDATE workers INNER JOIN wynik ON workers.id = wynik.osoba
        SET workers.salary = wynik.zarobki;
    END IF;
    /*Zamykam procedure*/
    COMMIT;
    ELSE
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Podwyżka przekracza dopuszczalny prog';
    END IF;
END $$
Delimiter ;

/*Show Shifts*/
DROP PROCEDURE IF EXISTS show_shifts;
DELIMITER $$
CREATE PROCEDURE show_shifts(  IN shiftx VARCHAR(11))
	BEGIN
    SELECT wd.worker_id, wd.name, wd.surname, wd.surname, wd.pesel, wd.date_of_birth, wd.nationality, wd.phone, wd.address, w.salary, w.branch_id, w.position_id FROM workers AS w 
    INNER JOIN workers_data AS wd ON w.id=wd.worker_id
    WHERE w.work_time=shiftx;
    
	END $$
DELIMITER ;

