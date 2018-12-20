package fr.formation.afpa;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.afpa.entity.Address;
import fr.formation.afpa.entity.Box;
import fr.formation.afpa.entity.Garage;
import fr.formation.afpa.entity.Location;
import fr.formation.afpa.entity.Person;
import fr.formation.afpa.entity.Vehicule;
import fr.formation.afpa.repository.AddressRepository;
import fr.formation.afpa.repository.BoxRepository;
import fr.formation.afpa.repository.GarageRepository;
import fr.formation.afpa.repository.LocationRepository;
import fr.formation.afpa.repository.PersonRepository;
import fr.formation.afpa.repository.VehiculeRepository;
import fr.formation.afpa.repository.VoitureRepository;

@SpringBootApplication
public class Exo04GarageSpringApplication  implements CommandLineRunner {

	Log log = LogFactory.getLog(Exo04GarageSpringApplication.class);

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	BoxRepository boxRepository;
	
	@Autowired
	GarageRepository garageRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	VehiculeRepository vehiculeRepository;
	
	@Autowired
	VoitureRepository voitureRepository;

	public static void main(String[] args) {
		SpringApplication.run(Exo04GarageSpringApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {

		initBDD();
		
		toStringAllGarage();

		//locationRepository.delete(locationRepository.findById(5l).get());
		//garageRepository.delete(garageRepository.findById(1l).get());
		
	}

	@SuppressWarnings("unused")
	private void initBDD() {
		Address address1 = new Address(null, 34090, "Montpellier");
		Address address2 = new Address(null, 34560, "Poussan");
		Address address3 = new Address(null, 15670, "Estouches");
		Address address4 = new Address(null, 19004, "Le Coudert");

		addressRepository.save(address1);
		addressRepository.save(address2);
		addressRepository.save(address3);
		addressRepository.save(address4);
		
		
		Vehicule veh1 = new Vehicule(null, "5001", "Citroen", new Date(), "546CD34");
		Vehicule veh2 = new Vehicule(null, "306", "Citroen", new Date(), "564HGF34");
		Vehicule veh3 = new Vehicule(null, "512", "Peugot", new Date(), "156JGH65");
		
		Vehicule veh4 = new Vehicule(null, "Picasso", "Citroen", new Date(), "617SB62");
		
		Vehicule veh5 = new Vehicule(null, "Multipla", "Fiat", new Date(), "195HQQ34");

		vehiculeRepository.save(veh1);
		vehiculeRepository.save(veh2);
		vehiculeRepository.save(veh3);
		vehiculeRepository.save(veh4);
		vehiculeRepository.save(veh5);
		
		Set<Vehicule> vehJean = new HashSet<>();
		vehJean.add(veh1);
		vehJean.add(veh2);
		vehJean.add(veh3);
		
		Set<Vehicule> vehPierre = new HashSet<>();
		vehJean.add(veh4);
		
		Set<Vehicule> vehPaul = new HashSet<>();
		vehJean.add(veh5);
		

		Person personJean = new Person(null, "Jean", "Gean", vehJean);
		Person personPierre = new Person(null, "Pierre", "Durand", vehPierre);
		Person personPaul = new Person(null, "Paul", "Jacques", vehPaul);

		personRepository.save(personJean);
		personRepository.save(personPierre);
		personRepository.save(personPaul);
		
		veh1.setPerson(personJean);
		veh2.setPerson(personJean);
		veh3.setPerson(personJean);
		
		veh4.setPerson(personPierre);
		
		veh5.setPerson(personPaul);

		vehiculeRepository.save(veh1);
		vehiculeRepository.save(veh2);
		vehiculeRepository.save(veh3);
		vehiculeRepository.save(veh4);
		vehiculeRepository.save(veh5);

		Box box1 = new Box(null, 1, 10.0f);
		Box box2 = new Box(null, 2, 10.0f);
		
		Box box3 = new Box(null, 1, 5.0f);

		Box box4 = new Box(null, 1, 25.0f);
		
		Box box5 = new Box(null, 1, 11.0f);
		
		boxRepository.save(box1);
		boxRepository.save(box2);
		boxRepository.save(box3);
		boxRepository.save(box4);
		boxRepository.save(box5);

		Set<Box> boxJeanG1 = new HashSet<>();
		boxJeanG1.add(box1);
		boxJeanG1.add(box2);

		Set<Box> boxJeanG2 = new HashSet<>();
		boxJeanG2.add(box3);

		Set<Box> boxPierreG3 = new HashSet<>();
		boxPierreG3.add(box4);

		Set<Box> boxPaulG4 = new HashSet<>();
		boxPaulG4.add(box5);

		Garage garage1 = new Garage(null, "Garage de la fronde", address1, personPaul, boxJeanG1);
		Garage garage2 = new Garage(null, "G12", address2, personPaul, boxJeanG2);
		
		Garage garage3 = new Garage(null, "Al'Ecrou", address3, personPierre, boxPierreG3);
		
		Garage garage4 = new Garage(null, "GarTaKar", address4, personPaul, boxPaulG4);

		garageRepository.save(garage1);
		garageRepository.save(garage2);
		garageRepository.save(garage3);
		garageRepository.save(garage4);

		box1.setGarage(garage1);
		box2.setGarage(garage1);
		
		box3.setGarage(garage2);
		
		box4.setGarage(garage3);
		
		box5.setGarage(garage4);
		
		boxRepository.save(box1);
		boxRepository.save(box2);
		boxRepository.save(box3);
		boxRepository.save(box4);
		boxRepository.save(box5);

		Location locationBox1Veh1 = new Location(null, box1, veh1, 100.0f, new Date(), new Date());
		Location locationBox2Veh2 = new Location(null, box2, veh2, 25.0f, new Date(), new Date());
		Location locationBox3Veh3 = new Location(null, box3, veh3, 78.0f, new Date(), new Date());
		Location locationBox4Veh4 = new Location(null, box4, veh4, 67.0f, new Date(), new Date());
		Location locationBox5Veh5 = new Location(null, box5, veh5, 22.0f, new Date(), new Date());

		locationRepository.save(locationBox1Veh1);
		locationRepository.save(locationBox2Veh2);
		locationRepository.save(locationBox3Veh3);
		locationRepository.save(locationBox4Veh4);
		locationRepository.save(locationBox5Veh5);
	}


	private void toStringAllGarage() {
		List<Garage> listGarage = (List<Garage>) garageRepository.findAll();
		
		for (Garage garage : listGarage) {
			garage.loadLocation((List<Location>) locationRepository.findAll());
			log.info(garage.toString());
		}
	}
}
