package com.person.crud.controller;


import com.person.crud.dto.request.PersonRequest;
import com.person.crud.dto.response.ApiResponse;
import com.person.crud.dto.response.PersonResponse;
import com.person.crud.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ApiResponse list() {

        List<PersonResponse> data = personService.getAll();

        return new ApiResponse(true, "Listado de personas", data);
    }

    @PostMapping
    public ApiResponse create(@RequestBody PersonRequest request) {

        PersonResponse data = personService.create(request);

        return new ApiResponse(true, "Persona creada correctamente", data);
    }

    @PutMapping("/{id}")
    public ApiResponse update(@PathVariable Long id,
                              @RequestBody PersonRequest request) {

        PersonResponse data = personService.update(id, request);

        return new ApiResponse(true, "Persona actualizada", data);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Long id) {

        personService.delete(id);

        return new ApiResponse(true, "Persona eliminada", null);
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Long id) {

        PersonResponse data = personService.getById(id);

        return new ApiResponse(true, "Persona encontrada", data);
    }

}