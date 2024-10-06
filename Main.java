// Main.java

import controllers.ArrendatarioController;
import controllers.DepartamentoController;
import controllers.ProyectoController;
import entities.Arrendatario;
import entities.Proyecto;
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

        // Datos iniciales - Proyectos
        Proyecto proyecto1 = new Proyecto("Proyecto Central", "Avenida Principal 123");
        Proyecto proyecto2 = new Proyecto("Proyecto Los Robles", "Calle Los Robles 456");

        // Datos iniciales - Departamentos para Proyecto 1
        Departamento dep1_1 = new Departamento("Depa 101", "D101", 55000, true, "101", 3, 2, 120);
        Departamento dep1_2 = new Departamento("Depa 102", "D102", 60000, true, "102", 4, 3, 150);

        // Datos iniciales - Departamentos para Proyecto 2
        Departamento dep2_1 = new Departamento("Depa 201", "D201", 45000, true, "201", 2, 1, 100);
        Departamento dep2_2 = new Departamento("Depa 202", "D202", 50000, true, "202", 3, 2, 130);
        Departamento dep2_3 = new Departamento("Depa 203", "D203", 70000, true, "203", 4, 3, 170);

        // Agregar departamentos a los proyectos
        proyecto1.agregarDepartamento(dep1_1);
        proyecto1.agregarDepartamento(dep1_2);
        proyecto2.agregarDepartamento(dep2_1);
        proyecto2.agregarDepartamento(dep2_2);
        proyecto2.agregarDepartamento(dep2_3);

        // Datos iniciales - Arrendatarios para dep1_1
        Arrendatario arr1_1 = new Arrendatario("Juan Pérez", "12345678-9", "juan.perez@mail.com", "987654321", "Contrato 001");
        Arrendatario arr1_2 = new Arrendatario("María López", "23456789-0", "maria.lopez@mail.com", "987654322", "Contrato 002");
        dep1_1.agregarArrendatario(arr1_1);
        dep1_1.agregarArrendatario(arr1_2);

        // Datos iniciales - Arrendatarios para dep1_2
        Arrendatario arr2_1 = new Arrendatario("Carlos Gutiérrez", "34567890-1", "carlos.gutierrez@mail.com", "987654323", "Contrato 003");
        dep1_2.agregarArrendatario(arr2_1);

        // Datos iniciales - Arrendatarios para dep2_1
        Arrendatario arr3_1 = new Arrendatario("Ana Rodríguez", "45678901-2", "ana.rodriguez@mail.com", "987654324", "Contrato 004");
        Arrendatario arr3_2 = new Arrendatario("Luis Fernández", "56789012-3", "luis.fernandez@mail.com", "987654325", "Contrato 005");
        dep2_1.agregarArrendatario(arr3_1);
        dep2_1.agregarArrendatario(arr3_2);

        // Datos iniciales - Arrendatarios para dep2_2
        Arrendatario arr4_1 = new Arrendatario("Elena Vargas", "67890123-4", "elena.vargas@mail.com", "987654326", "Contrato 006");
        dep2_2.agregarArrendatario(arr4_1);

        // Agregar los proyectos al modelo
        proyectoModel.agregarProyecto(proyecto1);
        proyectoModel.agregarProyecto(proyecto2);

        // Menú principal
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
