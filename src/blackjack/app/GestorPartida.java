package blackjack.app;

import blackjack.dominio.Baraja;
import blackjack.dominio.Mano;

/**
 * La clase GestorPartida es la encargada de llevar el trascurso de la partida,
 * la baraja, los jugadores, el número de rondas.
 * Contiene métodos llevar el propio juego, mostrar información de la ronda, la toma de decisiones
 *  y los resultados de la partida
 *  @author SMEFRAG2310
 */

public class GestorPartida {

	private Consola consola;
	private Baraja baraja;
	private Jugador jugador1, jugador2;
	private boolean plantado1,plantado2;
	private int contadorRonda;

	/**
	 * 
	 * Constructor que define la consola y baraja que se van a usar,
	 * además de definir el estado inicial de las decisiones.
	 * 
	 * @param consola recibe una consola.
	 * @param baraja la baraja de cartas.
	 */
	public GestorPartida(Consola consola, Baraja baraja) {
		this.consola = consola;
		this.baraja = baraja;
		plantado1=false;
		plantado2=false;
	}

	/**
	 * Este método es el encargado de la ejecución del juego,
	 * es donde se llaman a los demás métodos y se controla 
	 * el flujo de ejecución.
	 */
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

	/**
	 * Se encarga de recopilar los datos actuales y devolverlos.
	 * 
	 * @return String con la información de la ronda actual.
	 */
	public String renderRonda() {
		return String.format("\nRONDA %d\n %s\n %s\n",contadorRonda,jugador1.toString(),jugador2.toString());
	}
	
	
	/**
	 * Se encarga de recopilar la información de las decisiones de los jugadores
	 * y llamar al método de repartoRonda para realizar las acciones pertinentes.
	 */
	public void decisiones() {
		boolean decision1,decision2;
		decision1=false;
		decision2=false;
		
		if(!plantado1) {
		System.out.printf("%s,¿quieres carta (C) o plantarte (P)?: \n",jugador1.getApodo());
		decision1= leerOpcionRonda();
		}
		if(!plantado2) {
		System.out.printf("%s,¿quieres carta (C) o plantarte (P)?: \n",jugador2.getApodo());
		decision2= leerOpcionRonda();
		}
		consola.escribir("\n(Reparto de cartas de la ronda...)\n");
		
		repartoRonda(decision1,decision2);
	}
	
	/**
	 * Realiza el reparto inicial de las cartas según la elección 
	 * de los jugadores.
	 */
	public void repartoInicial() {
		int cartas;
		consola.escribir("Cartas iniciales (1 o 2): ");
		cartas=consola.leerEnteroRango(1, 2);
		for(int i= 0; i < cartas; i++) {
			jugador1.añadirCarta(baraja.extraerCarta());
			jugador2.añadirCarta(baraja.extraerCarta());
		}
	}
	/**
	 * 
	 * Es la encargada de recoger el caracter que define
	 * si quiere carta o se planta
	 * 
	 * @return boolean para la opción elegida
	 */
	public boolean leerOpcionRonda() {
		return consola.readBooleanUsingChar('c','p');
	}
	/**
	 * 
	 * Es la encargada de dar cartas a quienes lo hayan pedido y de 
	 * modificar el estado de plantado de cada jugador
	 * 
	 * @param decision1 la decisión del primer jugador
	 * @param decision2 la decisión del segundo jugador
	 */
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
	
	/**
	 * Define a los jugadores al inicio de la partida, pidiendo 
	 * un apodo para cada jugador, y crea una mano para cada uno.
	 */
	public void definirJugadores() {
		String apodo1,apodo2;
		
		apodo1= consola.leerTextoNoVacio("Apodo Jugador 1: ");
		apodo2= consola.leerTextoNoVacio("Apodo Jugador 2: ");
		
		jugador1= new Jugador(apodo1,new Mano());
		jugador2= new Jugador(apodo2,new Mano());
	}
	/**
	 * Método encargado de finalizar la partida cuando corresponda.
	 * 
	 * @return boolean que define el fin de la partida.
	 */
	public boolean finPartida() {
		if(jugador1.estaPasado() || jugador2.estaPasado()) {
			return true;
		}else if(plantado1 && plantado2) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * Al final de la partida, recoge y muestra las puntuaciones por jugador,
	 * mostrando quien ha ganado, quien se ha pasado y si ha ocurrido un empate.
	 */
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
