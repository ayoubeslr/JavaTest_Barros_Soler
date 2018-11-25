package tec;

import java.util.ArrayList;

public class Autobus implements Transport,Bus {

	JaugeNaturel jaugeAssis;
	JaugeNaturel jaugeDebout;
	int arret;
	ArrayList<Passager> listePass;
	
	public Autobus(int i, int j) {
		if(i<0 || j<0) {
			throw new IllegalArgumentException("Veuillez rentrer des places supérieurs ou egale à 0");
		}
		this.jaugeAssis = new JaugeNaturel(0,i,0);
		this.jaugeDebout = new JaugeNaturel(0,j,0);
		this.arret = 0;
		this.listePass = new ArrayList<>();
	}
	
	public Autobus(int nbPlace) {
		this(nbPlace, nbPlace);
	}

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

	@Override
	public boolean aPlaceAssise() {
		if(this.jaugeAssis.estBleu() || this.jaugeAssis.estVert()){
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean aPlaceDebout() {
		if(this.jaugeDebout.estBleu() || this.jaugeDebout.estVert()){
			return true;
		}else {
			return false;
		}
	}

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

	@Override
	public String toString() {
		return "[arret:"+this.arret+", assis:"+(int)this.jaugeAssis.getValeur()+", debout:"+(int)this.jaugeDebout.getValeur()+"]";
	}

}
