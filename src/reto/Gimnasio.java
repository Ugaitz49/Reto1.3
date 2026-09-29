package reto;

import java.util.Scanner;

public class Gimnasio {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int usuarios;
		int totalMinutosTodos = 0;
		int totalDiasTodos = 0;
		int usuarioMasMinutos = 0;
		int maxMinutos = 0;
		do {
			System.out.print("¿Cuántos usuarios se van a registrar? ");
			usuarios = sc.nextInt();

			if (usuarios <= 0) {
				System.out.println("El numero no puede ser negativo");
			}
			
		} while (usuarios <= 0);
		
		// for para llevar el conteo de los usuarios que pillara todo y hara bucle dependiendo de la cantidad de usuarios introducidos 
		for (int i = 1; i <= usuarios; i++) {
			int dias;
			
			do {
			System.out.print("\n¿Cuántos días ha acudido el usuario " + i + "? ");
			dias = sc.nextInt();
			
			if (dias<=0) { 
				System.out.println("Tienes que poner minimo 1 dia, no puede ser 0 ");
			}
			
			}while(dias<=0);
		
			int minutosTotales = 0;
			int diasMas60 = 0;
			
			//for para hacer bucle de dias, si el usuario pone 4 se repetira este for 4 veces 
			for (int j = 1; j <= dias; j++) {
				System.out.print("Minutos realizados el día " + j + ": ");
				int minutos = sc.nextInt();
				minutosTotales += minutos;
				if (minutos > 60) {
					diasMas60++;
				}
			}
			
			//Esto es para sacar la media, el (double) es para pasar de enteros a double los minutostotales y dias
			double media = (double) minutosTotales / dias;
			System.out.println("\nMinutos totales del usuario " + i + ": " + minutosTotales);
			System.out.println("\nMedia de minutos por día: " + media);
			System.out.println("\nDías con más de 60 minutos: " + diasMas60);
			if (minutosTotales > 300) {
				System.out.println("\nHa alcanzado el objetivo semanal");
			}
			
			totalMinutosTodos += minutosTotales;
			totalDiasTodos += dias;
			
			//Esto saca el usuario que mas minutos ha hecho 
			if (minutosTotales > maxMinutos) {
				maxMinutos = minutosTotales;
				usuarioMasMinutos = i;
			}
		}
		System.out.println("\nEl usuario que realizó más minutos es el usuario " + usuarioMasMinutos );
		System.out.println("\nEl número total de minutos realizados es " + totalMinutosTodos);
		System.out.println("\nEl número total de días de entrenamiento es " + totalDiasTodos);
		sc.close();
	}
}

