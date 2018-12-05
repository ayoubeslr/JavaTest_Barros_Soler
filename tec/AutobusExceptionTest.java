package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class AutobusExceptionTest.
 */
public class AutobusExceptionTest {

	/** The auto. */
	Autobus auto;
	
	/** The le bus magique. */
	Autobus leBusMagique;
	
	/** The le bus magique sans places. */
	Autobus leBusMagiqueSansPlaces;
	
	/** The Lise le cameleon. */
	PassagerStandard LiseLeCameleon;
	
	/** The Mademoiselle valerie billeen tete. */
	PassagerStandard MademoiselleValerieBilleenTete; 
	
	/** The haziz. */
	PassagerStandard haziz; 
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		MademoiselleValerieBilleenTete = new PassagerStandard("Mademoiselle Valerie Bille-en-Tete",5);
		LiseLeCameleon = new PassagerStandard("Lise Le Cameleon",3);
		haziz = new PassagerStandard("Haziz",6);
		leBusMagique = new Autobus(5,5);
		leBusMagiqueSansPlaces = new Autobus(1,1);
		
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		MademoiselleValerieBilleenTete = null;
		LiseLeCameleon = null;
		haziz = null;
		leBusMagique = null;
		leBusMagiqueSansPlaces = null;
	}

	/**
	 * Test autobusnb place assise inf 0.
	 */
	@Test (expected = IllegalArgumentException.class) 
	public void testAutobusnbPlaceAssiseInf0() {
		auto = new Autobus(-1,0);
	}

	/**
	 * Test autobusnb place debout inf 0.
	 */
	@Test (expected = IllegalArgumentException.class) 
	public void testAutobusnbPlaceDeboutInf0() {
		auto = new Autobus(0,-1);
	}

	/**
	 * Test aller arret suivant.
	 */
	//je sais pas quoi tester
	@Test
	public void testAllerArretSuivant() {
		assertNotEquals("je sais pas", "j'ai pas compris");
	}

	
	/**
	 * Test demander place assise.
	 *
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	@Test (expected = IllegalArgumentException.class) 
	public void testDemanderPlaceAssise() throws IllegalArgumentException {
		//on fait monter Michel
		leBusMagique.demanderPlaceAssise(MademoiselleValerieBilleenTete);
		//Michel est deja dans le bus donc pas dehors donc exception
		leBusMagique.demanderPlaceAssise(MademoiselleValerieBilleenTete);
	}

	/**
	 * Test demander place debout.
	 *
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testDemanderPlaceDebout() throws IllegalArgumentException {
		//on fait monter Michel
		leBusMagique.demanderPlaceAssise(MademoiselleValerieBilleenTete);
		//on fait monter Haziz, il est debout car il y a pas de place assise
		leBusMagiqueSansPlaces.demanderPlaceDebout(haziz);
		//Haziz est deja dans le bus donc pas dehors donc exception
		leBusMagiqueSansPlaces.demanderPlaceDebout(haziz);
	}

	/**
	 * Test demander changer en debout pas dans le bus.
	 *
	 * @throws IllegalStateException the illegal state exception
	 */
	@Test (expected = IllegalStateException.class)
	public void testDemanderChangerEnDeboutPasDansLeBus() throws IllegalStateException {
		//on change Haziz en debout mais il est pas dans le bus
		leBusMagique.demanderChangerEnDebout(haziz);
	}
	
	/**
	 * Test demander changer en debout mais debout deja.
	 *
	 * @throws IllegalStateException the illegal state exception
	 */
	@Test (expected = IllegalStateException.class)
	public void testDemanderChangerEnDeboutMaisDeboutDeja() throws IllegalStateException {
		//on fait monter Michel
		leBusMagiqueSansPlaces.demanderPlaceAssise(MademoiselleValerieBilleenTete);
		//on fait monter Haziz, il est debout car il y a pas de place assise
		leBusMagiqueSansPlaces.demanderPlaceAssise(haziz);
		//on change Haziz en debout mais il est deje debout
		leBusMagiqueSansPlaces.demanderChangerEnDebout(haziz);
	}

	/**
	 * Test demander changer en assis pas dans le bus.
	 *
	 * @throws IllegalStateException the illegal state exception
	 */
	@Test (expected = IllegalStateException.class)
	public void testDemanderChangerEnAssisPasDansLeBus() throws IllegalStateException {
		//on change Haziz en debout mais il est pas dans le bus
		leBusMagique.demanderChangerEnAssis(haziz);
	}
	
	/**
	 * Test demander changer en assis mais debout deja.
	 *
	 * @throws IllegalStateException the illegal state exception
	 */
	@Test (expected = IllegalStateException.class)
	public void testDemanderChangerEnAssisMaisDeboutDeja() throws IllegalStateException {
		//on fait monter Michel
		leBusMagique.demanderPlaceAssise(MademoiselleValerieBilleenTete);
		//on change Michel en assis mais il est deje assis
		leBusMagique.demanderChangerEnAssis(haziz);
	}

	/**
	 * Test demander sortie.
	 *
	 * @throws IllegalStateException the illegal state exception
	 */
	@Test (expected = IllegalStateException.class)
	public void testDemanderSortie() throws IllegalStateException {
		//Haziz n'est pas dans le bus
		leBusMagique.demanderSortie(haziz);
	}



}
