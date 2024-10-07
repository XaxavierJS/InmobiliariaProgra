import javax.swing.*;
import entities.Departamento;

public class GestionarArrendatario extends JFrame{
    private JButton volverButton;
    private JButton agregarArrendatarioButton;
    private JButton eliminarArrendatarioButton;
    private JPanel panelGestionarArrendatario;
    private JButton verArrendatariosButton;

    private Departamento departamento;

    private AgregarArrendatario agregarArrendatarioWindow;
    private EliminarArrendatario eliminarArrendatarioWindow;

    public GestionarArrendatario(Departamento departamento) {
        this.departamento = departamento;
        setTitle("Gestionar Departamento: " + departamento.getNombre());
        setContentPane(panelGestionarArrendatario);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        agregarArrendatarioButton.addActionListener(e -> {
            if (agregarArrendatarioWindow == null) {
                agregarArrendatarioWindow = new AgregarArrendatario(departamento.getArrendatarios());
            }
            agregarArrendatarioWindow.setVisible(true);
        });

        eliminarArrendatarioButton.addActionListener(e -> {
            if (eliminarArrendatarioWindow == null) {
                eliminarArrendatarioWindow = new EliminarArrendatario(departamento.getArrendatarios());
            }
            eliminarArrendatarioWindow.setVisible(true);
        });

        verArrendatariosButton.addActionListener(e -> {
            if (departamento.getArrendatarios().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay arrendatarios en este departamento.");
            } else {
                VerArrendatarios verArrendatariosWindow = new VerArrendatarios(departamento.getArrendatarios());
                verArrendatariosWindow.setVisible(true);
            }
        });

        volverButton.addActionListener(e -> {
            dispose();
        });
    }
}
