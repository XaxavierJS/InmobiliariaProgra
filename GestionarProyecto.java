import javax.swing.*;
import entities.Proyecto;
import entities.Departamento;

public class GestionarProyecto extends JFrame{
    private JPanel panelGestionarProyecto;
    private JButton agregarDepartamentoButton;
    private JButton eliminarDepartamentoButton;
    private JButton volverButton;
    private JButton verDepartementosButton;
    private JButton gestionarDepartamentosButton;
    private Proyecto proyecto;

    private AgregarDepartamento agregarDepartamentoWindow;
    private EliminarDepartamento eliminarDepartamentoWindow;

    public GestionarProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
        setTitle("Gestionar Proyecto: " + proyecto.getNombreProyecto());
        setContentPane(panelGestionarProyecto);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        agregarDepartamentoButton.addActionListener(e -> {
            if (agregarDepartamentoWindow == null) {
                agregarDepartamentoWindow = new AgregarDepartamento(proyecto.getDepartamentos());
            }
            agregarDepartamentoWindow.setVisible(true);
        });

        eliminarDepartamentoButton.addActionListener(e -> {
            if (eliminarDepartamentoWindow == null) {
                eliminarDepartamentoWindow = new EliminarDepartamento(proyecto.getDepartamentos());
            }
            eliminarDepartamentoWindow.setVisible(true);
        });

        verDepartementosButton.addActionListener(e -> {
            if (proyecto.getDepartamentos().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay departamentos en este proyecto.");
            } else {
                VerDepartamentos verDepartamentosWindow = new VerDepartamentos(proyecto.getDepartamentos());
                verDepartamentosWindow.setVisible(true);
            }
        });

        gestionarDepartamentosButton.addActionListener(e -> {
            if (proyecto.getDepartamentos().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay departamentos en este proyecto.");
            } else {
                // Muestra un diálogo para seleccionar un departamento
                StringBuilder options = new StringBuilder("Seleccione un departamento:\n");
                for (int i = 0; i < proyecto.getDepartamentos().size(); i++) {
                    options.append(i + 1).append(". ").append(proyecto.getDepartamentos().get(i).getNombre()).append("\n");
                }
                String input = JOptionPane.showInputDialog(options.toString());
                int departamentoIndex = Integer.parseInt(input) - 1;

                if (departamentoIndex >= 0 && departamentoIndex < proyecto.getDepartamentos().size()) {
                    // Obtener el departamento seleccionado
                    Departamento departamentoSeleccionado = proyecto.getDepartamentos().get(departamentoIndex);
                    // Crear la ventana de gestión de arrendatarios, pasando el departamento seleccionado
                    GestionarArrendatario gestionarArrendatarioWindow = new GestionarArrendatario(departamentoSeleccionado);
                    gestionarArrendatarioWindow.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Selección inválida.");
                }
            }
        });

        volverButton.addActionListener(e -> {
            dispose();
        });
    }
    /*public static void main(String[] args) {
        JFrame frame = new JFrame("GestionarProyecto");
        frame.setContentPane(new GestionarProyecto().panelGestionarProyecto);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }*/

}
