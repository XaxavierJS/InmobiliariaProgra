// controllers/DepartamentoController.java
package controllers;

import models.DepartamentoModel;
import models.ArrendatarioModel;
import entities.Departamento;
import Utils.Utils;

import java.util.List;
import java.util.Scanner;

public class DepartamentoController {
    private DepartamentoModel departamentoModel;

    public DepartamentoController(DepartamentoModel departamentoModel) {
        this.departamentoModel = departamentoModel;
    }

    public void gestionarDepartamentos(Scanner scanner, ArrendatarioModel arrendatarioModel) {
        while (true) {
            System.out.println("=== Gestión de Departamentos ===");
            System.out.println("1. Agregar Departamento");
            System.out.println("2. Eliminar Departamento");
            System.out.println("3. Verificar Disponibilidad");
            System.out.println("4. Buscar Departamento");
            System.out.println("5. Mostrar Todos los Departamentos");
            System.out.println("6. Agregar Arrendatario a Departamento");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = Utils.leerOpcionUsuario(scanner);

            switch (opcion) {
                case 1:
                    departamentoModel.agregarDepartamento(scanner);
                    break;
                case 2:
                    departamentoModel.eliminarDepartamento(scanner);
                    break;
                case 3:
                    departamentoModel.verificarDisponibilidad(scanner);
                    break;
                case 4:
                    departamentoModel.buscarDepartamento(scanner);
                    break;
                case 5:
                    departamentoModel.mostrarTodosLosDepartamentos();
                    break;
                case 6:
                    departamentoModel.agregarArrendatarioADepartamento(scanner, arrendatarioModel);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public void agregarDepartamento(Departamento departamento) {
        departamentoModel.agregarDepartamento(departamento);
    }

    public List<Departamento> getDepartamentos() {
        return departamentoModel.getListaDepartamentos();
    }

}