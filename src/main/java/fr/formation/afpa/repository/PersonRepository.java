package fr.formation.afpa.repository;

import org.springframework.data.repository.CrudRepository;

import fr.formation.afpa.entity.Person;

public interface PersonRepository  extends CrudRepository<Person, Long>{

}
