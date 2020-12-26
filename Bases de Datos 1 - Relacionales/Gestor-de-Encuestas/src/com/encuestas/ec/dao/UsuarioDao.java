/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.dao;

import com.encuestas.ec.entity.Usuario;
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
public class UsuarioDao {
    private String mensaje = "";

    public String agregarUsuario(Connection con, Usuario usuario) {
        PreparedStatement pst = null;
        String sql = "INSERT INTO USUARIO (NOMBRE,DIRECCION,CEDULA,CORREO,TELEFONO,CONTRASENA,GENERO,ESTADOCIVIL)"
                + " VALUES(?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getNombres());
            pst.setString(2, usuario.getDireccion());
            pst.setString(3, usuario.getCedula());
            pst.setString(4, usuario.getEmail());
            pst.setString(5, usuario.getTelefono());
            pst.setString(6, usuario.getContrasena());
            pst.setString(7, usuario.getGenero()+"");
            pst.setString(8, usuario.getEstadoCivil());
            mensaje = "Guardado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Guardado Incorrectamente" + e.getMessage();
        }
        return mensaje;
    }

    public String modificarUsuario(Connection con, Usuario usuario) {
        PreparedStatement pst = null; 
        String sql = "UPDATE USUARIO  SET NOMBRE=?, DIRECCION = ?, CORREO=?, TELEFONO=?, CONTRASENA=?, GENERO=?, ESTADOCIVIL=?"
                + "WHERE CEDULA=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, usuario.getNombres());
            pst.setString(2, usuario.getDireccion());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getTelefono());
            pst.setString(5, usuario.getContrasena());
            pst.setString(6, usuario.getGenero()+"");
            pst.setString(7, usuario.getEstadoCivil());
            pst.setString(8, usuario.getCedula());
            mensaje = "Actualizado Correctamente" + usuario.toString();
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Actualizado Incorrectamente" + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarUsuario(Connection con, String id) {
        PreparedStatement pst = null;
        String sql = "DELETE FROM USUARIO WHERE CEDULA=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, id);
            mensaje = "Eliminado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            mensaje = "Eliminado InCorrectamente" + e.getMessage();
        }
        return mensaje;
    }

    public void listarUsuario(Connection con, JTable tabla) {
        DefaultTableModel model;
        String[] columnas = {"NOMBRE", "DIRECCION","CEDULA","CORREO","TELEFONO","CONTRASENA","GENERO","ESTADOCIVIL"};
        model = new DefaultTableModel(null, columnas);
        String sql = "SELECT * FROM USUARIO";
        String[] filas = new String[8];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < 8; i++) {
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
