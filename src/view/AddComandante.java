package view;

import java.awt.*;
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

public class AddComandante extends JFrame implements ActionListener {
    private JLabel codigoComandante;
    private JLabel nombre;
    private JLabel apellidos;
    private JLabel anios;
    private JLabel escuela;
    private JLabel fecha;
    private JTextField tcodigo;
    private JTextField tnombre;
    private JTextField tapellidos;
    private JTextField tanios;
    private JTextField tescuela;
    private JTextField tfecha;
    private JButton boton;

    public AddComandante(){
        initComponents();
    }

    public void initComponents(){
        setTitle("Bitcora-agregar Comandante");
        setLayout(new GridLayout(8,2));
        InitialData datos = new InitialData();

        this.codigoComandante =new JLabel("Codigo Comandante");
        add(this.codigoComandante);
        this.tcodigo = new JTextField();
        add(this.tcodigo);

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

        this.boton = new JButton("Agregar");
        add(this.boton);
        this.boton.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.boton) {
            int codigo = Integer.parseInt((String)this.tcodigo.getText());
            String nombre = (String)this.tnombre.getText();
            String apellido=(String)this.tapellidos.getText();
            int anios=Integer.parseInt(((String)this.tanios.getText()));
            String escuela =(String)this.tescuela.getText();
            String fecha= (String)this.tfecha.getText();

            ComandanteModel comandante = new ComandanteModel(codigo,nombre,apellido,anios,escuela,fecha);
            ComandanteDAO coman = new ComandanteDAO();
            coman.insertComandante(comandante);
        }
    }


}
