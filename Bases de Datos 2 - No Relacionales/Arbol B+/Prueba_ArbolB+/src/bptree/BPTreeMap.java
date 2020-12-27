/**
 * Capa que permite trabajar con un archivo de valores
 * e indices (primario y secundarios), implementando
 * un árbol B+.
 */
package bptree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Santos Gallegos
 * @param <K> Clave
 * @param <V> Valor
 */
public class BPTreeMap<K, V> implements Serializable {
    
    private final File PATH; // Ruta donde se almacenará la tabla de valores.
    private final int OBJ_SIZE; // Tamaño max reservado para cada objeto.
    private final int EXTRA_BYTES = 4; // Bytes extras que contienen el tamaño del objeto.
    private final int ORDER; // Orden del árbol.
    private BPTree<K> tree; // Árbol B+, tabla de índices.
    
    private List<BPTree> secTreeIndex; // Lista de árboles que contienen indices secundarios.
    private List<IndexGenerator<V, Object>> indexGenerators; // Lista de generadores de indices secundarios.
    
    private BPTreeMap(int order, Comparator comparator, String dataPath, String treePath, int objSize, int nodeSize)
            throws IOException, FileNotFoundException, ObjectSizeException
    {
        ORDER = order;
        tree = BPTree.getTree(order, comparator, treePath, nodeSize);
        PATH = new File(dataPath);
        OBJ_SIZE = objSize;
        
        secTreeIndex = new ArrayList<>();
        indexGenerators = new ArrayList<>();
    }
    
    /**
     * Recupera un árbol existente de la ruta dada, si no existe
     * se retorna un nuevo árbol con los parámetros establecidos.
     * @param order
     * @param comparator
     * @param dataPath
     * @param treePath
     * @param objSize
     * @param nodeSize
     * @return 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     * @throws edu.ucue.bptree.ObjectSizeException 
     */
    public static BPTreeMap getTree(int order, Comparator comparator, String dataPath, String treePath, int objSize, int nodeSize)
            throws FileNotFoundException, IOException, ClassNotFoundException, ObjectSizeException
    {
        return new BPTreeMap(order, comparator, dataPath, treePath, objSize, nodeSize);
    }
    
    /**
     * Agrega un indice secundario por el cual ordenar.
     * Nota* Se crea un nuevo archivo de índices.
     * @param treePath
     * @param indexGenerator
     * @param nodeSize
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ObjectSizeException 
     */
    public void addSecIndex(String treePath, IndexGenerator indexGenerator, int nodeSize)
            throws IOException, FileNotFoundException, ObjectSizeException
    {
        secTreeIndex.add(BPTree.getTree(ORDER, indexGenerator.getComparator(), treePath, nodeSize));
        indexGenerators.add(indexGenerator);
    }
    
    /**
     * Retorna el número de elementos que contiene
     * el árbol.
     * @return 
     * @throws java.io.IOException 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     */
    public int size() throws IOException, FileNotFoundException, ClassNotFoundException {
        return tree.values().size();
    }
    
    /**
     * Retorna true si el árbol está vacío.
     * @return 
     * @throws java.io.IOException 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     */
    public boolean isEmpty() throws IOException, FileNotFoundException, ClassNotFoundException {
        return size() == 0;
    }
    
    /**
     * Retorna true si la clave key se encuentre
     * dentro del árbol.
     * @param key
     * @return 
     * @throws java.io.IOException 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     */
    public boolean containsKey(K key) throws IOException, FileNotFoundException, ClassNotFoundException {
        return tree.search(key) != null;
    }
    
    /**
     * Agrega un elemento V, y lo ordena de acuerdo a su
     * clave key.
     * @param key
     * @param value 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     * @throws edu.ucue.bptree.ObjectSizeException 
     */
    public void put(K key, V value) throws FileNotFoundException, IOException, ClassNotFoundException, ObjectSizeException {
        RandomAccessFile ram = null;
        byte[] obj;
        byte[] rest;
        long pos = 0;
        
        try {
            ram = new RandomAccessFile(PATH, "rw");
            
            obj = Tools.serialize(value);
            
            if(obj.length > OBJ_SIZE)
                throw new ObjectSizeException(PATH);
            
            pos = ram.length();
            ram.seek(pos);
            ram.writeInt(obj.length);
            ram.write(obj);
            
            // Llenar de bytes
            rest = new byte[OBJ_SIZE - obj.length + EXTRA_BYTES];
            ram.write(rest);
            
            tree.add(key, pos);
            // Agregar claves en arboles secundarios.
            for(int i = 0; i < secTreeIndex.size(); i++){
                IndexGenerator ig = indexGenerators.get(i);
                secTreeIndex.get(i).add(ig.getKey(value), pos);
            }
        } finally {
            ram.close();
        }
    }
    
