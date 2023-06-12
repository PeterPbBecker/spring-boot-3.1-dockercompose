////////////////////////////////////////////////////////////////////////////////
//
// Create by pbecker on 31.05.23.
//
// Copyright (c) 2023 Peter Becker. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package org.pbecker.example.newfeature.dockercompose.repository;

import org.pbecker.example.newfeature.dockercompose.domain.Person;
import org.springframework.data.repository.ListCrudRepository;

public interface PersonRepository extends ListCrudRepository<Person, Long> {
}
