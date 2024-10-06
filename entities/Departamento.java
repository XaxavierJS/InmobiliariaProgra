package entities;

public class Departamento {
    private String nombreDepartamento;
    private String codigo;
    private int precio;
    private Arrendatario arrendatario;
    private Proyecto proyecto;
    private boolean disponible;
    private String numero;
    private int habitaciones;
    private int banos;
    private int area;
    private int demanda;

    public Departamento(String nombreDepartamento, String codigo, int precio, Arrendatario arrendatario, Proyecto proyecto, boolean disponible, String numero, int habitaciones, int banos, int area) {
        this.nombreDepartamento = nombreDepartamento;
        this.codigo = codigo;
        this.precio = precio;
        this.arrendatario = arrendatario;
        this.proyecto = proyecto;
        this.disponible = disponible;
        this.numero = numero;
        this.habitaciones = habitaciones;
        this.banos = banos;
        this.area = area;
        this.demanda = 0;
    }

    // Getters and Setters
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Arrendatario getArrendatario() {
        return arrendatario;
    }

    public void setArrendatario(Arrendatario arrendatario) {
        this.arrendatario = arrendatario;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        this.banos = banos;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getID() {
        return codigo;
    }

    public void incrementarDemanda() {
        this.demanda++;
    }

    public int getDemanda() {
        return demanda;
    }

    public void calcularPrecio(int porcentaje) {
        this.precio += this.precio * porcentaje / 100;
    }

    public boolean getEstado() {
        return disponible;
    }

    public String getNombre() {
        return nombreDepartamento;
    }

    public void agregarArrendatario(Arrendatario arrendatario) {
        this.arrendatario = arrendatario;
    }

}