/*tworzymy tabelkê positions*/
CREATE TABLE positions (
id INT AUTO_INCREMENT PRIMARY KEY,
min_salary INT NOT NULL,
max_salary INT NOT NULL,
position_name VARCHAR(30) NOT NULL );


/***************/
/*TWORZE WIDOKI*/
/***************/
CREATE VIEW view_workers AS 
(SELECT * FROM workers 
 INNER JOIN workers_data ON workers.id = workers_data.worker_id);

/***************/
/*WSTAWIAM POZYCJE*/
/***************/


INSERT INTO positions (min_salary, max_salary, position_name)
VALUES (1900, 2100, "grill"); 
INSERT INTO positions (min_salary, max_salary, position_name)
VALUES (1900, 2100, "frytownica");
INSERT INTO positions (min_salary, max_salary, position_name)
VALUES (2000, 2200, "prezenter");
INSERT INTO positions (min_salary, max_salary, position_name)
VALUES (2000, 2200, "barista");

/*WSTAWIAM ROBOTNIKOW*/
INSERT INTO workers (salary, branch_id, position_id, work_time )
VALUES (2000,2, 1, "full")

INSERT INTO workers_data (worker_id, name, surname, date_of_birth, nationality, phone,address )
VALUES (5,"Andzej", "Vojusevic", 1999-07-12, )

/*Wstawiam kierownikow*/
INSERT INTO directors (
    name,
	surname,
    date_of_birth,
	nationality,
	phone,
	address,
	salary, 
	branch_id)
VALUES
(
	"Ida",
	"Vojusevic",
    "23-09-1999",
    "Czarnogora",
	"089342045",
    "Podgorica, Kotorska 5",
    "2000",
    2
)


CALL insert_director('Tamara', "Kalinovic", "99092307123",12-12-1999,"Serbia","009976235","Nis, Wolnosci 12",2000,1,123,123);
CALL insert_worker(2000, 3, 3, "full", "Luka", "Kalinic", "20001187632",'2000-01-01',"Chorwacja","999765123","Zagrzeb, Belgradzka 49","luka123","123");



