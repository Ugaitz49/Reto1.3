package principal;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Revisiones3 {

    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        
        // Variable para salir del bucle
        boolean salir = false;

        // Fecha actual 
        System.out.println(" FECHA ACTUAL");
        System.out.println("Introduzca el día actual:");
        int diaActual = Integer.parseInt(cs.nextLine());

        System.out.println("Introduzca el mes actual:");
        int mesActual = Integer.parseInt(cs.nextLine());

        System.out.println("Introduzca el año actual:");
        int anoActual = Integer.parseInt(cs.nextLine());

        LocalDate fechaActual = LocalDate.of(anoActual, mesActual, diaActual);

        // Contadores que acumulan los resultados
        int contNecesitan = 0;
        int contNoNecesitan = 0;

        // Bucle While: se repite mientras !salir sea true
        while (!salir) {
            System.out.println("Introduzca el número de identificación de la bicicleta:");
            int identificacion = Integer.parseInt(cs.nextLine());

            // Validación: Si la identificación es negativa, la ignoramos
            if (identificacion < 0) {
                System.out.println(" El número de identificación no puede ser negativo.");
                
                System.out.println("¿Quiere registrar otra bicicleta? Conteste S o N");
                String respuesta = cs.nextLine();
                if (respuesta.equalsIgnoreCase("n")) {
                    salir = true;
                }
                continue; // Salta al siguiente ciclo del bucle para no contar esta bicicleta
            }

            System.out.println("Introduzca el día de la última revisión:");
            int dia = Integer.parseInt(cs.nextLine());

            System.out.println("Introduzca el mes de la última revisión:");
            int mes = Integer.parseInt(cs.nextLine());

            System.out.println("Introduzca el año de la última revisión:");
            int ano = Integer.parseInt(cs.nextLine());

            // Agrupa el día, mes y año introducidos en la fecha
            LocalDate fechaRevision = LocalDate.of(ano, mes, dia);

            System.out.println("Bicicleta: " + identificacion);
            System.out.println("Última revisión: " + fechaRevision);

            // Condicional IF: Comprueba si la fecha de revisión más un año es anterior a hoy
            if (fechaRevision.plusYears(1).isBefore(fechaActual)) {
                System.out.println("Esta bicicleta necesita revisión.");
                contNecesitan++;
            } else {
                System.out.println("Esta bicicleta NO necesita revisión.");
                contNoNecesitan++;
            }
            
            // Pregunta si quiere salir del bucle
            System.out.println("¿Quiere registrar otra bicicleta? Conteste S o N");
            String respuesta = cs.nextLine();
            
            if (respuesta.equalsIgnoreCase("n")) {
                salir = true;
            }
        }// Fin del bucle While

        System.out.println(" RESUMEN FINAL ");
        System.out.println("Bicicletas que necesitan revisión: " + contNecesitan);
        System.out.println("Bicicletas que no necesitan revisión: " + contNoNecesitan);
        
        cs.close();
    }
}
