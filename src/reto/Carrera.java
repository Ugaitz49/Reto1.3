package reto;

import java.util.Scanner;

public class Carrera {

    public static void main(String[] args) {

        Scanner cs = new Scanner(System.in);
        String dni;
        int individual = 0;
        int parejas = 0;
        int opcion;

        int RegParT = 0;
        int RC3 = 0;
        int RTM60m = 0;

        int TiempoMedio = 0;
        int TiempoTotal = 0;


        int min = Integer.MAX_VALUE;

        int respuesta;
        int RC = 0;

        do {
        	do {
        	    System.out.println("Introduce tu DNI");
        	     dni = cs.next();

        	    if (dni.length() != 8) {
        	        System.out.println("El DNI debe tener exactamente 8 caracteres.");
        	    }
        	} while (dni.length() != 8);
            
            boolean sb = false;

            while (sb == false) {

                System.out.println("Introduzca en que carrera participará:"
                        + "\n1 Individual 1"
                        + "\n2 Parejas 2");

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

            boolean sb2 = false;

            while (sb2 == false) {

                System.out.println("Introduzca el numero de carreras populares que ha participado anteriormente");

                int carreras = cs.nextInt();

                if (carreras >= 0) {

                    sb2 = true;

                    if (carreras > 0) {
                        RC++;
                    }

                    if (carreras >= 3) {
                        RC3++;
                    }

                } else {

                    System.out.println("El numero no puede ser menor que 0");
                }
            }

            boolean sb3 = false;

            int minutos;
            int segundos;

            do {

                System.out.println("Introduzca los minutos realizados");
                minutos = cs.nextInt();

                System.out.println("Introduzca los segundos realizados");
                segundos = cs.nextInt();

                if (minutos < 0 || segundos < 0 || segundos >= 60) {

                    System.out.println("El tiempo introducido no es válido");

                } else {

                    sb3 = true;
                }

            } while (sb3 == false);


            // Convertimos los minutos y segundos a segundos
            int tiempoRealizado = minutos * 60 + segundos;


            // Comprobamos si ha terminado en menos de 60 minutos
            if (tiempoRealizado < 3600) {
                RTM60m++;
            }


            // Sumamos el tiempo al tiempo total
            TiempoTotal += tiempoRealizado;

            // Aumentamos el número de participantes
            RegParT++;

            // Calculamos el tiempo medio
            TiempoMedio = TiempoTotal / RegParT;


            // Comprobamos si es el mejor tiempo
            if (tiempoRealizado < min) {
                min = tiempoRealizado;
            }


            System.out.println("¿Quieres registrar otro participante?"
                    + "\n1 Si 1"
                    + "\n2 No 2");

            respuesta = cs.nextInt();

            sb = false;

        } while (respuesta == 1);


        // Convertimos el tiempo medio de segundos a minutos y segundos
        int minutosMedio = TiempoMedio / 60;
        int segundosMedio = TiempoMedio % 60;


        // Convertimos el mejor tiempo de segundos a minutos y segundos
        int minutosMejor = min / 60;
        int segundosMejor = min % 60;


        // Mostramos los resultados
        System.out.println(RegParT + " se han registrado");

        System.out.println(RC3
                + " han participado anteriormente en más de 3 carreras");

        System.out.println(RTM60m
                + " han terminado la carrera en menos de 60 minutos");

        System.out.println("Tiempo medio: "
                + minutosMedio + " minutos y "
                + segundosMedio + " segundos");

        System.out.println("Mejor tiempo: "
                + minutosMejor + " minutos y "
                + segundosMejor + " segundos");
        cs.close();
    }
}