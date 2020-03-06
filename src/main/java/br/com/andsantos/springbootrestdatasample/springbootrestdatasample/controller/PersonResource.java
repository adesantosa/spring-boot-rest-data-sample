package br.com.andsantos.springbootrestdatasample.springbootrestdatasample.controller;

import br.com.andsantos.springbootrestdatasample.springbootrestdatasample.exceptions.PersonNotFoundException;
import br.com.andsantos.springbootrestdatasample.springbootrestdatasample.person.Person;
import br.com.andsantos.springbootrestdatasample.springbootrestdatasample.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonResource {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public List<Person> retrieveAllPerson() {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public Person retrievePersonById(@PathVariable Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException("id-" + id));
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

    @PostMapping("/person")
    public ResponseEntity<Object> createPerson(@RequestBody Person person) {
        Person savedPerson = personRepository.save(person);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPerson.getId()).toUri();

        return ResponseEntity.created(location).body(person);

    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Object> updatePerson(@RequestBody Person person, @PathVariable Long id) {
        Optional<Person> studentOptional = personRepository.findById(id);
        person.setId(id);
        personRepository.save(person);
        return ResponseEntity.noContent().build();
    }



}
