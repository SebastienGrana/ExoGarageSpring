package fr.formation.afpa.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id", nullable = false, length = 25)
	private Long id;

	@OneToOne(cascade = { CascadeType.REFRESH})
	@JoinColumn(name = "id_box")
	private Box box;

	@OneToOne(cascade = { CascadeType.REFRESH})
	@JoinColumn(name = "id_vehicule")
	private Vehicule vehicule;
	
	@Column(name = "tarif", nullable = false, length = 25)
	private Float tarif;
	
	@Column(name = "dateStart", nullable = false, length = 25)
	private Date dateStart;
	
	@Column(name = "dateFin", nullable = false, length = 25)
	private Date dateFin;

	public Location(Long id, Box box, Vehicule vehicule, Float tarif, Date dateStart, Date dateFin) {
		super();
		this.id = id;
		this.box = box;
		this.vehicule = vehicule;
		this.tarif = tarif;
		this.dateStart = dateStart;
		this.dateFin = dateFin;
	}

	public Location() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Float getTarif() {
		return tarif;
	}

	public void setTarif(Float tarif) {
		this.tarif = tarif;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}
