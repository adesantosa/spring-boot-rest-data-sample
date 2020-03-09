package br.com.andsantos.springbootrestdatasample.springbootrestdatasample.people;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends CrudRepository<PeopleEntity, Long> {

}
