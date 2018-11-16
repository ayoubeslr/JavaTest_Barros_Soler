package tec;

public interface IJauge {

	public boolean estRouge();
	public boolean estVert();
	public boolean estBleu();
	public void incrementer();
	public void decrementer();
	public String toString();
	public float getValeur();
}
