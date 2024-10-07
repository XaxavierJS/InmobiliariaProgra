package controllers;

import models.ProyectoModel;
import entities.Proyecto;

import java.util.List;

public class ProyectoController {
    private ProyectoModel proyectoModel;
    private DepartamentoController departamentoController;

    public ProyectoController(ProyectoModel model, DepartamentoController departamentoController) {
        this.proyectoModel = model;
        this.departamentoController = departamentoController;
    }

    public void mostrarProyectos() {
        proyectoModel.mostrarProyectos();
    }

    public List<Proyecto> obtenerProyectos() {
        return proyectoModel.obtenerProyectos();
    }

    public Proyecto buscarProyectoPorNombre(String nombre) {
        return proyectoModel.buscarProyectoPorNombre(nombre);
    }
}
