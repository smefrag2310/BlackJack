package blackjack.app;

import blackjack.dominio.Baraja;
import blackjack.dominio.Mano;

public class GestorPartida {

	private Consola consola;
	private Baraja baraja;
	private Jugador jugador1, jugador2;
	private boolean plantado1,plantado2;
	private int contadorRonda;

	public GestorPartida(Consola consola, Baraja baraja) {
		this.consola = consola;
		this.baraja = baraja;
		plantado1=false;
		plantado2=false;
	}

	public void juego() {
		int partida;
		boolean fin;
		partida = 0;
		do {
			consola.menuPartida();
			partida = consola.leerEnteroRango(1, 2);
			if (partida == 1) {
				fin=false;
				contadorRonda = 1;
				definirJugadores();
				baraja.barajar();
				repartoInicial();
				consola.escribirLinea(renderRonda());
				while(!fin) {
				decisiones();
				fin=finPartida();
				contadorRonda++;
				consola.escribirLinea(renderRonda());
				}
				mostrarGanador();
				baraja.resetear();
			} else {
				consola.cerrar();
				consola.vaciarConsola();
			}
		} while (partida != 2);
		
		consola.escribirLinea("¡Hasta la próxima!");

	}

	public String renderRonda() {
		return String.format("\nRONDA %d\n %s\n %s\n",contadorRonda,jugador1.toString(),jugador2.toString());
	}
	
	public void decisiones() {
		boolean decision1,decision2;
		System.out.printf("%s,¿quieres carta (C) o plantarte (P)?: \n",jugador1.getApodo());
		decision1= leerOpcionRonda();
		System.out.printf("%s,¿quieres carta (C) o plantarte (P)?: \n",jugador2.getApodo());
		decision2= leerOpcionRonda();
		consola.escribir("\n(Reparto de cartas de la ronda...)\n");
		
		repartoRonda(decision1,decision2);
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
	
	public boolean leerOpcionRonda() {
		return consola.readBooleanUsingChar('c','p');
	}
	
	public void repartoRonda(boolean decision1,boolean decision2) {
		
		if(decision1) {
			jugador1.añadirCarta(baraja.extraerCarta());
			plantado1=false;
		}else {
			plantado1=true;
		}
		if(decision2) {
			jugador2.añadirCarta(baraja.extraerCarta());
			plantado2=false;
		}else {
			plantado2=true;
		}
	}
	

	public void definirJugadores() {
		String apodo1,apodo2;
		
		apodo1= consola.leerTextoNoVacio("Apodo Jugador 1: ");
		apodo2= consola.leerTextoNoVacio("Apodo Jugador 2: ");
		
		jugador1= new Jugador(apodo1,new Mano());
		jugador2= new Jugador(apodo2,new Mano());
	}
	
	public boolean finPartida() {
		if(jugador1.estaPasado() || jugador2.estaPasado()) {
			return true;
		}else if(plantado1 && plantado2) {
			return true;
		}else {
			return false;
		}
	}
	
	public void mostrarGanador() {
		int punt1,punt2;
		punt1= jugador1.puntuacion();
		punt2= jugador2.puntuacion();
		
		System.out.printf("\nRESULTADO FINAL:\n %s: %d puntos %s\n %s: %d puntos %s\n\n",
				jugador1.getApodo(),punt1,jugador1.estaPasado()?"(ESTA PASADO)":"",
						jugador2.getApodo(),punt2,jugador2.estaPasado()?"(ESTA PASADO)":"");
		
		if(jugador1.estaPasado() && jugador2.estaPasado()) {
			consola.escribirLinea("Ambos se han pasado. Empate.");
		}else if(jugador1.estaPasado()) {
			System.out.printf("GANADOR: %s\n",jugador2.getApodo());
		}else if(jugador2.estaPasado()) {
			System.out.printf("GANADOR: %s\n",jugador1.getApodo());
		}else if(punt1 > punt2) {
			System.out.printf("GANADOR: %s\n",jugador1.getApodo());
		}else if(punt1 < punt2) {
			System.out.printf("GANADOR: %s\n",jugador2.getApodo());
		}else {
			consola.escribirLinea("Empate");
		}
	}
}
