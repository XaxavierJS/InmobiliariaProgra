package controllers;

import models.DepartamentoModel;
import models.ArrendatarioModel;
import entities.Departamento;
import entities.Proyecto;

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
        departamentoModel.agregarDepartamento(scanner, proyecto);
    }

    public void eliminarDepartamento(Scanner scanner, Proyecto proyecto) {
        departamentoModel.eliminarDepartamento(scanner, proyecto);
    }

    public void modificarDepartamento(Scanner scanner, Proyecto proyecto) {
        // Lógica para modificar el departamento dentro del proyecto
    }

    public Departamento seleccionarDepartamento(Scanner scanner, Proyecto proyecto) {
        System.out.println("Departamentos disponibles:");
        for (Departamento departamento : proyecto.getDepartamentos()) {
            System.out.println(departamento.getID() + " - " + departamento.getNombre());
        }

        System.out.print("Ingrese el ID del departamento: ");
        String idDepartamento = scanner.nextLine();
        return departamentoModel.buscarDepartamentoPorID(proyecto.getDepartamentos(), idDepartamento);
    }

    // Gestionar arrendatarios
    public void agregarArrendatario(Scanner scanner, Departamento departamento) {
        departamentoModel.agregarArrendatarioADepartamento(scanner, arrendatarioModel, departamento);
    }

    public void eliminarArrendatario(Scanner scanner, Departamento departamento) {
        departamentoModel.eliminarArrendatario(scanner, departamento);
    }

    public void modificarArrendatario(Scanner scanner, Departamento departamento) {
        // Lógica para modificar un arrendatario del departamento
    }
}
