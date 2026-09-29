package reto1;

import java.util.Scanner;

public class Cine {

	public static void main(String[] args) {

		int adulticket;
		int infaticket;

		int adultictotal = 0;
		int infatictotal = 0;

		int numtotal = 0;
		double preciofinal;
		double preciototal = 0;

		int maxetrada = 0;
		int clientemax = 0;

		// El (Scanner) es para escanear lo que el usuario escribe.
		// (System.in) signigica (entrada del sistema).
		Scanner cs = new Scanner(System.in);
		
		// Validacion del registro de clientes en la sesion. (Tiene que ser mayor a 1)
		int regis = 0;
		do  {
			System.out.println("¿Cuántos clientes se van a registrar para la sesión?:");
			if (cs.hasNextInt()) {
				regis = cs.nextInt();
				if (regis < 1) {
					System.out.println("El número introducido debe ser al menos 1.");
				}
			} else {
				System.out.println("Has introducido letras o símbolos. Introduce un número.");
				cs.next(); // Limpia la entrada errónea
			}
		} while (regis < 1);
		
		// Bucle para procesar cada cliente uno a uno.
		for (int i = 1; i <= regis; i++) {
			System.out.println("\n***REGISTRO DEL CLIENTE " + i + "***");
			
		adulticket = -1;
		do {
			//Pedimos las entradas de los adultos.
			System.out.println("Entradas de adultos:");
			if (cs.hasNextInt()) {
				adulticket = cs.nextInt();
				if (adulticket < 0) {
					System.out.println("El número introducido no puede ser negativo.");
				}
			} else {
				System.out.println("Has introducido letras o símbolos. Introduce un número.");
				cs.next();
			}
		} while (adulticket < 0);
		
		infaticket = -1;
		do {
			//Pedimos las entradas de los niños.
			System.out.println("Entradas de infantiles:");
			if (cs.hasNextInt()) {
				infaticket = cs.nextInt();
				if (infaticket < 0) {
					System.out.println("El número introducido no puede ser negativo.");
				}
			} else {
				System.out.println("Has introducido letras o símbolos. Introduce un número.");
				cs.next();
			}
		} while(infaticket < 0);
			
			// El primer calculo es el total de entradas de los clientes. Tiene que haber comprado 1 entrada por lo menos.
			numtotal = adulticket + infaticket;
			if (numtotal < 1) {
				System.out.println("Minimo 1 entrada tienes que comprar. Reinicio registro del cliente.");
				i--; // Le restamos una a i para que vuelva a preguntarle al mismo cliente.
				continue; // Repite el bucle for
			}
			
			// Calculamos el precio total de los adultos y los niños(los adultos valen 9€ y los infantiles 6€)
			preciofinal = adulticket * 9 + infaticket * 6;
			
			// Descuento del 10% para el que compre mas de 5 entradas.
			if (numtotal >= 5) {
				preciofinal = preciofinal * 0.90;
			}
			// Imprime al cliente los ticket que ha comprado para los adultos y los niños.
			System.out.println("\n==== Datos ====");
			System.out.println("Entradas de adulto: " + adulticket);
			System.out.println("Entradas de infantiles: " + infaticket);
			System.out.println("Total de entradas: " + numtotal);
			System.out.println("Precio a pagar: " + preciofinal);
			
			// Acumulador del programa
			preciototal += preciofinal;
			adultictotal += adulticket;
			infatictotal += infaticket;
			
			// Para saber quien de los clientes es el que compro mas entradas.
			if (numtotal > maxetrada) {
				maxetrada = numtotal;
				clientemax = i;
			}
		}
		
		// Resumen final
		System.out.println("\n==== Resultado de dia ====");
		System.out.println("Total recaudado: " + preciototal);
		System.out.println("Total de entradas de adulto: " + adultictotal);
		System.out.println("Total de entradas de infantiles: " + infatictotal);
		System.out.println("El cliente " + clientemax + " que compro " + maxetrada + " entradas.");
		
		// Cerramos el objeto Scanner para liberar los recursos.
		cs.close();
	}

}