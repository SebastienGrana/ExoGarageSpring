package fr.formation.afpa.repository;

import org.springframework.data.repository.CrudRepository;

import fr.formation.afpa.entity.Location;

public interface LocationRepository  extends CrudRepository<Location, Long>{

}
