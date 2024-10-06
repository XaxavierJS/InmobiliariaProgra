package models;

import entities.Proyecto;

import java.util.ArrayList;
import java.util.List;

public class ProyectoModel {
    private List<Proyecto> listaProyectos = new ArrayList<>();

    public void agregarProyecto(Proyecto proyecto) {
        listaProyectos.add(proyecto);
        System.out.println("¡Proyecto agregado exitosamente!");
    }

    public List<Proyecto> obtenerProyectos() {
        return listaProyectos;
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

    public Proyecto buscarProyectoPorNombre(String nombre) {
        for (Proyecto proyecto : listaProyectos) {
            if (proyecto.getNombreProyecto().equalsIgnoreCase(nombre)) {
                return proyecto;
            }
        }
        return null;
    }
}
