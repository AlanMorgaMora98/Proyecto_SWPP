/*
------------------------
Dan Javier Olvera Villeda
UNIVERSIDAD VERACRUZANA
------------------------
 */

package Modelo;

import Controlador.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clave del programa: <br>
 * Autor: olver <br>
 * Fecha: 22/07/2020 <br>
 * Descripción: Implementación de la clase DocenteDAO, la cual da acceso a la información de los docentes contenidos en la base de datos<br>
 */
public class DocenteDAOImp implements DocenteDAO{

    @Override
    public boolean create(DocenteVO docente) throws SQLException{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        boolean resultado = false;
        try{
            String insertar = "INSERT INTO Docente VALUES (?,?,?)";
            try (PreparedStatement pst = conexBD.prepareStatement(insertar)){
                pst.setString(1, docente.getCedulaProfesional());
                pst.setString(2, docente.getNombre());
                pst.setString(3, docente.getGrupoNRC());
                
                conexBD.preparedStatementUpdate(pst);
            }           
            resultado = true;
        }catch(SQLException ex){
            throw ex;
        }finally{
            conexBD.close();
        }
        return resultado;
    }

    @Override
    public ObservableList<DocenteVO> readAll() throws SQLException{
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            ObservableList<DocenteVO> listaDocentes = FXCollections.observableArrayList();
            String consulta = "SELECT * FROM Docente";
            ResultSet rs;
            try (PreparedStatement pst = conexBD.prepareStatement(consulta)) {
                rs = conexBD.preparedStatementQuery(pst);
                while(rs.next()){
                    listaDocentes.add(
                            new DocenteVO(
                                    rs.getString("cedulaProfesional"),
                                    rs.getString("nombre"),
                                    rs.getString("grupoNRC")
                            )
                    );
                }
            }
            rs.close();
            conexBD.close();
            return listaDocentes;
        } catch (SQLException ex) {
            Logger.getLogger(DocenteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return null;
        }
    }

    @Override
    public DocenteVO read(String cedulaProf) throws SQLException {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String consulta = "SELECT * FROM Docente WHERE cedulaProfesional = ?";
            ResultSet rs = null;
            DocenteVO docente;
            try (PreparedStatement pst = conexBD.prepareStatement(consulta)) {
                pst.setString(1, cedulaProf);
                rs = conexBD.preparedStatementQuery(pst);
                docente = null;
                if(rs.next()){
                    docente = new DocenteVO(
                            rs.getString("cedulaProfesional"),
                            rs.getString("nombre"),
                            rs.getString("grupoNRC")
                    );
                }
            }finally{
                rs.close();
            }
            return docente;
        } catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
    }
    
    @Override
    public DocenteVO readPorGrupo(String NRC) throws Exception {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String consulta = "SELECT * FROM Docente WHERE GrupoNRC = ?";
            ResultSet rs = null;
            DocenteVO docente;
            try (PreparedStatement pst = conexBD.prepareStatement(consulta)) {
                pst.setString(1, NRC);
                rs = conexBD.preparedStatementQuery(pst);
                docente = null;
                if(rs.next()){
                    docente = new DocenteVO(
                            rs.getString("cedulaProfesional"),
                            rs.getString("nombre"),
                            rs.getString("grupoNRC")
                    );
                }   
            }finally{
                rs.close();
            }
            return docente;
        } catch (SQLException ex) {
            throw ex;
        }finally{
            conexBD.close();
        }
    }

    @Override
    public boolean update(String cedulaProf, DocenteVO docente) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String actualizacion = "UPDATE Docente SET "
                    + "cedulaProfesional = ?,"
                    + "nombre = ?,"
                    + "grupoNRC = ?,"
                    + "WHERE cedulaProfesional = ?";
            PreparedStatement pst = conexBD.prepareStatement(actualizacion);
            
            pst.setString(1, docente.getCedulaProfesional());
            pst.setString(2, docente.getNombre());
            pst.setString(3, docente.getGrupoNRC());
            pst.setString(4, cedulaProf);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DocenteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public boolean delete(DocenteVO docente) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM Docente WHERE cedulaProfesional = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, docente.getCedulaProfesional());
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DocenteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }

    @Override
    public boolean delete(String cedulaProf) {
        ConexionBD conexBD = new ConexionBD("localhost","bd_swpp","root","JLDI02092102");
        try {
            String borrar = "DELETE FROM Docente WHERE cedulaProfesional = ?";
            PreparedStatement pst = conexBD.prepareStatement(borrar);
            
            pst.setString(1, cedulaProf);
            
            conexBD.preparedStatementUpdate(pst);
            
            pst.close();
            conexBD.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DocenteDAOImp.class.getName()).log(Level.SEVERE, null, ex);
            conexBD.close();
            return false;
        }
    }
}
