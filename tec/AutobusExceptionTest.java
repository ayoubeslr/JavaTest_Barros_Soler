package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AutobusExceptionTest {

	Autobus auto;
	Autobus leBusMagique;
	Autobus leBusMagiqueSansPlaces;
	PassagerStandard michel;
	PassagerStandard jaquie; 
	PassagerStandard haziz; 
	@Before
	public void setUp() throws Exception {
		michel = new PassagerStandard("Michel",5);
		jaquie = new PassagerStandard("Jaquie",3);
		haziz = new PassagerStandard("Haziz",6);
		leBusMagique = new Autobus(5,5);
		leBusMagiqueSansPlaces = new Autobus(1,1);
		
	}

	@After
	public void tearDown() throws Exception {
		michel = null;
		jaquie = null;
		haziz = null;
		leBusMagique = null;
		leBusMagiqueSansPlaces = null;
	}

	@Test (expected = IllegalArgumentException.class) 
	public void testAutobusnbPlaceAssiseInf0() {
		auto = new Autobus(-1,0);
	}

	@Test (expected = IllegalArgumentException.class) 
	public void testAutobusnbPlaceDeboutInf0() {
		auto = new Autobus(0,-1);
	}

	//je sais pas quoi tester
	@Test
	public void testAllerArretSuivant() {
		assertNotEquals("je sais pas", "j'ai pas compris");
	}

	
	@Test (expected = IllegalArgumentException.class) 
	public void testDemanderPlaceAssise() throws IllegalArgumentException {
		//on fait monter Michel
		leBusMagique.demanderPlaceAssise(michel);
		//Michel est deja dans le bus donc pas dehors donc exception
		leBusMagique.demanderPlaceAssise(michel);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testDemanderPlaceDebout() throws IllegalArgumentException {
		//on fait monter Michel
		leBusMagique.demanderPlaceAssise(michel);
		//on fait monter Haziz, il est debout car il y a pas de place assise
		leBusMagiqueSansPlaces.demanderPlaceDebout(haziz);
		//Haziz est deja dans le bus donc pas dehors donc exception
		leBusMagiqueSansPlaces.demanderPlaceDebout(haziz);
	}

	@Test (expected = IllegalStateException.class)
	public void testDemanderChangerEnDeboutPasDansLeBus() throws IllegalStateException {
		//on change Haziz en debout mais il est pas dans le bus
		leBusMagique.demanderChangerEnDebout(haziz);
	}
	@Test (expected = IllegalStateException.class)
	public void testDemanderChangerEnDeboutMaisDeboutDeja() throws IllegalStateException {
		//on fait monter Michel
		leBusMagiqueSansPlaces.demanderPlaceAssise(michel);
		//on fait monter Haziz, il est debout car il y a pas de place assise
		leBusMagiqueSansPlaces.demanderPlaceAssise(haziz);
		//on change Haziz en debout mais il est déjà debout
		leBusMagiqueSansPlaces.demanderChangerEnDebout(haziz);
	}

	@Test (expected = IllegalStateException.class)
	public void testDemanderChangerEnAssisPasDansLeBus() throws IllegalStateException {
		//on change Haziz en debout mais il est pas dans le bus
		leBusMagique.demanderChangerEnAssis(haziz);
	}
	@Test (expected = IllegalStateException.class)
	public void testDemanderChangerEnAssisMaisDeboutDeja() throws IllegalStateException {
		//on fait monter Michel
		leBusMagique.demanderPlaceAssise(michel);
		//on change Michel en assis mais il est déjà assis
		leBusMagique.demanderChangerEnAssis(haziz);
	}

	@Test (expected = IllegalStateException.class)
	public void testDemanderSortie() throws IllegalStateException {
		//Haziz n'est pas dans le bus
		leBusMagique.demanderSortie(haziz);
	}



}
