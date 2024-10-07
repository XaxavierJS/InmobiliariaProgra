import javax.swing.*;
import java.util.*;
import entities.Departamento;

public class AgregarDepartamento extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton volverButton;
    private JButton aceptarButton;
    private JPanel agregarDepartamento;
    private List<Departamento> departamentosList;

    public AgregarDepartamento(List<Departamento> departamentosList) {
        this.departamentosList = departamentosList;
        setContentPane(agregarDepartamento);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        aceptarButton.addActionListener(e -> {
            String ID = textField1.getText();
            String nombre = textField3.getText();
            String precioStr = textField2.getText();

            if (ID != null && !ID.isEmpty() && nombre != null && !nombre.isEmpty() && precioStr != null && !precioStr.isEmpty()) {
                try {
                    // Validar que el precio sea un número válido
                    int precio = Integer.parseInt(precioStr);

                    // Crear un nuevo departamento
                    Departamento nuevoDepartamento = new Departamento(nombre, ID, precio, true, "N/A", 0, 0, 0);

                    // Agregar el departamento a la lista de departamentos
                    departamentosList.add(nuevoDepartamento);

                    // Limpiar los campos de texto después de agregar
                    textField1.setText("");
                    textField3.setText("");
                    textField2.setText("");

                    JOptionPane.showMessageDialog(null, "Departamento agregado exitosamente!");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El precio debe ser un número válido.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
            }
        });

        volverButton.addActionListener(e -> {
            dispose();
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AgregarDepartamento");
        frame.setContentPane(new AgregarDepartamento(new ArrayList<Departamento>()).agregarDepartamento);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
