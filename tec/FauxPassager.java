package tec;

// TODO: Auto-generated Javadoc
/**
 * The Class FauxPassager.
 */
public class FauxPassager implements Passager { 
  
  /** The Constant DEHORS. */
  static final byte DEHORS = 0;
  
  /** The Constant ASSIS. */
  static final byte ASSIS  = 1;
  
  /** The Constant DEBOUT. */
  static final byte DEBOUT = 2;
  
  /** The status. */
  byte status = DEHORS;

  /** The message. */
  String message ="???";

  /* (non-Javadoc)
   * @see tec.Passager#nom()
   */
  public String nom() {
    return null;
  }

  /* (non-Javadoc)
   * @see tec.Passager#estDehors()
   */
  public boolean estDehors() {
    return status == DEHORS;
  }
  
  /* (non-Javadoc)
   * @see tec.Passager#estAssis()
   */
  public boolean estAssis() {
    return status == ASSIS;
  }
  
  /* (non-Javadoc)
   * @see tec.Passager#estDebout()
   */
  public boolean estDebout() {
    return status == DEBOUT;
  }

  /* (non-Javadoc)
   * @see tec.Passager#accepterSortie()
   */
  public void accepterSortie() {
    message = ":accepterSortie:";
  }

  /* (non-Javadoc)
   * @see tec.Passager#accepterPlaceAssise()
   */
  public void accepterPlaceAssise() {
    message = ":accepterPlaceAssise:";
  }

  /* (non-Javadoc)
   * @see tec.Passager#accepterPlaceDebout()
   */
  public void accepterPlaceDebout() {
    message = ":accepterPlaceDebout:";
  }

  /* (non-Javadoc)
   * @see tec.Passager#nouvelArret(tec.Bus, int)
   */
  public void nouvelArret(Bus bus, int numeroArret) {
    message = ":nouvelArret " + numeroArret + ":";
  }

  /**
   * Monter dans.
   *
   * @param t the t
   */
  public void monterDans(Transport t) { // throws UsagerInvalideException {
  }

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "FauxPassager [status=" + status + "]";
}
  
}
