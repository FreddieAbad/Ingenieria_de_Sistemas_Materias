/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author ediss
 */
public class DataBase {

    private final DBCollection colArrDelay;
    private final DBCollection colDepDelay;

    //private final Block<Document> document;
    private final BasicDBObject document;
    
    public DataBase(DBCollection colArrDelay, DBCollection colDeoDelay,BasicDBObject document) {
        this.colArrDelay = colArrDelay;
        this.colDepDelay = colDeoDelay;
        this.document = document;
    }

    public ArrayList<ArrayList<String>> getArrDelay() {
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        ArrayList<String> columna = new ArrayList<>();;
        columna.add("id");
        columna.add("Anio");
        columna.add("Mes");
        columna.add("Origen");
        columna.add("Destino");
        columna.add("Retrasos");
        datos.add(columna);

        DBCursor cursor = colArrDelay.find();//.limit(417);
        int cont = 1;
        while (cursor.hasNext()) {
            
            try {
                columna = new ArrayList<>();
                DBObject objeto = cursor.next();
                //VALOR DE OBJETO _id
                Object a  = objeto.get("_id");
                DBObject b = (DBObject) a;
                Object year = b.get("year");
                Object mes = b.get("month");
                Object origen = b.get("origin");
                Object destino = b.get("dest");

                //VALOR OBJETO retrasos
                a  = objeto.get("value");
                b = (DBObject) a;
                Object retr = b.get("retrasos");

                //System.out.println("VALORES DE _id");
                /*System.out.println("year: "+year.toString());
                System.out.println("month: "+mes.toString());
                System.out.println("origin: "+origen.toString());
                System.out.println("dest: "+destino.toString());

                System.out.println("VALORES DE restrasos");
                System.out.println("retrasos: "+retr.toString());
                System.out.println("");
                */
                columna.add(""+cont);
                columna.add(""+((int) Double.parseDouble(year.toString())));
                columna.add(""+((int) Double.parseDouble(mes.toString())));
                columna.add(origen.toString());
                columna.add(destino.toString());
                columna.add(""+((int) Double.parseDouble(retr.toString())));

                datos.add(columna);
                cont++;
            } catch (Exception e) {
            }
            
                
        }
        return datos;
    }

    public ArrayList<ArrayList<String>> getDepDelay() {
        ArrayList<ArrayList<String>> datos = new ArrayList<>();
        ArrayList<String> columna = new ArrayList<>();;
        columna.add("id");
        columna.add("Anio");
        columna.add("Mes");
        columna.add("Origen");
        columna.add("Destino");
        columna.add("Retrasos");
        datos.add(columna);

        DBCursor cursor = colDepDelay.find();//.limit(417);
        int cont = 1;
        while (cursor.hasNext()) {
            
            try {
                columna = new ArrayList<>();
                DBObject objeto = cursor.next();
                //VALOR DE OBJETO _id
                Object a  = objeto.get("_id");
                DBObject b = (DBObject) a;
                Object year = b.get("year");
                Object mes = b.get("month");
                Object origen = b.get("origin");
                Object destino = b.get("dest");

                //VALOR OBJETO retrasos
                a  = objeto.get("value");
                b = (DBObject) a;
                Object retr = b.get("retrasos");

                //System.out.println("VALORES DE _id");
                /*System.out.println("year: "+year.toString());
                System.out.println("month: "+mes.toString());
                System.out.println("origin: "+origen.toString());
                System.out.println("dest: "+destino.toString());

                System.out.println("VALORES DE restrasos");
                System.out.println("retrasos: "+retr.toString());
                System.out.println("");
                */
                columna.add(""+cont);
                columna.add(""+((int) Double.parseDouble(year.toString())));
                columna.add(""+((int) Double.parseDouble(mes.toString())));
                columna.add(origen.toString());
                columna.add(destino.toString());
                columna.add(""+((int) Double.parseDouble(retr.toString())));

                datos.add(columna);
                cont++;
            } catch (Exception e) {
            }
            
                
        }
        return datos;
    }

    /*private static AggregationOutput obtenerRetrasos(DBCollection collection) {
        DBObject match = new BasicDBObject("$match",
                new BasicDBObject("product.mpoCode", "VA001").append("product.npoCode",
                        new BasicDBObject("$exists", "true")
                )
        );

        DBObject group = new BasicDBObject("$group",
                new BasicDBObject("_id", new BasicDBObject("providerId", "$providerId"))
                        .append("specialityCodeList",
                                new BasicDBObject("$addToSet", "$product.specialties.code")
                        )
        );

        List<DBObject> pipeline = Arrays.<DBObject>asList(match, group);
        AggregationOutput output = collection.aggregate(pipeline);

        return output;
    }*/
}
