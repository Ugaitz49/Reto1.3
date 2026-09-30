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
		// En este do hacemos el control de personas
		do {
			System.out.println("Cuantas personas se van a registrar?");
			numP = sc.nextInt();

			if (numP <= 0) {
				System.out.println("Error, debe haber al menos una persona");
			}

		} while (numP <= 0);
		// En este for hacemos un bucle completo sobre personas, donde entrara en el do
		// y se guardara la informacion de cada persona
		for (int persona = 1; persona <= numP; persona++) {
			double total = 0;

			System.out.println("Persona " + persona);
			// En este do hacemos la eleccion de la persona y el calculo propio
			do {
				System.out.println("\n1. Coches " + "\n2. Autobus " + "\n3. Bicicleta " + "\n4. Plancha "
						+ "\n5. Ordenador " + "\n6. Movil " + "\n7. Salir ");
				opcion = sc.nextInt();

				if (opcion < 1 || opcion > 7) {
					System.out.println("introduce un numero valido (del 1 al 7)");
				}

				switch (opcion) {

				case 1:

					do {
						System.out.println("¿Cuantos KM has recorrido en coche?");
						kmC = sc.nextDouble();

						if (kmC < 1) {
							System.out.println("El numero no puede ser menor que 1");
						}

					} while (kmC < 1);

					kmC = kmC * 0.21;
					System.out.println("Co2 usado con el coche: " + kmC);
					total += kmC;
					totalCoche += kmC;

					break;

				case 2:

					do {
						System.out.println("¿Cuantos KM has recorrido en autobus?");
						kmA = sc.nextDouble();

						if (kmA < 1) {
							System.out.println("El numero no puede ser menor que 1");
						}

					} while (kmA < 1);

					kmA = kmA * 0.10;
					System.out.println("Co2 usado con el autobus: " + kmA);
					total += kmA;
					totalAutobus += kmA;

					break;

				case 3:

					do {
						System.out.println("¿Cuantos KM has recorrido en bicicleta?");
						bici = sc.nextDouble();

						if (bici < 1) {
							System.out.println("El numero no puede ser menor que 1");
						}

					} while (bici < 1);

					bici = bici * 0;
					System.out.println("0 CO2 por km: " + bici);
					total += bici;

					break;

				case 4:

					System.out.println("Has usado la plancha? 1.Si | 2.No");
					pl = sc.nextInt();

					if (pl == 1) {

						do {
							System.out.println("¿Cuantas horas lo has utilizado?");
							upL = sc.nextDouble();

							if (upL < 1) {
								System.out.println("El numero no puede ser menor que 1");
							}

						} while (upL < 1);

						upL = upL * 0.70;
						System.out.println("Co2 usado en la plancha: " + upL);
						total += upL;
						totalPlancha += upL;

					} else if (pl == 2) {

						System.out.println("Entendido, te llevo de vuelta el menu");
					}

					break;

				case 5:

					do {
						System.out.println("¿Cuantas horas has utilizado el ordenador?");
						or = sc.nextDouble();

						if (or < 1) {
							System.out.println("El numero no puede ser menor que 1");
						}

					} while (or < 1);

					or = or * 0.08;
					System.out.println("Co2 usado en el ordenador: " + or);
					total += or;
					totalOrdenador += or;

					break;

				case 6:

					do {
						System.out.println("¿Cuantas horas has utilizado el movil?");
						mv = sc.nextDouble();

						if (mv < 1) {
							System.out.println("El numero no puede ser menor que 1");
						}

					} while (mv < 1);

					mv = mv * 0.02;
					System.out.println("Co2 usado en el movil: " + mv);
					total += mv;
					totalMovil += mv;

					break;
				case 7:
					System.out.println("has finalizado persona " + persona + ", este es tu uso de Co2: " + total);
				}

			} while (opcion != 7);
			// Esto es del for, osea que cada vez que termine el do, se sumara la
			// informacion de cada persona por cada vuelta del for
			totalG += total;

		}
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
		System.out.println("\nEste es el total entre todos: " + totalG);
		System.out.println("\nLa media de CO2 por persona es: " + media);
		System.out.println("\nLa actividad que mas CO2 genera es: " + actividad);
		System.out.println("\nCO2 generado por esta actividad: " + mayor);

	}
}
