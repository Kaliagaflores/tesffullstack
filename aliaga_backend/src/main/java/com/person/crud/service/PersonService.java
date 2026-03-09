package com.person.crud.service;

import com.person.crud.dto.request.PersonRequest;
import com.person.crud.dto.response.PersonResponse;

import java.util.List;

public interface PersonService {

    List<PersonResponse> getAll();

    PersonResponse create(PersonRequest request);

    PersonResponse update(Long id, PersonRequest request);

    void delete(Long id);

}