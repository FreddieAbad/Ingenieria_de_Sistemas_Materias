/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBase {
    
    private final Connection conn;

    public DataBase(Connection conn) {
        this.conn = conn;
    }
    
    /* CERRAR LA CONEXION*/
    public void cerrarConexion() {
        try {
            this.conn.close();
        } catch (Exception ex) {
            throw new RuntimeException("Error Base Datos: error al desconectarse de "
                    + "la Base de Datos.\nSQL Error: "+ex.getMessage());
        }
    }
    
    /*OBTIENE TODOS LOS USUARIOS DE LA BASE DE DATOS*/
    public ArrayList<ArrayList<String>> getPersonas() {
        String sentConsulta = "SELECT ID, NOMBRE, APELLIDO FROM personas";
        ArrayList<ArrayList<String>> resultado = this.consulta(sentConsulta);
        //resultado.remove(0);
        return resultado;
    }
    
    /*OBTIENE TODOS LOS USUARIOS DE LA BASE DE DATOS*/
    public ArrayList<ArrayList<String>> getCiudades() {
        String sentConsulta = "SELECT * FROM ciudades";
        ArrayList<ArrayList<String>> resultado = this.consulta(sentConsulta);
        //resultado.remove(0);
        return resultado;
    }
    
    public ArrayList<ArrayList<String>> getPersonasbyCiudad(int idCiudad) {
        String sentConsulta = "SELECT * FROM ciudades where id_ciudad=" +idCiudad+"";
        ArrayList<ArrayList<String>> resultado = this.consulta(sentConsulta);
        //resultado.remove(0);
        return resultado;
    }
    
    public void addPersona(String nombre, String apellido, int idCiudad) {
        String sentConsulta = "INSERT INTO PERSONAS (NOMBRE, APELLIDO, ID_CIUDAD) VALUES ('"+nombre+"', '"+apellido+"', "+idCiudad+")";
        this.actualizacion(sentConsulta);
    }
    
    public void addCiudad(String nombre) {
        String sentConsulta = "INSERT INTO CIUDADES (NOMBRE_CIUDAD) VALUES ('"+nombre+"')";
        this.actualizacion(sentConsulta);
    }
    
    public void delPersona(int idPersona) {
        String sentConsulta = "DELETE FROM PERSONAS WHERE ID = '"+idPersona+"'";
        this.actualizacion(sentConsulta);
    }
    
    public void delCiudad(int idCiudad) {
        String sentConsulta = "DELETE FROM CIUDADES WHERE ID_CIUDAD = '"+idCiudad+"'";
        this.actualizacion(sentConsulta);
    }
    
    public ArrayList<ArrayList<String>> getPersonasbyID(int idPersona) {
        String sentConsulta = "SELECT * FROM personas where id=" +idPersona+"";
        ArrayList<ArrayList<String>> resultado = this.consulta(sentConsulta);
        resultado.remove(0);
        return resultado;
    }
    
    public ArrayList<ArrayList<String>> getCiudadesbyID(int idCiudad) {
        String sentConsulta = "SELECT * FROM CIUDADES where id_ciudad=" +idCiudad+"";
        ArrayList<ArrayList<String>> resultado = this.consulta(sentConsulta);
        resultado.remove(0);
        return resultado;
    }
    
    public void actualizarPersona(int id, String nombre, String apellido, int idCiudad){
        String sentConsulta = "UPDATE PERSONAS SET NOMBRE = '"+nombre+"'"+ ", APELLIDO = '"+apellido+"'"+", ID_CIUDAD = '"+idCiudad+"'"+" WHERE ID = '"+id+"'";
        this.actualizacion(sentConsulta);
    }
    
    public void actualizarCiudad(int id_ciudad, String nombre){
        String sentConsulta = "UPDATE CIUDADES SET NOMBRE_CIUDAD = '"+nombre+"'"+ " WHERE ID_CIUDAD = '"+id_ciudad+"'";
        this.actualizacion(sentConsulta);
    }
    
    /*OBTENER LOS DATOS DEL RESULTADO(RESULSET) RETORNADO*/
    private void recuperarDatos(ArrayList<ArrayList<String>> datos, ResultSet result) throws SQLException {
        try {
            int cantColumnas = result.getMetaData().getColumnCount();
            ArrayList<String> columna;
            while (result.next()) {
                columna = new ArrayList<>();
                for (int i = 0; i < cantColumnas; i++) {
                    columna.add(result.getString(i + 1));
                }
                datos.add(columna);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Error al obtener los datos de resultado");
        } 
    }
    
    /*REALIZA UNA CONSULTA TIPO executeQuery (SELECT) Y DEVUELVE LA INFORMACION 
    DE RESPUESTA*/
    private ArrayList<ArrayList<String>> consulta(String consulta) {
        Statement st = null;
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        try {
            st = conn.createStatement();
            ResultSet res = st.executeQuery(consulta);
            ArrayList<String> cabeceras = new ArrayList<>();
            int numCols = res.getMetaData().getColumnCount();
            for (int i = 0; i < numCols; i++) {
                cabeceras.add(res.getMetaData().getColumnName(i + 1));
            }
            datos.add(cabeceras);
            recuperarDatos(datos, res);
            return datos;
        } catch (SQLException ex) {
            throw new RuntimeException("Error en Consulta: "+consulta+
                    ".\nError SQL: " + ex.getMessage());
        } finally {
            try {
                if (st != null) 
                    st.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Error Base Datos: error al terminar "
                        + "la conexión de la Consula.\nSQL Error: "+ex.getMessage());
            }
        }
    }

    /*EJECUTA UNA CONSULTA TIPO executeUpdate(insert, update, delete) Y NO 
    DEVUELVE LA INFORMACION DE RESPUESTA*/
    private void actualizacion(String consulta) {
        Statement st = null;
        try {
            st = this.conn.createStatement();
            st.executeUpdate(consulta);
        } catch (SQLException ex) {
            throw new RuntimeException("Error en Consulta: "+consulta+
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
