package view;

import controller.ChangeEvent;
import controller.ClickEvent;
import controller.InitialData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.ComandanteModel;
import controller.InitialData;

import java.awt.*;
import java.util.ArrayList;


public class ControlsPanel extends JPanel {
    private JButton addComandante;
    private JButton eliminar;
    private JButton consultar;
    private JTable tablaresultados;

    public ControlsPanel(ResultsPanel resultsPanel) {
        this.tablaresultados = resultsPanel.getTblResults();
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2,1));
        InitialData datoInicial = new InitialData();
        this.setTablaresultados(datoInicial.getComandantes());
        ClickEvent clickEvent = new ClickEvent(this);
        this.addComandante = new JButton("Agregar Nuevo Comandante");
        add(this.addComandante);
        this.getAddComandante().addActionListener(clickEvent);
        this.eliminar = new JButton("Eliminar Comandante");
        add(this.eliminar);
        this.getEliminar().addActionListener(clickEvent);
        this.consultar = new JButton("Actualizar");
        add(this.consultar);
        this.getConsultar().addActionListener(clickEvent);
    }

    public JButton getAddComandante() {
        return addComandante;
    }

    public JButton getEliminar() {
        return eliminar;
    }

    public JButton getConsultar() {
        return consultar;
    }

    public JTable getTablaresultados() {
        return tablaresultados;
    }

    public void setTablaresultados(ArrayList<ComandanteModel> comandante) {
        String[] encabezado = {"Codigo", "Nombre", "Apellido", "Años de Servicio", "Escuela", "Fecha de Ingreso"};
        this.tablaresultados.removeAll();
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.setColumnIdentifiers(encabezado);
        this.tablaresultados.setModel(modeloTabla);

        for (int i = 0; i < comandante.size(); i++) {
            modeloTabla.addRow((Object[]) comandante.get(i).toArray());
        }
    }
}
