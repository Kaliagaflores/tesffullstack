package com.person.crud.service.impl;


import com.person.crud.dto.request.PersonRequest;
import com.person.crud.dto.response.PersonResponse;
import com.person.crud.model.Person;
import com.person.crud.repository.PersonRepository;
import com.person.crud.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<PersonResponse> getAll() {

        return personRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PersonResponse create(PersonRequest request) {

        Person person = mapToEntity(request);

        personRepository.save(person);

        return mapToResponse(person);
    }

    @Override
    public PersonResponse update(Long id, PersonRequest request) {

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        person.setNombre(request.getNombre());
        person.setApellido(request.getApellido());
        person.setFechaNacimiento(request.getFechaNacimiento());
        person.setPuesto(request.getPuesto());
        person.setSueldo(request.getSueldo());

        personRepository.save(person);

        return mapToResponse(person);
    }

    @Override
    public void delete(Long id) {

        personRepository.deleteById(id);

    }

    private PersonResponse mapToResponse(Person person) {

        PersonResponse response = new PersonResponse();

        response.setId(person.getId());
        response.setNombre(person.getNombre());
        response.setApellido(person.getApellido());
        response.setFechaNacimiento(person.getFechaNacimiento());
        response.setPuesto(person.getPuesto());
        response.setSueldo(person.getSueldo());

        return response;
    }

    private Person mapToEntity(PersonRequest request) {

        Person person = new Person();

        person.setNombre(request.getNombre());
        person.setApellido(request.getApellido());
        person.setFechaNacimiento(request.getFechaNacimiento());
        person.setPuesto(request.getPuesto());
        person.setSueldo(request.getSueldo());

        return person;
    }

    @Override
    public PersonResponse getById(Long id) {

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));

        return mapToResponse(person);
    }

}