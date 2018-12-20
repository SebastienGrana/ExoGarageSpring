package fr.formation.afpa.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "garage")
public class Garage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id", nullable = false, length = 25)
	private Long id;

	@Column(name = "name", nullable = false, length = 125)
	private String name;

	@OneToOne(cascade = { CascadeType.REMOVE })
	@JoinColumn(name = "id_address")
	private Address address;

	@OneToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "id_person")
	private Person owner;

	@OneToMany(fetch = FetchType.LAZY, 
			targetEntity = fr.formation.afpa.entity.Box.class, 
			cascade = {CascadeType.REFRESH, CascadeType.REMOVE }, 
			mappedBy = "garage")
	private Set<Box> boxs;
	
	@Transient		//Hibernet Ignore this list when loading the object
	private List<Location> locations;

	public Garage(Long id, String name, Address address, Person owner, Set<Box> boxs) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.owner = owner;
		this.boxs = boxs;
	}

	public Garage() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public Set<Box> getBoxs() {
		return boxs;
	}

	public void setBoxs(Set<Box> boxs) {
		this.boxs = boxs;
	}

	public void loadLocation(List<Location> locations) {

		this.locations = locations;
	}

	@Override
	public String toString() {
		String textToPrint = "\n Garage : " + name;
		for (Box box : boxs) {
			Location goodLocaiton = getGoodLocation(box);
			if (goodLocaiton != null) {
				Vehicule vehicule = goodLocaiton.getVehicule();
				Person person = vehicule.getPerson();
				
				textToPrint = textToPrint + 
						"\n\t Box : " + box.toString() + 
						"\n\t\t Vehicule : " + vehicule.toString() + 
						"\n\t\t Personne : " + person.toString();
			}else {
				try {
					throw new Exception("ERROR, Locations Empty");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return textToPrint;
		
	}

	private Location getGoodLocation(Box box) {
		Location goodLocaiton = null;
		if (locations != null) {
			for (Location location : locations) {
				Box boxFromLocation = location.getBox();
				if (box.getId().equals(boxFromLocation.getId())) {
					goodLocaiton = location;
				}
			}
		}
		return goodLocaiton;
	}

}
