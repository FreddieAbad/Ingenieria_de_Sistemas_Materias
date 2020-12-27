package GUI;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import org.bson.Document;

/**
 *
 * @author bryan
 */
public class main1 {

    public static void main(String[] args) {
        DB basedatos;
        DBCollection coleccion;
        BasicDBObject document = new BasicDBObject();

        String col = "totalArrDelay";
        String namedb = "clusterbd";

        try {
            //Mongo mongocliente = new MongoClient(Arrays.asList(new ServerAddress("172.16.147.92", 27017), new ServerAddress("172.16.147.165", 27017), new ServerAddress("172.16.147.21", 27017), new ServerAddress("172.16.147.201", 27017)));
            Mongo mongocliente = new MongoClient("localhost", 27017);

            basedatos = mongocliente.getDB(namedb);
            coleccion = basedatos.getCollection(col);
            System.out.println("Conexion establecida!");

            //System.out.println(coleccion);
            //insertar
            /*document.put("id", "123");
            document.put("name", "Otra");
            document.put("last_name", "Otro");
            document.put("street", "Cuenca");
            document.put("phone", "0991538711");
            coleccion.insert(document);*/
            //mostrar
            DBCursor cursor = coleccion.find().limit(418);
            System.out.println(cursor.toString());
            while (cursor.hasNext()) {
                
                try {
                    DBObject objeto = cursor.next();

                    System.out.println(objeto);
                    //System.out.println(objeto.get("valu"));
                    //VALOR DE OBJETO _id
                    Object a  = objeto.get("_id");
                    DBObject b = (DBObject) a;
                    //String b = (String) a.get("year");
                    Object year = b.get("year");
                    Object mes = b.get("month");
                    Object origen = b.get("origin");
                    Object destino = b.get("dest");

                    System.out.println("VALORES DE _id");
                    System.out.println("year: "+((int) Double.parseDouble(year.toString())));
                    System.out.println("month: "+((int) Double.parseDouble(mes.toString())));
                    System.out.println("origin: "+origen.toString());
                    System.out.println("dest: "+destino.toString());

                    a  = objeto.get("value");
                    b = (DBObject) a;
                    Object retr = b.get("retrasos");
                    System.out.println("VALORES DE restrasos");
                    System.out.println("retrasos: "+((int) Double.parseDouble(retr.toString())));
                    System.out.println("");
                } catch (Exception e) {
                }
                    
                
                //VALOR DE OBJETO value
                
            }
            
            
            /*
            columna = new ArrayList<>();
            columna.add((String) objeto.get("Year"));
            columna.add((String) objeto.get("Month"));
            columna.add((String) objeto.get("Origin"));
            columna.add((String) objeto.get("Dest"));
            columna.add((String) objeto.get("retrasos"));
            datos.add(columna);
            
            */
            

            //eliminar
            /*document.put("id", "1");
            coleccion.remove(document);*/
            //actualizar
            /*BasicDBObject query = new BasicDBObject();
            query.put("id", "123");
            query.put("name", "Otra");
            query.put("last_name", "Otro");
            query.put("street", "Cuenca");
            query.put("phone", "0991538711");

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("id", "2");
            newDocument.put("name", "asd");
            newDocument.put("last_name", "dfvgbhn");
            newDocument.put("street", "tyu");
            newDocument.put("phone", "0000");

            
            BasicDBObject updateObject = new BasicDBObject();
            updateObject.put("$set", newDocument);
            coleccion.findAndModify(query, updateObject);
            
             */
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
