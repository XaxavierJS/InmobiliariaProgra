// models/DepartamentoModel.java
package models;

import entities.Arrendatario;
import entities.Departamento;
import Utils.Utils;

import java.util.*;

public class DepartamentoModel {
    private final List<Departamento> listaDepartamentos = new ArrayList<>();
    private final Map<String, Departamento> mapaDepartamentos = new HashMap<>();


    public void agregarDepartamento(Scanner scanner) {
        System.out.print("Ingrese el ID del departamento: ");
        String ID = scanner.nextLine();
        if (mapaDepartamentos.containsKey(ID)) {
            System.out.println("Ya existe un departamento con este ID.");
            return;
        }

        System.out.print("Ingrese el nombre del departamento: ");
        String nombre = scanner.nextLine();
        int precio = Utils.leerEntero(scanner, "Ingrese el precio del departamento: ");
        int piezas = Utils.leerEntero(scanner, "Ingrese la cantidad de piezas del departamento: ");
        int banos = Utils.leerEntero(scanner, "Ingrese la cantidad de baños del departamento: ");
        int tamano = Utils.leerEntero(scanner, "Ingrese el tamaño del departamento (en m2): ");
        System.out.print("Ingrese el número del departamento: ");
        String numeroDepa = scanner.nextLine();
        boolean estado = Utils.leerBoolean(scanner, "¿Está disponible? (true/false): ");

        Departamento nuevoDepartamento = new Departamento(nombre, ID, precio, estado, numeroDepa, piezas, banos, tamano);
        listaDepartamentos.add(nuevoDepartamento);
        mapaDepartamentos.put(ID, nuevoDepartamento);

        System.out.println("¡Departamento agregado exitosamente!");
    }

    public void agregarDepartamento(Departamento departamento) {
        listaDepartamentos.add(departamento);
        mapaDepartamentos.put(departamento.getID(), departamento);
    }

    public void eliminarDepartamento(Scanner scanner) {
        System.out.print("Ingrese el ID del departamento a eliminar: ");
        String IDbuscado = scanner.nextLine();

        Departamento departamentoAEliminar = mapaDepartamentos.get(IDbuscado);
        if (departamentoAEliminar != null) {
            listaDepartamentos.remove(departamentoAEliminar);
            mapaDepartamentos.remove(IDbuscado);
            System.out.println("¡Departamento eliminado exitosamente!");
        } else {
            System.out.println("No se encontró el departamento con ID: " + IDbuscado + ".");
        }
    }

    public void verificarDisponibilidad(Scanner scanner) {
        System.out.print("Ingrese el ID del departamento a verificar: ");
        String IDbuscado = scanner.nextLine();
        Departamento departamentoAVerificar = mapaDepartamentos.get(IDbuscado);

        if (departamentoAVerificar != null) {
            // Incrementar demanda y ajustar precio si es necesario
            departamentoAVerificar.incrementarDemanda();
            if (departamentoAVerificar.getDemanda() % 5 == 0) {
                departamentoAVerificar.calcularPrecio(10); // Aumenta el precio en 10%
                System.out.println("Debido a la alta demanda, el precio del departamento ha aumentado.");
            }

            if (departamentoAVerificar.getEstado()) {
                System.out.println("El departamento con ID: " + IDbuscado + " está disponible.");
            } else {
                System.out.println("El departamento con ID: " + IDbuscado + " NO está disponible.");
            }
        } else {
            System.out.println("No se encontró el departamento con ID: " + IDbuscado + ".");
        }
    }

    public void buscarDepartamento(Scanner scanner) {
        System.out.println("1. Buscar por ID");
        System.out.println("2. Buscar por Precio Máximo");
        System.out.print("Seleccione una opción: ");
        int opcion = Utils.leerOpcionUsuario(scanner);

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el ID del departamento: ");
                String ID = scanner.nextLine();
                Departamento dep = buscarDepartamentoPorID(ID);
                if (dep != null) {
                    System.out.println("Departamento encontrado: " + dep.getNombre());
                } else {
                    System.out.println("Departamento no encontrado.");
                }
                break;
            case 2:
                int precioMax = Utils.leerEntero(scanner, "Ingrese el precio máximo: ");
                List<Departamento> deps = buscarDepartamentoPorPrecio(precioMax);
                if (!deps.isEmpty()) {
                    System.out.println("Departamentos encontrados:");
                    for (Departamento d : deps) {
                        System.out.println(d.getNombre() + " - Precio: " + d.getPrecio());
                    }
                } else {
                    System.out.println("No se encontraron departamentos por debajo de ese precio.");
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void mostrarTodosLosDepartamentos() {
        if (listaDepartamentos.isEmpty()) {
            System.out.println("No hay departamentos registrados.");
        } else {
            for (Departamento departamento : listaDepartamentos) {
                System.out.println("ID: " + departamento.getID() + ", Nombre: " + departamento.getNombre() + ", Precio: " + departamento.getPrecio());
            }
        }
    }

    public Departamento buscarDepartamentoPorID(String ID) {
        return mapaDepartamentos.get(ID);
    }

    public List<Departamento> buscarDepartamentoPorPrecio(int precio) {
        List<Departamento> resultado = new ArrayList<>();
        for (Departamento departamento : listaDepartamentos) {
            if (departamento.getPrecio() <= precio) {
                resultado.add(departamento);
            }
        }
        return resultado;
    }
    public void agregarArrendatarioADepartamento(Scanner scanner, ArrendatarioModel arrendatarioModel) {
        System.out.print("Ingrese el ID del departamento: ");
        String IDdepartamento = scanner.nextLine();
        Departamento departamento = mapaDepartamentos.get(IDdepartamento);

        if (departamento != null) {
            arrendatarioModel.agregarArrendatario(scanner);
            Arrendatario nuevoArrendatario = arrendatarioModel.getUltimoArrendatario();
            departamento.agregarArrendatario(nuevoArrendatario);  // Agregar arrendatario a la lista
            System.out.println("¡Arrendatario agregado al departamento exitosamente!");
        } else {
            System.out.println("Departamento no encontrado.");
        }
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }
}
