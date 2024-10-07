import controllers.ArrendatarioController;
import controllers.DepartamentoController;
import controllers.ProyectoController;
import exceptions.DepartamentoException;
import models.ArrendatarioModel;
import models.DepartamentoModel;
import models.ProyectoModel;
import entities.Departamento;
import entities.Proyecto;
import Utils.Utils;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws DepartamentoException {
        Scanner scanner = new Scanner(System.in);

        // Modelos
        ProyectoModel proyectoModel = new ProyectoModel();
        proyectoModel.cargarProyectosDesdeCSV(); // Cargar proyectos desde el CSV de proyectos

        // Cargar departamentos y asignarlos a los proyectos
        DepartamentoModel departamentoModel = new DepartamentoModel();
        departamentoModel.cargarDepartamentosDesdeCSV(proyectoModel.obtenerProyectos());  // Cargar los departamentos pasando los proyectos

        // Cargar arrendatarios y asignarlos a los departamentos
        ArrendatarioModel arrendatarioModel = new ArrendatarioModel();
        arrendatarioModel.cargarArrendatariosDesdeCSV(departamentoModel);  // Cargar los arrendatarios

        // Controladores
        DepartamentoController departamentoController = new DepartamentoController(departamentoModel, arrendatarioModel);
        ProyectoController proyectoController = new ProyectoController(proyectoModel, departamentoController);
        ArrendatarioController arrendatarioController = new ArrendatarioController(arrendatarioModel);

        // Reporte de arrendatarios
        ReporteArrendatarios reporteArrendatarios = new ReporteArrendatarios();

        // Obtener la ruta del escritorio
        String rutaEscritorio = Paths.get(System.getProperty("user.home"), "Desktop").toString();

        // Menú principal
        while (true) {
            System.out.println("=== Gestión de Proyectos ===");
            List<Proyecto> proyectos = proyectoController.obtenerProyectos();
            if (proyectos.isEmpty()) {
                System.out.println("No hay proyectos disponibles.");
                break;
            }

            // Mostrar proyectos con números
            for (int i = 0; i < proyectos.size(); i++) {
                System.out.println((i + 1) + ". " + proyectos.get(i).getNombreProyecto() + " - " + proyectos.get(i).getUbicacion());
            }

            System.out.println("9. Generar reporte de arrendatarios por departamento");
            System.out.print("Seleccione una opción: ");
            int opcionProyecto = Utils.leerEntero(scanner, "Opción: ");

            if (opcionProyecto == 9) {
                // Generar el reporte de arrendatarios
                reporteArrendatarios.generarReportePorDepartamento(departamentoModel);
                continue;
            }

            if (opcionProyecto < 1 || opcionProyecto > proyectos.size()) {
                System.out.println("Opción no válida. Intente nuevamente.");
                continue;
            }

            // Obtener el proyecto seleccionado
            Proyecto proyectoSeleccionado = proyectos.get(opcionProyecto - 1);
            System.out.println("Has seleccionado: " + proyectoSeleccionado.getNombreProyecto());

            // Menú para gestionar el proyecto seleccionado
            while (true) {
                System.out.println("\n=== Gestión de Departamentos en " + proyectoSeleccionado.getNombreProyecto() + " ===");
                System.out.println("1. Agregar Departamento");
                System.out.println("2. Eliminar Departamento");
                System.out.println("3. Modificar Departamento");
                System.out.println("4. Seleccionar Departamento");
                System.out.println("0. Volver a la selección de proyectos");
                System.out.print("Seleccione una opción: ");
                int opcion = Utils.leerOpcionUsuario(scanner);

                switch (opcion) {
                    case 1:
                        departamentoController.agregarDepartamento(scanner, proyectoSeleccionado);
                        break;
                    case 2:
                        departamentoController.eliminarDepartamento(scanner, proyectoSeleccionado);
                        break;
                    case 3:
                        departamentoController.modificarDepartamento(scanner, proyectoSeleccionado);
                        break;
                    case 4:
                        // Seleccionar y gestionar departamento
                        Departamento departamentoSeleccionado = departamentoController.seleccionarDepartamento(scanner, proyectoSeleccionado);
                        if (departamentoSeleccionado != null) {
                            // Menú para gestionar arrendatarios del departamento seleccionado
                            while (true) {
                                System.out.println("\n=== Gestión de Arrendatarios en " + departamentoSeleccionado.getNombre() + " ===");
                                System.out.println("1. Agregar Arrendatario");
                                System.out.println("2. Eliminar Arrendatario");
                                System.out.println("3. Modificar Arrendatario");
                                System.out.println("0. Volver a la gestión de departamentos");
                                int opcionArrendatario = Utils.leerOpcionUsuario(scanner);

                                if (opcionArrendatario == 0) break;

                                switch (opcionArrendatario) {
                                    case 1:
                                        departamentoController.agregarArrendatario(scanner, departamentoSeleccionado);
                                        break;
                                    case 2:
                                        departamentoController.eliminarArrendatario(scanner, departamentoSeleccionado);
                                        break;
                                    case 3:
                                        departamentoController.modificarArrendatario(scanner, departamentoSeleccionado);
                                        break;
                                    default:
                                        System.out.println("Opción no válida.");
                                }
                            }
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }

                if (opcion == 0) break;
            }
        }
    }
}
