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
		int media;
		int numjugador;
		do {
			System.out.println("Introduce cuantos jugadores se van a registrar:");
			numjugador = cs.nextInt();
			if (numjugador < 1) {
				System.out.println("Introduce un jugador por lo menos.");
			}
		} while (numjugador < 1);
		
		for (int i = 1; i <= numjugador; i++) {
			System.out.println("/nRegistro de jugador " + i);
			
		do {
			System.out.println("Cuantos puntos conseguiste en la partida:");	
			puntos = cs.nextInt();
			if (puntos < 1) {
				System.out.println("Introduce una puntuacion mas alta que 1. Intentalo de nuevo.");
			}
		} while (puntos < 1);
		
		do {
			System.out.println("Introduce enemigos derrotados:");
			enemigos = cs.nextInt();
			if (enemigos < 1) {
				System.out.println("Tienes que poner mas de 1. Intentalo de nuevo.");
			}
		} while(enemigos <1);
		System.out.println("\nResultado jugado");
		System.out.println("Los puntos conseguidos: " + puntos);
		System.out.println("El numero de enemigos derrotados son " + enemigos);
		}
	}

}
