import javax.swing.*;
import java.util.*;
import entities.Departamento;
import entities.Arrendatario;

public class VerDepartamentos extends JFrame {
    private JList<String> list1;
    private JButton volverButton;
    private JPanel panelVerDepartamentos;
    private JTextField precioMaxTextField;
    private JButton filtrarButton;

    public VerDepartamentos(List<Departamento> departamentos) {
        setTitle("Ver Departamentos");
        setContentPane(panelVerDepartamentos);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        DefaultListModel<String> model = new DefaultListModel<>();
        cargarListaDepartamentos(departamentos, model);

        list1.setModel(model);

        volverButton.addActionListener(e -> dispose());

        // Acción del botón Filtrar
        filtrarButton.addActionListener(e -> {
            try {
                double precioMax = Double.parseDouble(precioMaxTextField.getText());
                DefaultListModel<String> modeloFiltrado = new DefaultListModel<>();

                for (Departamento departamento : departamentos) {
                    if (departamento.getPrecio() <= precioMax) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("ID: ").append(departamento.getID()).append(", ");
                        sb.append("Nombre: ").append(departamento.getNombre()).append(", ");
                        sb.append("Precio: ").append(departamento.getPrecio()).append(", ");
                        sb.append("Arrendatarios: ");

                        // Obtener arrendatarios
                        List<Arrendatario> arrendatarios = departamento.getArrendatarios();
                        if (arrendatarios.isEmpty()) {
                            sb.append("Ninguno");
                        } else {
                            for (Arrendatario arrendatario : arrendatarios) {
                                sb.append(arrendatario.getNombre()).append(" ");
                            }
                        }

                        modeloFiltrado.addElement(sb.toString());
                    }
                }

                // Actualizar la lista con los departamentos filtrados
                list1.setModel(modeloFiltrado);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido para el precio.");
            }
        });
    }

    // Método para cargar la lista completa de departamentos
    private void cargarListaDepartamentos(List<Departamento> departamentos, DefaultListModel<String> model) {
        for (Departamento departamento : departamentos) {
            StringBuilder sb = new StringBuilder();
            sb.append("ID: ").append(departamento.getID()).append(", ");
            sb.append("Nombre: ").append(departamento.getNombre()).append(", ");
            sb.append("Precio: ").append(departamento.getPrecio()).append(", ");
            sb.append("Arrendatarios: ");

            List<Arrendatario> arrendatarios = departamento.getArrendatarios();
            if (arrendatarios.isEmpty()) {
                sb.append("Ninguno");
            } else {
                for (Arrendatario arrendatario : arrendatarios) {
                    sb.append(arrendatario.getNombre()).append(" ");
                }
            }

            model.addElement(sb.toString());
        }
    }

    public static void main(String[] args) {
        List<Departamento> departamentos = new ArrayList<>();
        // Puedes agregar departamentos de prueba aquí si es necesario.
        JFrame frame = new VerDepartamentos(departamentos);
        frame.setVisible(true);
    }
}