package br.com.andsantos.springbootrestdatasample.springbootrestdatasample.people;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class PeopleEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id;
    private String cpf;
    private String name;
    private String motherName;
}
