import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import entities.Arrendatario;
import entities.Departamento;
import models.DepartamentoModel;

public class ReporteArrendatarios {

    // Método para generar el reporte
    public void generarReportePorDepartamento(DepartamentoModel departamentoModel) {
        // Ruta fija para guardar el archivo en el directorio de usuario
        String rutaCarpeta = System.getProperty("user.home") + "\\";

        // Crear archivo .txt en el directorio de usuario
        String nombreArchivo = rutaCarpeta + "ReporteArrendatariosPorDepartamento.txt";
        File archivoReporte = new File(nombreArchivo);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoReporte))) {
            // Escribir la cabecera del reporte
            writer.write("=== Reporte de Arrendatarios por Departamento ===\n\n");

            // Obtener todos los departamentos y sus arrendatarios
            List<Departamento> departamentos = departamentoModel.obtenerTodosLosDepartamentos();
            for (Departamento departamento : departamentos) {
                writer.write("Departamento: " + departamento.getNombre() + " (ID: " + departamento.getID() + ")\n");
                writer.write("Precio: " + departamento.getPrecio() + "\n");
                writer.write("Arrendatarios:\n");

                List<Arrendatario> arrendatarios = departamento.getArrendatarios();
                if (arrendatarios.isEmpty()) {
                    writer.write("  No hay arrendatarios registrados.\n");
                } else {
                    for (Arrendatario arrendatario : arrendatarios) {
                        writer.write("  - Nombre: " + arrendatario.getNombre() + ", RUT: " + arrendatario.getRut() +
                                ", Correo: " + arrendatario.getCorreo() + ", Teléfono: " + arrendatario.getTelefono() + "\n");
                    }
                }
                writer.write("\n");
            }

            System.out.println("Reporte generado correctamente en: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }
    }
}
