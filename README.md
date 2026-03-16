
# Blackjack Java Console Edition

Un simulador del juego de casino **Blackjack (21)** desarrollado en Java, diseñado para ejecutarse en terminal. 
Este proyecto implementa una arquitectura orientada a objetos (POO) robusta, separando la lógica de negocio de la interfaz de usuario.

##  Explicación del Juego

El objetivo es acercarse lo más posible a **21 puntos** sin pasarse. El juego enfrenta a dos jugadores en una competencia por turnos.

* **Regla del As:** El sistema detecta automáticamente si un As debe valer 11 o 1 punto para beneficiar la mano del jugador y evitar que quede eliminado.
* **Figuras:** J, Q y K tienen un valor fijo de 10 puntos.

## Arquitectura del Sistema

El proyecto está organizado en dos paquetes principales para mantener el principio de responsabilidad única:

### 1. Paquete `blackjack.dominio` (Capa de Lógica)

Gestiona las reglas puras del juego (como la regla del AS y el valor de las  figuras):

* **`Carta`**: Clase inmutable que combina un  enum `TipoCarta` y un enum `Palo`.
* **`Baraja`**: Es la clase encargada de controlar el mazo de 52 cartas, su inicialización, mezcla y autorreinicio cuando se agotan las existencias.
* **`Mano`**: Es la clase contenedora de cartas de cada jugador. Incluye el algoritmo de cálculo de puntuación dinámica para los Ases.
* **`Palo` & `TipoCarta` (Enums)**: Definen los valores (11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 19) y símbolos (❤️, ♠️, ♦️, ♣️) de forma tipada y segura.

### 2. Paquete `blackjack.app` (Capa de Aplicación)

Gestiona la ejecución y la interacción:

* **`GestorPartida`**: Es la clase que dirige el flujo de la partida (rondas, repartos iniciales, turnos de decisión y determinación del ganador).
* **`Jugador`**: Es la clase que representa a cada participante con su apodo y su mano asociada.
* **`Consola`**: La clase encargada de la utilidad para la entrada/salida de datos, con validaciones para evitar errores de tipo (`InputMismatchException`) o rangos inválidos.
* **`Main`**: Es el punto de entrada que inicializa los componentes y arranca el ciclo de juego.

##  Características Técnicas

* **Cálculo Inteligente:** Algoritmo para ajustar el valor del As entre 11 y 1 según la suma total.
* **Validación:** Control estricto de entradas por consola para garantizar que el programa no se detenga por errores del usuario.
* **Interfaz Visual en Consola:** Uso de símbolos UTF-8 para una representación clara de los palos de la baraja.
* **Código Documentado:** Uso extensivo de JavaDoc para explicar el propósito de cada método y clase.

##  Flujo de Partida

1. **Inicio:** Selección de la opción "Jugar" y registro de apodos.
2. **Reparto Inicial:** Se elige recibir 1 o 2 cartas de inicio.
3. **Turnos:** Cada jugador elige en cada ronda si quiere **Carta (C)** o **Plantarse (P)**.
4. **Finalización:** La partida termina si alguien se pasa de 21 o si ambos deciden plantarse. El gestor compara puntuaciones y anuncia al ganador o el empate.

---

**Desarrollado por:** SMEFRAG2310 / RGONCAR723
**Versión:** 1.0

**Proyecto Académico:** Ciclo Formativo de Grado Superior - Desarrollo de Aplicaciones Multiplataforma (DAM).
