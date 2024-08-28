public class Departamento {
    private int precio;
    private String nombre;
    private String ID;
    private Proyecto proyecto;
    private Arrendatario arrendatario;
    private boolean estado;
    private String numeroDepa;
    private int piezas;
    private int baños;
    private int tamaño;

    public Departamento(String nombre, String ID, int precio, Proyecto proyecto, Arrendatario arrendatario, boolean estado, String numeroDepa, int piezas, int baños, int tamaño) {
        this.nombre = nombre;
        this.ID = ID;
        this.precio = precio;
        this.proyecto = proyecto;
        this.arrendatario = arrendatario;
        this.estado = estado;
        this.numeroDepa = numeroDepa;
        this.piezas = piezas;
        this.baños = baños;
        this.tamaño = tamaño;
    }

    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }
    public Proyecto getProyecto() { return proyecto; }
    public void setProyecto(Proyecto proyecto) { this.proyecto = proyecto; }
    public Arrendatario getArrendatario() { return arrendatario; }
    public void setArrendatario(Arrendatario arrendatario) { this.arrendatario = arrendatario; }
    public boolean getEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
    public String getNumeroDepa() { return numeroDepa; }
    public void setNumeroDepa(String numeroDepa) { this.numeroDepa = numeroDepa; }
    public int getPiezas() { return piezas; }
    public void setPiezas(int piezas) { this.piezas = piezas; }
    public int getBaños() { return baños; }
    public void setBaños(int baños) { this.baños = baños; }
    public int getTamaño() { return tamaño; }
    public void setTamaño(int tamaño) { this.tamaño = tamaño; }
}
