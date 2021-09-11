package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;

import model.ComandanteModel;
import utils.ConnectionDB;

public class ComandanteDAO {
    private Connection conn = null;

    public ArrayList<ComandanteModel> getAllComandantes() {
        ArrayList<ComandanteModel> comandantes = new ArrayList<>();
        try {
            if (conn == null)
                conn = ConnectionDB.getConnection();
            String sql = "SELECT codigo_comandante, nombres, apellidos, anio_servicio, escuela, fecha_ingreso FROM comandante";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                ComandanteModel comandante = new ComandanteModel(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4), result.getString(5), result.getString(6));
                comandantes.add(comandante);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return comandantes;
    }

    public ArrayList<ComandanteModel> getComandante(int codigoComandante) {
        ArrayList<ComandanteModel> comandantes = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "SELECT nombres, apellidos, anio_servicio, escuela, fecha_ingreso FROM comandante WHERE codigo_comandante=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, codigoComandante);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                ComandanteModel comandante = new ComandanteModel(result.getString(1), result.getString(2), result.getInt(3), result.getString(4), result.getString(5));
                comandantes.add(comandante);
            }
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return comandantes;
    }

    public void insertComandante(ComandanteModel comandante){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "INSERT INTO comandante(codigo_comandante, nombres, apellidos, anio_servicio, escuela, fecha_ingreso) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, comandante.getCodigoComandante());
            statement.setString(2, comandante.getNombreComandante());
            statement.setString(3, comandante.getApellidoComandante());
            statement.setInt(4, comandante.getAnioServicioComandante());
            statement.setString(5, comandante.getEscuelaComandante());
            statement.setString(6, comandante.getFechaIngresoComandante());

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0)
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void updateComandante(ComandanteModel comandante) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "UPDATE comandante SET nombres=?, apellidos=?, anio_servicio=?, escuela=?, fecha_ingreso=? WHERE codigo_comandante=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, comandante.getNombreComandante());
            statement.setString(2, comandante.getApellidoComandante());
            statement.setInt(3, comandante.getAnioServicioComandante());
            statement.setString(4, comandante.getEscuelaComandante());
            statement.setString(5, comandante.getFechaIngresoComandante());
            statement.setInt(6, comandante.getCodigoComandante());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0)
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
    }

    public void deleteComandante(int codigoComandante) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();

            String sql = "DELETE FROM comandante WHERE codigo_comandante=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, codigoComandante);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

}
