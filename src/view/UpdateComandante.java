package view;

import model.ComandanteModel;

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

public class UpdateComandante extends JFrame implements ActionListener {
    private JLabel nombre;
    private JLabel apellidos;
    private JLabel anios;
    private JLabel escuela;
    private JLabel fecha;
    private JTextField tnombre;
    private JTextField tapellidos;
    private JTextField tanios;
    private JTextField tescuela;
    private JTextField tfecha;
    private JButton boton;

    private JLabel ActualizarComandante;
    private JComboBox<ComandanteModel> codigoComandante;

    public UpdateComandante( ){
        initComponents();
    }

    public void initComponents(){
        setTitle("Actualizar Comandante");
        setLayout(new GridLayout(8,2));
        InitialData datos = new InitialData();

        this.ActualizarComandante = new JLabel("Selecciones Comandante");
        add(this.ActualizarComandante);

        this.codigoComandante=new JComboBox();
        this.codigoComandante.setModel(new DefaultComboBoxModel<>(datos.getComandantes().toArray(new ComandanteModel[datos.getComandantes().size()])));
        this.codigoComandante.setSelectedIndex(0);
        add(this.codigoComandante);




        this.nombre= new JLabel("Nombre Comandante");
        add(this.nombre);
        this.tnombre= new JTextField();
        add(this.tnombre);

        this.apellidos = new JLabel("Apellidos Comandante");
        add(this.apellidos);
        this.tapellidos = new JTextField();
        add(this.tapellidos);

        this.anios = new JLabel("Años Experiencia");
        add(this.anios);
        this.tanios=new JTextField();
        add(this.tanios);

        this.escuela=new JLabel("Escuela ");
        add(this.escuela);
        this.tescuela= new JTextField();
        add(this.tescuela);

        this.fecha= new JLabel("Fecha ingreso (AA/MM/DD)");
        add(this.fecha);
        this.tfecha = new JTextField();
        add(this.tfecha);

        this.boton = new JButton("Actualizar");
        add(this.boton);
        this.boton.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionevent) {
        if (actionevent.getSource() == this.boton) {
            int id = ((ComandanteModel) this.codigoComandante.getSelectedItem()).getCodigoComandante();
            String nombre = (String)this.tnombre.getText();
            String apellido=(String)this.tapellidos.getText();
            int anios=Integer.parseInt(((String)this.tanios.getText()));
            String escuela =(String)this.tescuela.getText();
            String fecha= (String)this.tfecha.getText();
            ComandanteModel modelo = new ComandanteModel(id, nombre, apellido, anios, escuela, fecha);
            ComandanteDAO com = new ComandanteDAO();
            com.updateComandante(modelo);

        }
    }



}
