package tec;
// TODO: Auto-generated Javadoc
/**
 * Cette classe représente l'état d'un passager dans un transport.
 * Il y a un état à l'exterieur du transport (dehors) et deux états à 
 * l'intérieur (assis, debout).
 *  
 * Les instances de cette classe sont des objets constants.
 **/
public class EtatPassager implements IEtatPassager{
  /**
   * Définit les trois états possible d'un passager dans un transport.
   */
  public enum Etat {
/**  passager assis à l'intérieur. */  ASSIS, 
                    
                    /**  passager debout à l'intérieur. */ DEBOUT,  
                    
                    /**  passager à l'extérieur. */        DEHORS};

  /** The mon etat. */
  protected Etat monEtat;

  /**
   * Construit une instance en précisant l'état du passager.
   * 
   * @param e  valeur de l'état.
   */
  public EtatPassager(Etat e) {
    monEtat = e;

    /* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
     * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
     */
  }


  /**
   * Le passager est-il à l'extérieur du transport ?.
   *
   * @return vrai si instanciation avec DEHORS;
   */
  public boolean estExterieur() {
    return this.monEtat.equals(Etat.DEHORS);
  }

  /**
   * Le passager est-il assis à l'intérieur du transport ?.
   *
   * @return vrai si instanciation avec ASSIS;
   */
  public boolean estAssis() {
    return this.monEtat.equals(Etat.ASSIS);
  }

  /**
   * Le passager est-il debout à l'intérieur du transport ?.
   *
   * @return vrai si instanciation avec DEBOUT;
   */
  public boolean estDebout() {
    return this.monEtat.equals(Etat.DEBOUT);
  }

  /**
   * Le passager est-il a l'intérieur du transport ?.
   *
   * @return vrai si instanciation avec ASSIS ou DEBOUT.
   */
  public boolean estInterieur() {
    return !this.monEtat.equals(Etat.DEHORS);
  }



  /**
   * Cette méthode est heritée de la classe {@link java.lang.Object}.
   * Trés utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant à l'état d'un objet.
   * <p> Un code par défaut est définit dans 
   * {@link java.lang.Object#toString() la classe Object} 
   * Il faut adapter (redéfinir) le code de cette méthode à chaque classe.
   * 
   * Pour les chaînes de cararctéres, l'opérateur + correspond a la concaténation.
   *
   * @return the string
   */
  @Override
  public String toString() {
    return "<" + monEtat + ">";
  }
}