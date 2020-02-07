/*tworzymy tabelkę workers_login_data*/
CREATE TABLE workers_login_data (
worker_id INT PRIMARY KEY,
login VARCHAR(30) NOT NULL,
password VARCHAR(120) NOT NULL );

ALTER TABLE workers_login_data ADD FOREIGN KEY (worker_id) REFERENCES workers( id );