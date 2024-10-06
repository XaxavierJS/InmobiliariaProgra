// Main.java

import controllers.ArrendatarioController;
import controllers.DepartamentoController;
import controllers.ProyectoController;
import models.ArrendatarioModel;
import models.DepartamentoModel;
import models.ProyectoModel;
import entities.Departamento;
import Utils.Utils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Modelos
        DepartamentoModel departamentoModel = new DepartamentoModel();
        ArrendatarioModel arrendatarioModel = new ArrendatarioModel();
        ProyectoModel proyectoModel = new ProyectoModel();

        // Controladores
        DepartamentoController departamentoController = new DepartamentoController(departamentoModel);
        ArrendatarioController arrendatarioController = new ArrendatarioController(arrendatarioModel);
        ProyectoController proyectoController = new ProyectoController(proyectoModel);

        // Datos iniciales
        Departamento dep1 = new Departamento("Depa 1", "D001", 50000, null, null, true, "101", 3, 2, 120);
        Departamento dep2 = new Departamento("Depa 2", "D002", 60000, null, null, false, "102", 4, 3, 150);
        departamentoController.agregarDepartamento(dep1);
        departamentoController.agregarDepartamento(dep2);

        while (true) {
            Utils.mostrarMenu();
            int opcion = Utils.leerOpcionUsuario(scanner);

            switch (opcion) {
                case 1:
                    departamentoController.gestionarDepartamentos(scanner, arrendatarioModel);

                    break;
                case 2:
                    arrendatarioController.gestionarArrendatarios(scanner);
                    break;
                case 3:
                    proyectoController.gestionarProyectos(scanner, departamentoController.getDepartamentos());
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
