package controller;

import access.ComandanteDAO;
import view.AddComandante;
import view.ControlsPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.ComandanteModel;
import view.RemoveComandante;
import view.UpdateComandante;


import java.awt.event.ActionListener;

public class ClickEvent implements ActionListener {
    private ControlsPanel controlsPanel;

    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getAddComandante()) {
            AddComandante agregarComandante = new AddComandante();
            agregarComandante.setVisible(true);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getEliminar()) {
            RemoveComandante eliminarComandante = new RemoveComandante();
            eliminarComandante.setVisible(true);
        }
        else if (actionEvent.getSource() == this.controlsPanel.getConsultar()) {
            UpdateComandante actualizarComandante = new UpdateComandante();
            actualizarComandante.setVisible(true);
        }
    }
}
