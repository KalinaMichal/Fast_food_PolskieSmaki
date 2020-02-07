/****************/
/*TWORZYMY USEROW*/
/*******************/

/*worker*/
CREATE USER 'worker'@'localhost' IDENTIFIED BY 'worker';
GRANT SELECT ON projectDB.* TO 'worker'@'localhost';

/*director*/
CREATE USER 'director'@'localhost' IDENTIFIED BY 'director';
GRANT SELECT ON projectDB.* TO 'director'@'localhost';
GRANT SELECT,UPDATE,INSERT ON projectDB.workers_login_data TO 'director'@'localhost';
GRANT SELECT,UPDATE,INSERT ON projectDB.workers_data TO 'director'@'localhost';
GRANT SELECT,UPDATE,INSERT ON projectDB.workers TO 'director'@'localhost';
GRANT SELECT,UPDATE,INSERT,DELETE ON projectDB.workers_login_data TO 'director'@'localhost';
GRANT SELECT,UPDATE,INSERT,DELETE ON projectDB.workers_data TO 'director'@'localhost';
GRANT SELECT,UPDATE,INSERT,DELETE ON projectDB.workers TO 'director'@'localhost';
GRANT EXECUTE ON PROCEDURE delete_worker TO 'director'@'localhost';
GRANT EXECUTE ON PROCEDURE update_worker TO 'director'@'localhost';
GRANT EXECUTE ON PROCEDURE riseSalary TO 'director'@'localhost';
GRANT EXECUTE ON PROCEDURE insert_worker TO 'director'@'localhost';

/*owner*/
CREATE USER 'owner'@'localhost' IDENTIFIED BY 'owner';
GRANT ALL PRIVILEGES ON projectDB.* TO 'owner'@'localhost';

