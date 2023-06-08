////////////////////////////////////////////////////////////////////////////////
//
// Create by pbecker on 08.06.23.
//
// Copyright (c) 2023 Peter Becker. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package org.pbecker.example.newfeature.dockercompose.controller;

import org.pbecker.example.newfeature.dockercompose.domain.Person;
import org.pbecker.example.newfeature.dockercompose.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/api/persons")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @GetMapping("/api/persons/{name}")
    public Person findByName(@PathVariable("name") String name) {
        return personRepository.findByName(name);
    }
}
