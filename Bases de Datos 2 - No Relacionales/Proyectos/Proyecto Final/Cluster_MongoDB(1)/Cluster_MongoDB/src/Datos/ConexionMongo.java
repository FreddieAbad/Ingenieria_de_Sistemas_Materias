/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import org.bson.Document;

/**
 *
 * @author ediss
 */
public class ConexionMongo {
    
    private DB BaseDatos;
    
    private DBCollection collectiontotalArrDelay;
    private DBCollection collectiontotalDepDelay;
    
    //private Block<Document> printblock = document -> System.out.println(document.toJson());
    private BasicDBObject document = new BasicDBObject();
    
    Parametros parametros = new Parametros();
    private String colArrDelay = parametros.collectiontotalArrDelay;
    private String colDepDelay = parametros.collectiontotalDepDelay;
    
    private String namedb = parametros.BDName;

    public ConexionMongo() {
        try {
            //Mongo mongocliente = new MongoClient(Arrays.asList(new ServerAddress("172.16.147.92", 27017), new ServerAddress("172.16.147.165", 27017), new ServerAddress("172.16.147.21", 27017), new ServerAddress("172.16.147.201", 27017)));
            Mongo mongocliente = new MongoClient("localhost",27017);
            BaseDatos = mongocliente.getDB(namedb);
            
            collectiontotalArrDelay = BaseDatos.getCollection(colArrDelay);
            collectiontotalDepDelay = BaseDatos.getCollection(colDepDelay);
            
            System.out.println("Conexion establecida!");
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public DBCollection getCollectionArrDelay() {
        return collectiontotalArrDelay;
    }
    
    public DBCollection getCollectionDepDelay() {
        return collectiontotalDepDelay;
    }

    public BasicDBObject getDocument() {
        return document;
    }
    
    /*public Block<Document> getDocument() {
        return printblock;
    }*/
}
