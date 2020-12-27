/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.bo;

import com.encuestas.ec.dao.PreguntaDao;
import com.encuestas.ec.db.Conexion;
import com.encuestas.ec.entity.Pregunta;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Freddie
 */
public class PreguntaBo {

    private String mensaje = "";
    private PreguntaDao pdao = new PreguntaDao();

    public String agregarPregunta(Pregunta pregunta) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = pdao.agregarPregunta(con, pregunta);
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

    public String modificarPregunta(Pregunta pregunta) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = pdao.modificarPregunta(con, pregunta);
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

    public String eliminarPregunta(int id) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = pdao.eliminarPregunta(con, id);
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

    public void listarPregunta(JTable table) throws SQLException {
        Connection con = Conexion.getConnection();
        pdao.listarPregunta(con, table);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getMaxID() {
        Connection con = Conexion.getConnection();
        int id = pdao.getMaxID(con);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
}