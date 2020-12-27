/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.ConexionMongo;
import Datos.DataBase;
import java.util.ArrayList;

/**
 *
 * @author ediss
 */
public class Mongo_Server {
    private static Mongo_Server instance = null;
    private final DataBase database;

    private Mongo_Server() {
        ConexionMongo connDB = new ConexionMongo();
        database = new DataBase(connDB.getCollection(), connDB.getDocument());
    }
    
    
    /*OBTENER LA INSTANCIA*/
    public static Mongo_Server getInstance() {
        if (instance == null)
            return new Mongo_Server();
        else 
            return instance;
    }
    
    public void insertPerson(ArrayList<String[]> datos) {
        database.insertPerson(datos);
    }
    
    public ArrayList<ArrayList<String>> getPersons () {
        return database.getPersons();
    }
    
    public void updatePersons (ArrayList<String[]> datosA, ArrayList<String[]> datosN) {
        database.updatePersons(datosA, datosN);
    }
    
    public void deletePerson (ArrayList<String[]> datos) {
        database.deletePerson(datos);
    }
}
