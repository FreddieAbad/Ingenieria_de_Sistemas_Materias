/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.ConexionOracle;
import Datos.BaseDatos;

/**
 *
 * @author ediss
 */
public class OracleServidor {
    
    private static OracleServidor instance = null;
    private final BaseDatos database;

    private OracleServidor(){
        ConexionOracle connDB = new ConexionOracle();
        database = new BaseDatos(connDB.getConn());
    }
    
     /*OBTENER LA INSTANCIA*/
    public static OracleServidor getInstance() {
        if (instance == null)
            return new OracleServidor();
        else 
            return instance;
    }

    /*CREA UN USUARIO EN LA BASE DE DATOS*/
    public void insertRecord(String code, String desc) {
        database.insertRecord(code, desc);
    }
}