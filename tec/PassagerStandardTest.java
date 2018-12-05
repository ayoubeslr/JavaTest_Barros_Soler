package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;

public class PassagerStandardTest extends PassagerAbstractTest {
	@Test
	public void testMonterDansVide() {
		Bus busVide = new FauxBusVide();
		try {
			passager1.monterDans(busVide);
			assertFalse(passager1.estDehors());
		}catch(UsagerInvalideException e) {
			assertTrue(passager1.estDehors());
		}
	}
	@Test
	public void testMonterDansPlein() {
		Bus busPlein = new FauxBusPlein();
		try {
			passager1.monterDans(busPlein);
			assertTrue(passager1.estDehors());
		}catch(UsagerInvalideException e) {
			assertTrue(passager1.estDehors());
		}
	}
	@Test
	public void testMonterDansAssis() {
		Bus busAssis = new FauxBusAssis();
			try {
				passager1.monterDans(busAssis);
			} catch (UsagerInvalideException e) {
				e.printStackTrace();
			}
			assertTrue(passager1.estAssis());

	}
	@Test
	public void testMonterDansDebout() {
		Bus busDebout = new FauxBusDebout();
			try {
				passager1.monterDans(busDebout);
			} catch (UsagerInvalideException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(passager1.estDebout());
	}
}