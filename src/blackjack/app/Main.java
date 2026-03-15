package blackjack.app;

import blackjack.dominio.Baraja;

public class Main {
	
	public void show() {
		
		Consola consola= new Consola();
		Baraja baraja= new Baraja();
		GestorPartida gestor= new GestorPartida(consola,baraja);
		
		gestor.juego();
	}
public static void main(String[] args) {
	new Main().show();
}
}