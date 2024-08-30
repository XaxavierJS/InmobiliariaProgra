import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Departamento> listaDepartamentos = new ArrayList<>();
        List<Arrendatario> listaArrendatarios = new ArrayList<>();
        List<Proyecto> listaProyectos = new ArrayList<>();

        // Menú principal
        while (true) {
            mostrarMenu();
            int opcion = leerOpcionUsuario(scanner);

            switch (opcion) {
                case 1:
                    gestionarDepartamentos(scanner, listaDepartamentos);
                    break;
                case 2:
                    gestionarArrendatarios(scanner, listaArrendatarios, listaDepartamentos);
                    break;
                case 3:
                    gestionarProyectos(scanner, listaProyectos, listaDepartamentos);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return; // Salir del programa
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static int leerOpcionUsuario(Scanner scanner) {
        int opcion = scanner.nextInt();
        scanner.nextLine();
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

    public static void mostrarMenuGestionDepartamentos(){
        System.out.println("=== Menú Gestión Departamentos ===");
        System.out.println("1. Agregar Departamento");
        System.out.println("2. Eliminar Departamento");
        System.out.println("3. Verificar Disponibilidad");
        System.out.println("4. Buscar Departamento");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void gestionarDepartamentos(Scanner scanner, List<Departamento> listaDepartamentos) {
        while (true) {
            mostrarMenuGestionDepartamentos();
            int opcion = leerOpcionUsuario(scanner);

            switch (opcion) {
                case 1:
                    agregarDepartamento(scanner, listaDepartamentos);
                    break;
                case 2:
                    eliminarDepartamento(scanner, listaDepartamentos);
                    break;
                case 3:
                    verificarDisponibilidad(scanner, listaDepartamentos);
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    return; // Salir del programa
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    public static void agregarDepartamento(Scanner scanner, List<Departamento> listaDepartamentos){
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

    public static void eliminarDepartamento(Scanner scanner, List<Departamento> listaDepartamentos){
        System.out.println("Ingrese el ID del departamento a eliminar: ");
        String IDbuscado = scanner.nextLine();

        Departamento departamentoAEliminar = null;

        for(Departamento departamento : listaDepartamentos){
            if (departamento.getID().equals(IDbuscado)){
                departamentoAEliminar = departamento;
                break;
            }
        }

        if (departamentoAEliminar != null){
            listaDepartamentos.remove(departamentoAEliminar);
            System.out.println("¡Departamento eliminado exitosamente!");
        }
        else{
            System.out.println("No se encontró el departamento con ID: " + IDbuscado + ".");
        }
    }

    public static void verificarDisponibilidad(Scanner scanner, List<Departamento> listaDepartamentos){
        System.out.println("Ingrese el ID del departamento a verificar: ");
        String IDbuscado = scanner.nextLine();
        Departamento departamentoAVerficar = null;

        for (Departamento departamento : listaDepartamentos){
            if (departamento.getID().equals(IDbuscado)){
                departamentoAVerficar = departamento;
                break;
            }
        }

        if (departamentoAVerficar != null){
            if (departamentoAVerficar.getEstado()){
                System.out.println("El departamento con ID: " + IDbuscado + " se encuentra disponible.");
            }
            else{
                System.out.println("El departamento con ID: " + IDbuscado + " NO se encuentra disponible.");
            }
        }
        else{
            System.out.println("No se encontró el departamento con ID: " + IDbuscado + ".");
        }
    }

    public static void gestionarArrendatarios(Scanner scanner, List<Arrendatario> listaDeArrendatarios, List<Departamento> listaDeDepartamentos) {

    }

    public static void gestionarProyectos(Scanner scanner, List<Proyecto> listaDeProyectos, List<Departamento> listaDeDepartamentos) {
    }
}