package rental;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.Before;
import org.junit.Test;

public class RentalAgencyTest {

	private RentalAgency agency;
    private Vehicle v;
    private Vehicle notExist;
	private Client client1;
	private Client client2;

	/* méthode exécutée avant l'exécution de chacune des méthodes de test */
	@Before
	public void before() {
	   // réinitialisation des attributs v1 et v2 pour chacun des tests
	   this.agency = new RentalAgency();
	   this.v = new Vehicle("Vroum", "Vroum", 2000, 100);
	   this.notExist = new Vehicle("Boom", "Brom", 2000, 200);
	   this.client1 = new Client("Tim Oleon", 25);
	   this.client2 = new Client("Tim Oleon", 25);
	}

	@Test
	public void twoClientObjectsWithSameNameCorrespondsToSameClient() 
					throws IllegalStateException, UnknownVehicleException {
		 
		agency.addVehicle(v);
		// Verifie si le prix du vehicule loué par le client == 100.0
		assertEquals(100.0, agency.rentVehicle(client1, v),0.0001);
		// verifie si le client1 a bien louer v
		assertTrue(agency.hasRentedAVehicle(client1));
		// client2 corresponds to same client than client1 since names are equals
		// then test should succeed
		assertTrue(agency.hasRentedAVehicle(client2));
	}
	// client retourner le véhicule loué
	@Test
	public void clientReturnTheRentedVehicle()
					throws IllegalStateException, UnknownVehicleException{
		// Ajout du vehicule a la list
		agency.addVehicle(v);
		// Vehicule pas encore loué
		assertFalse(agency.isRented(v));
		// List contient v
		assertTrue(agency.getAllVehicles().contains(v));
		// La Map Ne contient pas le vehicule v
		assertFalse(agency.allRentedVehicles().contains(v));
		// Verifie si le prix du vehicule loué par le client == 100.0
		assertEquals(100.0, agency.rentVehicle(client1, v),0.0001);
		// verifie si le client1 a bien louer v
		assertTrue(agency.hasRentedAVehicle(client1));
		// Vehicule v loué
		assertTrue(agency.isRented(v));
		// Le client rend maintenant le vehicule v
		agency.returnVehicle(client1);
		// verifie que client1 loue plus v
		assertFalse(agency.hasRentedAVehicle(client1));
		// Vehicule v n'est plus loué par client1
		assertFalse(agency.isRented(v));

	}

	@Test 
	public void removeVehicleOk()
						throws IllegalStateException, UnknownVehicleException{
		// Ajout du vehicule a la list
		agency.addVehicle(v);
		// Verifie si le prix du vehicule loué par le client == 100.0
		assertEquals(100.0, agency.rentVehicle(client1, v),0.0001);
		agency.removeVehicle(v);
		// List contient v
		assertFalse(agency.getAllVehicles().contains(v));
		// verifie que client1 loue plus v apres suppression de celui ci dans la liste
		//assertNull(agency.hasRentedAVehicle(client1));
		// Vehicule v n'est plus loué par client1 apres suppression du veicule dans la liste
		//assertFalse(agency.isRented(v));
	}

	// Vehicule inconnu
	@Test(expected=UnknownVehicleException.class)
	public void unknownVehicleExceptionOk() throws Exception {
		agency.addVehicle(notExist);
		assertEquals(100.0, agency.rentVehicle(client1, v),0.0001);
	}

	// Voiture deja louer
	@Test(expected=IllegalStateException.class)
	public void carIsrenting() throws Exception {
		agency.addVehicle(v);
		assertEquals(100.0, agency.rentVehicle(client1, v),0.0001);
		assertEquals(100.0, agency.rentVehicle(client2, v),0.0001);

	}

	// Le client loue deja une voiture
	@Test(expected=IllegalStateException.class) 
	public void clientRentingCar() throws Exception {
		agency.addVehicle(v);
		agency.addVehicle(notExist);
		assertEquals(100.0, agency.rentVehicle(client1, v),0.0001);
		assertEquals(200.0, agency.rentVehicle(client1, notExist),0.0001);

	}

	// vehicules pas loué
	@Test
	public void isRentedTest() {
		agency.addVehicle(v);
		agency.addVehicle(notExist);
		assertFalse(this.agency.isRented(v)) ;
		assertFalse(this.agency.isRented(notExist)) ;
	}


	// Le client n'a pas loué un véhicule
	@Test
	public void hasRentedAVehicleTest() {
		agency.addVehicle(v);
		agency.addVehicle(notExist);
		assertFalse(agency.hasRentedAVehicle(client1)) ;
		assertFalse(agency.hasRentedAVehicle(client2)) ;
	}

	// ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(rental.RentalAgencyTest.class);
	}

}
