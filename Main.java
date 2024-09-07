import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Datos iniciales de ejemplo
        List<Departamento> listaDepartamentos = new ArrayList<>();
        List<Arrendatario> listaArrendatarios = new ArrayList<>();
        List<Proyecto> listaProyectos = new ArrayList<>();

        // Map para gestionar departamentos por ID
        Map<String, Departamento> mapaDepartamentos = new HashMap<>();

        // Agregar datos iniciales
        Departamento dep1 = new Departamento("Depa 1", "D001", 50000, null, null, true, "101", 3, 2, 120);
        Departamento dep2 = new Departamento("Depa 2", "D002", 60000, null, null, false, "102", 4, 3, 150);
        listaDepartamentos.add(dep1);
        listaDepartamentos.add(dep2);
        mapaDepartamentos.put(dep1.getID(), dep1);
        mapaDepartamentos.put(dep2.getID(), dep2);

        while (true) {
            mostrarMenu();
            int opcion = leerOpcionUsuario(scanner);

            switch (opcion) {
                case 1:
                    gestionarDepartamentos(scanner, listaDepartamentos, mapaDepartamentos);
                    break;
                case 2:
                    gestionarArrendatarios(scanner, listaArrendatarios);
                    break;
                case 3:
                    gestionarProyectos(scanner, listaProyectos, listaDepartamentos);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static int leerOpcionUsuario(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        return opcion;
    }

    public static void mostrarMenu() {
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Gestionar Departamentos");
        System.out.println("2. Gestionar Arrendatarios");
        System.out.println("3. Gestionar Proyectos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Método agregado para mostrar el menú de gestión de departamentos
    public static void mostrarMenuGestionDepartamentos() {
        System.out.println("=== Gestión de Departamentos ===");
        System.out.println("1. Agregar Departamento");
        System.out.println("2. Eliminar Departamento");
        System.out.println("3. Verificar Disponibilidad");
        System.out.println("4. Buscar Departamento");
        System.out.println("0. Volver al menú principal");
        System.out.print("Seleccione una opción: ");
    }

    // Agregar método para gestionar departamento usando Map
    public static void gestionarDepartamentos(Scanner scanner, List<Departamento> listaDepartamentos, Map<String, Departamento> mapaDepartamentos) {
        while (true) {
            mostrarMenuGestionDepartamentos();
            int opcion = leerOpcionUsuario(scanner);

            switch (opcion) {
                case 1:
                    agregarDepartamento(scanner, listaDepartamentos, mapaDepartamentos);
                    break;
                case 2:
                    eliminarDepartamento(scanner, listaDepartamentos, mapaDepartamentos);
                    break;
                case 3:
                    verificarDisponibilidad(scanner, listaDepartamentos);
                    break;
                case 4:
                    gestionarBuscarDepartamento(scanner, listaDepartamentos);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    // Sobrecarga de métodos en búsqueda de departamentos
    public static void gestionarBuscarDepartamento(Scanner scanner, List<Departamento> listaDepartamentos) {
        System.out.println("1. Buscar por ID");
        System.out.println("2. Buscar por Precio Máximo");
        int opcion = leerOpcionUsuario(scanner);

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el ID del departamento:");
                String ID = scanner.nextLine();
                Departamento dep = buscarDepartamentoPorID(ID, listaDepartamentos);
                if (dep != null) {
                    System.out.println("Departamento encontrado: " + dep.getNombre());
                } else {
                    System.out.println("Departamento no encontrado.");
                }
                break;
            case 2:
                System.out.println("Ingrese el precio máximo:");
                int precioMax = leerEntero(scanner, "Ingrese el precio máximo:");
                List<Departamento> deps = buscarDepartamentoPorPrecio(precioMax, listaDepartamentos);
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

    public static List<Departamento> buscarDepartamentoPorPrecio(int precio, List<Departamento> listaDepartamentos) {
        List<Departamento> resultado = new ArrayList<>();
        for (Departamento departamento : listaDepartamentos) {
            if (departamento.getPrecio() <= precio) {
                resultado.add(departamento);
            }
        }
        return resultado;
    }

    public static void agregarDepartamento(Scanner scanner, List<Departamento> listaDepartamentos, Map<String, Departamento> mapaDepartamentos) {
        System.out.println("Ingrese el ID del departamento:");
        String ID = scanner.nextLine();
        if (mapaDepartamentos.containsKey(ID)) {
            System.out.println("Ya existe un departamento con este ID.");
            return;
        }

        System.out.println("Ingrese el nombre del departamento:");
        String nombre = scanner.nextLine();
        int precio = leerEntero(scanner, "Ingrese el precio del departamento:");
        int piezas = leerEntero(scanner, "Ingrese la cantidad de piezas del departamento:");
        int baños = leerEntero(scanner, "Ingrese la cantidad de baños del departamento:");
        int tamaño = leerEntero(scanner, "Ingrese el tamaño del departamento (en m2):");
        System.out.println("Ingrese el número del departamento:");
        String numeroDepa = scanner.nextLine();
        boolean estado = leerBoolean(scanner, "¿Está disponible? (true/false):");

        Departamento nuevoDepartamento = new Departamento(nombre, ID, precio, null, null, estado, numeroDepa, piezas, baños, tamaño);
        listaDepartamentos.add(nuevoDepartamento);
        mapaDepartamentos.put(ID, nuevoDepartamento);  // Se agrega al mapa

        System.out.println("¡Departamento agregado exitosamente!");
    }

    public static void eliminarDepartamento(Scanner scanner, List<Departamento> listaDepartamentos, Map<String, Departamento> mapaDepartamentos) {
        System.out.println("Ingrese el ID del departamento a eliminar: ");
        String IDbuscado = scanner.nextLine();

        Departamento departamentoAEliminar = mapaDepartamentos.get(IDbuscado);
        if (departamentoAEliminar != null) {
            listaDepartamentos.remove(departamentoAEliminar);
            mapaDepartamentos.remove(IDbuscado);  // También se elimina del mapa
            System.out.println("¡Departamento eliminado exitosamente!");
        } else {
            System.out.println("No se encontró el departamento con ID: " + IDbuscado + ".");
        }
    }

    public static void verificarDisponibilidad(Scanner scanner, List<Departamento> listaDepartamentos) {
        System.out.println("Ingrese el ID del departamento a verificar: ");
        String IDbuscado = scanner.nextLine();
        Departamento departamentoAVerificar = buscarDepartamentoPorID(IDbuscado, listaDepartamentos);

        if (departamentoAVerificar != null) {
            if (departamentoAVerificar.getEstado()) {
                System.out.println("El departamento con ID: " + IDbuscado + " está disponible.");
            } else {
                System.out.println("El departamento con ID: " + IDbuscado + " NO está disponible.");
            }
        } else {
            System.out.println("No se encontró el departamento con ID: " + IDbuscado + ".");
        }
    }

    public static Departamento buscarDepartamentoPorID(String ID, List<Departamento> listaDepartamentos) {
        for (Departamento departamento : listaDepartamentos) {
            if (departamento.getID().equals(ID)) {
                return departamento;
            }
        }
        return null; // No encontrado
    }

    public static int leerEntero(Scanner scanner, String mensaje) {
        System.out.println(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        return valor;
    }

    public static boolean leerBoolean(Scanner scanner, String mensaje) {
        System.out.println(mensaje);
        while (!scanner.hasNextBoolean()) {
            System.out.println("Por favor, ingrese true o false.");
            scanner.next();
        }
        boolean valor = scanner.nextBoolean();
        scanner.nextLine();  // Consumir el salto de línea
        return valor;
    }

    public static void gestionarArrendatarios(Scanner scanner, List<Arrendatario> listaDeArrendatarios) {

    }

    public static void gestionarProyectos(Scanner scanner, List<Proyecto> listaDeProyectos, List<Departamento> listaDeDepartamentos) {

    }
}
