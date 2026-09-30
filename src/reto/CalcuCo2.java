package reto;

import java.util.Scanner;

public class CalcuCo2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int opcion;
		int numP;
		double kmA;
		double kmC;
		double bici;
		double upL;
		double pl;
		double or;
		double mv;
		double totalG = 0;
		double totalCoche = 0;
		double totalAutobus = 0;
		double totalPlancha = 0;
		double totalOrdenador = 0;
		double totalMovil = 0;

		String diasSem;

		// Control de número de personas
		do {
			System.out.println("Cuantas personas se van a registrar?");
			numP = sc.nextInt();

			if (numP <= 0) {
				System.out.println("Error, debe haber al menos una persona");
			}

		} while (numP <= 0);

		// Bucle principal por cada persona
		for (int persona = 1; persona <= numP; persona++) {
			double totalSemanaPersona = 0;

			System.out.println("REGISTRO PARA LA PERSONA " + persona);

			// Bucle para recorrer los 7 días de la semana
			for (int i = 0; i < 7; i++) {
				System.out.println("\n--- Día: " + i + " ---");

				do {
					System.out.println("\n1. Coches " + "\n2. Autobus " + "\n3. Bicicleta " + "\n4. Plancha "
							+ "\n5. Ordenador " + "\n6. Movil " + "\n7. Pasar al siguiente día / Salir");
					opcion = sc.nextInt();

					if (opcion < 1 || opcion > 7) {
						System.out.println("Introduce un numero valido (del 1 al 7)");
					}

					switch (opcion) {

					case 1:
						do {
							System.out.println("¿Cuantos KM has recorrido en coche?");
							kmC = sc.nextDouble();

							if (kmC < 0) {
								System.out.println("El numero no puede ser menor que 0");
							}

						} while (kmC < 0);

						kmC = kmC * 0.21;
						System.out.println("CO2 usado con el coche: " + kmC + " kg");
						totalSemanaPersona += kmC;
						totalCoche += kmC;
						break;

					case 2:
						do {
							System.out.println("¿Cuantos KM has recorrido en autobus?");
							kmA = sc.nextDouble();

							if (kmA < 0) {
								System.out.println("El numero no puede ser menor que 0");
							}

						} while (kmA < 0);

						kmA = kmA * 0.10;
						System.out.println("CO2 usado con el autobus: " + kmA + " kg");
						totalSemanaPersona += kmA;
						totalAutobus += kmA;
						break;

					case 3:
						do {
							System.out.println("¿Cuantos KM has recorrido en bicicleta?");
							bici = sc.nextDouble();

							if (bici < 0) {
								System.out.println("El numero no puede ser menor que 0");
							}

						} while (bici < 0);

						bici = bici * 0;
						System.out.println("0 CO2 por km: " + bici + " kg");
						totalSemanaPersona += bici;
						break;

					case 4:
						System.out.println("Has usado la plancha? 1.Si | 2.No");
						pl = sc.nextInt();

						if (pl == 1) {
							do {
								System.out.println("¿Cuantas horas la has utilizado?");
								upL = sc.nextDouble();

								if (upL < 0) {
									System.out.println("El numero no puede ser menor que 0");
								}

							} while (upL < 0);

							upL = upL * 0.70;
							System.out.println("CO2 usado en la plancha: " + upL + " kg");
							totalSemanaPersona += upL;
							totalPlancha += upL;

						} else if (pl == 2) {
							System.out.println("Entendido, te llevo de vuelta al menu");
						}
						break;

					case 5:
						do {
							System.out.println("¿Cuantas horas has utilizado el ordenador?");
							or = sc.nextDouble();

							if (or < 0) {
								System.out.println("El numero no puede ser menor que 0");
							}

						} while (or < 0);

						or = or * 0.08;
						System.out.println("CO2 usado en el ordenador: " + or + " kg");
						totalSemanaPersona += or;
						totalOrdenador += or;
						break;

					case 6:
						do {
							System.out.println("¿Cuantas horas has utilizado el movil?");
							mv = sc.nextDouble();

							if (mv < 0) {
								System.out.println("El numero no puede ser menor que 0");
							}

						} while (mv < 0);

						mv = mv * 0.02;
						System.out.println("CO2 usado en el movil: " + mv + " kg");
						totalSemanaPersona += mv;
						totalMovil += mv;
						break;

					case 7:
						System.out.println("Registro completado para el " + i);
						break;
					}

				} while (opcion != 7);
			}

			
			System.out.println("Has finalizado persona " + persona + ".");
			System.out.println("Tu total de CO2 acumulado en la semana es: " + totalSemanaPersona + " kg");

			if (totalSemanaPersona < 10) {
				System.out.println("Valoración: Excelente, tu huella de carbono es muy baja");
			} else if (totalSemanaPersona <= 30) {
				System.out.println("Valoración: Tu huella de carbono es moderada, puedes mejorar");
			} else {
				System.out.println("Valoración: Atención, tu huella de carbono es muy alta");
			}

			totalG += totalSemanaPersona;
		}

		// Cálculo final global
		double mayor = totalCoche;
		String actividad = "Coche";

		if (totalAutobus > mayor) {
			mayor = totalAutobus;
			actividad = "Autobus";
		}

		if (totalPlancha > mayor) {
			mayor = totalPlancha;
			actividad = "Plancha";
		}

		if (totalOrdenador > mayor) {
			mayor = totalOrdenador;
			actividad = "Ordenador";
		}

		if (totalMovil > mayor) {
			mayor = totalMovil;
			actividad = "Movil";
		}

		double media = totalG / numP;

		System.out.println("\nRESUMEN GENERAL DE TODAS LAS PERSONAS");
		System.out.println("Este es el total acumulado entre todos: " + totalG + " kg");
		System.out.println("La media de CO2 semanal por persona es: " + media + " kg");
		System.out.println("La actividad que mas CO2 genera en total es: " + actividad);
		System.out.println("CO2 generado por esta actividad: " + mayor + " kg");

		sc.close();
	}
}