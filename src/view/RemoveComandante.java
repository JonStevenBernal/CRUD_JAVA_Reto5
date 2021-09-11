package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import access.ComandanteDAO;
import controller.InitialData;
import model.ComandanteModel;

public class RemoveComandante  extends JFrame implements ActionListener {
    private JLabel eliminarComandante;
    private JComboBox<ComandanteModel> codigoComandante;
    private JButton accionEliminarComandante;

    public RemoveComandante() {
        initComponents();
    }

    public void initComponents() {
        setTitle("Bitcora-EliminarComandante");
        setLayout(new GridLayout(8,2));
        InitialData datos = new InitialData();

        this.eliminarComandante=new JLabel("¿Que id desea eliminar?");
        add(this.eliminarComandante);

        this.codigoComandante=new JComboBox();
        this.codigoComandante.setModel(new DefaultComboBoxModel<>(datos.getComandantes().toArray(new ComandanteModel[datos.getComandantes().size()])));
        this.codigoComandante.setSelectedIndex(0);
        add(this.codigoComandante);

        this.accionEliminarComandante = new JButton("Eliminar");
        add(this.accionEliminarComandante);
        this.accionEliminarComandante.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionevent) {
        if (actionevent.getSource() == this.accionEliminarComandante) {
            int id = ((ComandanteModel) this.codigoComandante.getSelectedItem()).getCodigoComandante();
            ComandanteDAO com = new ComandanteDAO();
            com.deleteComandante(id);
        }
    }
}
