import javax.swing.*;
import entities.Arrendatario; // Asegúrate de que esta clase exista
import java.util.*;

public class EliminarArrendatario extends JFrame {
    private JTextField textField1; // Campo para ingresar el RUT del arrendatario
    private JButton volverButton1;
    private JButton aceptarButton;
    private JPanel panelEliminarArrendatario;

    private List<Arrendatario> arrendatariosList; // Lista de arrendatarios

    public EliminarArrendatario(List<Arrendatario> arrendatariosList) {
        this.arrendatariosList = arrendatariosList;

        setTitle("Eliminar Arrendatario");
        setContentPane(panelEliminarArrendatario);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        aceptarButton.addActionListener(e -> {
            String rut = textField1.getText(); // Obtenemos el RUT del arrendatario a eliminar

            if (rut != null && !rut.isEmpty()) {
                // Buscamos el arrendatario en la lista
                Arrendatario arrendatarioAEliminar = buscarArrendatario(rut);

                if (arrendatarioAEliminar != null) {
                    arrendatariosList.remove(arrendatarioAEliminar); // Eliminamos el arrendatario
                    JOptionPane.showMessageDialog(null, "Arrendatario eliminado correctamente.");
                    textField1.setText(""); // Limpiamos el campo de texto
                } else {
                    JOptionPane.showMessageDialog(null, "Arrendatario no encontrado.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un RUT válido.");
            }
        });

        volverButton1.addActionListener(e -> {
            dispose(); // Cierra la ventana
        });
    }

    private Arrendatario buscarArrendatario(String rut) {
        for (Arrendatario a : arrendatariosList) {
            if (a.getRut().equals(rut)) {
                return a;
            }
        }
        return null; // Retorna null si no se encuentra
    }

    public static void main(String[] args) {
        List<Arrendatario> arrendatarios = new ArrayList<>();
        JFrame frame = new JFrame("Eliminar Arrendatario");
        frame.setContentPane(new EliminarArrendatario(arrendatarios).panelEliminarArrendatario);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
