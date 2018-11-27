package tec;

// TODO: Auto-generated Javadoc
/**
 * Cette interface définit le type manipule par le programme principal.
 * <p>
 * Un bus a un nombre de places assises et de places debouts.
 * <p>
 * Un Transport voyage d'arrêt en arrêt, il prévient ses passagers de chaque
 * nouvel arrêt.
 */
public interface Transport {

  /**
   * Indique au tranport de simuler l'arrêt suivant.
   *
   * @throws UsagerInvalideException the usager invalide exception
   */
  public void allerArretSuivant() throws UsagerInvalideException;
}

