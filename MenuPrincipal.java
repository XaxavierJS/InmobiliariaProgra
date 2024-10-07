import javax.swing.*;
import java.util.*;

import entities.Proyecto;

public class MenuPrincipal extends JFrame {
    private JButton AgregarProyectoButton;
    private JButton EliminarProyectoButton;
    private JButton GestionarProyectoButton;
    private JPanel panelMenuPrincipal;
    private JList list1;
    private DefaultListModel<String> listModel;
    private List<Proyecto> proyectos;
    private GestionarProyecto gestionarProyectoWindow;

    public MenuPrincipal() {

        listModel = new DefaultListModel<>();
        list1.setModel(listModel);

        List<Proyecto> proyectos = new ArrayList<Proyecto>(); //Proyecto.cargarProyectosDesdeCSV("ruta/al/archivo.csv");
        for (Proyecto proyecto : proyectos) {
            listModel.addElement(proyecto.getNombreProyecto());
        }

        setContentPane(panelMenuPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        /*AgregarProyectoButton.addActionListener(e -> {
            // Solicitar el nombre del proyecto
            String nombreProyecto = JOptionPane.showInputDialog("Ingrese el nombre del nuevo proyecto:");

            if (nombreProyecto != null && !nombreProyecto.isEmpty()) {
                // Solicitar la ubicación del proyecto
                String ubicacionProyecto = JOptionPane.showInputDialog("Ingrese la ubicación del nuevo proyecto:");

                if (ubicacionProyecto != null && !ubicacionProyecto.isEmpty()) {
                    // Crear un objeto Proyecto con el nombre y la ubicación
                    Proyecto nuevoProyecto = new Proyecto(nombreProyecto, ubicacionProyecto);

                    // Agregar el nombre del proyecto a la lista visual
                    listModel.addElement("Nombre: " + nuevoProyecto.getNombreProyecto() + "     ||     Ubicación: " + nuevoProyecto.getUbicacion());
                    // Aquí puedes agregar el proyecto a una lista de objetos Proyecto para futuras gestiones
                    // proyectosList.add(nuevoProyecto);
                } else {
                    JOptionPane.showMessageDialog(null, "La ubicación del proyecto no puede estar vacía.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nombre del proyecto no puede estar vacío.");
            }
        });*/

        AgregarProyectoButton.addActionListener(e -> {
            String nombreProyecto = JOptionPane.showInputDialog("Ingrese el nombre del nuevo proyecto:");
            if (nombreProyecto != null && !nombreProyecto.isEmpty()) {
                String ubicacionProyecto = JOptionPane.showInputDialog("Ingrese la ubicación del nuevo proyecto:");
                if (ubicacionProyecto != null && !ubicacionProyecto.isEmpty()) {
                    Proyecto nuevoProyecto = new Proyecto(nombreProyecto, ubicacionProyecto);
                    proyectos.add(nuevoProyecto);  // Agregar el proyecto a la lista de objetos
                    listModel.addElement("Nombre: " + nuevoProyecto.getNombreProyecto() + "     ||     Ubicación: " + nuevoProyecto.getUbicacion());
                } else {
                    JOptionPane.showMessageDialog(null, "La ubicación del proyecto no puede estar vacía.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El nombre del proyecto no puede estar vacío.");
            }
        });

        EliminarProyectoButton.addActionListener(e -> {
            int selectedIndex = list1.getSelectedIndex();  // Obtener el índice del proyecto seleccionado
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);  // Eliminar el proyecto del modelo y la lista
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un proyecto para eliminar.");
            }
        });

        GestionarProyectoButton.addActionListener(e -> {
            int selectedIndex = list1.getSelectedIndex();  // Obtener el índice del proyecto seleccionado
            if (selectedIndex != -1) {
                Proyecto proyectoSeleccionado = proyectos.get(selectedIndex);  // Obtener el proyecto desde la lista de objetos

                if (gestionarProyectoWindow == null) {
                    gestionarProyectoWindow = new GestionarProyecto(proyectoSeleccionado);  // Pasar el proyecto seleccionado
                }
                gestionarProyectoWindow.setVisible(true);  // Mostrar la ventana de gestión
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un proyecto para gestionar.");
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MenuPrincipal");
        frame.setContentPane(new MenuPrincipal().panelMenuPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
