package tec;

import java.util.ArrayList;
import java.util.Arrays;

public class Autobus implements Transport,Bus {

	JaugeNaturel jaugeAssis;
	JaugeNaturel jaugeDebout;
	int arret;
	ArrayList<Passager> listePass;
	
	public Autobus(int i, int j) {
		this.jaugeAssis = new JaugeNaturel(0,i,0);
		this.jaugeDebout = new JaugeNaturel(0,j,0);
		this.arret = 0;
		this.listePass = new ArrayList<>();
	}

	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		this.arret+=1;
		ArrayList<Passager> copyListePass = new ArrayList<>(listePass);

		for(Passager pass : copyListePass) {
			pass.nouvelArret(this, this.arret);
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
	public void demanderPlaceAssise(Passager p) {
		if(this.aPlaceAssise() && p.estDehors()) {
			this.jaugeAssis.incrementer();
			this.listePass.add(p);
			p.accepterPlaceAssise();
		}else {
			this.demanderPlaceDebout(p);
		}
		
	}

	@Override
	public void demanderPlaceDebout(Passager p) {
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
	public void demanderChangerEnDebout(Passager p) {
		if(p.estAssis()) {
			if(this.aPlaceDebout()) {
				this.jaugeAssis.decrementer();
				this.jaugeDebout.incrementer();
				p.accepterPlaceDebout();

			}

		}

		
	}

	@Override
	public void demanderChangerEnAssis(Passager p) {
		if(p.estDebout()){
			if(this.aPlaceAssise()) {
				p.accepterPlaceAssise();
				this.jaugeAssis.incrementer();
				this.jaugeDebout.decrementer();
			}

		}
	}

	@Override
	public void demanderSortie(Passager p) {
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
