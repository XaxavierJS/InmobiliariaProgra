package models;

import entities.Arrendatario;
import entities.Departamento;

import java.io.*;
import java.util.*;

public class ArrendatarioModel {
    private List<Arrendatario> listaArrendatarios = new ArrayList<>();
    private static final String RUTA_CSV = "C:\\Users\\javie\\OneDrive - mail.pucv.cl\\Documentos\\GitHub\\Inmobiliaria\\models\\arrendatarios.csv";

    // Método para cargar arrendatarios desde un archivo CSV
// En ArrendatarioModel
    public void cargarArrendatariosDesdeCSV(DepartamentoModel departamentoModel) {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_CSV))) {
            String linea;
            boolean esPrimeraLinea = true;  // Para saltar la primera línea si es el encabezado
            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false;  // Saltar el encabezado
                    continue;
                }

                String[] datos = linea.replace("\"", "").split(",");  // Eliminar comillas aquí
                if (datos.length >= 7) {  // id, nombre, rut, correo, telefono, contrato, id_departamento
                    String idArrendatario = datos[0].trim();
                    String nombre = datos[1].trim();
                    String rut = datos[2].trim();
                    String correo = datos[3].trim();
                    String telefono = datos[4].trim();
                    String contrato = datos[5].trim();
                    String idDepartamento = datos[6].trim();  // Asegurarse de eliminar comillas y espacios

                    // Buscar el departamento correspondiente por ID
                    Departamento departamento = departamentoModel.buscarDepartamentoPorId(idDepartamento);
                    if (departamento != null) {
                        // Crear el arrendatario y asociarlo al departamento
                        Arrendatario arrendatario = new Arrendatario(nombre, rut, correo, telefono, contrato);
                        departamento.agregarArrendatario(arrendatario);  // Asociar al departamento
                        listaArrendatarios.add(arrendatario);  // Agregar a la lista general de arrendatarios
                        System.out.println("Arrendatario " + nombre + " agregado al departamento " + departamento.getNombre());
                    } else {
                        // Si no se encuentra el departamento, imprimimos un mensaje de advertencia
                        System.out.println("Departamento con ID '" + idDepartamento + "' no encontrado. No se pudo asociar el arrendatario: " + nombre);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV de arrendatarios: " + e.getMessage());
        }
    }

    // Método para agregar un arrendatario
    public void agregarArrendatario(Arrendatario arrendatario) {
        listaArrendatarios.add(arrendatario);
        System.out.println("Arrendatario agregado correctamente.");
    }

    // Método para mostrar arrendatarios
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
