// controllers/ArrendatarioController.java
package controllers;

import models.ArrendatarioModel;
import Utils.Utils;

import java.util.Scanner;

public class ArrendatarioController {
    private ArrendatarioModel arrendatarioModel;

    public ArrendatarioController(ArrendatarioModel model) {
        this.arrendatarioModel = model;
    }

    public void gestionarArrendatarios(Scanner scanner) {
        while (true) {
            System.out.println("=== Gestión de Arrendatarios ===");
            System.out.println("1. Agregar Arrendatario");
            System.out.println("2. Ver Arrendatarios");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = Utils.leerOpcionUsuario(scanner);

            switch (opcion) {
                case 1:
                    arrendatarioModel.agregarArrendatario(scanner);
                    break;
                case 2:
                    arrendatarioModel.mostrarArrendatarios();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
