package tec;

import tec.EtatPassager.Etat;
/**
 * Cette class implémente les methodes de Usager et Passager pour gérer l'etat d'un passager
 * Elle instancie un passager avec un non, une destination et un etat
 * 
 * @author Soler Ayoube
 *
 */

public class PassagerStandard implements Usager, Passager{
	private String nom;
	private int destination;
	protected EtatPassager etat;
	
	/**
	 * Instancie un nouveau passager
	 * avec un nom, une destination et un etat
	 * Instancie un passager avec un etat DEHORS.
	 * 
	 * @param nom
	 * @param destination
	 * @throws IllegalArgumentException
	 */
	public PassagerStandard(String nom, int destination) throws IllegalArgumentException{
		if(destination <= 0 ) {
			throw new IllegalArgumentException("Votre destination doit être supérieure à 0");
		}
		this.nom = nom;
		this.destination = destination;
		this.etat = new EtatPassager(EtatPassager.Etat.DEHORS);
	}
	
	public PassagerStandard(int destination) {
		this(("PassagerStandard" + destination),destination);
	}
	//getteurs

	public int getDest() {return this.destination;}
	//Setteurs
	
	public String setNom(String newNom) {return this.nom = newNom;}
	public int setDest(int newDest) {return this.destination = newDest;}

	/**
	   * Retourne le nom du passager
	   * @return nom
	   */
	@Override
	public String nom() {
		// TODO Auto-generated method stub
		return this.nom;
	}

	/**
	   * Retourne vrai si l'etat du passager est exérieur
	   * @return vrai si l'etat  du passager est Dehors
	   */
	@Override
	public boolean estDehors() {
		return (this.etat.estExterieur()); 
	}

	/**
	   * Retourne vrai si l'etat du passager est assis
	   * @return vrai si l'etat  du passager est assis
	   */
	@Override
	public boolean estAssis() {
		return (this.etat.estAssis());
	}
	

	/**
	   * Retourne vrai si  l'etat du passager est Debout
	   * @return vrai si l'etat  du passager est Debout
	   */
	@Override
	public boolean estDebout() {
		return (this.etat.estDebout());
	}
	
	/**
	   * Change l'état du passager en dehors
	   * Le passager est dehors
	   */
	@Override
	public void accepterSortie() throws IllegalStateException{
		if(this.etat.monEtat == EtatPassager.Etat.DEHORS) {
			throw new IllegalStateException("Ce passager est déjà dehors!");
		}
		this.etat.monEtat = EtatPassager.Etat.DEHORS;
		
	}

	/**
	   * Change l'état du passager en assis
	   * Le passager est assis dans le bus
	   */
	@Override
	public void accepterPlaceAssise() throws IllegalStateException {
		if(this.etat.monEtat == EtatPassager.Etat.ASSIS) {
			throw new IllegalStateException("Ce passager est déjà assis!");
		}
		this.etat.monEtat = EtatPassager.Etat.ASSIS;
		
	}

	/**
	   * Change l'état du passager en debout
	   * Le passager est debout dans le bus
	   */
	@Override
	public void accepterPlaceDebout()  throws IllegalStateException{
		if(this.etat.monEtat == EtatPassager.Etat.DEBOUT) {
			throw new IllegalStateException("Ce passager est déjà debout!");
		}
		this.etat.monEtat = EtatPassager.Etat.DEBOUT;
		
	}

	/**
	   * Indique au passager qu'il est arrivé à un nouvel arrêt. Cette methode
	   * fixe le comportement (changer de place ou sortir). 
	   * Cette méthode est appelée par Bus.
	   *
	   * @param bus le bus dans lequel se trouve le passager.
	   * @param numeroArret numero de l'arrêt.
	   */
	@Override
	public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException {
		if(this.destination < numeroArret) {
			throw new UsagerInvalideException("L'arret de ce passager a déjà été passer. Erreur");
		}
		if(this.etat.monEtat ==  EtatPassager.Etat.DEHORS) {
			throw new UsagerInvalideException("Le passager n'est pas dans le bus, il ne doit donc pas etre prevenu de ce nouvel arret");
		}
		
		if(this.destination == numeroArret) {
			bus.demanderSortie(this);
		}else if(this.estDebout()) {
			bus.demanderChangerEnAssis(this);
		}
		
	}
	
	/**
	   * affiche le nom du passager et sont etat 
	   * @return le nom de passager et sont etat
	   */
	@Override
	  public String toString() {
	    return this.nom + " " + this.etat.monEtat;
	  }

	/**
	   * Indique que le passager monte dans un bus
	   * cette methode et appelée pas bus  
	   * @param bus le bus dans lequel va monter le passager
	 */
	@Override
	public void monterDans(Bus b) throws UsagerInvalideException {
		if(this.etat.monEtat != EtatPassager.Etat.DEHORS) {
			throw new UsagerInvalideException("On ne peut faire monter un passager uniquement si il est dehors");
		}
			if(b.aPlaceAssise()) {
				b.demanderPlaceAssise(this);
			}else {
				b.demanderPlaceDebout(this);
			}
	}

}