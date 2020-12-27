
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import java.util.Arrays;

/**
 *
 * @author bryan
 */
public class main {

    public static void main(String[] args) {
        DB basedatos;
        DBCollection coleccion;
        BasicDBObject document = new BasicDBObject();

        String col = "personas";
        String namedb = "dataejemplo";

        try {
            //Mongo mongocliente = new MongoClient(Arrays.asList(new ServerAddress("172.16.147.92", 27017), new ServerAddress("172.16.147.165", 27017), new ServerAddress("172.16.147.21", 27017), new ServerAddress("172.16.147.201", 27017)));
            Mongo mongocliente = new MongoClient("localhost", 27017);
            
            basedatos = mongocliente.getDB(namedb);
            coleccion = basedatos.getCollection(col);
            
            System.out.println(coleccion);
            
            System.out.println("Conexion establecida!");

            //insertar
            /*document.put("id", "123");
            document.put("name", "Otra");
            document.put("last_name", "Otro");
            document.put("street", "Cuenca");
            document.put("phone", "0991538711");
            coleccion.insert(document);*/
            //mostrar
            DBCursor cursor = coleccion.find();
            System.out.println(cursor.toString());
            while (cursor.hasNext()) {
                DBObject objeto = cursor.next();
                System.out.println(objeto.toString());
                //System.out.println(objeto.get("id"));
                //System.out.println(cursor.next());
            }

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
