package principal;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;

import java.util.Scanner;

public class Revisiones3 {

	public static void main(String[] args) {
		Scanner cs = new Scanner(System.in);
		boolean salir = false;

		// Fecha actual al principio
		System.out.println("--- FECHA ACTUAL ---");
		System.out.println("Introduzca el día actual:");
		int diaActual = Integer.parseInt(cs.nextLine());

		System.out.println("Introduzca el mes actual:");
		int mesActual = Integer.parseInt(cs.nextLine());

		System.out.println("Introduzca el año actual:");
		int anoActual = Integer.parseInt(cs.nextLine());

		LocalDate fechaActual = LocalDate.of(anoActual, mesActual, diaActual);

		// Contadores para las bicicletas
		int contNecesitan = 0;
		int contNoNecesitan = 0;

		// Bucle para registrar las bicicletas
		while (!salir) {
			System.out.println("\nIntroduzca el número de identificación de la bicicleta:");
			int identificacion = Integer.parseInt(cs.nextLine());

			System.out.println("Introduzca el día de la última revisión:");
			int dia = Integer.parseInt(cs.nextLine());

			System.out.println("Introduzca el mes de la última revisión:");
			int mes = Integer.parseInt(cs.nextLine());

			System.out.println("Introduzca el año de la última revisión:");
			int ano = Integer.parseInt(cs.nextLine());

			LocalDate fechaRevision = LocalDate.of(ano, mes, dia);

			System.out.println("Bicicleta: " + identificacion);
			System.out.println("Última revisión: " + fechaRevision);

			/*
			 * Comparar si ha pasado más de un año
			 *
			 */
			if (fechaRevision.plusYears(1).isBefore(fechaActual)) {
				System.out.println("Esta bicicleta necesita revisión.");
				contNecesitan++;
			} else {
				System.out.println("Esta bicicleta NO necesita revisión.");
				contNoNecesitan++;
			}

			System.out.println("¿Quiere registrar otra bicicleta? Conteste S o N");
			String respuesta = cs.nextLine();

			if (respuesta.equalsIgnoreCase("n")) {
				salir = true;
			}
		}

		System.out.println("\n--- RESUMEN FINAL ---");
		System.out.println("Bicicletas que necesitan revisión: " + contNecesitan);
		System.out.println("Bicicletas que no necesitan revisión: " + contNoNecesitan);

		cs.close();
	}
}