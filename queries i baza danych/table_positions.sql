/*tworzymy tabelkę positions*/
CREATE TABLE positions (
id INT AUTO_INCREMENT PRIMARY KEY,
min_salary INT NOT NULL,
max_salary INT NOT NULL,
position_name VARCHAR(30) NOT NULL );
/*Trigery*/
/*TODO - pensja min musi byc mniejsza od max */

/* Wrzucamy dane do positions */

