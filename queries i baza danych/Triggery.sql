/***********/
/*TRIGGERY*/
/**********/

/*INSERT*/
DELIMITER $$
CREATE  TRIGGER pesel_age_check AFTER INSERT ON workers_data FOR EACH ROW 
BEGIN
IF (!(CHAR_LENGTH(NEW.pesel) = 11) AND NEW.pesel IS NOT NULL) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Zly pesel";
END IF;
IF ((NEW.date_of_birth + INTERVAL 18 YEAR) > NOW()) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Nieletni";
END IF;
 END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER pesel_age_check AFTER INSERT ON directors FOR EACH ROW 
BEGIN
IF (!(CHAR_LENGTH(NEW.pesel) = 11) AND NEW.pesel IS NOT NULL) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Zly pesel";
END IF;
IF ((NEW.date_of_birth + INTERVAL 18 YEAR) > NOW()) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Nieletni";
END IF;
 END$$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER salarycheck AFTER INSERT ON workers FOR EACH ROW 
BEGIN
IF (NEW.salary>(SELECT max_salary FROM positions WHERE NEW.position_id LIKE positions.id)) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Za wysoka placa";
END IF;
IF (NEW.salary<(SELECT min_salary FROM positions WHERE NEW.position_id LIKE positions.id)) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Za niska placa";
END IF;
 END$$
DELIMITER ;



/*UPDATE*/


DELIMITER $$
CREATE TRIGGER pesel_age_check_UP BEFORE UPDATE ON workers_data  FOR EACH ROW 
BEGIN
IF (!(CHAR_LENGTH(NEW.pesel) = 11) AND NEW.pesel IS NOT NULL) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Zly pesel";
END IF;
IF ((NEW.date_of_birth + INTERVAL 18 YEAR) > NOW()) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Nieletni";
END IF;
END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER pesel_age_check_UP BEFORE UPDATE ON directors FOR EACH ROW 
BEGIN
IF (!(CHAR_LENGTH(NEW.pesel) = 11) AND NEW.pesel IS NOT NULL) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Zly pesel";
END IF;
IF ((NEW.date_of_birth + INTERVAL 18 YEAR) > NOW()) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Nieletni";
END IF;
END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER salarycheck_UP AFTER UPDATE ON workers FOR EACH ROW 
BEGIN
IF (NEW.salary>(SELECT max_salary FROM positions WHERE NEW.position_id LIKE positions.id)) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Za wysoka placa";
END IF;
IF (NEW.salary<(SELECT min_salary FROM positions WHERE NEW.position_id LIKE positions.id)) THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Za niska placa";
END IF;
END$$
DELIMITER ;


/*DELETE*/



DELIMITER $$
CREATE TRIGGER delete_worker AFTER DELETE ON workers FOR EACH ROW 
BEGIN
DELETE FROM workers_data WHERE OLD.id=workers_data.worker_id;
DELETE FROM workers_login_data WHERE OLD.id=workers_login_data.worker_id;
 END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER delete_director AFTER DELETE ON directors FOR EACH ROW 
BEGIN
DELETE FROM directors_login_data WHERE OLD.id=directors_login_data.director_id;
 END$$
DELIMITER ;







