package blackjack.dominio;

public enum TipoCarta {
	/**
	 * Representa los tipos de cartas posibles en una baraja de BlackJack.
	 * Cada tipo tiene un valor numérico asociado según las reglas del juego:
	 * <ul>
	 * <li>Los números del 2 al 10 valen su valor nominal.</li>
	 * <li>Las figuras (J, Q, K) valen 10.</li>
	 * <li>El AS vale inicialmente 11.</li>
	 * </ul>
	 * * @author RGONCASR723
	 * 
	 */

	AS(11), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9), DIEZ(10), J(10), K(10), Q(10);

	private final int valor;

	/**
	 * Constructor del enumerado.
	 * 
	 * @param valor Valor entero asociado a la carta.
	 */
	TipoCarta(int valor) {
		this.valor = valor;
	}
	/**
     * Obtiene el valor numérico de la carta.
     * @return El valor entero de la carta.
     */

	public int getValor() {
		return valor;
	}
	/**
     * Comprueba si la carta actual es un AS.
     * @return true si es un AS, false en caso contrario.
     */
	public boolean esAs() {
		return this == AS;
	}
	/**
     * Devuelve una representación textual abreviada de la carta.
     * @return "A", "J", "Q", "K" para las figuras o el valor numérico para el resto.
     */
	@Override
	public String toString() {
		return switch (this) {
		case AS -> "A";
		case J -> "J";
		case Q -> "Q";
		case K -> "K";
		default -> String.valueOf(this.valor);
		};
	}
}
