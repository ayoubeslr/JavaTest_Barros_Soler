package tec;

import tec.EtatPassager.Etat;

public class PassagerStandard implements Usager, Passager{
	private String nom;
	private int destination;
	protected EtatPassager etat;
	
	public PassagerStandard(String nom, int destination) {
		this.nom = nom;
		this.destination = destination;
		this.etat = new EtatPassager(EtatPassager.Etat.DEHORS);
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
	   * @return vrai si l'etat  du passager est Dehors
	   */
	@Override
	public boolean estDebout() {
		// TODO Auto-generated method stub
		return (this.etat.estDebout());
	}
	/**
	   * Change l'état du passager en dehors
	   * Le passager est dehors
	   */
	@Override
	public void accepterSortie() {
		this.etat.monEtat = EtatPassager.Etat.DEHORS;
		
	}
	/**
	   * Change l'état du passager en assis
	   * Le passager est assis dans le bus
	   */
	@Override
	public void accepterPlaceAssise() {
		this.etat.monEtat = EtatPassager.Etat.ASSIS;
		
	}
	/**
	   * Change l'état du passager en debout
	   * Le passager est debout dans le bus
	 */
	@Override
	public void accepterPlaceDebout() {
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
	public void nouvelArret(Bus bus, int numeroArret) {
		if(this.destination == numeroArret) {
			bus.demanderSortie(this);
		}else if(this.estDebout()) {
			if(bus.aPlaceAssise()) {
				bus.demanderChangerEnAssis(this);
			}
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
	public void monterDans(Bus bus) throws UsagerInvalideException {
		if(bus.aPlaceAssise()) {
			bus.demanderPlaceAssise(this);
		}else if(bus.aPlaceDebout()) {
			bus.demanderPlaceDebout(this);
		}
		
	}

}