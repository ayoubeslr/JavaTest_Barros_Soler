package tec;

// TODO: Auto-generated Javadoc
/**
 * The Class FauxBusPlein.
 */
public class FauxBusPlein implements Bus, Transport{
  
  /** The message. */
  String message = "???";

  /* (non-Javadoc)
   * @see tec.Bus#aPlaceAssise()
   */
  public boolean aPlaceAssise() {
    return false;
  }

  /* (non-Javadoc)
   * @see tec.Bus#aPlaceDebout()
   */
  public boolean aPlaceDebout() {
    return false;
  }

  /* (non-Javadoc)
   * @see tec.Bus#demanderPlaceAssise(tec.Passager)
   */
  public void demanderPlaceAssise(Passager p) {
    message = ":demanderPlaceAssise:";
  }

  /* (non-Javadoc)
   * @see tec.Bus#demanderPlaceDebout(tec.Passager)
   */
  public void demanderPlaceDebout(Passager p) {
    message = ":demanderPlaceDebout:";
  }

  /* (non-Javadoc)
   * @see tec.Bus#demanderChangerEnDebout(tec.Passager)
   */
  public void demanderChangerEnDebout(Passager p) {
    message = ":demanderChangerEnDebout:";
  }
  
  /* (non-Javadoc)
   * @see tec.Bus#demanderChangerEnAssis(tec.Passager)
   */
  public void demanderChangerEnAssis(Passager p) {
    message = ":demanderChangerEnAssis:";
  }

  /* (non-Javadoc)
   * @see tec.Bus#demanderSortie(tec.Passager)
   */
  public void demanderSortie(Passager p) {
    message = ":demanderSortie:";    
    p.accepterSortie();
  }

  /* (non-Javadoc)
   * @see tec.Bus#allerArretSuivant()
   */
  public void allerArretSuivant() { //throws UsagerInvalideException {
  }
}
