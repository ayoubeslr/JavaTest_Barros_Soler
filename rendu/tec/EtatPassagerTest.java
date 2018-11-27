package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * Classe de test.
 * Teste les méthodes de la classe EtatPassager.
 *
 */

public class EtatPassagerTest {
	
	/** Declaration des 3 etats : Assi, Debout, Dehors.
	 * 
	 */
	EtatPassager eAssis;
	
	/** The e debout. */
	EtatPassager eDebout;
	
	/** The e dehors. */
	EtatPassager eDehors;

	/**
	 *  Instantiation de 3 états : Assis, Debout, Dehors.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		EtatPassager.Etat assis = EtatPassager.Etat.ASSIS;
		eAssis = new EtatPassager(assis);
		EtatPassager.Etat debout = EtatPassager.Etat.DEBOUT;
		eDebout = new EtatPassager(debout);
		EtatPassager.Etat dehors = EtatPassager.Etat.DEHORS;
		eDehors = new EtatPassager(dehors);
	}

	/**
	 *  Destruction des 3 états : Assi, Debout , Dehors.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		eAssis = null;
		eDebout = null;
		eDehors = null;
	}

	/**Methode de Test 
	 * Test de l'instantiation d'un EtatPassager.
	 * 
	 */
	@Test
	public void testEtatPassager() {
		assertNotNull(eAssis);
		assertNotNull(eDebout);
		assertNotNull(eDehors);
	}

	/**Methode de Test
	 * Test si l'etat a pour valeur "Exterieur".
	 */
	@Test
	public void testEstExterieur() {
		assertTrue(eDehors.estExterieur());
		assertFalse(eDehors.estAssis());
		assertFalse(eDehors.estDebout());
	}

	/**Methode de Test
	 * Test si l'état a pour valeur "Assis".
	 */
	@Test
	public void testEstAssis() {
		assertFalse(eAssis.estExterieur());
		assertTrue(eAssis.estAssis());
		assertFalse(eAssis.estDebout());
	}

	/**Methode de Test
	 * Test si l'état a pour valeur "Debout".
	 */
	@Test
	public void testEstDebout() {
		assertFalse(eDebout.estExterieur());
		assertFalse(eDebout.estAssis());
		assertTrue(eDebout.estDebout());
	}

	/**Methode de Test
	 * Test si le passager est à l'intérieur du transport.
	 */
	@Test
	public void testEstInterieur() {
		assertFalse(eDehors.estInterieur());
		assertTrue(eAssis.estInterieur());
		assertTrue(eDebout.estInterieur());
	}

	/**Methode de Test
	 * Test la conversion d'un passager en chaine de caractère.
	 */
	@Test
	public void testToString() {
		assertEquals(eDehors.toString(), "<DEHORS>");
	}

}
