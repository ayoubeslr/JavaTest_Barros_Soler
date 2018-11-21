package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PassagerStandardTest {
	
	PassagerStandard passager1;
	PassagerStandard passager2;
	PassagerStandard passager3;
	
	@Before
	public void setUp() throws Exception {
		passager1 = new PassagerStandard("psg1", 5);
		passager2 = new PassagerStandard("psg2", 6);
		passager2.etat.monEtat = EtatPassager.Etat.ASSIS;
		passager3 = new PassagerStandard("psg3", 7);
		passager3.etat.monEtat = EtatPassager.Etat.DEBOUT;
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
	public void testSetNom() {
		assertTrue(passager1.setNom("passager1") == "passager1");
		assertTrue(passager3.setNom("passager3") == "passager3");
		assertTrue(passager2.setNom("passager2") == "passager2");
	}

	@Test
	public void testSetDest() {
		assertTrue(passager1.setDest(8) == 8);
		assertTrue(passager2.setDest(9) == 9);
		assertTrue(passager3.setDest(10) == 10);
	}

	@Test
	public void testNom() {
		assertTrue(passager1.nom() == "psg1");
		assertTrue(passager2.nom() == "psg2");
		assertTrue(passager3.nom() == "psg3");
		
	}

	@Test
	public void testMonterDans() {
		assertTrue(true);
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
	public void testNouvelArret() {
		assertTrue(true);
	}

	@Test
	public void testToString() {
		assertEquals(passager1.toString(), "psg1 DEHORS");
	}

}
