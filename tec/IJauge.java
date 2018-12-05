package tec;

// TODO: Auto-generated Javadoc
/**
 * The Interface IJauge.
 */
public interface IJauge {

	/**
	 * Est rouge.
	 *
	 * @return true, if successful
	 */
	public boolean estRouge();
	
	/**
	 * Est vert.
	 *
	 * @return true, if successful
	 */
	public boolean estVert();
	
	/**
	 * Est bleu.
	 *
	 * @return true, if successful
	 */
	public boolean estBleu();
	
	/**
	 * Incrementer.
	 */
	public void incrementer();
	
	/**
	 * Decrementer.
	 */
	public void decrementer();
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString();
	
	/**
	 * Gets the valeur.
	 *
	 * @return the valeur
	 */
	public float getValeur();
}
