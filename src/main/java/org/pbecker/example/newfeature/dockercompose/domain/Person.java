////////////////////////////////////////////////////////////////////////////////
//
// Create by pbecker on 31.05.23.
//
// Copyright (c) 2023 Peter Becker. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package org.pbecker.example.newfeature.dockercompose.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String firstname;
    private String name;
    private int age;

    public Person() {}

    public Person(Integer id, String firstname, String name, int age) {
        this.id = id;
        this.firstname = firstname;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
