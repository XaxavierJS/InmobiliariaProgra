package models;

import entities.Departamento;
import entities.Proyecto;
import java.io.*;
import java.util.*;

public class ProyectoModel {
    private final List<Proyecto> listaProyectos = new ArrayList<>();
    private static final String RUTA_CSV = "C:\\Users\\javie\\OneDrive - mail.pucv.cl\\Documentos\\GitHub\\Inmobiliaria\\models\\proyectos.csv";

    // Leer proyectos desde un archivo CSV
    public void cargarProyectosDesdeCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_CSV))) {
            String linea;
            boolean esPrimeraLinea = true;
            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false;  // Omitir encabezado
                    continue;
                }

                // Saltar líneas vacías
                if (linea.trim().isEmpty()) {
                    continue;
                }

                // Procesar la línea y remover comillas si es necesario
                String[] datos = linea.replace("\"", "").split(",");

                if (datos.length >= 3) {  // id, nombre, ubicacion
                    String id = datos[0].trim();
                    String nombre = datos[1].trim();
                    String ubicacion = datos[2].trim();

                    // Evitar encabezados o valores erróneos
                    if (!id.equalsIgnoreCase("id_proyecto")) {
                        Proyecto proyecto = new Proyecto(nombre, ubicacion);
                        proyecto.setId(id);  // Asignamos el ID manualmente
                        listaProyectos.add(proyecto);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV de proyectos: " + e.getMessage());
        }
    }

    // Obtener proyectos
    public List<Proyecto> obtenerProyectos() {
        return listaProyectos;
    }

    // Cargar departamentos y asociarlos con proyectos


    public Proyecto buscarProyectoPorNombre(String nombre) {
        for (Proyecto proyecto : listaProyectos) {
            if (proyecto.getNombreProyecto().equalsIgnoreCase(nombre)) {
                return proyecto;
            }
        }
        return null; // Si no se encuentra el proyecto
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
}
