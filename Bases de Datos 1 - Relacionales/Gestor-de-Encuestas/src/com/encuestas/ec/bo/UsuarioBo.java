/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.bo;


import com.encuestas.ec.dao.UsuarioDao;
import com.encuestas.ec.db.Conexion;
import com.encuestas.ec.entity.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Freddie
 */
public class UsuarioBo {
    
    private String mensaje = "";
    private UsuarioDao udao = new UsuarioDao();

    public String agregarUsuario(Usuario usuario) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = udao.agregarUsuario(con, usuario);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String modificarUsuario(Usuario usuario) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = udao.modificarUsuario(con, usuario);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String eliminarUsuario(String id) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = udao.eliminarUsuario(con, id);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
            }
        }
        return mensaje;
    }

    public void listarUsuario(JTable table) throws SQLException {
        Connection con = Conexion.getConnection();
        udao.listarUsuario(con, table);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getMaxID() {
        Connection con = Conexion.getConnection();
        int id = udao.getMaxID(con);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
    public int validarUsuario(String usuario, String contrasena){
        //TODO 1 es admin 2 usuario 3 equivocado validar
        System.out.println("safsafd");
        return 3;
    }
}
