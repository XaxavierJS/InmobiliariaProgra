// controllers/ProyectoController.java
package controllers;

import models.ProyectoModel;
import entities.Departamento;
import Utils.Utils;
import entities.Proyecto;
import java.util.List;
import java.util.Scanner;

public class ProyectoController {
    private ProyectoModel proyectoModel;

    public ProyectoController(ProyectoModel model) {
        this.proyectoModel = model;
    }

    public void gestionarProyectos(Scanner scanner, List<Departamento> departamentosDisponibles) {
        while (true) {
            System.out.println("=== Gestión de Proyectos ===");
            System.out.println("1. Agregar Proyecto");
            System.out.println("2. Ver Proyectos");
            System.out.println("3. Agregar Departamento a Proyecto");
            System.out.println("4. Mostrar Departamentos de un Proyecto");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = Utils.leerOpcionUsuario(scanner);

            switch (opcion) {
                case 1:
                    // Solicitar los datos del proyecto
                    System.out.print("Ingrese el nombre del proyecto: ");
                    String nombreProyecto = scanner.nextLine();
                    System.out.print("Ingrese la ubicación del proyecto: ");
                    String ubicacion = scanner.nextLine();

                    // Crear el proyecto y agregarlo al modelo
                    Proyecto nuevoProyecto = new Proyecto(nombreProyecto, ubicacion);
                    proyectoModel.agregarProyecto(nuevoProyecto);
                    break;
                case 2:
                    proyectoModel.mostrarProyectos();
                    break;
                case 3:
                    proyectoModel.agregarDepartamentoAProyecto(scanner, departamentosDisponibles);
                    break;
                case 4:
                    proyectoModel.mostrarDepartamentosDeProyecto(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
