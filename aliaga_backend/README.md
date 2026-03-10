# Backend CRUD Personas

Proyecto desarrollado con Spring Boot.

## Requisitos

Java 17  
MySQL

## Base de datos

Crear base:

bd_aliaga

## Ejecutar

mvn spring-boot:run

## Endpoints



| Método | URL                                  | Descripción        |
| ------ | ------------------------------------ | ------------------ |
| GET    | `http://localhost:8080/api/person`   | listar personas    |
| GET    | `http://localhost:8080/api/person/1` | obtener persona    |
| POST   | `http://localhost:8080/api/person`   | crear persona      |
| PUT    | `http://localhost:8080/api/person/1` | actualizar persona |
| DELETE | `http://localhost:8080/api/person/1` | eliminar persona   |


## URL

http://localhost:8080