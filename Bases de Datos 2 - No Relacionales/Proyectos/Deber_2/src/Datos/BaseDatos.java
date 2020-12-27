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
    
    public void insertOrder(int id_orden, int id_cliente, int id_empleado, String fecha_orden) {
        CallableStatement st = null;
        try {
            st = this.conn.prepareCall("{call PROC_INS_ORDERS(?,?,?,TO_DATE(?,'DD-MM-YYYY'))}");
            st.setInt(1, id_orden);
            st.setInt(2, id_cliente);
            st.setInt(3, id_empleado);
            st.setString(4, fecha_orden);
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
    
    public void insertOrderDetails(int id_orden, int id_producto, int cantidad) {
        CallableStatement st = null;
        try {
            st = this.conn.prepareCall("{call PROC_INS_ORDER_DETAILS(?,?,?)}");
            st.setInt(1, id_orden);
            st.setInt(2, id_producto);
            st.setInt(3, cantidad);
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
