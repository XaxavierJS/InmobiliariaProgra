package models;

import entities.Departamento;
import entities.Proyecto;
import entities.Arrendatario;
import Utils.Utils;

import java.util.*;

public class DepartamentoModel {
    private List<Departamento> listaDepartamentos = new ArrayList<>();

    public void agregarDepartamento(Scanner scanner, Proyecto proyecto) {
        // Crear y agregar un departamento al proyecto
        System.out.print("Ingrese el nombre del departamento: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del departamento: ");
        String id = scanner.nextLine();
        int precio = Utils.leerEntero(scanner, "Ingrese el precio del departamento: ");
        Departamento nuevoDepartamento = new Departamento(nombre, id, precio, true, "XXX", 3, 2, 100);
        proyecto.agregarDepartamento(nuevoDepartamento);
        System.out.println("Departamento agregado exitosamente al proyecto " + proyecto.getNombreProyecto());
    }

    public void eliminarDepartamento(Scanner scanner, Proyecto proyecto) {
        // Eliminar un departamento del proyecto
        System.out.print("Ingrese el ID del departamento a eliminar: ");
        String idDepartamento = scanner.nextLine();
        Departamento departamento = buscarDepartamentoPorID(proyecto.getDepartamentos(), idDepartamento);
        if (departamento != null) {
            proyecto.getDepartamentos().remove(departamento);
            System.out.println("Departamento eliminado exitosamente.");
        } else {
            System.out.println("Departamento no encontrado.");
        }
    }

    public Departamento buscarDepartamentoPorID(List<Departamento> departamentos, String id) {
        for (Departamento dep : departamentos) {
            if (dep.getID().equalsIgnoreCase(id)) {
                return dep;
            }
        }
        return null;
    }

    // Métodos para gestionar arrendatarios...
    public void agregarArrendatarioADepartamento(Scanner scanner, ArrendatarioModel arrendatarioModel, Departamento departamento) {
        arrendatarioModel.agregarArrendatario(scanner);
        Arrendatario arrendatario = arrendatarioModel.getUltimoArrendatario();
        departamento.agregarArrendatario(arrendatario);
        System.out.println("Arrendatario agregado exitosamente al departamento.");
    }

    public void eliminarArrendatario(Scanner scanner, Departamento departamento) {
        System.out.print("Ingrese el nombre del arrendatario a eliminar: ");
        String nombreArrendatario = scanner.nextLine();
        Arrendatario arrendatarioAEliminar = departamento.getArrendatarios().stream()
                .filter(a -> a.getNombre().equalsIgnoreCase(nombreArrendatario))
                .findFirst()
                .orElse(null);
        if (arrendatarioAEliminar != null) {
            departamento.getArrendatarios().remove(arrendatarioAEliminar);
            System.out.println("Arrendatario eliminado exitosamente.");
        } else {
            System.out.println("Arrendatario no encontrado.");
        }
    }

    // Agrega otros métodos de modificación si es necesario...
}
