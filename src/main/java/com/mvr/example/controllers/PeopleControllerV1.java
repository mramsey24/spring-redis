package com.mvr.example.controllers;

import java.util.Optional;

import com.mvr.example.models.Person;
import com.mvr.example.repositories.PeopleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleControllerV1 {
    @Autowired
    PeopleRepository repo;

    @GetMapping("all")
    Iterable<Person> all() {
        return repo.findAll();
    }

    @GetMapping("{id}")
    Optional<Person> byId(@PathVariable String id) {
        return repo.findById(id);
    }

}
