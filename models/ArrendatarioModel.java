// models/ArrendatarioModel.java
package models;

import entities.Arrendatario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrendatarioModel {
    private List<Arrendatario> listaArrendatarios = new ArrayList<>();

    public void agregarArrendatario(Scanner scanner) {
        System.out.print("\nIngrese el nombre del arrendatario: ");
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
        listaArrendatarios.add(nuevoArrendatario);

        System.out.println("¡Arrendatario agregado exitosamente!");
    }
    public Arrendatario getUltimoArrendatario() {
        if (!listaArrendatarios.isEmpty()) {
            return listaArrendatarios.get(listaArrendatarios.size() - 1);
        }
        return null;
    }
    public void mostrarArrendatarios() {
        if (listaArrendatarios.isEmpty()) {
            System.out.println("No hay arrendatarios registrados.");
        } else {
            for (Arrendatario arrendatario : listaArrendatarios) {
                System.out.println("Nombre: " + arrendatario.getNombre() +
                        ", RUT: " + arrendatario.getRut() +
                        ", Correo: " + arrendatario.getCorreo() +
                        ", Teléfono: " + arrendatario.getTelefono());
            }
        }
    }
}
