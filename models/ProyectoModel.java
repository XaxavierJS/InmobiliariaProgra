// models/ProyectoModel.java
package models;

import entities.Proyecto;
import entities.Departamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProyectoModel {
    private List<Proyecto> listaProyectos = new ArrayList<>();

    public void agregarProyecto(Scanner scanner) {
        System.out.print("Ingrese el nombre del proyecto: ");
        String nombreProyecto = scanner.nextLine();
        System.out.print("Ingrese la ubicación del proyecto: ");
        String ubicacion = scanner.nextLine();

        Proyecto nuevoProyecto = new Proyecto(nombreProyecto, ubicacion);
        listaProyectos.add(nuevoProyecto);

        System.out.println("¡Proyecto agregado exitosamente!");
    }

    public void agregarDepartamentoAProyecto(Scanner scanner, List<Departamento> departamentosDisponibles) {
        System.out.print("Ingrese el nombre del proyecto al que desea agregar departamentos: ");
        String nombreProyecto = scanner.nextLine();
        Proyecto proyecto = buscarProyectoPorNombre(nombreProyecto);

        if (proyecto != null) {
            if (departamentosDisponibles.isEmpty()) {
                System.out.println("No hay departamentos disponibles para agregar.");
                return;
            }

            System.out.println("Departamentos disponibles:");
            for (Departamento dep : departamentosDisponibles) {
                System.out.println(dep.getID() + " - " + dep.getNombre());
            }
            System.out.print("Ingrese el ID del departamento que desea agregar: ");
            String idDepartamento = scanner.nextLine();
            Departamento departamento = buscarDepartamentoPorID(departamentosDisponibles, idDepartamento);

            if (departamento != null) {
                proyecto.agregarDepartamento(departamento);
                System.out.println("¡Departamento agregado al proyecto exitosamente!");
            } else {
                System.out.println("Departamento no encontrado.");
            }
        } else {
            System.out.println("Proyecto no encontrado.");
        }
    }

    public void mostrarDepartamentosDeProyecto(Scanner scanner) {
        System.out.print("Ingrese el nombre del proyecto: ");
        String nombreProyecto = scanner.nextLine();
        Proyecto proyecto = buscarProyectoPorNombre(nombreProyecto);

        if (proyecto != null) {
            List<Departamento> departamentos = proyecto.getDepartamentos();
            if (!departamentos.isEmpty()) {
                System.out.println("Departamentos en el proyecto " + nombreProyecto + ":");
                for (Departamento dep : departamentos) {
                    System.out.println(dep.getID() + " - " + dep.getNombre());
                }
            } else {
                System.out.println("No hay departamentos asociados a este proyecto.");
            }
        } else {
            System.out.println("Proyecto no encontrado.");
        }
    }

    public void mostrarProyectos() {
        if (listaProyectos.isEmpty()) {
            System.out.println("No hay proyectos registrados.");
        } else {
            for (Proyecto proyecto : listaProyectos) {
                System.out.println("Nombre del Proyecto: " + proyecto.getNombreProyecto() +
                        ", Ubicación: " + proyecto.getUbicacion());
            }
        }
    }

    private Proyecto buscarProyectoPorNombre(String nombre) {
        for (Proyecto proyecto : listaProyectos) {
            if (proyecto.getNombreProyecto().equalsIgnoreCase(nombre)) {
                return proyecto;
            }
        }
        return null;
    }

    private Departamento buscarDepartamentoPorID(List<Departamento> departamentos, String id) {
        for (Departamento dep : departamentos) {
            if (dep.getID().equalsIgnoreCase(id)) {
                return dep;
            }
        }
        return null;
    }
}
