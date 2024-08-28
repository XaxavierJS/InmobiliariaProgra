import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

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
                    gestionarDepartamentos(listaDeDepartamentos);
                    break;
                case 2:
                    gestionarArrendatarios(listaDeArrendatarios, listaDeDepartamentos);
                    break;
                case 3:
                    gestionarProyectos(listaDeProyectos, listaDeDepartamentos);
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

    public static int leerOpcionUsuario() {

    }

    public static void gestionarDepartamentos(List<Departamento> listaDeDepartamentos) {

    }

    public static void gestionarArrendatarios(List<Arrendatario> listaDeArrendatarios, List<Departamento> listaDeDepartamentos) {

    }

    public static void gestionarProyectos(List<Proyecto> listaDeProyectos, List<Departamento> listaDeDepartamentos) {
    }
}