    /**
     * Retorna una colección con todos los elementos
     * almacenados en el árbol.
     * @return 
     * @throws java.io.IOException 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     */
    public Collection<V> values() throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList values = new ArrayList();
        for(Long pos : tree.values())
            values.add(getObject(pos));
        return values;
    }
    
    /**
     * Retorna una coleccion con todos los elementos
     * ordenados de acuerdo al arbol secundario especificado.
     * @param indexSecTree
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public Collection<V> valuesOf(int indexSecTree) throws IOException, FileNotFoundException, ClassNotFoundException {
        ArrayList values = new ArrayList();
        BPTree<Object> t = secTreeIndex.get(indexSecTree);
        for(Long pos : t.values())
            values.add(getObject(pos));
        return values;
    }

    /**
     * Retorna un objeto dado su clave,
     * retorna null si este no existe.
     * @param key
     * @return 
     * @throws java.io.IOException 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     */
    public V get(K key) throws IOException, FileNotFoundException, ClassNotFoundException {
        Long pos = tree.search(key);
        if(pos == null)
            return null;
        return getObject(pos);
    }
    
    /**
     * Retorna la posicion donde se encuentra el objeto.
     * @param key
     * @return 
     * @throws java.io.IOException 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     */
    private Long getPos(K key) throws IOException, FileNotFoundException, ClassNotFoundException{
        return tree.search(key);
    }

    /**
     * Elimina un elemento del árbol dada su clave
     * (sólo se elimina de la tabla de índices, no
     * de la tabla de valores).
     * @param key 
     * @throws java.io.IOException 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     * @throws edu.ucue.bptree.ObjectSizeException 
     */
    public void remove(K key) throws IOException, FileNotFoundException, ClassNotFoundException, ObjectSizeException {
        V obj = getObject(tree.search(key));
        tree.del(key);
        
        // Borrar claves en arboles secundarios.
        for(int i = 0; i < secTreeIndex.size(); i++){
            IndexGenerator ig = indexGenerators.get(i);
            secTreeIndex.get(i).del(ig.getKey(obj));
        }
    }
    
    /**
     * Obtiene un objeto dada su posicion dentro del archivo de
     * acceso aleatorio.
     * @param pos
     * @return 
     */
    private V getObject(long pos) throws FileNotFoundException, IOException, ClassNotFoundException {
        RandomAccessFile raf = null;
        byte[] objByte;
        V obj;
        try {
            raf = new RandomAccessFile(PATH, "rw");
            
            raf.seek(pos);
            objByte = new byte[raf.readInt()];
            raf.read(objByte);
            obj = (V) Tools.deserialize(objByte);
            return obj;
        } finally {
            raf.close();
        }
    }
    
    /**
     * Actualiza un objeto de la tabla de valores.
     * @param key
     * @param newValue
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws ObjectSizeException 
     */
    public void update(K key, V newValue) throws FileNotFoundException, IOException, ClassNotFoundException, ObjectSizeException {
        RandomAccessFile raf = null;
        byte[] obj;
        byte[] rest;
        long pos;
        V oldObj = getObject(tree.search(key));
        
        try {
            raf = new RandomAccessFile(PATH, "rw");
            
            obj = Tools.serialize(newValue);
            
            if(obj.length > OBJ_SIZE)
                throw new ObjectSizeException(PATH);
            
            pos = getPos(key);
            raf.seek(pos);
            raf.writeInt(obj.length);
            raf.write(obj);
            
            // Llenar de bytes
            rest = new byte[OBJ_SIZE - obj.length + EXTRA_BYTES];
            raf.write(rest);
            
            // Eliminar clave secundaria y volver a añadirla con nuevo valor
            // en caso que se haya modificado el valor de la clave secundaria.
            for(int i = 0; i < secTreeIndex.size(); i++){
                IndexGenerator ig = indexGenerators.get(i);
                Comparator comp = ig.getComparator();
                if(comp.compare(ig.getKey(obj), ig.getKey(oldObj)) != 0){
                    secTreeIndex.get(i).del(ig.getKey(oldObj));
                    secTreeIndex.get(i).add(ig.getKey(newValue), pos);
                }
            }
        } finally {
            raf.close();
        }
    }
    
    public void showAll() throws IOException, FileNotFoundException, ClassNotFoundException{
        tree.showAll();
    }
}
