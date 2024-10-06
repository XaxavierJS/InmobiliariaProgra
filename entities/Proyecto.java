// entities/Proyecto.java
package entities;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private String nombreProyecto;
    private String ubicacion;
    private List<Departamento> departamentos;

    public Proyecto(String nombreProyecto, String ubicacion) {
        this.nombreProyecto = nombreProyecto;
        this.ubicacion = ubicacion;
        this.departamentos = new ArrayList<>();
    }
    public void agregarDepartamento(Departamento departamento) {
        this.departamentos.add(departamento);
    }

    public void agregarDepartamento(List<Departamento> departamentos) {
        this.departamentos.addAll(departamentos);
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

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
}
