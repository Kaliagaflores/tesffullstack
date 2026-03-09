package com.person.crud.dto.request;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PersonRequest {

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String puesto;
    private Double sueldo;

}