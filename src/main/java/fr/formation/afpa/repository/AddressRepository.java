package fr.formation.afpa.repository;

import org.springframework.data.repository.CrudRepository;

import fr.formation.afpa.entity.Address;

public interface AddressRepository   extends CrudRepository<Address, Long>{

}
