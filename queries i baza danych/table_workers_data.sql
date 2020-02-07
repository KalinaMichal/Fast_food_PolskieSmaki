/*tworzymy tablekę workers_data*/
CREATE TABLE workers_data (
worker_id INT PRIMARY KEY,
name VARCHAR(30) NOT NULL,
surname VARCHAR(30),
pesel VARCHAR(30),
date_of_birth DATE,
nationality VARCHAR(30) NOT NULL,
phone VARCHAR(30),
address VARCHAR(30) );

/* Indexy */
ALTER TABLE workers_data ADD INDEX index_pesel USING BTREE (pesel);

/* klucze obce */
ALTER TABLE workers_data ADD FOREIGN KEY (worker_id) REFERENCES workers(id) ;