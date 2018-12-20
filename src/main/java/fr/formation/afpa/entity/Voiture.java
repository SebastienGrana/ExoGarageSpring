package fr.formation.afpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "voiture")
public class Voiture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id", nullable = false, length = 25)
	private Long id;
	
	@Column(name = "model", nullable = false, length = 125)
	private String model;
	
	@Column(name = "brand", nullable = false, length = 125)
	private String brand;
	
	@Column(name = "year", nullable = false, length = 10)
	private Date year;

	@ManyToOne
	@JoinColumn(name = "id_person")
	private Person person;

	public Voiture(Long id, String model, String brand, Date year) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.year = year;
	}

	public Voiture() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return  getBrand() + " " + getModel();
	}

}
