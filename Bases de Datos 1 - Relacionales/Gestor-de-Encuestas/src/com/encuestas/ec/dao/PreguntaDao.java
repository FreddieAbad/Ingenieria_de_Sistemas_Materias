/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.dao;

import com.encuestas.ec.entity.Pregunta;
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
public class PreguntaDao {

    private String mensaje = "";

    public String agregarPregunta(Connection con, Pregunta pregunta) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO PREGUNTA (IDPREGUNTA,IDENCUESTA,IDTIPORESPUESTA,PREGUNTA)"
                + " VALUES(?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pregunta.getIdPregunta());
            pst.setInt(2, pregunta.getIdEncuesta());
            pst.setInt(3, pregunta.getTipoRespuesta());
            pst.setString(4, pregunta.getPregunta());
            mensaje = "Guardado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Guardado Incorrectamente" + e.getMessage();
        }
        return mensaje;
    }

    public String modificarPregunta(Connection con, Pregunta pregunta) {
        PreparedStatement pst = null;
        String sql = "UPDATE PREGUNTA  SET IDENCUESTA=? ,IDTIPORESPUESTA=?,PREGUNTA=?"
                + "WHERE IDPREGUNTA=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, pregunta.getIdEncuesta());
            pst.setInt(2, pregunta.getTipoRespuesta());
            pst.setString(3, pregunta.getPregunta());
            pst.setInt(4, pregunta.getIdPregunta());
            mensaje = "Actualizado Correctamente" + pregunta.toString();
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Actualizado InCorrectamente" + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPregunta(Connection con, int id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM PREGUNTA WHERE IDPREGUNTA=?";
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

    public void listarPregunta(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"IDPREGUNTA", "IDENCUESTA", "IDTIPOENCUESTA", "PREGUNTA"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM PREGUNTA ORDER BY IDPREGUNTA";
        String[] filas = new String[4];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 4; i++) {
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
        String sql = "SELECT MAX(IDPREGUNTA)+1 FROM PREGUNTA"; //mUESTRA EL ID PRESENTE
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
