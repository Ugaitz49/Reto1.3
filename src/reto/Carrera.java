package reto;

import java.util.Scanner;

public class Carrera {

	public static void main(String[] args) {
		Scanner cs = new Scanner(System.in);
		// Contador de participantes en carrera individual
		int individual = 0;
		// Contador de participantes en parejas
		int parejas = 0;
		// Guarda la opción de carrera elegida
		int opcion;
		// Contador de participantes registrados
		int ParReg = 0;
		// Número total de participantes registrados
		int RegParT = 0;
	    // Contador de personas que han participado en 3 o más carreras anteriormente
		int RC3 = 0;
		// Contador de personas que han terminado en menos de 60 minutos
		int RTM60m = 0;
		// Guarda el tiempo medio
		int TiempoMedio = 0;
		// Guarda la suma de todos los tiempos
		int TiempoTotal=0;
		// Valores que representan las respuestas Sí y No
		int Si = 1;
		int No = 2;
		// Empezamos con el valor máximo posible para poder buscar el menor tiempo
		int min = Integer.MAX_VALUE;
		// Guarda la respuesta de si queremos registrar otro participante
		int respuesta;
		// Contador de personas que han participado anteriormente en alguna carrera
		int RC = 0;
		 
		// BUCLE PRINCIPAL
        // Se repite mientras el usuario quiera registrar participantes
		do {
			// Pedimos el DNI del participante
			System.out.println("Introduce tu DNI");
			String dni = cs.next();
			// BUCLE PARA ELEGIR EL TIPO DE CARRERA
			boolean sb = false;
			while (sb == false) {
				System.out.println("Introduzca en que carrera participará:" + "\n1 Individual 1 \n2 Parejas 2");
				opcion = cs.nextInt();
				if (opcion == 1) {
					individual++;
					sb = true;
				}
				if (opcion == 2) {
					parejas++;
					sb = true;
				}
			}
			// BUCLE PARA LAS CARRERAS ANTERIORES
			boolean sb2 = false;
			while (sb2 == false) {
				System.out.println("Introduzca el numero de carreras populares que ha participado anteriormente");
				int carreras = cs.nextInt();
				if (carreras > 0) {
					RC++;
					sb2 = true;
				}
				if (carreras >= 3) {
					RC3++;
					sb2 = true;

				} if(carreras < 0) {
					System.out.println("El numero no puede ser menor que 0");
				}
				 
			}
			// BUCLE PARA INTRODUCIR EL TIEMPO
			boolean sb3 = false;
			int tiempoRealizado;
			do {

				System.out.println("Introduzca el tiempo realizado en la carrera");
				tiempoRealizado = cs.nextInt();

				if (tiempoRealizado <= 0) {
					System.out.println("No puedes introducir numeros negativos");
				} else {
					sb3 = true;
				}

			} while (sb3 == false);

			if (tiempoRealizado < 60) {
				RTM60m++;
			} else {

			}
			// CALCULAMOS EL TIEMPO TOTAL Y EL TIEMPO MEDIO
			TiempoTotal +=tiempoRealizado;
			RegParT++;
			TiempoMedio = TiempoTotal / RegParT;
			//BUSCAMOS EL MEJOR TIEMPO
			if (tiempoRealizado < min) {
				min = tiempoRealizado;
			}
			// PREGUNTAMOS SI QUIERE REGISTRAR OTRO PARTICIPANTE
			System.out.println("¿Quieres registrar otro participante?" + "\n1 Si 1" + "\n2 No 2");
			respuesta = cs.nextInt();
			sb = false;

		} while (respuesta == 1);
		 // MOSTRAMOS LOS RESULTADOS FINALES
		System.out.println(RegParT + " se han registrado");
		System.out.println(RC3 + " han participado anteriormente en más de 3 carreras");
		System.out.println(RTM60m + " han terminado la carrera en menos de 60 minutos");
		System.out.println(" Tiempo medio " + TiempoMedio);
		System.out.println("Mejor tiempo " + min);
	}
}


