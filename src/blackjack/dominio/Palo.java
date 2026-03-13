package blackjack.dominio;

public enum Palo {
	/**
	 * Representa los cuatro palos de la baraja.
	 * Cada palo tiene asociado un símbolo gráfico para su representación visual 
	 * en la interfaz de consola.
	 * * @author RGONCAR723
	 * 
	 */
	CORAZONES("❤️"), PICAS("♠️"), DIAMANTES("♦️"), TREBOLES("♣️");

	private String description;
	/**
     * Constructor del enumerado Palo.
     * @param description Cadena de texto que contiene el símbolo del palo.
     */
	Palo(String description) {
		this.description = description;
	}
	/**
     * Obtiene el símbolo gráfico asociado al palo.
     * @return El carácter o emoji que representa al palo.
     */
	public String getDescription() {
		return description;
	}
}
