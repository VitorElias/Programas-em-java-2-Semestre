CREATE DATABASE lojainformatica;


USE lojainformatica;


CREATE TABLE Computador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    processador VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    hd VARCHAR(10) NOT NULL
);


INSERT INTO Computador (processador, marca, hd) VALUES
('Intel Core i5', 'Vitor Elias', '500'),
('AMD Ryzen 7', 'Vitor Elias', '512'),
('Intel Core i7', 'Vitor Elias', '256'),
('AMD Athlon', 'Vitor Elias', '2'),
('Intel Core i9', 'Vitor Elias', '1000');


SELECT * FROM Computador;
