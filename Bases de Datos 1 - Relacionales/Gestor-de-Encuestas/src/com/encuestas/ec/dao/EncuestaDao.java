/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.dao;

import com.encuestas.ec.entity.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Freddie
 */
public class EncuestaDao {
    private String mensaje="";
    public String agregarEncuesta(Connection con, Encuesta encuesta){
        PreparedStatement pst=null;
        String sql="INSERT INTO ENCUESTA (IDENCUESTA,NOMBRE,DESCRIPCION,IDTIPOENCUESTA)"+
                    " VALUES(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,encuesta.getIdEncuesta());
            pst.setString(2, encuesta.getNombre());
            pst.setString(3, encuesta.getDescripcion());
            pst.setInt(4, encuesta.getTipoEncuesta());
            mensaje="Guardado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje="Guardado Incorrectamente"+e.getMessage();
        }
        return mensaje;
    }
    public String modificarEncuesta(Connection con, Encuesta encuesta){
        PreparedStatement pst=null;
        String sql="UPDATE ENCUESTA SET NOMBRE=? ,DESCRIPCION=?,IDTIPOENCUESTA=?"+
                    "WHERE IDENCUESTA=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, encuesta.getNombre());
            pst.setString(2, encuesta.getDescripcion());
            pst.setInt(3, encuesta.getTipoEncuesta());
            pst.setInt(4,encuesta.getIdEncuesta());
            mensaje="Actualizado Correctamente"+encuesta.toString();
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje="Actualizado InCorrectamente"+e.getMessage();
        }
        return mensaje;
    }
    public String eliminarEncuesta(Connection con, int id){
        PreparedStatement pst=null;
        String sql="DELETE FROM ENCUESTA WHERE IDENCUESTA=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            mensaje="Eliminado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje="Eliminado InCorrectamente"+e.getMessage();
        }
        return mensaje;
    }
    public void listarEncuesta(Connection con, JTable tabla){
        DefaultTableModel model;
        String [] columnas = {"ID","NOMBRE","DESCRIPCION","IDTIPOENCUESTA"};
        model=new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM ENCUESTA ORDER BY IDENCUESTA";
        String [] filas= new String[4];
        Statement st=null;
        ResultSet rs= null;
        try {
            st=con.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                for (int i = 0; i < 4; i++) {
                    filas[i]=rs.getString(i+1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }
     public int getMaxID(Connection con){
        int id=0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql="SELECT MAX(IDENCUESTA)+1 FROM ENCUESTA"; //mUESTRA EL ID PRESENTE
        try {
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar ID"+e.getMessage());
        }
        return id;
    } 
}
