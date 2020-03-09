package br.com.andsantos.springbootrestdatasample.springbootrestdatasample.controller;

import br.com.andsantos.springbootrestdatasample.springbootrestdatasample.exceptions.PeopleNotFoundException;
import br.com.andsantos.springbootrestdatasample.springbootrestdatasample.people.PeopleEntity;
import br.com.andsantos.springbootrestdatasample.springbootrestdatasample.people.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleResource {

    private final PeopleRepository peopleRepository;

    @GetMapping
    public Iterable<PeopleEntity> retrieveAllPerson() {
        return peopleRepository.findAll();
    }

    @GetMapping("/{id}")
    public PeopleEntity retrievePersonById(@PathVariable final Long id) {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new PeopleNotFoundException("id-" + id));
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable final Long id) {
        peopleRepository.deleteById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PeopleEntity createPeople(@RequestBody final PeopleEntity peopleEntity) {
        return peopleRepository.save(peopleEntity);
    }

    @PutMapping("/{id}")
    public PeopleEntity updatePerson (@PathVariable final Long id, @RequestBody final PeopleEntity peopleEntity) {
        return peopleRepository.findById(id)
                .map(it -> {
                    // Update your attributes here
                    return peopleEntity;
                })
                .map(peopleRepository::save)
                .get()
                ;
    }

}
