package blackjack.app;

import java.util.List;
import blackjack.dominio.Carta;
import blackjack.dominio.Mano;

/**
 * Esta clase es la encargada de definir los apodos y mantener las manos de los usuarios
 * que jugarán, se añadiran cartas, se comprobará la puntuación y si se pasa.
 * @author SMEFRAG2310
 */

public class Jugador {

	private String apodo;
	private Mano mano;
	/**
	 * Constructor para definir el apodo y crear la mano al principio de partida
	 * 
	 * @param apodo nombre del jugador
	 * @param mano las cartas del jugador
	 */
	public Jugador(String apodo, Mano mano) {
		this.apodo=apodo;
		this.mano=mano;
	}
	
	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}
	/**
	 * Se añade la carta a la mano del jugador
	 * 
	 * @param carta a añadir a la mano
	 */
	public void añadirCarta(Carta carta) {
		mano.añadirCarta(carta);
	}
	/**
	 * Devuelve la puntuación del jugador actualmente
	 * 
	 * @return int con la puntuación del jugador
	 */
	public int puntuacion() {
		return mano.calcularPuntuacion();
	}
	/**
	 * Comprueba si el jugador se ha pasado o no 
	 * 
	 * @return boolean de la situación del jugador
	 */
	public boolean estaPasado() {
		return mano.estaPasado();
	}
	/**
	 * Devuelve una cadena con toda la información relevante del jugador
	 * 
	 * @return String con el apodo, las cartas actuales y si se ha pasado o no 
	 */
	@Override
	public String toString() {
		return String.format("%s: %s \t%s",apodo,mano.toString(),estaPasado()? "(SE HA PASADO)":"");
	}
}
