package tec;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JaugeNaturelTest {

	
	JaugeNaturel jauge;
	JaugeNaturel jaugeTestIntervalle;
	JaugeNaturel jaugeVerte;
	JaugeNaturel jaugeRouge;
	JaugeNaturel jaugeBleu;
	String StringJauge;
	
	@Before
	public void setUp() throws Exception {
		
		jauge = new JaugeNaturel(0, 50, 50);
		jaugeTestIntervalle = new JaugeNaturel(-345,67899,100);
		StringJauge = "<50 [0,50]>";
	}

	@After
	public void tearDown() throws Exception {
		jauge=null;
	}

	@Test
	public void testJaugeNaturel() {
		assertNotNull("ma jauge est bien crée",jauge);
	}

	//TEST estRouge
	@Test
	public void testEstRouge() {
		assertTrue("ma jauge est rouge",jauge.estRouge());
	}
	@Test
	public void testEstRougeValeurSupMax() {
		jaugeRouge = new JaugeNaturel(0, 50, 51);
		assertTrue("ma jauge est rouge",jaugeRouge.estRouge());
	}
	@Test
	public void testEstRougeValeurInfMax() {
		jaugeRouge = new JaugeNaturel(0, 50, 49);
		assertFalse("ma jauge est rouge",jaugeRouge.estRouge());
	}

	
	//TEST EstVerte
	@Test
	public void testEstVertValeurComprise() {
		jaugeVerte = new JaugeNaturel(0, 50, 49);
		assertTrue("ma jauge est verte",jaugeVerte.estVert());
	}
	@Test
	public void testEstVertValeuregaleMin() {
		jaugeVerte = new JaugeNaturel(0, 50, 0);
		assertFalse("ma jauge est verte",jaugeVerte.estVert());
	}
	@Test
	public void testEstVertValeurSuppMin() {
		jaugeVerte = new JaugeNaturel(0, 50, 1);
		assertTrue("ma jauge est verte",jaugeVerte.estVert());
	}
	@Test
	public void testEstVertValeuregaleMax() {
		jaugeVerte = new JaugeNaturel(0, 50, 50);
		assertFalse("ma jauge est verte",jaugeVerte.estVert());
	}
	@Test
	public void testEstVertValeurSupMax() {
		jaugeVerte = new JaugeNaturel(0, 50, 51);
		assertFalse("ma jauge est verte",jaugeVerte.estVert());
	}
	@Test
	public void testEstVertValeurInfMin() {
		jaugeVerte = new JaugeNaturel(0, 50, -1);
		assertFalse("ma jauge est verte",jaugeVerte.estVert());
	}

	//TEST estBleu
	@Test
	public void testEstBleu() {
		jaugeBleu = new JaugeNaturel(0, 50, 0);
		assertTrue("ma jauge est bleu",jaugeBleu.estBleu());
	}
	@Test
	public void testEstBleuValeurSupMin() {
		jaugeBleu = new JaugeNaturel(0, 50, 1);
		assertFalse("ma jauge est bleu",jaugeBleu.estBleu());
	}
	@Test
	public void testEstBleuValeurInfMin() {
		jaugeBleu = new JaugeNaturel(0, 50, -1);
		assertTrue("ma jauge est bleu",jaugeBleu.estBleu());
	}

	@Test
	public void testIncrementer() {
		jauge.incrementer();
		//Valeur de jauge == 50 avant incrementtion, -> 51 apres
		assertEquals(jauge.getValeur(),51,0);
	}


	@Test
	public void testDecrementer() {
		jauge.decrementer();
		//Valeur de jauge == 50 avant incrementtion, -> 49 apres
		assertEquals(jauge.getValeur(),49,0);
	}

	@Test
	public void testToString() {
		assertEquals(jauge.toString(),StringJauge);
	}
	
	@Test
	public void testDansIntervalle() {
		assertFalse("la jauge n'est pas bleu",jaugeTestIntervalle.estBleu());
		assertFalse("la jauge n'est pas rouge",jaugeTestIntervalle.estRouge());
		assertTrue("la jauge est verte",jaugeTestIntervalle.estVert());
	}
	
//	@Test
//	public void testLimiteVigieMaxInferieurVigieMin() {
//		JaugeNaturel jaugeLimite = new JaugeNaturel(1,0,10);
//		assertNull(jaugeLimite);
//	}
//	@Test
//	public void testLimiteVigieMaxEgaleVigieMin() {
//		JaugeNaturel jaugeLimite = new JaugeNaturel(0,0,10);
//		assertNull(jaugeLimite);
//	}
	
}
