package blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {

	private Scanner sc;
	
	public Consola() {
		sc= new Scanner(System.in);
	}
	
	public void escribir(String texto) {
		System.out.print(texto);
	}
	
	public void escribirLinea(String texto) {
		System.out.println(texto);
	}
	
	public String leerTexto(String mensaje) {
		String texto;

		escribir(mensaje);
		texto = sc.nextLine();

		return texto.trim();
	}
	
	public String leerTextoNoVacio(String mensaje) {
		String texto;

		texto = "";
		while (texto.isBlank()) {
			escribir(mensaje);
			texto = sc.nextLine();
			texto = texto.trim();
			if (texto.isBlank()) {
				escribirLinea("ERROR - No puede estar vacío.");
			}
		}
		return texto;
	}
	
	public int leerEntero() {
		int value=0;
		boolean error;
		do {
	       try {
	    	   value= sc.nextInt();
	    	   error=false;
	       }catch(InputMismatchException e) {
	    	   System.out.printf("Debes introducir un número entero y que no se salga del rango %d, %d: ",Integer.MIN_VALUE,Integer.MAX_VALUE);
	    	   error=true;
	       }finally {
	    	   sc.nextLine();
	       }
		}while(error);
	        return value;
	    }
	
	public int leerEnteroRango(int menor, int mayor) {
		int value;
		do {
			value = leerEntero();
			if (value < menor || value > mayor) {
				System.out.printf("%d está fuera del rango %d - %d, Introduce otro número: ", value, menor,
						mayor);
			}
		} while (value < menor || value > mayor);
		return value;
	}
	
	public void cerrar() {
		this.sc.close();
	}
	
	public void menuPartida() {
		escribirLinea("""
				===== BlackJack =====
				1) Jugar 
				2) Salir 
				""");
	}
	
	public void vaciarConsola() {
		for(int i=0; i<50; i++) {
			escribirLinea("");
		}
	}
	
}
