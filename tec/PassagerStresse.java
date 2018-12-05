package tec;

public class PassagerStresse extends PassagerAbstract {

	public PassagerStresse(int destination) {
		super(destination);
	}
	/*
	 * a la montée demande une place assise ou rine 
	 * à partir de 3 arretd de sa destination demamnde une place debout*/

	@Override
	public void choixChangerPlace(Bus b, int numeroArret) throws UsagerInvalideException {
		if(this.destination <= numeroArret + 3) {
			b.demanderChangerEnDebout(this);
		}
		
	}

	@Override
	public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
		if(b.aPlaceAssise()) {
			b.demanderPlaceAssise(this);
		}
	}
	
}
