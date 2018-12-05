package tec;

import tec.EtatPassager.Etat;
/**
 * Cette class impl�mente les methodes de Usager et Passager pour g�rer l'etat d'un passager
 * Elle instancie un passager avec un non, une destination et un etat
 * 
 * @author Soler Ayoube
 *
 */

public abstract class PassagerAbstract implements Usager, Passager{
	protected String nom;
	protected int destination;
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
	public PassagerAbstract(String nom, int destination) throws IllegalArgumentException{
		if(destination <= 0 ) {
			throw new IllegalArgumentException("Votre destination doit �tre sup�rieure � 0");
		}
		this.nom = nom;
		this.destination = destination;
		this.etat = new EtatPassager(EtatPassager.Etat.DEHORS);
	}
	
	public PassagerAbstract(int destination) {
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
	   * Retourne vrai si l'etat du passager est ex�rieur
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
	   * Change l'�tat du passager en dehors
	   * Le passager est dehors
	   */
	@Override
	public void accepterSortie() throws IllegalStateException{
		if(this.etat.monEtat == EtatPassager.Etat.DEHORS) {
			throw new IllegalStateException("Ce passager est d�j� dehors!");
		}
		this.etat.monEtat = EtatPassager.Etat.DEHORS;
		
	}

	/**
	   * Change l'�tat du passager en assis
	   * Le passager est assis dans le bus
	   */
	@Override
	public void accepterPlaceAssise() throws IllegalStateException {
		if(this.etat.monEtat == EtatPassager.Etat.ASSIS) {
			throw new IllegalStateException("Ce passager est d�j� assis!");
		}
		this.etat.monEtat = EtatPassager.Etat.ASSIS;
		
	}

	/**
	   * Change l'�tat du passager en debout
	   * Le passager est debout dans le bus
	   */
	@Override
	public void accepterPlaceDebout()  throws IllegalStateException{
		if(this.etat.monEtat == EtatPassager.Etat.DEBOUT) {
			throw new IllegalStateException("Ce passager est d�j� debout!");
		}
		this.etat.monEtat = EtatPassager.Etat.DEBOUT;
		
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
	   * cette methode et appel�e pas bus  
	   * @param bus le bus dans lequel va monter le passager
	 */
	@Override
	public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException{
		choixChangerPlace(bus, numeroArret);
	}
	@Override
	public void monterDans(Bus b) throws UsagerInvalideException{
		choixPlaceMontee(b);
	}
	
	public abstract void choixChangerPlace(Bus b, int numeroArret) throws UsagerInvalideException;
	
	public abstract void choixPlaceMontee(Bus b) throws UsagerInvalideException;

}