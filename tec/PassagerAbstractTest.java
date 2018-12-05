package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;

public class PassagerAbstractTest {
	
	PassagerStandard passager1;
	PassagerStandard passager2;
	PassagerStandard passager3;
	PassagerStandard passager4;
	
	
	@Before
	public void setUp() throws Exception {
		passager1 = new PassagerStandard("psg1", 5);
		passager2 = new PassagerStandard("psg2", 6);
		passager2.etat.monEtat = EtatPassager.Etat.ASSIS;
		passager3 = new PassagerStandard("psg3", 7);
		passager3.etat.monEtat = EtatPassager.Etat.DEBOUT;
		passager4 = new PassagerStandard(7);
	}

	@After
	public void tearDown() throws Exception {
		passager1 = null;
		passager2 = null;
		passager3 = null;
	}

	@Test
	public void testPassagerStandard() {
		assertNotNull(passager1);
		assertNotNull(passager2);
		assertNotNull(passager3);
	}

	@Test
	public void testGetDest() {
		assertTrue(passager1.getDest() == 5);
		assertTrue(passager2.getDest() == 6);
		assertTrue(passager3.getDest() == 7);
	}


	@Test
	public void testNom() {
		assertTrue(passager1.nom() == "psg1");
		assertTrue(passager2.nom() == "psg2");
		assertTrue(passager3.nom() == "psg3");
		
	}

	
	@Test
	public void testEstDehors() {
		assertTrue(passager1.etat.monEtat == EtatPassager.Etat.DEHORS);
	}

	@Test
	public void testEstAssis() {
		assertTrue(passager2.etat.monEtat == EtatPassager.Etat.ASSIS);
	}

	@Test
	public void testEstDebout() {
		assertTrue(passager3.etat.monEtat == EtatPassager.Etat.DEBOUT);
	}

	@Test
	public void testAccepterSortie() {
		passager2.accepterSortie();
		assertTrue(passager2.etat.monEtat == EtatPassager.Etat.DEHORS);
	}

	@Test
	public void testAccepterPlaceAssise() {
		passager3.accepterPlaceAssise();
		assertTrue(passager3.etat.monEtat == EtatPassager.Etat.ASSIS);
	}

	@Test
	public void testAccepterPlaceDebout() {
		passager1.accepterPlaceDebout();
		assertTrue(passager1.etat.monEtat == EtatPassager.Etat.DEBOUT);
	}

	@Test
	public void testNouvelArret() throws UsagerInvalideException {
		Bus newBus = new FauxBusVide();
		newBus.demanderPlaceAssise(passager1);
		passager1.nouvelArret(newBus, 5);
		assertTrue(passager1.etat.monEtat == Etat.DEHORS);
	}
	

	@Test
	public void testToString() {
		assertEquals(passager1.toString(), "psg1 DEHORS");
	}
	
	@Test
	public void testToStringConstructor2() {
		assertEquals(passager4.toString(), "PassagerStandard7 DEHORS");
	}
	
	
}