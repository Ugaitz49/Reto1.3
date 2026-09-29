package reto1;

import java.util.Scanner;

public class Videojuego {

	public static void main(String[] args) {

		Scanner cs = new Scanner(System.in);
		int partidas;
		int puntos;
		int enemigos;

		int puntotal;
		int enemitotal;
		double media;
		int numjugador = 0;

		int maxPun = -1; // Se pone en -1 para que cualquier puntuación (que siempre será 0 o más) supere ese valor inicial
		int mejorJugador = 0;
		int punGlobal = 0;
		int enemitotalglobla = 0;

		// Validación de entrada con do-while + cs.hasNextInt() para prevenir letras
		do {
			System.out.println("Introduce cuantos jugadores se van a registrar:");
			if (cs.hasNextInt()) {
				numjugador = cs.nextInt();
				if (numjugador < 1) {
					System.out.println("Introduce un jugador por lo menos");
				}
			} else {
				System.out.println("Has introducido letras o simbolos. Introduce un numero.");
				cs.next();
			}
		} while (numjugador < 1);

		// Bucle exterior para procesar cada jugador
		for (int i = 1; i <= numjugador; i++) {
			System.out.println("\nRegistro de jugador " + i);

			partidas = 0;
			do {
				System.out.println("¿Cuántas partidas ha jugado el jugador " + i + "?:");
				if (cs.hasNextInt()) {
					partidas = cs.nextInt();
					if (partidas < 1) {
						System.out.println("Debe haber jugado al menos 1 partida.");
					}
				} else {
					System.out.println("Has introducido letras o símbolos. Introduce un número.");
					cs.next();
				}
			} while (partidas < 1);

			// Reinicio de acumuladores para el jugador actual
			puntotal = 0;
			enemitotal = 0;

			// Bucle para registrar cada partida del jugador
			for (int p = 1; p <= partidas; p++) {
				System.out.println("\n--- Partida " + p + " ---");

				puntos = 0;
				// Validar puntos de la partida
				do {
					System.out.print("Puntos conseguidos: ");
					if (cs.hasNextInt()) {
						puntos = cs.nextInt();
						if (puntos < 1) {
							System.out.println("Los puntos deben ser al menos 1.");
						}
					} else {
						System.out.println("Has introducido letras o símbolos. Introduce un número.");
						cs.next(); // Limpia la entrada
					}
				} while (puntos < 1);

				enemigos = 0;
				// Validar enemigos
				do {
					System.out.print("Enemigos derrotados: ");
					if (cs.hasNextInt()) {
						enemigos = cs.nextInt();
						if (enemigos < 1) {
							System.out.println("El número de enemigos debe ser al menos 1.");
						}
					} else {
						System.out.println("Has introducido letras o símbolos. Introduce un número.");
						cs.next(); // Limpia la entrada
					}
				} while (enemigos < 1);

				// Consigues un bonus cuando llegas a los 1000 puntos
				if (puntos > 1000) {
					puntos += 100;
					System.out.println("Sumas 100 puntos extra por superar los 1000 puntos.");
				}

				// Acumular puntos y enemigos de la partida
				puntotal += puntos;
				enemitotal += enemigos;
			}

			// Calcular media y mostrar resumen del jugador
			media = (double) puntotal / partidas;

			System.out.println("\n=== Resultado del Jugador " + i + " ===");
			System.out.println("Puntuación total (con bonus): " + puntotal);
			System.out.println("Enemigos derrotados: " + enemitotal);
			System.out.println("Puntuación media por partida: " + media);

			// Acumular globales y comprobar el mejor jugador
			punGlobal += puntotal;
			enemitotalglobla += enemitotal;

			if (puntotal > maxPun) {
				maxPun = puntotal;
				mejorJugador = i;
			}
		}

		// Imprimir estadísticas finales
		System.out.println("\n=================================");
		System.out.println("       ESTADÍSTICAS FINALES      ");
		System.out.println("=================================");
		System.out.println("Jugador con mayor puntuación: Jugador " + mejorJugador + " (con " + maxPun + " puntos)");
		System.out.println("Puntuación total entre todos: " + punGlobal);
		System.out.println("Enemigos derrotados entre todos: " + enemitotalglobla);

		cs.close();
	}
}