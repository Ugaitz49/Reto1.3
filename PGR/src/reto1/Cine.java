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
		
		// Solicita cuantos clientes se van a registrar 
		System.out.println("¿Cuántos clientes se van a registrar para la sesión?:");
		int regis = Integer.parseInt(cs.nextLine());
		
		// Bucle para procesar cada cliente uno a uno.
		for (int i = 1; i <= regis; i++) {
			System.out.println("\n--- REGISTRO DEL CLIENTE " + i + " ---");
			
			//Pedimos las entradas de los adultos.
			System.out.println("Entradas de adultos:");
			adulticket = cs.nextInt();
			
			//Pedimos las entradas de los niños.
			System.out.println("Entradas de infantiles:");
			infaticket = cs.nextInt();
			
			// El primer calculo es el total de entradas de los clientes.
			numtotal = adulticket + infaticket;
			
			// Calculamos el precio total de los adultos y los niños(los adultos valen 9€ y los infantiles 6€)
			preciofinal = adulticket * 9 + infaticket * 6;
			
			
			if (numtotal >= 5) {
				preciofinal = preciofinal * 0.90;
			}
			// Imprime al cliente los ticket que ha comprado para los adultos y los niños.
			System.out.println("==== Datos ====");
			System.out.println("Entradas de adulto: " + adulticket);
			System.out.println("Entradas de infantiles: " + infaticket);
			System.out.println("Total de entradas: " + numtotal);
			System.out.println("Precio a pagar: " + preciofinal);

			preciototal += preciofinal;
			adultictotal += adultictotal;
			infatictotal += infatictotal;
			if (numtotal < maxetrada) {
				maxetrada = numtotal;
				clientemax = i;
			}
		}
		System.out.println("==== Resultado de dia ====");
		System.out.println("Total recaudado: " + preciototal);
		System.out.println("Total de entradas de adulto: " + adultictotal);
		System.out.println("Total de entradas de infantiles: " + adultictotal);
		System.out.println("El cliente " + clientemax + " que compro" + maxetrada);
		
		// Cerramos el objeto Scanner para liberar los recursos.
		cs.close();
	}

}