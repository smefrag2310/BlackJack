package blackjack.dominio;

import java.util.*;

public class Baraja {
	/**
	 * Representa el mazo de cartas utilizado para el juego de BlackJack.
	 * Esta clase se encarga de gestionar el ciclo de vida de las cartas: 
	 * desde su creación e inicialización, hasta su mezcla y distribución.
	 * * @author RGONCAR723
	 * 
	 */
	private List<Carta> cartas;
	/**
     * Constructor de la clase. Inicializa el contenedor de cartas
     * y genera automáticamente las 52 cartas de la baraja.
     */
	public Baraja() {
		this.cartas = new ArrayList<>();
		inicializar();
	}
	/**
     * Genera las cartas de la baraja combinando cada {@link Palo} 
     * con cada {@link TipoCarta} disponible.
     */
	private void inicializar() {
		for (Palo p : Palo.values()) {
			for (TipoCarta tp : TipoCarta.values()) {
				cartas.add(new Carta(tp, p));
			}
		}
	}
	/**
     * Mezcla aleatoriamente las cartas contenidas en el mazo 
     * para asegurar la aleatoriedad en el reparto.
     */
	public void barajar() {
		Collections.shuffle(cartas);
	}
	/**
     * Restablece el mazo a su estado completo. 
     * Vacía las cartas actuales, vuelve a generar las 52 cartas y las mezcla.
     */
	public void resetear() {
		cartas.clear();
		inicializar();
		barajar();
	}
	/**
     * Extrae y devuelve la carta situada en la parte superior (final de la lista).
     * Si el mazo se queda sin cartas, imprime un aviso y se reinicia 
     * automáticamente antes de realizar la extracción.
     * * @return La {@link Carta} extraída del mazo.
     */
	public Carta extraerCarta() {

		if (cartas.isEmpty()) {
			System.out.printf("La baraja está vacía… \n volviendo a barajar...");
			resetear();
		}
		return cartas.remove(cartas.size() - 1);

	}
}
