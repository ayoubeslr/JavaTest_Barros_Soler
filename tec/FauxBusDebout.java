package tec;


public class FauxBusDebout {
  String message = "???";

  boolean aPlaceAssise() {
    return false;
  }

  boolean aPlaceDebout() {
    return true;
  }

  void demanderPlaceAssise(Passager p) {
    message = ":demanderPlaceAssise:";
  }

  void demanderPlaceDebout(Passager p) {
    message = ":demanderPlaceDebout:";
    p.accepterPlaceDebout();
  }

  void demanderChangerEnDebout(Passager p) {
    message = ":demanderChangerEnDebout:";
    p.accepterPlaceDebout();
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
