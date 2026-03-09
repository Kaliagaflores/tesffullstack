CREATE DATABASE bd_aliaga;

USE bd_aliaga;

CREATE TABLE person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    fechaNacimiento DATE,
    puesto VARCHAR(100),
    sueldo DECIMAL(10,2)
);