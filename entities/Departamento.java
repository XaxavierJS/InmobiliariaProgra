package entities;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombreDepartamento;
    private String codigo;  // ID del departamento
    private int precio;
    private String idProyecto;  // ID del proyecto
    private boolean disponible;  // Estado del departamento
    private List<Arrendatario> arrendatarios;

    public Departamento(String nombreDepartamento, String codigo, int precio, boolean disponible, String idProyecto) {
        this.nombreDepartamento = nombreDepartamento;
        this.codigo = codigo;
        this.precio = precio;
        this.idProyecto = idProyecto;
        this.disponible = disponible;
        this.arrendatarios = new ArrayList<>();  // Inicializamos la lista de arrendatarios
    }

    // Getters y setters
    public String getID() {
        return codigo;
    }

    public String getNombre() {
        return nombreDepartamento;
    }

    public int getPrecio() {
        return precio;
    }

    public String getProyectoID() {
        return idProyecto;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void agregarArrendatario(Arrendatario arrendatario) {
        this.arrendatarios.add(arrendatario);
    }

    public void eliminarArrendatario(String nombreArrendatario) {
        arrendatarios.removeIf(arrendatario -> arrendatario.getNombre().equalsIgnoreCase(nombreArrendatario));
    }

    public List<Arrendatario> getArrendatarios() {
        return arrendatarios;
    }

    public void setNombreDepartamento(String nuevoNombre) {
        this.nombreDepartamento = nuevoNombre;
    }

    public Object getCodigo() {
        return null;
    }

    public Arrendatario buscarArrendatarioPorNombre(String nombreArrendatario) {
        return arrendatarios.stream()
                .filter(arrendatario -> arrendatario.getNombre().equalsIgnoreCase(nombreArrendatario))
                .findFirst()
                .orElse(null);
    }

    public void setPrecio(int nuevoPrecio) {
        this.precio = nuevoPrecio;

    }
}
