/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.ConexionMySQL;
import Datos.DataBase;
import java.util.ArrayList;

/**
 *
 * @author Edisson
 */
public class MySQL_Server {
    
    private static MySQL_Server instance = null;
    private final DataBase database;

    private MySQL_Server() {
        ConexionMySQL connDB = new ConexionMySQL();
        database = new DataBase(connDB.getConn());
    }
    
    /* OBTENER LA CONEXION*/
    public void cerrarConexion() {
        database.cerrarConexion();
    }
    
    
    /*OBTENER LA INSTANCIA*/
    public static MySQL_Server getInstance() {
        if (instance == null)
            return new MySQL_Server();
        else 
            return instance;
    }
    
    
    
    
    /*OBTIENE TODOS LOS USUARIOS DE LA BASE DE DATOS*/
    public ArrayList<ArrayList<String>> getPersonas() {
        return database.getPersonas();
    }
    
    public ArrayList<ArrayList<String>> getCiudades() {
        return database.getCiudades();
    }
    
    public ArrayList<ArrayList<String>> getPersonasbyCiudad(int idCiudad) {
        return database.getPersonasbyCiudad(idCiudad);
    }
    
    public void addPersona(String nombre, String apellido, int idCiudad) {
        database.addPersona(nombre, apellido, idCiudad);
    }
    
    public void addCiudad(String nombre) {
        database.addCiudad(nombre);
    }
    
    public void delPersona(int idPersona) {
        database.delPersona(idPersona);
    }
    
    public void delCiudad(int idCiudad) {
        database.delCiudad(idCiudad);
    }
    
    public ArrayList<ArrayList<String>> getPersonasbyID(int idPersona){
        return database.getPersonasbyID(idPersona);
    }
    
    public ArrayList<ArrayList<String>> getCiudadesbyID(int idciudad){
        return database.getCiudadesbyID(idciudad);
    }
    
    public void actualizarPersona(int id, String nombre, String apellido, int idCiudad){
        database.actualizarPersona(id, nombre, apellido, idCiudad);
    }
    
    public void actualizarCiudad(int id_ciudad, String nombre){
        database.actualizarCiudad(id_ciudad, nombre);
    }
}
