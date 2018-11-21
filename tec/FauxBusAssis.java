package tec;

public class FauxBusAssis {
  String message = "???";

  boolean aPlaceAssise() {
    return true;
  }

  boolean aPlaceDebout() {
    return false;
  }

  void demanderPlaceAssise(Passager p) {
    message = ":demanderPlaceAssise:";
    p.accepterPlaceAssise();
  }

  void demanderPlaceDebout(Passager p) {
    message = ":demanderPlaceDebout:";
  }

  void demanderChangerEnDebout(Passager p) {
    message = ":demanderChangerEnDebout:";
  }
  
  void demanderChangerEnAssis(Passager p) {
    message = ":demanderChangerEnAssis:";
    p.accepterPlaceAssise();
  }

  void demanderSortie(Passager p) {
    message = ":demanderSortie:";    
    p.accepterSortie();
  }

  public void allerArretSuivant() { //throws UsagerInvalideException {
  }
}
