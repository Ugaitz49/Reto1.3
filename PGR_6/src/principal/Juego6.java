package principal;

import java.util.Scanner;

public class Juego6 {

	public static void main(String[] args) {
		int pmedia;
		double media;
		int partida;
		int puntos;
		int enemigos;
		int total;
		int totale;
		Scanner cs = new Scanner(System.in);
		System.out.println("\n------ Registro del Jugador -----");
		System.out.println("¿Cuántos jugadores se van a registrar?:");
		int jugadores = Integer.parseInt(cs.nextLine());

		for (int i = 1; i <= jugadores; i++) {
			System.out.println("\n------ Registro de los Datos del Jugador " + i + " -----");
			System.out.println("Intoduzca las partidas jugadas: ");
			partida = Integer.parseInt(cs.nextLine());

			System.out.println("Intoduzca los puntos obtenidos: ");
			puntos = Integer.parseInt(cs.nextLine());

			System.out.println("Intoduzca los enemigos derrotados: ");
			enemigos = Integer.parseInt(cs.nextLine());

			total += puntos;
			totale += enemigos;
			
			
			

			}

		}

		cs.close();
	}
}
