import java

public class Proyecto {
    private String nombreProyecto;
    private String ubicacion;
    private List<Departamento> listaDepartamentos;

    public Proyecto(String nombreProyecto, String ubicacion, List<Departamento> listaDepartamentos) {
        this.nombreProyecto = nombreProyecto;
        this.ubicacion = ubicacion;
        this.listaDepartamentos = new ArrayList<>();
    }

    public String getNombreProyecto() { return nombreProyecto; }
    public void setNombreProyecto(String nombreProyecto) { this.nombreProyecto = nombreProyecto; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public List<Departamento> getListaDepartamentos() { return listaDepartamentos; }
    public void setListaDepartamentos(List<Departamento> listaDepartamentos) { this.listaDepartamentos = listaDepartamentos; }
}
