package blackjack.dominio;

import java.util.*;

public class Mano {
	/**
	 * Representa el conjunto de cartas que posee un jugador en la partida.
	 * Gestiona el almacenamiento de las cartas y el cálculo dinámico de la 
	 * puntuación, aplicando las reglas de optimización de los Ases.
	 * * @author RGONCAR723
	 * 
	 */
	private List<Carta> cartas;
	/**
     * Constructor que inicializa una mano vacía sin cartas.
     */
	public Mano() {
		cartas = new ArrayList<>();
	}
	/**
     * Agrega una carta a la colección del jugador.
     * @param carta Objeto {@link Carta} a añadir a la mano.
     */
	public void añadirCarta(Carta carta) {
		if(carta != null) {
			cartas.add(carta);
		}
		
	}
	/**
     * Calcula la puntuación total de la mano.
     * Implementa la lógica de valor variable del As: se suma inicialmente 11 
     * y se reduce a 1 (restando 10) de forma iterativa si la puntuación 
     * excede los 21 puntos.
     * * @return Puntuación total optimizada (entre 0 y el valor máximo de las cartas).
     */
	public int calcularPuntuacion() {
		int suma = 0;
		int contadorAs = 0;
		for(int i = 0; i< cartas.size();i++) {
			suma += cartas.get(i).getValorNumerico();
			if(cartas.get(i).getValorNumerico() == 11) {
				contadorAs++;
			}
		}
		while (suma > 21 && contadorAs > 0) {
            suma -= 10;
            contadorAs--; 
        }
		
			
		return suma;
	}
	/**
     * Indica si el jugador ha perdido al superar el límite de 21 puntos.
     * @return true si la puntuación es superior a 21, false en caso contrario.
     */
	public boolean estaPasado() {
		boolean estaPasado=false;
		if(calcularPuntuacion()>21) {
			return !estaPasado;
		}
		return estaPasado;
	}
	/**
     * Devuelve una representación textual de la mano, incluyendo sus cartas.
     * @return Cadena con el listado de cartas de la mano y la puntuación actal de la mano.
     */
	@Override
	public String toString() {
		return String.format("Cartas: %s (Puntuación actual : %d)", cartas.toString(),calcularPuntuacion());
	}
}
