package blackjack.dominio;

public class Carta {
	/**
	 * Representa una carta individual de la baraja.
	 * Esta clase es inmutable y combina un {@link TipoCarta} y un {@link TipoPalo}
	 * para definir la identidad de la carta y su comportamiento en el juego.
	 * * @author RGONCAR723
	 * 
	 */
	private TipoCarta Tipocarta;
	private Palo palo;

	/**
	 * Crea una nueva carta con el tipo y palo especificados.
	 * 
	 * @param tipoCarta El tipo de carta (valor o figura).
	 * @param palo      El palo de la baraja.
	 */
	public Carta(TipoCarta Tipocarta, Palo palo) {
		this.Tipocarta = Tipocarta;
		this.palo = palo;
	}
	
	/**
     * Obtiene la representación textual del tipo de carta (ej. "A", "J", "10").
     * @return String con el nombre corto o valor del tipo de carta.
     */
	public String getTipoCarta() {
		return Tipocarta.toString();
	}
	/**
     * Obtiene el valor numérico de la carta para el cálculo de la puntuación.
     * @return Valor entero según las reglas del BlackJack.
     */
	public int getValorNumerico() {
		return Tipocarta.getValor();
	}
	/**
     * Obtiene el símbolo o descripción del palo de la carta.
     * @return String que representa el palo.
     */
	public String getPalo() {
		return palo.getDescription();
	}
	/**
     * Indica si la carta es un As. 
     * Delegar esta comprobación al tipo de carta facilita el cálculo especial de puntos.
     * @return true si es un As, false en caso contrario.
     */
	public boolean isAs() {
		return Tipocarta.esAs();
	}
	/**
     * Devuelve la representación visual de la carta combinando valor y palo.
     * Ejemplo: "A♠", "10♣".
     * @return Una cadena formateada con la información de la carta.
     */
	@Override
	public String toString() {
		return String.format("%s%s", getTipoCarta(), getPalo());
	}
}
