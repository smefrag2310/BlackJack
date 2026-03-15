package blackjack.app;

import java.util.List;
import blackjack.dominio.Carta;
import blackjack.dominio.Mano;

public class Jugador {

	private String apodo;
	private Mano mano;
	
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
	
	public void añadirCarta(Carta carta) {
		mano.añadirCarta(carta);
	}
	
	public int puntuación() {
		return mano.calcularPuntuacion();
	}
	
	public boolean estaPasado() {
		return mano.estaPasado();
	}
}
