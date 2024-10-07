import javax.swing.*;
import java.util.*;
import entities.Arrendatario; // Asegúrate de que esta clase exista

public class AgregarArrendatario extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField4;
    private JTextField textField3;
    private JButton aceptarButton;
    private JButton volverButton;
    private JPanel panelAgregarArrendatario;

    private List<Arrendatario> arrendatariosList; // Lista para almacenar arrendatarios

    public AgregarArrendatario(List<Arrendatario> arrendatariosList) {
        this.arrendatariosList = arrendatariosList;

        setContentPane(panelAgregarArrendatario);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        aceptarButton.addActionListener(e -> {
            String nombre = textField1.getText();
            String rut = textField2.getText();
            String telefono = textField4.getText();
            String email = textField3.getText();

            // Verificar que todos los campos estén llenos
            if (!nombre.isEmpty() && !rut.isEmpty() && !telefono.isEmpty() && !email.isEmpty()) {
                // Crear un nuevo arrendatario
                Arrendatario arrendatario = new Arrendatario(nombre, rut, telefono, email, null);

                // Agregar el arrendatario a la lista
                arrendatariosList.add(arrendatario);

                // Limpiar los campos de texto después de agregar
                textField1.setText("");
                textField2.setText("");
                textField4.setText("");
                textField3.setText("");

                JOptionPane.showMessageDialog(null, "Arrendatario agregado correctamente.");
                dispose(); // Cierra la ventana
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            }
        });

        volverButton.addActionListener(e -> {
            dispose(); // Cierra la ventana
        });
    }

    public static void main(String[] args) {
        // Para probar la clase, crea una lista de arrendatarios
        List<Arrendatario> arrendatariosList = new ArrayList<>();
        AgregarArrendatario frame = new AgregarArrendatario(arrendatariosList);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
