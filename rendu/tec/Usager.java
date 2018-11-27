package tec;

// TODO: Auto-generated Javadoc
/**
 * Cette interface définit le type manipulé par le programme principal.
 * <p> 
 * Suivant son caractère, l'usager choisit a la montée une place assise, 
 * debout ou reste dehors.
 * Le transport est chargé d'authoriser cette demande. Si le transport
 * refuse toute demande, le passager reste dehors.
 */
public interface Usager {
  
  /**
   * fournit le nom de l'usager.
   *
   * @return the string
   */
  public String nom();

  /**
   * Fournit à l'usager le transport auquel il peut accéder.
   * Cette méthode réalise le caractère du passager à la montée.
   *
   * @param serenity the serenity
   * @throws UsagerInvalideException the usager invalide exception
   */
  public void monterDans(Bus serenity) throws UsagerInvalideException;
 
}

