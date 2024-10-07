import javax.swing.*;
import java.util.*;
import entities.Arrendatario;

public class VerArrendatarios extends JFrame {
    private JList<String> list1;
    private JButton volverButton;
    private JPanel panelVerArrendatarios;

    public VerArrendatarios(List<Arrendatario> arrendatarios) {
        setTitle("Ver Arrendatarios");
        setContentPane(panelVerArrendatarios);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        DefaultListModel<String> model = new DefaultListModel<>();

        for (Arrendatario arrendatario : arrendatarios) {
            StringBuilder sb = new StringBuilder();
            sb.append("RUT: ").append(arrendatario.getRut()).append(", ");
            sb.append("Nombre: ").append(arrendatario.getNombre()).append(", ");
            sb.append("Correo: ").append(arrendatario.getCorreo()).append(", ");
            sb.append("Teléfono: ").append(arrendatario.getTelefono()).append(", ");
            model.addElement(sb.toString());
        }

        list1.setModel(model);

        volverButton.addActionListener(e -> {
            dispose();
        });
    }

    public static void main(String[] args) {
        List<Arrendatario> arrendatarios = new ArrayList<>();
        // Puedes agregar arrendatarios de prueba aquí si es necesario.

        JFrame frame = new VerArrendatarios(arrendatarios);
        frame.setVisible(true);
    }
}
