package reto1;

import java.util.Scanner;

public class Cine {

	public static void main(String[] args) {
		// El (Scanner) es para escanear lo que el usuario escribe.
		// (System.in) signigica (entrada del sistema).

		int adulticket;
		int adultictotal;

		int infanticket;
		int infantictotal;

		int numtotal;
		

		double preciototal;

		Scanner cs = new Scanner(System.in);

		System.out.println("¿Cuantos clientes se van a registrar para la sesion?");
		int regist = Integer.parseInt(cs.nextLine());
		
		for (int i = 1; i <= regist; i++) {
			System.out.println("\n-- Registro del Cliente " + i + "--");
			
			System.out.println("¿Cuántas entradas de adulto desea?");
			adulticket = cs.nextInt();
			
			System.out.println("¿Cuántas entradas de infantiles desea?");
			infanticket = cs.nextInt();
			
			numtotal = adulticket + infanticket;
			preciototal = adulticket * 9 + infanticket * 6;
			
			if (numtotal >= 5) {
				preciototal = preciototal * 0.90;
			}
			
		}

		cs.close();
	}

}
