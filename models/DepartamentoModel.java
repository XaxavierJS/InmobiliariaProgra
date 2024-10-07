package models;

import entities.Departamento;
import entities.Proyecto;

import java.io.*;
import java.util.*;

public class DepartamentoModel {
    private List<Departamento> listaDepartamentos = new ArrayList<>();
    private static final String RUTA_CSV = "C:\\Users\\javie\\OneDrive - mail.pucv.cl\\Documentos\\GitHub\\Inmobiliaria\\models\\departamentos.csv";

    // Método para cargar departamentos desde un archivo CSV y asociarlos a los proyectos correspondientes
    public void cargarDepartamentosDesdeCSV(List<Proyecto> proyectos) {
        String RUTA_CSV_DEPARTAMENTOS = "C:\\Users\\javie\\OneDrive - mail.pucv.cl\\Documentos\\GitHub\\Inmobiliaria\\models\\departamentos.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_CSV_DEPARTAMENTOS))) {
            String linea;
            boolean esPrimeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false;
                    continue;  // Saltar encabezado
                }

                // Saltar líneas vacías
                if (linea.trim().isEmpty()) {
                    continue;
                }

                // Eliminar comillas y procesar los datos
                String[] datos = linea.replace("\"", "").split(",");
                if (datos.length >= 4) {  // id_departamento, nombre, precio, id_proyecto
                    String idDepartamento = datos[0].trim();  // Aquí eliminamos comillas y espacios
                    String nombre = datos[1].trim();
                    int precio = Integer.parseInt(datos[2].trim());
                    String idProyecto = datos[3].trim();

                    // Buscar el proyecto correspondiente por idProyecto
                    Proyecto proyecto = proyectos.stream()
                            .filter(p -> p.getId().equals(idProyecto))
                            .findFirst()
                            .orElse(null);

                    if (proyecto != null) {
                        // Crear el departamento y asociarlo al proyecto
                        Departamento departamento = new Departamento(nombre, idDepartamento, precio, true, idProyecto);
                        proyecto.agregarDepartamento(departamento);  // Asocia el departamento al proyecto
                        listaDepartamentos.add(departamento);  // Agregar el departamento a la lista global
                        System.out.println("Departamento " + departamento.getNombre() + " agregado al proyecto " + proyecto.getNombreProyecto());
                    } else {
                        System.out.println("No se encontró el proyecto con ID: " + idProyecto);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV de departamentos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir un valor numérico en el archivo CSV: " + e.getMessage());
        }
    }


    // Método para obtener departamentos por proyecto
    public List<Departamento> obtenerDepartamentosPorProyecto(String idProyecto) {
        List<Departamento> departamentosDelProyecto = new ArrayList<>();
        for (Departamento departamento : listaDepartamentos) {
            if (departamento.getProyectoID().equals(idProyecto)) {
                departamentosDelProyecto.add(departamento);
            }
        }
        return departamentosDelProyecto;
    }

    // Método para agregar departamento
    public void agregarDepartamento(Departamento departamento) {
        listaDepartamentos.add(departamento);
        System.out.println("Departamento agregado correctamente.");
    }

    // Método para eliminar departamento
    public void eliminarDepartamento(String id) {
        Departamento departamentoAEliminar = buscarDepartamentoPorId(id);
        if (departamentoAEliminar != null) {
            listaDepartamentos.remove(departamentoAEliminar);
            System.out.println("Departamento eliminado correctamente.");
        } else {
            System.out.println("Departamento no encontrado.");
        }
    }

    // Método para buscar departamento por ID
    public Departamento buscarDepartamentoPorId(String id) {
        for (Departamento departamento : listaDepartamentos) {
            System.out.println("Comparando departamento ID: '" + departamento.getID() + "' con ID buscado: '" + id + "'");
            if (departamento.getID().equals(id)) {
                return departamento;
            }
        }
        System.out.println("Departamento con ID '" + id + "' no encontrado.");
        return null;
    }



    // Método para agregar arrendatario a un departamento
    public void agregarArrendatarioADepartamento(Departamento departamento, entities.Arrendatario arrendatario) {
        departamento.agregarArrendatario(arrendatario);
        System.out.println("Arrendatario agregado al departamento.");
    }

    // Método para eliminar arrendatario de un departamento
    public void eliminarArrendatario(Departamento departamento, String nombreArrendatario) {
        departamento.eliminarArrendatario(nombreArrendatario);
        System.out.println("Arrendatario eliminado del departamento.");
    }
    public List<Departamento> obtenerTodosLosDepartamentos() {
        return listaDepartamentos;
    }
}
