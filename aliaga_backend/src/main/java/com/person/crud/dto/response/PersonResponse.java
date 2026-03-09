package com.person.crud.dto.response;


import lombok.Data;
import java.time.LocalDate;

@Data
public class PersonResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String puesto;
    private Double sueldo;

}