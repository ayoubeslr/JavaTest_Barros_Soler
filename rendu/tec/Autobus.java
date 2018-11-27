package tec;

import java.util.ArrayList;
// TODO: Auto-generated Javadoc

/**
 * Cette class implémente les methodes de Transport et Bus pour gérer le transport de Passagers
 * Elle comporte une liste de passagers Assis ou Debout
 * Un Autobus comporte un nombre de place assise ou debout supérieures à 0.
 *
 * @author Barros Lucas
 */
public class Autobus implements Transport,Bus {

	/** The jauge assis. */
	JaugeNaturel jaugeAssis;
	
	/** The jauge debout. */
	JaugeNaturel jaugeDebout;
	
	/** The arret. */
	int arret;
	
	/** The liste pass. */
	ArrayList<Passager> listePass;
	
	/**
	 * Instancie un nouveau Autobus selon 2 parametres.
	 * Le nombre de places assises puis le nombre de places debouts.
	 * Instance le numéro de l'arrêt à 0 et la liste des passagers à vide
	 *
	 * @param i the i
	 * @param j the j
	 */
	public Autobus(int i, int j) {
		if(i<0 || j<0) {
			throw new IllegalArgumentException("Veuillez rentrer des places supérieurs ou egale à 0");
		}
		this.jaugeAssis = new JaugeNaturel(0,i,0);
		this.jaugeDebout = new JaugeNaturel(0,j,0);
		this.arret = 0;
		this.listePass = new ArrayList<>();
	}
	
	/**
	 * Instancie un nouveau Autobus selon 1 parametre.
	 * Ce constructeur fait appel au constructeur avec 2 parametres.
	 * Ce nouveau Autobus aura le même nombre de places assises et debouts
	 *
	 * @param nbPlace the nb place
	 */
	public Autobus(int nbPlace) {
		this(nbPlace, nbPlace);
	}

	/**
	 * Méthodes permetant à l'Autobus d'avancer d'un arrêt
	 * Il fera appel à tous les passagers présent dans sa liste pour leur signaler le nouvel arrêt.
	 * Si une exception surgit, il l'attrape et renvera une exception de type UsagerInvalideException à la place
	 *
	 * @throws UsagerInvalideException the usager invalide exception
	 */
	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		try{
			this.arret+=1;
		
		ArrayList<Passager> copyListePass = new ArrayList<>(listePass);

		for(Passager pass : copyListePass) {
			pass.nouvelArret(this, this.arret);
		}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new UsagerInvalideException(e.toString());
		}
	}

	/**
	 * Renvoie un boolean pour savoir si oui ou non il reste des places assises.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean aPlaceAssise() {
		if(this.jaugeAssis.estBleu() || this.jaugeAssis.estVert()){
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Renvoie un boolean pour savoir si oui ou non il reste des places debouts.
	 *
	 * @return true, if successful
	 */
	@Override
	public boolean aPlaceDebout() {
		if(this.jaugeDebout.estBleu() || this.jaugeDebout.estVert()){
			return true;
		}else {
			return false;
		}
	}

	/**
	 * Change l'état d'un passager en assis si il reste des places assises et que le passager est dehors.
	 * Peut lever une exception si le passager est déjà dans l'Autobus
	 * Cette méthode est appellé à la monter dans un Autobus
	 *
	 * @param p the p
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	@Override
	public void demanderPlaceAssise(Passager p) throws IllegalArgumentException {
		if(this.listePass.contains(p)) {
				throw new IllegalArgumentException("Le passager est déjà dans le bus");
		}
			
		
			if(this.aPlaceAssise() && p.estDehors()) {
				this.jaugeAssis.incrementer();
				this.listePass.add(p);
				p.accepterPlaceAssise();
			}else {
				this.demanderPlaceDebout(p);
			}
		
	}

	/**
	 * Change l'état d'un passager en assis si il reste des places debout et que le passager est dehors.
	 * Peut lever une exception si le passager est déjà dans l'Autobus
	 * Cette méthode est appellé à la monter dans un Autobus et qu'il n'y a plus de place assise
	 *
	 * @param p the p
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	@Override
	public void demanderPlaceDebout(Passager p) throws IllegalArgumentException {
		if(this.listePass.contains(p)) {
				throw new IllegalArgumentException("Le passager est déjà dans le bus");
		}
		
		if(this.aPlaceAssise()) {
			this.demanderPlaceAssise(p);
		}else if(this.aPlaceDebout()) {
			this.jaugeDebout.incrementer();
			this.listePass.add(p);
			p.accepterPlaceDebout();
		}else {
			//nothing todo
		}
		
	}

	/**
	 * Change l'état d'un passager en debout si il reste des places assises et que le passager est assis.
	 * Peut lever une exception si le passager n'est pas assis
	 *
	 * @param p the p
	 * @throws IllegalStateException the illegal state exception
	 */
	@Override
	public void demanderChangerEnDebout(Passager p) throws IllegalStateException {
		if(!p.estAssis()) {
			throw new IllegalStateException("Le passager n'est pas assis, il ne peux donc pas demander une place debout");
		}
		if(p.estAssis()) {
			if(this.aPlaceDebout()) {
				this.jaugeAssis.decrementer();
				this.jaugeDebout.incrementer();
				p.accepterPlaceDebout();

			}

		}

		
	}

	/**
	 * Change l'état d'un passager en assis si il reste des places debout et que le passager est debout.
	 * Peut lever une exception si le passager n'est pas debout
	 *
	 * @param p the p
	 * @throws IllegalStateException the illegal state exception
	 */
	@Override
	public void demanderChangerEnAssis(Passager p) throws IllegalStateException {
		if(!p.estDebout()) {
			throw new IllegalStateException("Le passager n'est pas debout, il ne peux donc pas demander une place assise");
		}
		if(p.estDebout()){
			if(this.aPlaceAssise()) {
				p.accepterPlaceAssise();
				this.jaugeAssis.incrementer();
				this.jaugeDebout.decrementer();
			}

		}
	}

	/**
	 * Change l'état d'un passager en dehors si il est dans le bus.
	 * Peut lever une exception si le passager est déjà dehors
	 *
	 * @param p the p
	 * @throws IllegalStateException the illegal state exception
	 */
	@Override
	public void demanderSortie(Passager p) throws IllegalStateException {
		if(p.estDehors()) {
				throw new IllegalStateException("Le passager est déjà dehors");
		}
	
		if(p.estAssis()) {
			p.accepterSortie();
			this.jaugeAssis.decrementer();
			this.listePass.remove(p);
		}else if(p.estDebout()){
			p.accepterSortie();
			this.jaugeDebout.decrementer();
			this.listePass.remove(p);
		}else {
			//nothing todo passenger not in the bus
		}
		
	}

	/**
	 * Override de la méthode toString sur l'objet Autobus
	 * un resultat du type [arret:0, assis:0, debout:0];.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "[arret:"+this.arret+", assis:"+(int)this.jaugeAssis.getValeur()+", debout:"+(int)this.jaugeDebout.getValeur()+"]";
	}

}
