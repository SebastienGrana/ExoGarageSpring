package fr.formation.afpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "box")
public class Box {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id", nullable = false, length = 25)
	private Long id;
	
	@Column(name = "numPosition", nullable = false, length = 25)
	private Integer numPosition;
	
	@Column(name = "area", nullable = false, length = 25)
	private Float area;


	@ManyToOne
	@JoinColumn(name = "id_garage")
	private Garage garage;

	public Box(Long id, Integer numPosition, Float area) {
		super();
		this.id = id;
		this.numPosition = numPosition;
		this.area = area;
	}

	public Box() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumPosition() {
		return numPosition;
	}

	public void setNumPosition(Integer numPosition) {
		this.numPosition = numPosition;
	}

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		this.garage = garage;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + " Emplacement n°" + getNumPosition() ;
	}

}
