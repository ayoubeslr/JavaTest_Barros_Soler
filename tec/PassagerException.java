package tec;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PassagerException {
	
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
	
	@Test (expected=UsagerInvalideException.class)
	public void testMonterDansVide() throws UsagerInvalideException {
		Bus busVide = new FauxBusVide();
		passager1.monterDans(busVide);
		assertFalse(passager1.estDehors());
	}
	/**Methode de Test 
	 * Test si le passager monte dans un bus plein
	 * @throws UsagerInvalideException 
	 * 
	 */
	@Test (expected=IllegalStateException.class)
	public void testMonterDansPlein() throws UsagerInvalideException {
		Bus busPlein = new FauxBusPlein();
		passager1.monterDans(busPlein);
		assertTrue(passager1.estDehors());
}
	/**Methode de Test 
	 * Test si le passager monte dans un bus avec des places assis
	 * @throws UsagerInvalideException 
	 * 
	 */
	@Test (expected=IllegalStateException.class)
	public void testMonterDansAssis() throws UsagerInvalideException {
		Bus busAssis = new FauxBusAssis();
		passager1.monterDans(busAssis);
		assertTrue(passager1.estAssis());
	}
	/**Methode de Test 
	 * Test si le passager monte dans un bus avec des places debout
	 * @throws UsagerInvalideException 
	 * 
	 */
	@Test (expected=IllegalStateException.class)
	public void testMonterDansDebout() throws UsagerInvalideException {
		Bus busDebout = new FauxBusDebout();
		passager1.monterDans(busDebout);
		assertTrue(passager1.estDebout());
	}

}
