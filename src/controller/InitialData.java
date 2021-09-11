package controller;

import access.ComandanteDAO;
import java.util.ArrayList;
import model.ComandanteModel;


public class InitialData {
    private ArrayList<ComandanteModel> comandantes = null;

    public InitialData() {
        ComandanteDAO comandanteDAO = new ComandanteDAO();
        this.comandantes = comandanteDAO.getAllComandantes();
        //this.comandantes.add(0, new ComandanteModel(-1, "Todos los comandantes"));


    }

    public ArrayList<ComandanteModel> getComandantes() {
        return comandantes;
    }
}
