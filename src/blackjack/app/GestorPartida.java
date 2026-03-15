package blackjack.app;

import blackjack.dominio.Baraja;
import blackjack.dominio.Mano;

public class GestorPartida {

	private Consola consola;
	private Baraja baraja;
	private Jugador jugador1, jugador2;
	private int contadorRonda;

	public GestorPartida(Consola consola, Baraja baraja) {
		this.consola = consola;
		this.baraja = baraja;
	}

	public void juego() {
		int partida;
		partida = 0;
		do {
			consola.menuPartida();
			partida = consola.leerEnteroRango(1, 2);
			if (partida == 1) {
				contadorRonda = 1;
				
				definirJugadores();
				baraja.barajar();
				repartoInicial();
				
			} else {
				consola.cerrar();
				consola.vaciarConsola();
			}
		} while (partida != 2);
		
		consola.escribirLinea("¡Hasta la próxima!");

	}

	public String renderRonda() {
		return String.format("RONDA %d \n %s: %s");
	}
	
	public void decisiones() {
		
	}
	
	public void repartoInicial() {
		int cartas;
		consola.escribir("Cartas iniciales (1 o 2): ");
		cartas=consola.leerEnteroRango(1, 2);
		for(int i= 0; i < cartas; i++) {
			jugador1.añadirCarta(baraja.extraerCarta());
			jugador2.añadirCarta(baraja.extraerCarta());
		}
	}
	
	public void repartoRonda() {
		
	}

	public void definirJugadores() {
		String apodo1,apodo2;
		
		apodo1= consola.leerTextoNoVacio("Apodo Jugador 1: ");
		apodo2= consola.leerTextoNoVacio("Apodo Jugador 2: ");
		
		jugador1= new Jugador(apodo1,new Mano());
		jugador2= new Jugador(apodo2,new Mano());
	}
	
	public boolean finPartida() {
		
	}
}
