package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class AutobusTest.
 */
public class AutobusTest {
	
	/** The auto. */
	Autobus auto;
	
	/** The auto 2. */
	Autobus auto2;
	
	/** The auto 3. */
	Autobus auto3;
	
	/** The pass assis. */
	FauxPassager passAssis;
	
	/** The pass debout. */
	FauxPassager passDebout;
	
	/** The pass dehors. */
	FauxPassager passDehors;
	
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		auto = new Autobus(1,2);
		auto2 = new Autobus(2,2);
		auto3 = new Autobus(2,1);
		passAssis = new FauxPassager();
		passAssis.status = 1;
		passDebout = new FauxPassager();
		passDebout.status = 2;
		passDehors = new FauxPassager();
		passDehors.status = 0;
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		auto = null;
		auto2 = null;
		auto3 = null;
		passAssis = null;
		passDebout = null;
		passDehors = null;
	}

	/**
	 * Test autobus.
	 */
	@Test
	public void testAutobus() {
		assertNotNull(auto);
	}
	
	/**
	 * Test to string.
	 */
	@Test
	public void testToString() {
		assertEquals(auto.toString(), "[arret:0, assis:0, debout:0]");
	}
	
	/**
	 * Test to string not startat 1.
	 */
	@Test
	public void testToStringNotStartat1() {
		assertNotEquals(auto.toString(), "[arret:1, assis:0, debout:0]");
	}

	/**
	 * Test aller arret suivant.
	 */
	@Test
	public void testAllerArretSuivant() {
		try {
			auto.allerArretSuivant();
		} catch (UsagerInvalideException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test A place assise avec bus vide.
	 */
	@Test
	public void testAPlaceAssiseAvecBusVide() {
		assertTrue(auto.aPlaceAssise());
	}
	
	/**
	 * Test A place assise avecnb personne assise inf NB placeassise.
	 */
	@Test
	public void testAPlaceAssiseAvecnbPersonneAssiseInfNBPlaceassise() {
		auto2.jaugeAssis.incrementer();
		assertTrue(auto2.aPlaceAssise());
	}
	
	/**
	 * Test A place assise avecnb personne assise egale NB placeassise.
	 */
	@Test
	public void testAPlaceAssiseAvecnbPersonneAssiseEgaleNBPlaceassise() {
		auto.jaugeAssis.incrementer();
		assertFalse(auto.aPlaceAssise());
	}
	
	/**
	 * Test A place debout avec bus vide.
	 */
	@Test
	public void testAPlaceDeboutAvecBusVide() {
		assertTrue(auto.aPlaceDebout());
	}
	
	/**
	 * Test A place debout avecnb personne assise inf NB placeassise.
	 */
	@Test
	public void testAPlaceDeboutAvecnbPersonneAssiseInfNBPlaceassise() {
		auto2.jaugeDebout.incrementer();
		assertTrue(auto2.aPlaceDebout());
	}
	
	/**
	 * Test A place debout avecnb personne assise egale NB placeassise.
	 */
	@Test
	public void testAPlaceDeboutAvecnbPersonneAssiseEgaleNBPlaceassise() {
		auto3.jaugeDebout.incrementer();
		assertFalse(auto3.aPlaceDebout());
	}

	
	/**
	 * Test demander place assise bus vide.
	 */
	@Test
	public void testDemanderPlaceAssiseBusVide() {

			auto.demanderPlaceAssise(passDehors);

		assertEquals(auto.jaugeAssis.getValeur(), 1, 0);
	}
	
	/**
	 * Test demander place assise bus non vide mais pas plein.
	 */
	@Test
	public void testDemanderPlaceAssiseBusNonVideMaisPasPlein() {
		//on change le bus en mode non vide
		auto2.jaugeAssis.incrementer();
		//on demande la place
		
			auto2.demanderPlaceAssise(passDehors);
	
		assertEquals(auto2.jaugeAssis.getValeur(), 2, 0);
	}
	
	/**
	 * Test demander place assise bus pein.
	 */
	@Test
	public void testDemanderPlaceAssiseBusPein() {
		//on remplit le bus
		auto2.jaugeAssis.incrementer();
		auto2.jaugeAssis.incrementer();
		//on demande la place

			auto2.demanderPlaceAssise(passDehors);
	
		// on test que le bus n'a pas ajouter une place assise impossible
		assertEquals(auto2.jaugeAssis.getValeur(), 2, 0);
	}
	
	/**
	 * Test demander place assise bus pein ajout personne debout.
	 */
	@Test
	public void testDemanderPlaceAssiseBusPeinAjoutPersonneDebout() {
		//on remplit le bus
		auto2.jaugeAssis.incrementer();
		auto2.jaugeAssis.incrementer();
		//on demande la place

			auto2.demanderPlaceAssise(passDehors);
	
		// on test que le bus a ajouter une presonne debout
		assertEquals(auto2.jaugeDebout.getValeur(), 1, 0);
	}

	/**
	 * Test demander place debout bus vide.
	 */
	@Test
	public void testDemanderPlaceDeboutBusVide() {
	
			auto.demanderPlaceDebout(passDehors);

		assertEquals(auto.jaugeDebout.getValeur(), 0, 0);
		assertEquals(auto.jaugeAssis.getValeur(), 1, 0);
	}

	/**
	 * Test demander place debout bus pein assis.
	 */
	@Test
	public void testDemanderPlaceDeboutBusPeinAssis() {
		//on remplit le bus
		auto2.jaugeAssis.incrementer();
		auto2.jaugeAssis.incrementer();
		//on demande la place

			auto2.demanderPlaceDebout(passDehors);

		// on test que le bus n'a pas ajouter une place assise impossible
		assertEquals(auto2.jaugeDebout.getValeur(), 1, 0);
	}
	
	/**
	 * Test demander place debout bus pein assiset debout.
	 */
	@Test
	public void testDemanderPlaceDeboutBusPeinAssisetDebout() {
		//on remplit le bus
		auto2.jaugeAssis.incrementer();
		auto2.jaugeAssis.incrementer();
		auto2.jaugeDebout.incrementer();
		auto2.jaugeDebout.incrementer();
		//on demande la place
	
			auto2.demanderPlaceDebout(passDehors);

		// on test que le bus n'a pas ajouter une place assise impossible
		assertEquals(auto2.jaugeDebout.getValeur(), 2, 0);
	}



	/**
	 * Test demander changer en debout.
	 */
	@Test
	public void testDemanderChangerEnDebout() {
		//on remplit le bus
	
			auto2.demanderPlaceAssise(passDehors);
	
		//on demande la place
	
			auto2.demanderChangerEnDebout(passAssis);

		// on test que le bus n'a pas ajouter une place assise impossible
		assertEquals(auto2.jaugeDebout.getValeur(), 1, 0);
		assertEquals(auto2.jaugeAssis.getValeur(), 0, 0);
	}
	
	/**
	 * Test demander changer en debout bus debout plein.
	 */
	@Test
	public void testDemanderChangerEnDeboutBusDeboutPlein() {
		//on remplit le bus
		auto2.jaugeAssis.incrementer();
		auto2.jaugeDebout.incrementer();
		auto2.jaugeDebout.incrementer();
		//on demande la place

			auto2.demanderChangerEnDebout(passAssis);

		// on test que le bus n'a pas ajouter une place assise impossible
		assertEquals(auto2.jaugeDebout.getValeur(), 2, 0);
		assertEquals(auto2.jaugeAssis.getValeur(), 1, 0);
	}
	
	/**
	 * Test demander changer en assis.
	 */
	@Test
	public void testDemanderChangerEnAssis() {
		//on remplit le bus
		auto2.jaugeDebout.incrementer();
		//on demande la place

			auto2.demanderChangerEnAssis(passDebout);

		
		// on test que le bus n'a pas ajouter une place assise impossible
		assertEquals(auto2.jaugeDebout.getValeur(), 0, 0);
		assertEquals(auto2.jaugeAssis.getValeur(), 1, 0);
	}
	
	/**
	 * Test demander changer en assis bus debout plein.
	 */
	@Test
	public void testDemanderChangerEnAssisBusDeboutPlein() {
		//on remplit le bus
		auto2.jaugeAssis.incrementer();
		auto2.jaugeAssis.incrementer();
		auto2.jaugeDebout.incrementer();
		//on demande la place

			auto2.demanderChangerEnAssis(passDebout);

		// on test que le bus n'a pas ajouter une place assise impossible
		assertEquals(auto2.jaugeDebout.getValeur(), 1, 0);
		assertEquals(auto2.jaugeAssis.getValeur(), 2, 0);
	}

}
