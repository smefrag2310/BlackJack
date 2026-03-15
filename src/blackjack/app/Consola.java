package blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Esta es la clase encargada de gestionar la interacción por consola con el usuario.
 * Permite mostrar mensajes, leer distintos tipos de entrada y validar que
 * los datos introducidos sean correctos y los buscados.
 * @author SMEFRAG2310
 */

public class Consola {

	private Scanner sc;
	/**
	 * Constructor que inicializa el objeto {@code Scanner}.
	 */
	public Consola() {
		sc= new Scanner(System.in);
	}
	/**
	 * Muestra un texto en consola sin salto de línea.
	 * 
	 * @param texto texto a mostrar por consola
	 */
	public void escribir(String texto) {
		System.out.print(texto);
	}
	/**
	 * Muestra un texto en consola seguido de salto de línea
	 * 
	 * @param texto texto a mostrar por consola
	 */
	public void escribirLinea(String texto) {
		System.out.println(texto);
	}
	/**
	 * 
	 * Lee una cadena introducida por el usuario
	 * 
	 * @param mensaje mensaje que se muestra antes de solicitar datos
	 * @return String texto introducido por el usuario sin espacios laterales
	 */
	public String leerTexto(String mensaje) {
		String texto;

		escribir(mensaje);
		texto = sc.nextLine();

		return texto.trim();
	}
	/**
	 *  * Lee una cadena no vacía introducida por el usuario.
     * Si el usuario introduce una cadena vacía o solo espacios,
     * se solicitará nuevamente.
	 * 
	 * @param mensaje mensaje que se muestra antes de solicitar datos
	 * @return String texto del usuario
	 */
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
	/**
	 * Lee un número entero introducido por el usuario.
     * Si el valor no es un entero válido, se solicitará nuevamente.
     *
	 * @return int con el número del usuario
	 */
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
	/**
	 * Lee un número entero dentro de un rango específico.
     * Si el valor introducido está fuera del rango, se solicitará nuevamente.
     *
     * @param menor límite inferior del rango (incluido)
     * @param mayor límite superior del rango (incluido)
     * @return int dentro del rango especificado
     */
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
	/**
	 * Muestra en consola el menu de la partida
	 */
	public void menuPartida() {
		escribirLinea("""
				
				===== BlackJack =====
				1) Jugar 
				2) Salir 
				""");
	}
	/**
     * Lee un único carácter introducido por el usuario.
     * Si se introduce más de un carácter, se solicitará nuevamente.
     *
	 * @return char con el caracter introducido
	 */
	public char readChar() {
		String input;
		do {
			input = sc.next();
			if (input.trim().length() != 1) {
				System.out.println("**Cadena inválida** Por favor, introduce un único carácter: ");
			}
		} while (input.length() != 1);
		sc.nextLine();
		return input.charAt(0);
	}
	/**
	 * Se encarga de que el usuario solo pueda introducir uno de los dos caracteres,
	 * en caso negativo lo volverá a pedir
	 * 
	 * @param affirmativeValue caracter que representa el valor {@code true}
	 * @param negativeValue caracter que representa el valor {@code false}
	 * @return boolean dependiendo del valor introducido
	 */
	public boolean readBooleanUsingChar(char affirmativeValue, char negativeValue) {
		char input;
		boolean character;
		character = true;

		do {
			input = readChar();
			if (Character.toLowerCase(input) == Character.toLowerCase(affirmativeValue)) {
				character = true;
			} else if (Character.toLowerCase(input) == Character.toLowerCase(negativeValue)) {
				character = false;
			} else {
				System.out.printf("**Carácter inválido** Introduce %s o %s para continuar: ", affirmativeValue,
						negativeValue);
			}
		} while (input != affirmativeValue && input != negativeValue);
		return character;
	}
	/**
	 * Vacía la consola cuando se decide por salir del juego
	 */
	public void vaciarConsola() {
		for(int i=0; i<50; i++) {
			escribirLinea("");
		}
	}
	
}
