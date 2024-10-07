package controllers;

import models.DepartamentoModel;
import models.ArrendatarioModel;
import entities.Departamento;
import entities.Proyecto;
import entities.Arrendatario;
import Utils.Utils;

import java.util.List;
import java.util.Scanner;

public class DepartamentoController {
    private DepartamentoModel departamentoModel;
    private ArrendatarioModel arrendatarioModel;

    public DepartamentoController(DepartamentoModel departamentoModel, ArrendatarioModel arrendatarioModel) {
        this.departamentoModel = departamentoModel;
        this.arrendatarioModel = arrendatarioModel;
    }

    // Gestionar departamentos
    public void agregarDepartamento(Scanner scanner, Proyecto proyecto) {
        System.out.print("Ingrese el nombre del departamento: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el ID del departamento: ");
        String id = scanner.nextLine();
        int precio = Utils.leerEntero(scanner, "Ingrese el precio del departamento: ");

        Departamento nuevoDepartamento = new Departamento(nombre, id, precio, true, proyecto.getId());
        proyecto.agregarDepartamento(nuevoDepartamento);  // Agregar al proyecto
        departamentoModel.agregarDepartamento(nuevoDepartamento);  // Guardar en el modelo
    }

    public void eliminarDepartamento(Scanner scanner, Proyecto proyecto) {
        System.out.print("Ingrese el ID del departamento a eliminar: ");
        String idDepartamento = scanner.nextLine();
        Departamento departamento = departamentoModel.buscarDepartamentoPorId(idDepartamento);
        if (departamento != null) {
            proyecto.getDepartamentos().remove(departamento);
            departamentoModel.eliminarDepartamento(idDepartamento);
            System.out.println("Departamento eliminado correctamente.");
        } else {
            System.out.println("Departamento no encontrado.");
        }
    }

    public void modificarDepartamento(Scanner scanner, Proyecto proyecto) {
        System.out.print("Ingrese el ID del departamento a modificar: ");
        String idDepartamento = scanner.nextLine();
        Departamento departamento = departamentoModel.buscarDepartamentoPorId(idDepartamento);

        if (departamento != null) {
            System.out.print("Ingrese el nuevo nombre del departamento: ");
            String nuevoNombre = scanner.nextLine();
            departamento.setNombreDepartamento(nuevoNombre);
            System.out.println("Departamento modificado correctamente.");
        } else {
            System.out.println("Departamento no encontrado.");
        }
    }

    public Departamento seleccionarDepartamento(Scanner scanner, Proyecto proyecto) {
        System.out.println("Departamentos disponibles:");

        // Filtrar departamentos que pertenecen al proyecto seleccionado
        List<Departamento> departamentosDelProyecto = proyecto.getDepartamentos();

        if (departamentosDelProyecto.isEmpty()) {
            System.out.println("No hay departamentos para este proyecto.");
            return null;
        }

        // Mostrar solo los departamentos que coinciden con el ID del proyecto seleccionado
        for (Departamento departamento : departamentosDelProyecto) {
            System.out.println(departamento.getID() + " - " + departamento.getNombre());
        }

        System.out.print("Ingrese el ID del departamento: ");
        String idDepartamento = scanner.nextLine();

        // Buscar y retornar el departamento seleccionado
        return departamentosDelProyecto.stream()
                .filter(departamento -> departamento.getID().equalsIgnoreCase(idDepartamento))
                .findFirst()
                .orElse(null);
    }


    // Gestionar arrendatarios
   // Gestionar arrendatarios
    public void agregarArrendatario(Scanner scanner, Departamento departamento) {
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

        Arrendatario nuevoArrendatario = new Arrendatario(nombre, rut, correo, telefono, contrato);
        departamento.agregarArrendatario(nuevoArrendatario);  // Asociar al departamento
        arrendatarioModel.agregarArrendatario(nuevoArrendatario);  // Guardar en el modelo
    }

    public void eliminarArrendatario(Scanner scanner, Departamento departamento) {
        List<Arrendatario> arrendatarios = departamento.getArrendatarios();

        // Mostrar los arrendatarios del departamento
        if (arrendatarios.isEmpty()) {
            System.out.println("No hay arrendatarios para eliminar en este departamento.");
            return;
        }

        System.out.println("Arrendatarios disponibles en el departamento " + departamento.getNombre() + ":");
        for (int i = 0; i < arrendatarios.size(); i++) {
            System.out.println((i + 1) + ". " + arrendatarios.get(i).getNombre());
        }

        System.out.print("Ingrese el número del arrendatario a eliminar: ");
        int opcion = Utils.leerEntero(scanner, "Opción: ");

        if (opcion < 1 || opcion > arrendatarios.size()) {
            System.out.println("Opción no válida.");
            return;
        }

        Arrendatario arrendatario = arrendatarios.get(opcion - 1);
        departamento.eliminarArrendatario(arrendatario.getNombre());
        System.out.println("Arrendatario " + arrendatario.getNombre() + " eliminado correctamente.");
    }


    public void modificarArrendatario(Scanner scanner, Departamento departamento) {
        List<Arrendatario> arrendatarios = departamento.getArrendatarios();

        // Mostrar los arrendatarios del departamento
        if (arrendatarios.isEmpty()) {
            System.out.println("No hay arrendatarios para modificar en este departamento.");
            return;
        }

        System.out.println("Arrendatarios disponibles en el departamento " + departamento.getNombre() + ":");
        for (int i = 0; i < arrendatarios.size(); i++) {
            System.out.println((i + 1) + ". " + arrendatarios.get(i).getNombre());
        }

        System.out.print("Ingrese el número del arrendatario a modificar: ");
        int opcion = Utils.leerEntero(scanner, "Opción: ");

        if (opcion < 1 || opcion > arrendatarios.size()) {
            System.out.println("Opción no válida.");
            return;
        }

        Arrendatario arrendatario = arrendatarios.get(opcion - 1);

        // Proceder a modificar el arrendatario
        System.out.print("Ingrese el nuevo correo del arrendatario: ");
        String nuevoCorreo = scanner.nextLine();
        arrendatario.setCorreo(nuevoCorreo);
        System.out.println("Arrendatario " + arrendatario.getNombre() + " modificado correctamente.");
    }

}
