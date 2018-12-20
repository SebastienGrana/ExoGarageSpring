package fr.formation.afpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vehicule")
public class Vehicule extends Voiture{

	@Column(name = "immat", nullable = false, length = 25)
	private String immat;

	public Vehicule(Long id, String model, String brand, Date year, String immat) {
		super(id, model, brand, year);
		this.immat = immat;
	}

	public Vehicule() {
	}

	public String getImmat() {
		return immat;
	}

	public void setImmat(String immat) {
		this.immat = immat;
	}

	@Override
	public String toString() {
		return super.toString() + " " + getImmat();
	}
	
	

}
