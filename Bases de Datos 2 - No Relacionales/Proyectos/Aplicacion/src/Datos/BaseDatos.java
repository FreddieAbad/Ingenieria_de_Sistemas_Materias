/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ediss
 */
public class BaseDatos {

    private final Connection conn;

    public BaseDatos(Connection conn) {
        this.conn = conn;
    }
    
    public void insertRecord(String code, String desc) {
        CallableStatement st = null;
        try {
            st = this.conn.prepareCall("{call insertarDatos(?, ?)}");
            st.setString(1, code);
            st.setString(2, desc);
            st.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Error en Consulta: "+st.toString()+
                    ".\nError SQL: " + ex.getMessage());
        } finally {
            try {
                if (st != null) 
                    st.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Error Base Datos: error al terminar "
                        + "la conexión de la consula.\nSQL Error: "+ex.getMessage());
            }
        }
    }
}
