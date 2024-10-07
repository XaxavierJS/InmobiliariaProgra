import javax.swing.*;
import entities.Departamento;
import java.util.*;

public class EliminarDepartamento extends JFrame{
    private JTextField textField1;
    private JButton volverButton;
    private JButton aceptarButton;
    private JPanel panelEliminarDepartamento;

    private List<Departamento> departamentosList;

    public EliminarDepartamento(List<Departamento> departamentosList) {
        this.departamentosList = departamentosList;

        setTitle("Eliminar Departamento");
        setContentPane(panelEliminarDepartamento);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        aceptarButton.addActionListener(e -> {
            String id = textField1.getText(); // Obtenemos el ID del departamento a eliminar

            if (id != null && !id.isEmpty()) {
                // Buscamos el departamento en la lista
                Departamento departamentoAEliminar = buscarDepartamento(id);

                if (departamentoAEliminar != null) {
                    departamentosList.remove(departamentoAEliminar); // Eliminamos el departamento
                    JOptionPane.showMessageDialog(null, "Departamento eliminado correctamente.");
                    textField1.setText(""); // Limpiamos el campo de texto
                } else {
                    JOptionPane.showMessageDialog(null, "Departamento no encontrado.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un ID válido.");
            }
        });

        volverButton.addActionListener(e -> {
            dispose();
        });
    }

    private Departamento buscarDepartamento(String id) {
        for (Departamento d : departamentosList) {
            if (d.getID().equals(id)) {
                return d;
            }
        }
        return null; // Retorna null si no se encuentra
    }

    public static void main(String[] args) {
        List<Departamento> departamentos = new ArrayList<>();
        JFrame frame = new JFrame("Eliminar Departamento");
        frame.setContentPane(new EliminarDepartamento(departamentos).panelEliminarDepartamento);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}