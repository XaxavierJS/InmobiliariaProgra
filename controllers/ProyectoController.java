// controllers/ProyectoController.java
package controllers;

import models.ProyectoModel;
import entities.Departamento;
import utils.Utils;

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
                    proyectoModel.agregarProyecto(scanner);
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
