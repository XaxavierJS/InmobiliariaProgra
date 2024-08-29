import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Departamento> listaDepartamentos = new ArrayList<>();
        List<Arrendatario> listaArrendatarios = new ArrayList<>();
        List<Proyecto> listaProyectos = new ArrayList<>();

        // Menú principal
        while (true) {
            mostrarMenu();
            int opcion = leerOpcionUsuario();

            switch (opcion) {
                case 1:
                    gestionarDepartamentos(listaDepartamentos);
                    break;
                case 2:
                    gestionarArrendatarios(listaArrendatarios, listaDepartamentos);
                    break;
                case 3:
                    gestionarProyectos(listaProyectos, listaDepartamentos);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return; // Salir del programa
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void mostrarMenu() {
        System.out.println("=== Menú Principal ===");
        System.out.println("1. Gestionar Departamentos");
        System.out.println("2. Gestionar Arrendatarios");
        System.out.println("3. Gestionar Proyectos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void mostrarMenuGestionDepartamentos(){
        System.out.println("=== Menú Gestión Departamentos ===");
        System.out.println("1. Agregar Departamento");
        System.out.println("2. Eliminar Departamento");
        System.out.println("3. Verificar Disponibilidad");
        System.out.println("0. Buscar Departamento");
        System.out.print("Seleccione una opción: ");
    }
    public static void agregarDepartamento(List<Departamento> listaDepartamentos){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del departamento:");
        String ID = scanner.nextLine();
        System.out.println("Ingrese el nombre del departamento:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el precio del departamento:");
        int precio = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la cantidad de piezas del departamento:");
        int piezas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la cantidad de baños del departamento:");
        int baños = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el tamaño del departamento (en m2):");
        int tamaño = scanner.nextInt();
        scanner.nextLine();
        System.out.println("¿Está disponible? (true/false):");
        boolean estado = scanner.nextBoolean();
        scanner.nextLine();
        System.out.println("Ingrese el número del departamento:");
        String numeroDepa = scanner.nextLine();

        Departamento nuevoDepartamento = new Departamento(nombre, ID, precio, null, null, estado, numeroDepa, piezas, baños, tamaño);
        listaDepartamentos.add(nuevoDepartamento);

        System.out.println("¡Departamento agregado exitosamente!");
    }

    public static int leerOpcionUsuario() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void gestionarDepartamentos(List<Departamento> listaDepartamentos) {
        while (true) {
            mostrarMenuGestionDepartamentos();
            int opcion = leerOpcionUsuario();

            switch (opcion) {
                case 1:
                    agregarDepartamento(listaDepartamentos);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return; // Salir del programa
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void gestionarArrendatarios(List<Arrendatario> listaDeArrendatarios, List<Departamento> listaDeDepartamentos) {

    }

    public static void gestionarProyectos(List<Proyecto> listaDeProyectos, List<Departamento> listaDeDepartamentos) {
    }
}