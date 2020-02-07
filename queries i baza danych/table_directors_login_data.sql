/*tworzymy tabelkę directors_login_data*/
CREATE TABLE directors_login_data (
director_id INT PRIMARY KEY,
login VARCHAR(30) NOT NULL,
password VARCHAR(120) NOT NULL );
/* Klucze obce */
ALTER TABLE directors_login_data ADD FOREIGN KEY (director_id) REFERENCES directors( id );