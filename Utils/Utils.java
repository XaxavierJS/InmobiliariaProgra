// utils/Utils.java
package Utils;

import java.util.Scanner;

public class Utils {

    public static int leerOpcionUsuario(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        return opcion;
    }

    public static int leerEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        int entero = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        return entero;
    }

    public static boolean leerBoolean(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Por favor, ingrese 'true' o 'false'.");
            scanner.next();
        }
        boolean valor = scanner.nextBoolean();
        scanner.nextLine();  // Consumir el salto de línea
        return valor;
    }

    public static void mostrarMenu() {
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Gestionar Departamentos");
        System.out.println("2. Gestionar Arrendatarios");
        System.out.println("3. Gestionar Proyectos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
}
