package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tec.EtatPassager.Etat;

public class PassagerStandardTest extends PassagerAbstractTest {
	@Test
	public void testChoixPlaceMonteeDansVide() {
		Bus busVide = new FauxBusVide();
		try {
			passager1.choixPlaceMontee(busVide);
			assertFalse(passager1.estDehors());
		}catch(UsagerInvalideException e) {
			assertTrue(passager1.estDehors());
		}
	}
	@Test
	public void testChoixPlaceMonteeDansPlein() {
		Bus busPlein = new FauxBusPlein();
		try {
			passager1.choixPlaceMontee(busPlein);
			assertTrue(passager1.estDehors());
		}catch(UsagerInvalideException e) {
			assertTrue(passager1.estDehors());
		}
	}
	@Test
	public void testChoixPlaceMonteeDansAssis() {
		Bus busAssis = new FauxBusAssis();
			try {
				passager1.choixPlaceMontee(busAssis);
			} catch (UsagerInvalideException e) {
				e.printStackTrace();
			}
			assertTrue(passager1.estAssis());

	}
	@Test
	public void testChoixPlaceMonteeDansDebout() {
		Bus busDebout = new FauxBusDebout();
			try {
				passager1.choixPlaceMontee(busDebout);
			} catch (UsagerInvalideException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertTrue(passager1.estDebout());
	}
	@Override
	protected PassagerAbstract creerPassager(String nom, int destination) {
		return new PassagerStandard(nom, destination);
	}
}