package tec;

public class FauxBusPlein {
  String message = "???";

  boolean aPlaceAssise() {
    return false;
  }

  boolean aPlaceDebout() {
    return false;
  }

  void demanderPlaceAssise(Passager p) {
    message = ":demanderPlaceAssise:";
  }

  void demanderPlaceDebout(Passager p) {
    message = ":demanderPlaceDebout:";
  }

  void demanderChangerEnDebout(Passager p) {
    message = ":demanderChangerEnDebout:";
  }
  
  void demanderChangerEnAssis(Passager p) {
    message = ":demanderChangerEnAssis:";
  }

  void demanderSortie(Passager p) {
    message = ":demanderSortie:";    
    p.accepterSortie();
  }

  public void allerArretSuivant() { //throws UsagerInvalideException {
  }
}
