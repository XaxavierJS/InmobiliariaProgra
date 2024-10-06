import controllers.ArrendatarioController;
import controllers.DepartamentoController;
import controllers.ProyectoController;
import models.ArrendatarioModel;
import models.DepartamentoModel;
import models.ProyectoModel;
import entities.Departamento;
import entities.Proyecto;
import entities.Arrendatario;
import Utils.Utils;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Modelos
        DepartamentoModel departamentoModel = new DepartamentoModel();
        ArrendatarioModel arrendatarioModel = new ArrendatarioModel();
        ProyectoModel proyectoModel = new ProyectoModel();

        // Controladores
        DepartamentoController departamentoController = new DepartamentoController(departamentoModel, arrendatarioModel);
        ProyectoController proyectoController = new ProyectoController(proyectoModel, departamentoController);

        // Datos iniciales - Proyectos y Departamentos
        Proyecto proyecto1 = new Proyecto("Proyecto Central", "Avenida Principal 123");
        Proyecto proyecto2 = new Proyecto("Proyecto Los Robles", "Calle Los Robles 456");

        // Agregar departamentos a los proyectos
        Departamento dep1_1 = new Departamento("Depa 101", "D101", 55000, true, "101", 3, 2, 120);
        Departamento dep1_2 = new Departamento("Depa 102", "D102", 60000, true, "102", 4, 3, 150);
        proyecto1.agregarDepartamento(dep1_1);
        proyecto1.agregarDepartamento(dep1_2);

        Departamento dep2_1 = new Departamento("Depa 201", "D201", 45000, true, "201", 2, 1, 100);
        Departamento dep2_2 = new Departamento("Depa 202", "D202", 50000, true, "202", 3, 2, 130);
        Departamento dep2_3 = new Departamento("Depa 203", "D203", 70000, true, "203", 4, 3, 170);
        proyecto2.agregarDepartamento(dep2_1);
        proyecto2.agregarDepartamento(dep2_2);
        proyecto2.agregarDepartamento(dep2_3);

        proyectoModel.agregarProyecto(proyecto1);
        proyectoModel.agregarProyecto(proyecto2);

        // Menú principal
        while (true) {
            System.out.println("=== Gestión de Proyectos ===");
            List<Proyecto> proyectos = proyectoController.obtenerProyectos();
            if (proyectos.isEmpty()) {
                System.out.println("No hay proyectos disponibles.");
                break;
            }

            // Mostrar proyectos con números
            for (int i = 0; i < proyectos.size(); i++) {
                System.out.println((i + 1) + ". " + proyectos.get(i).getNombreProyecto() + " - " + proyectos.get(i).getUbicacion());
            }

            System.out.print("Seleccione un proyecto por su número (o '0' para salir): ");
            int opcionProyecto = Utils.leerEntero(scanner, "Opción: ");

            if (opcionProyecto == 0) {
                System.out.println("Saliendo...");
                break;
            }

            if (opcionProyecto < 1 || opcionProyecto > proyectos.size()) {
                System.out.println("Opción no válida. Intente nuevamente.");
                continue;
            }

            // Obtener el proyecto seleccionado
            Proyecto proyectoSeleccionado = proyectos.get(opcionProyecto - 1);
            System.out.println("Has seleccionado: " + proyectoSeleccionado.getNombreProyecto());

            // Menú para gestionar el proyecto seleccionado
            while (true) {
                System.out.println("\n=== Gestión de Departamentos en " + proyectoSeleccionado.getNombreProyecto() + " ===");
                System.out.println("1. Agregar Departamento");
                System.out.println("2. Eliminar Departamento");
                System.out.println("3. Modificar Departamento");
                System.out.println("4. Seleccionar Departamento");
                System.out.println("0. Volver a la selección de proyectos");
                System.out.print("Seleccione una opción: ");
                int opcion = Utils.leerOpcionUsuario(scanner);

                switch (opcion) {
                    case 1:
                        departamentoController.agregarDepartamento(scanner, proyectoSeleccionado);
                        break;
                    case 2:
                        departamentoController.eliminarDepartamento(scanner, proyectoSeleccionado);
                        break;
                    case 3:
                        departamentoController.modificarDepartamento(scanner, proyectoSeleccionado);
                        break;
                    case 4:
                        // Seleccionar y gestionar departamento
                        Departamento departamentoSeleccionado = departamentoController.seleccionarDepartamento(scanner, proyectoSeleccionado);
                        if (departamentoSeleccionado != null) {
                            // Menú para gestionar arrendatarios del departamento seleccionado
                            while (true) {
                                System.out.println("\n=== Gestión de Arrendatarios en " + departamentoSeleccionado.getNombre() + " ===");
                                System.out.println("1. Agregar Arrendatario");
                                System.out.println("2. Eliminar Arrendatario");
                                System.out.println("3. Modificar Arrendatario");
                                System.out.println("0. Volver a la gestión de departamentos");
                                int opcionArrendatario = Utils.leerOpcionUsuario(scanner);

                                if (opcionArrendatario == 0) break;

                                switch (opcionArrendatario) {
                                    case 1:
                                        departamentoController.agregarArrendatario(scanner, departamentoSeleccionado);
                                        break;
                                    case 2:
                                        departamentoController.eliminarArrendatario(scanner, departamentoSeleccionado);
                                        break;
                                    case 3:
                                        departamentoController.modificarArrendatario(scanner, departamentoSeleccionado);
                                        break;
                                    default:
                                        System.out.println("Opción no válida.");
                                }
                            }
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }

                if (opcion == 0) break;
            }
        }
    }
}
