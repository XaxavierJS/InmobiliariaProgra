package controllers;

import entities.Arrendatario;
import models.ArrendatarioModel;
import Utils.Utils;

import java.util.Scanner;

public class ArrendatarioController {
    private ArrendatarioModel arrendatarioModel;

    public ArrendatarioController(ArrendatarioModel model) {
        this.arrendatarioModel = model;
    }
    public void mostrarTodosArrendatarios() {
        arrendatarioModel.mostrarArrendatarios();  // Llama al método para mostrar todos los arrendatarios
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
                    System.out.print("Ingrese el nombre del arrendatario: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el RUT del arrendatario: ");
                    String rut = scanner.nextLine();
                    System.out.print("Ingrese el correo del arrendatario: ");
                    String correo = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del arrendatario: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingrese el contrato del arrendatario: ");
                    String contrato = scanner.nextLine();

                    arrendatarioModel.agregarArrendatario(new Arrendatario(nombre, rut, correo, telefono, contrato));
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
