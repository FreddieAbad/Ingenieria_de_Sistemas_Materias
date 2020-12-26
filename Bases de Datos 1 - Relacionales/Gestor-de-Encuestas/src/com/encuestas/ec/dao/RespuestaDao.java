/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.dao;

import com.encuestas.ec.entity.Respuesta;
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
public class RespuestaDao {
    private String mensaje = "";

    public String agregarRespuesta(Connection con, Respuesta respuesta) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO RESPUESTA (IDRESPUESTA,IDPREGUNTA,RESPUESTA)"
                + " VALUES(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, respuesta.getIdRespuesta());
            pst.setInt(2, respuesta.getIdPregunta());
            pst.setString(3, respuesta.getRespuesta());
            mensaje = "Guardado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Guardado Incorrectamente" + e.getMessage();
        }
        return mensaje;
    }

    public String modificarRespuesta(Connection con, Respuesta respuesta) {
        PreparedStatement pst = null;
        String sql = "UPDATE RESPUESTA  SET IDPREGUNTA=?, RESPUESTA = ?"
                + "WHERE IDRESPUESTA=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, respuesta.getIdPregunta());
            pst.setString(2, respuesta.getRespuesta());
            pst.setInt(3, respuesta.getIdRespuesta());
            mensaje = "Actualizado Correctamente" + respuesta.toString();
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Actualizado InCorrectamente" + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarRespuesta(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM RESPUESTA WHERE IDRESPUESTA=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            mensaje = "Eliminado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Eliminado InCorrectamente" + e.getMessage();
        }
        return mensaje;
    }

    public void listarRespuesta(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"IDRESPUESTA", "IDPREGUNTA", "RESPUESTA"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM PREGUNTA ORDER BY IDPREGUNTA";
        String[] filas = new String[3];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 3; i++) {
                    filas[i] = rs.getString(i + 1);
                }
                model.addRow(filas);
            }
            tabla.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede listar la tabla");
        }
    }

    public int getMaxID(Connection con) {
        int id = 0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(IDRESPUESTA)+1 FROM RESPUESTA"; //mUESTRA EL ID PRESENTE
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar ID" + e.getMessage());
        }
        return id;
    }
}
