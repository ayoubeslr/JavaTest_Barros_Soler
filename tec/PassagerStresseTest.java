package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PassagerStresseTest extends PassagerAbstractTest {


	@Test
	public void testChoixChangerPlaceAssis() throws UsagerInvalideException {
		Bus MonBusArret = new FauxBusVide();
		passager3.choixPlaceMontee(MonBusArret);
    	passager3.choixChangerPlace(MonBusArret,3 );
    	assertTrue(passager3.estDebout());
    	
    	}
	@Test
	public void testChoixPlaceMonteeVide() throws UsagerInvalideException {
		Bus MonBus = new FauxBusVide();
		passager1.choixPlaceMontee(MonBus);

    	assertTrue(passager1.estAssis());
	}
	@Test
	public void testChoixPlaceMonteePlein() throws UsagerInvalideException {
		Bus MonBus = new FauxBusPlein();
		passager1.choixPlaceMontee(MonBus);

    	assertTrue(passager1.estDehors());
	}
	public void testChoixPlaceMonteepasdeplaceassise() throws UsagerInvalideException {
		Bus MonBus = new FauxBusDebout();
		passager1.choixPlaceMontee(MonBus);

    	assertTrue(passager1.estDehors());
	}
	
	@Override
	protected PassagerAbstract creerPassager(String nom, int destination) {
		return new PassagerStresse(nom,destination);
	}
	


}