package blackjack.dominio;

public enum TipoCarta {
	
	AS(11),DOS(2),TRES(3),CUATRO(4),CINCO(5),SEIS(6),SIETE(7),OCHO(8),NUEVE(9),DIEZ(10),J(10),K(10),Q(10);
	private final int valor;
	
	TipoCarta(int valor) {
		this.valor=valor;
	}
	public int getValor() {
		return valor;
	}
	public boolean esAs() {
        return this == AS;
    }
}
