package entities;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String id;
    private String nombreProyecto;
    private String ubicacion;
    private List<Departamento> departamentos = new ArrayList<>();

    // Constructor
    public Proyecto(String nombreProyecto, String ubicacion) {
        this.nombreProyecto = nombreProyecto;
        this.ubicacion = ubicacion;
    }

    // Getter y setter para id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Otros métodos y getters/setters
    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void agregarDepartamento(Departamento departamento) {
        this.departamentos.add(departamento);
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }
}
