package fr.formation.afpa.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id", nullable = false, length = 25)
	private Long id;
	
	@Column(name = "firstName", nullable = false, length = 25)
	private String firstName;
	
	@Column(name = "lastName", nullable = false, length = 25)
	private String lastName;

	@OneToMany(
			fetch = FetchType.LAZY, 
			targetEntity = fr.formation.afpa.entity.Voiture.class, 
			cascade = {			
					CascadeType.REFRESH, 
					CascadeType.REMOVE }, 
			mappedBy = "person")
	private Set<Vehicule> vehicules;

	public Person(Long id, String firstName, String lastName, Set<Vehicule> vehicules) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.vehicules = vehicules;
	}

	public Person() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(Set<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	@Override
	public String toString() {
		return getFirstName() + " "+ getLastName();
	}

}
