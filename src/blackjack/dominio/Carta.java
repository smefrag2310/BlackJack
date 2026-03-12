package blackjack.dominio;

public class Carta {
	private TipoCarta carta;
	private TipoPalo palo;
	
	public Carta(TipoCarta carta, TipoPalo palo) {
		this.carta=carta;
		this.palo=palo;
		}
	public int getValorNumerico() {
		return carta.getValor();
	}
	public String getPalo() {
		return palo.getDescription();
	}
	public boolean esAs() {
		return carta.esAs();
	}
	@Override
	public String toString() {
		return String.format("%d%s", getValorNumerico(), getPalo());
	}
