package com.moderansolutions.person.controller;

import com.moderansolutions.person.entity.Person;
import com.moderansolutions.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/persons")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        try {
            return new ResponseEntity<>(personRepository.save(person), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllCustomers(@RequestParam(required = false) String search) {
        try {
            List<Person> list = new ArrayList<Person>();
            if (search == null)
                personRepository.findAll().forEach(list::add);
            else
                personRepository.findByNameContainingIgnoreCase(search).forEach(list::add);
            if (list.isEmpty()) {
                return new ResponseEntity<List<Person>>(list, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updateCustomer(@RequestBody Person person) {
        try {
            return new ResponseEntity<Person>(personRepository.save(person), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
        try {
            Optional<Person> customer = personRepository.findById(id);
            if (customer.isPresent()) {
                personRepository.delete(customer.get());
            }
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
