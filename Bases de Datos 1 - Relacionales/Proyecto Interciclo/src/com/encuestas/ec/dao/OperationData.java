/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.encuestas.ec.db.Conexion;
import com.encuestas.ec.entity.ConsultasGenericas;

/**
 *
 * @author danny
 */
public class OperationData {

    private static OperationData MyOperationData = null;

    public static OperationData ObtenerDatos() throws SQLException {
        if (MyOperationData == null) {
            MyOperationData = new OperationData();
        }
        return MyOperationData;
    }

    public void insertarRegistro(Object o) throws Exception {
        PreparedStatement pstmt = null;

        try {
            String consulta = SQLSntences.insertarRegistro(o);
            Conexion.getConnection();
            pstmt = Conexion.getConnection().prepareStatement(consulta);
            pstmt.executeUpdate(consulta);
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        } finally {
            Conexion.obtenerConexion().desconexion();
        }
    }

    public Object realizarConsulta(ConsultasGenericas cons) throws Exception {

        String consulta = SQLSntences.getObtenerConsulta(cons);
        ArrayList<ArrayList<String>> datos;
        System.out.println("realizar : " + consulta.toString());
        datos = (ArrayList<ArrayList<String>>) consultarBD(consulta);
        System.out.println("" + datos.toString());
        return datos;
    }

    private Object consultarBD(String consulta) throws Exception {
        Statement stmt = null;
        ArrayList<ArrayList<String>> resultado = new ArrayList<>();
        try {
            Conexion.getConnection();
            stmt = Conexion.getConnection().createStatement();
            ResultSet respuesta = stmt.executeQuery(consulta);
            //Cabecera
            ArrayList<String> cabecera = new ArrayList<>();
            int numeroColumnas = respuesta.getMetaData().getColumnCount();
            for (int i = 0; i < numeroColumnas; i++) {
                cabecera.add(respuesta.getMetaData().getColumnName(i + 1));
            }
            resultado.add(cabecera);

            //Armar el ArrayList con el resultado
            int numCols = respuesta.getMetaData().getColumnCount();
            ArrayList<String> columna;
            while (respuesta.next()) {
                columna = new ArrayList<>();
                for (int i = 0; i < numCols; i++) {
                    columna.add(respuesta.getString(i + 1));
                }
                resultado.add(columna);
            }
            return resultado;
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        } finally {
            Conexion.obtenerConexion().desconexion();
        }
    }

    public String ObtenerIDtabla(Object o) throws Exception {
        String consulta = null;
        consulta = SQLSntences.getCampoPrimaria((String) o);
        ArrayList<ArrayList<String>> datos = (ArrayList<ArrayList<String>>) consultarBD(consulta);
        return datos.get(1).get(0);
    }

    public void modificarRegistro(Object oA, Object o) throws Exception {
        Statement stmt = null;
        try {
            String consulta = SQLSntences.modificarRegistro(oA, o);
            Conexion.getConnection();
            stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(consulta);
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        } finally {
            Conexion.obtenerConexion().desconexion();
        }
    }

    public void eliminarRegistro(ConsultasGenericas o) throws Exception {
        Statement stmt = null;
        try {
            Conexion.getConnection();
            String consulta = SQLSntences.eliminarRegistro(o);
            stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(consulta);
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        } finally {
            Conexion.obtenerConexion().desconexion();
        }
    }

    public Object getNombreTablas() throws Exception {
        String consulta = SQLSntences.getNombreTablas();
        return consultarBD(consulta);
    }

    /*Retorna ArrayList<ArrayList<String>> los nombres de los atributos a traves
    del nombre de la tabla.*/
    public Object getAtributosTablas(Object o) throws Exception {
        String consulta = SQLSntences.getAtributosTabla((String) o);
        return consultarBD(consulta);
    }

    public String getCampoPrimario(Object o) throws Exception {
        String consulta = null;
        consulta = SQLSntences.getCampoPrimaria((String) o);
        ArrayList<ArrayList<String>> datos = (ArrayList<ArrayList<String>>) consultarBD(consulta);
        return datos.get(1).get(0);
    }

}
