
import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;
import org.bson.Document;

public class MongoConexion {

    static MongoDatabase db;
    static MongoCollection tabla;
    
    static DBCollection paraBorrar;
    
    static String coleccion = "personas";
    static String database = "dataejemplo";

    public static void main(String[] args) {
        
        try {
            MongoClient mongocliente = new MongoClient(Arrays.asList(new ServerAddress("172.16.147.92", 27017), new ServerAddress("172.16.147.165", 27017), new ServerAddress("172.16.147.21", 27017), new ServerAddress("172.16.147.201", 27017)));
            db = mongocliente.getDatabase(database);
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        
        tabla = db.getCollection(coleccion);
        
    }
    
    public static void insertarRegistro(String id_persona, String nombre, String apellido, String direccion, String telef){
        
        tabla.insertOne(new Document()
                .append("id", id_persona)
                .append("name", nombre)
                .append("last_name", apellido)
                .append("street", direccion)
                .append("phone", telef)
        );
        System.out.println("(\"------------------SE INSERTO UN DATO--------------------------");
    }
    
    public static void recuperarRegistro(){
        /*.getString("name")*/
        FindIterable<Document> iterable = tabla.find();
        iterable.forEach(new Block<Document>() {
            public void apply(final Document doc) {
                System.out.println("Valor " + doc);
            }
        });
    }
    
    public static void actualizarRegistro(String id_persona, String nombre, String apellido, String direccion, String telef, String new_id_persona, String new_nombre, String new_apellido, String new_direccion, String new_telef){

        BasicDBObject query = new BasicDBObject();
        query.put("id", id_persona);
        query.put("name", nombre);
        query.put("last_name", apellido);
        query.put("street", direccion);
        query.put("phone", telef);
        
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("id", new_id_persona);
        newDocument.put("name", new_nombre);
        newDocument.put("last_name", new_apellido);
        newDocument.put("street", new_direccion);
        newDocument.put("phone", new_telef);
        
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", newDocument);
        tabla.updateOne(query, updateObject);
        
        System.out.println("------------------SE ACTUALIZO UN DATO--------------------------");
    }
    
    public static void borrarRegistro(String id){
        
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("id",id);
        paraBorrar.remove(searchQuery);
        
        System.out.println("------------------SE ELIMINO UN DATO--------------------------");
    }
}