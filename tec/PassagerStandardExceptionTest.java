package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class PassagerStandardExceptionTest.
 */
public class PassagerStandardExceptionTest {

	/** The pass test. */
	PassagerStandard passTest;
	
	/** The Mowgli. */
	PassagerStandard Mowgli;
	
	/** The le bus magique le retour. */
	//on instancie des autobus et non pas des faux autobus car on sait qu'il est fonctionnel apr�s la mise en commun
	Autobus leBusMagiqueLeRetour;
	
	/** The le bus de sportif. */
	FauxBusDebout leBusDeSportif;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		Mowgli = new PassagerStandard("Mowgli",2);
		leBusMagiqueLeRetour = new Autobus(5,5);
		leBusDeSportif = new FauxBusDebout();
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		Mowgli = null;
		leBusMagiqueLeRetour = null;
		leBusDeSportif = null;
	}

	/**
	 * Test constructor.
	 *
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testConstructor() throws IllegalArgumentException{
		passTest = new PassagerStandard("Tarzan", 0);
	}
	
	/**
	 * Test constructor 2.
	 *
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	@Test (expected=IllegalArgumentException.class)
	public void testConstructor2() throws IllegalArgumentException{
		passTest = new PassagerStandard("Tarzan", -1);
	}
	
	/**
	 * Test nouvel arret.
	 *
	 * @throws UsagerInvalideException the usager invalide exception
	 */
	@Test (expected=UsagerInvalideException.class)
	public void testChoixCangerPlace() throws UsagerInvalideException{
		//Mowgli est assis son arret est le 2
		leBusMagiqueLeRetour.demanderPlaceAssise(Mowgli);
		Mowgli.nouvelArret(leBusMagiqueLeRetour,5);
	}
	
	/**
	 * Test nouvel arret dehors.
	 *
	 * @throws UsagerInvalideException the usager invalide exception
	 */
	@Test (expected=UsagerInvalideException.class)
	public void testchoixPlaceMonteeDehors() throws UsagerInvalideException{
		//Mowgli est dehors
		Mowgli.nouvelArret(leBusMagiqueLeRetour,5);
	}
	

}
