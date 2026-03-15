package blackjack.app;

import blackjack.dominio.Baraja;

/**
 * Es la clase encargada de pasar los parametros necesarios al constructor del gestor
 * y llamar al método que inicia el juego
 * @author SMEFRAG2310
 */

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