package com.codeclan.examples.folders.controllers;

import com.codeclan.examples.folders.models.Folder;
import com.codeclan.examples.folders.models.Person;
import com.codeclan.examples.folders.repositories.FolderRepository;
import com.codeclan.examples.folders.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {



    @Autowired
    PersonRepository personRepo;

    @GetMapping(value="/persons")
    public ResponseEntity<List<Person>> getAllPersons(){
        return new ResponseEntity<>(personRepo.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/persons/{id}")
    public ResponseEntity getPersons(@PathVariable Long id){
        return new ResponseEntity(personRepo.findById(id),HttpStatus.OK);
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> postPersons(@RequestBody Person person){
        personRepo.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
