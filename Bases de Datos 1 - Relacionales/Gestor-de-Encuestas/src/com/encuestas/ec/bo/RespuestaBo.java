/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.bo;


import com.encuestas.ec.dao.RespuestaDao;
import com.encuestas.ec.db.Conexion;
import com.encuestas.ec.entity.Respuesta;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author Freddie
 */
public class RespuestaBo {
    
    private String mensaje = "";
    private RespuestaDao rdao = new RespuestaDao();

    public String agregarRespuesta(Respuesta respuesta) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = rdao.agregarRespuesta(con, respuesta);
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

    public String modificarRespuesta(Respuesta respuesta) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = rdao.modificarRespuesta(con, respuesta);
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

    public String eliminarRespuesta(int id) {
        Connection con = Conexion.getConnection();
        try {
            mensaje = rdao.eliminarRespuesta(con, id);
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

    public void listarRespuesta(JTable table) throws SQLException {
        Connection con = Conexion.getConnection();
        rdao.listarRespuesta(con, table);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getMaxID() {
        Connection con = Conexion.getConnection();
        int id = rdao.getMaxID(con);
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
    }
}
