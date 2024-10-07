import javax.swing.*;
import java.util.*;
import entities.Proyecto;
import models.DepartamentoModel;
import models.ProyectoModel;
import models.ArrendatarioModel;

public class MenuPrincipal extends JFrame {
    private JButton AgregarProyectoButton;
    private JButton EliminarProyectoButton;
    private JButton GestionarProyectoButton;
    private JPanel panelMenuPrincipal;
    private JList<String> list1;
    private DefaultListModel<String> listModel;
    private List<Proyecto> proyectos;

    private ProyectoModel proyectoModel;
    private DepartamentoModel departamentoModel;
    private ArrendatarioModel arrendatarioModel;

    public MenuPrincipal() {
        // Inicializamos los modelos
        proyectoModel = new ProyectoModel();
        departamentoModel = new DepartamentoModel();
        arrendatarioModel = new ArrendatarioModel();

        // Cargar los archivos CSV al iniciar el programa
        cargarDatosDesdeCSV();

        // Configuración de la interfaz gráfica
        listModel = new DefaultListModel<>();
        list1.setModel(listModel);

        setContentPane(panelMenuPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        // Cargar los proyectos en la lista visual
        for (Proyecto proyecto : proyectos) {
            listModel.addElement(proyecto.getNombreProyecto() + " - " + proyecto.getUbicacion());
        }

        // Acción para agregar un proyecto
        AgregarProyectoButton.addActionListener(e -> {
            String nombreProyecto = JOptionPane.showInputDialog("Ingrese el nombre del nuevo proyecto:");
            if (nombreProyecto != null && !nombreProyecto.isEmpty()) {
                String ubicacionProyecto = JOptionPane.showInputDialog("Ingrese la ubicación del nuevo proyecto:");
                if (ubicacionProyecto != null && !ubicacionProyecto.isEmpty()) {
                    Proyecto nuevoProyecto = new Proyecto(nombreProyecto, ubicacionProyecto);
                    proyectos.add(nuevoProyecto);  // Agregar el proyecto a la lista de objetos
                    listModel.addElement(nuevoProyecto.getNombreProyecto() + " - " + nuevoProyecto.getUbicacion());
                } else {
                    JOptionPane.showMessageDialog(null, "La ubicación del proyecto no puede estar vacía.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nombre del proyecto no puede estar vacío.");
            }
        });

        // Acción para eliminar un proyecto
        EliminarProyectoButton.addActionListener(e -> {
            int selectedIndex = list1.getSelectedIndex();  // Obtener el índice del proyecto seleccionado
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);  // Eliminar el proyecto de la lista visual
                proyectos.remove(selectedIndex);  // Eliminar el proyecto de la lista de objetos
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un proyecto para eliminar.");
            }
        });

        // Acción para gestionar un proyecto
        GestionarProyectoButton.addActionListener(e -> {
            int selectedIndex = list1.getSelectedIndex();  // Obtener el índice del proyecto seleccionado
            if (selectedIndex != -1) {
                Proyecto proyectoSeleccionado = proyectos.get(selectedIndex);  // Obtener el proyecto desde la lista de objetos
                GestionarProyecto gestionarProyectoWindow = new GestionarProyecto(proyectoSeleccionado);  // Pasar el proyecto seleccionado
                gestionarProyectoWindow.setVisible(true);  // Mostrar la ventana de gestión
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un proyecto para gestionar.");
            }
        });
    }

    // Método para cargar los datos desde los archivos CSV
    private void cargarDatosDesdeCSV() {
        // Cargar proyectos
        proyectoModel.cargarProyectosDesdeCSV();
        proyectos = proyectoModel.obtenerProyectos();

        // Cargar departamentos y asociarlos a los proyectos
        departamentoModel.cargarDepartamentosDesdeCSV(proyectos);

        // Cargar arrendatarios y asociarlos a los departamentos
        arrendatarioModel.cargarArrendatariosDesdeCSV(departamentoModel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuPrincipal ventana = new MenuPrincipal();
            ventana.setVisible(true);
        });
    }
}
