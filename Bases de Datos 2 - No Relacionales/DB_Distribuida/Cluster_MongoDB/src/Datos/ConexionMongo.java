/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import java.util.Arrays;

/**
 *
 * @author ediss
 */
public class ConexionMongo {
    
    private DB BaseDatos;
    private DBCollection collection;
    private BasicDBObject document = new BasicDBObject();
    
    Parametros par = new Parametros();
    private String col = par.collection;
    private String namedb = par.BDName;

    public ConexionMongo() {
        try {
            Mongo mongocliente = new MongoClient(Arrays.asList(new ServerAddress("172.16.147.92", 27017), new ServerAddress("172.16.147.165", 27017), new ServerAddress("172.16.147.21", 27017), new ServerAddress("172.16.147.201", 27017)));
            
            BaseDatos = mongocliente.getDB(namedb);
            collection = BaseDatos.getCollection(col);
            System.out.println("Conexion establecida!");
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public DBCollection getCollection() {
        return collection;
    }

    public BasicDBObject getDocument() {
        return document;
    }
}
