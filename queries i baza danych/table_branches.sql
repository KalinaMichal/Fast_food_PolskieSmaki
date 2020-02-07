/*tworzymy tabelkę branches*/
CREATE TABLE branches (
id INT AUTO_INCREMENT PRIMARY KEY,
specialisation VARCHAR(30) NOT NULL,
location VARCHAR(30) NOT NULL );

/* Wkładamy podstawowe dane */
INSERT INTO branches (specialisation,location) VALUES 
( 'Frytki Smaczne', 'Szczawnica' ),
('Burger Zbujnicki','Tatry'),
('Pizza Bieszczadczka','Bieszczady');