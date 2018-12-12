package tec;

import tec.EtatPassager.Etat;
/**
 * Cette class implémente les methodes de Usager et Passager pour gérer l'etat d'un passager
 * Elle instancie un passager avec un non, une destination et un etat
 * 
 * @author Soler Ayoube
 *
 */

public class PassagerStandard extends PassagerAbstract{

	public PassagerStandard(String nom, int destination) throws IllegalArgumentException {
		super(nom, destination);
	}
	
	public PassagerStandard(int destination) throws IllegalArgumentException {
		super("PassagerStandard"+destination, destination);
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
	public void choixChangerPlace(Bus bus, int numeroArret) throws UsagerInvalideException {
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
	   * Indique que le passager monte dans un bus
	   * cette methode et appelée pas bus  
	   * @param bus le bus dans lequel va monter le passager
	 */
	@Override
	public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
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