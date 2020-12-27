/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;

/**
 *
 * @author ediss
 */
public class DataBase {
    private final DBCollection col;
    private final BasicDBObject document;

    public DataBase(DBCollection col, BasicDBObject document) {
        this.col = col;
        this.document = document;
    }
    
    public void insertPerson(ArrayList<String[]> datos) {
        document.put("id", datos.get(0)[1]);
        document.put("name", datos.get(1)[1]);
        document.put("last_name", datos.get(2)[1]);
        document.put("street", datos.get(3)[1]);
        document.put("phone", datos.get(4)[1]);
        col.insert(document);
    }
    
    public ArrayList<ArrayList<String>> getPersons () {
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        ArrayList<String> columna = new ArrayList<>();;
        columna.add("Id");
        columna.add("Name");
        columna.add("Last_name");
        columna.add("Street");
        columna.add("Phone");
        datos.add(columna);
        
        DBCursor cursor = col.find();
        while (cursor.hasNext()) {
            DBObject objeto = cursor.next();
            //System.out.println(objeto.get("id"));
            //System.out.println(cursor.next());
            columna = new ArrayList<>();
            columna.add((String)objeto.get("id"));
            columna.add((String)objeto.get("name"));
            columna.add((String)objeto.get("last_name"));
            columna.add((String)objeto.get("street"));
            columna.add((String)objeto.get("phone"));
            datos.add(columna);
        }
        return datos;
    }
    
    public void updatePersons (ArrayList<String[]> datosA, ArrayList<String[]> datosN) {
        BasicDBObject query = new BasicDBObject();
        query.put("id", datosA.get(0)[1]);
        query.put("name", datosA.get(1)[1]);
        query.put("last_name", datosA.get(2)[1]);
        query.put("street", datosA.get(3)[1]);
        query.put("phone", datosA.get(4)[1]);

        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("id", datosN.get(0)[1]);
        newDocument.put("name", datosN.get(1)[1]);
        newDocument.put("last_name", datosN.get(2)[1]);
        newDocument.put("street", datosN.get(3)[1]);
        newDocument.put("phone", datosN.get(4)[1]);

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);
        col.findAndModify(query, updateObject);
    }
    
    public void deletePerson (ArrayList<String[]> datos) {
        document.put("id", datos.get(0)[1]);
        document.put("name", datos.get(1)[1]);
        document.put("last_name", datos.get(2)[1]);
        document.put("street", datos.get(3)[1]);
        document.put("phone", datos.get(4)[1]);
        col.remove(document);
    }
}
