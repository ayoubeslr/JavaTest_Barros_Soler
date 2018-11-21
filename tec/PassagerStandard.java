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

	
	@Override
	public String nom() {
		// TODO Auto-generated method stub
		return this.nom;
	}


	@Override
	public boolean estDehors() {
		return (this.etat.estExterieur()); 
	}

	@Override
	public boolean estAssis() {
		return (this.etat.estAssis());
	}

	@Override
	public boolean estDebout() {
		// TODO Auto-generated method stub
		return (this.etat.estDebout());
	}

	@Override
	public void accepterSortie() {
		this.etat.monEtat = EtatPassager.Etat.DEHORS;
		
	}

	@Override
	public void accepterPlaceAssise() {
		this.etat.monEtat = EtatPassager.Etat.ASSIS;
		
	}

	@Override
	public void accepterPlaceDebout() {
		this.etat.monEtat = EtatPassager.Etat.DEBOUT;
		
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) {
		if(this.destination == numeroArret) {
			bus.demanderSortie(this);
		}else if(this.estDebout()) {
			bus.demanderChangerEnAssis(this);
		}
		
	}
	
	@Override
	  public String toString() {
	    return this.nom + " " + this.etat.monEtat;
	  }

	@Override
	public void monterDans(Bus b) throws UsagerInvalideException {
		if(b.aPlaceAssise()) {
			b.demanderPlaceAssise(this);
		}else if(b.aPlaceDebout()) {
			b.demanderPlaceDebout(this);
		}
		
	}

}