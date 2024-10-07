import javax.swing.*;
import java.util.*;
import entities.Departamento;
import entities.Arrendatario;

public class VerDepartamentos extends JFrame {
    private JList<String> list1;
    private JButton volverButton;
    private JPanel panelVerDepartamentos;

    public VerDepartamentos(List<Departamento> departamentos) {
        setTitle("Ver Departamentos");
        setContentPane(panelVerDepartamentos);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        DefaultListModel<String> model = new DefaultListModel<>();

        for (Departamento departamento : departamentos) {
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

            model.addElement(sb.toString());
        }

        list1.setModel(model);

        volverButton.addActionListener(e -> {
            dispose();
        });
    }

    public static void main(String[] args) {
        List<Departamento> departamentos = new ArrayList<>();
        JFrame frame = new VerDepartamentos(departamentos);
        frame.setVisible(true);
    }
}
