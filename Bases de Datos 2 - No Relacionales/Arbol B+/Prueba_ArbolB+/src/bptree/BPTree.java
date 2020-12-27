/**
 * B+ Tree / Árbol B+
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

/**
 * Árbol B+.
 * @author Edisson Sigua
 * @param <K> Clave
 */
public class BPTree<K> implements Serializable {
    private Long root;
    private final int maxKeys;
    private final int minKeys; // Mínimo de claves que puede tener un nodo (excepto el nodo root)
    private final Comparator<K> keysComparator;
    private final File PATH; // Ruta donde se almacenara la tabla de indices
    private final int NODE_SIZE; // Tamaño max reservado para cada nodo.
    private final int EXTRA_BYTES = 4; // Bytes extras que contienen el tamaño del nodo.
    
    /**
     * Crea un nuevo árbol vacío.
     * @param order Número máximo de claves.
     * @param comparator Objeto necesario para comparar las claves.
     * @param path
     * @param nodeSize
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    private BPTree(int order, Comparator<K> comparator, String path, int nodeSize, Long root)
            throws FileNotFoundException, IOException
    {
        this.maxKeys = order - 1;
        this.keysComparator = comparator;
        this.minKeys = (int) Math.ceil(order/2.0) - 1;
        this.NODE_SIZE = nodeSize;
        this.PATH = new File(path);
        
        setNewRoot(root);
    }
    
    /**
     * Retorna un árbol desde un archivo, si no existe crea uno nuevo vacío.
     * @param order
     * @param comparator
     * @param path
     * @param nodeSize
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ObjectSizeException 
     */
    public static BPTree getTree(int order, Comparator comparator, String path, int nodeSize)
            throws FileNotFoundException, IOException, ObjectSizeException
    {
        File treePath = new File(path);
        if(!treePath.exists()){
            return getEmptyTree(order, comparator, path, nodeSize);
        }else {
            return getTreeFrom(path, order, comparator, nodeSize);
        }
    }
    
    /**
     * Reotorna un nuevo árbol vacio.
     * @param order
     * @param comparator
     * @param path
     * @param nodeSize
     * @return
     * @throws IOException
     * @throws ObjectSizeException 
     */
    private static BPTree getEmptyTree(int order, Comparator comparator, String path, int nodeSize)
            throws IOException, ObjectSizeException
    {
        BPTree tree = new BPTree(order, comparator, path, nodeSize, 8L);
        tree.saveNode(new Node(true, order - 1, comparator));
        return tree;
    }
    
    /**
     * Retorna un nuevo árbol desde la ruta indicada por "path".
     * @param path
     * @param order
     * @param comparator
     * @param nodeSize
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private static BPTree getTreeFrom(String path, int order, Comparator comparator, int nodeSize)
            throws FileNotFoundException, IOException
    {
        RandomAccessFile raf = null;
        File treePath = new File(path);
        try{
            raf = new RandomAccessFile(treePath, "rw");
            raf.seek(0);
            Long root = raf.readLong();
            return new BPTree(order, comparator, path, nodeSize, root);
        } finally {
            if(raf != null)
                raf.close();
        }
    }
        
    /**
     * Cambia la raíz actual del árbol por una nueva.
     * @param root
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private void setNewRoot(Long root) throws FileNotFoundException, IOException {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(PATH, "rw");
            raf.seek(0);
            raf.writeLong(root);
            this.root = root;
        } finally {
            if(raf != null)
                raf.close();
        }
    }
    
    /**
     * Busca un valor por su clave desde la raiz del árbol,
     * si no hay una coincidencia retorna null.
     * @param key
     * @return 
     * @throws java.io.IOException 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     */
    public Long search(K key) throws IOException, FileNotFoundException, ClassNotFoundException {
        Node leaf = getNode(searchLeaf(key));
        if(leaf == null)
            return null;
        return searchInLeaf(key, leaf);
    }
    
    /**
     * Busca un valor dentro de una hoja, si no se encuentra
     * retorna null.
     * @param key
     * @param node
     * @return 
     */
    private Long searchInLeaf(K key, Node node){
        for(int i = 0; i < node.getNodeSize(); i++){
            if(keysComparator.compare(key, (K) node.getKey(i)) == 0)
                return node.getValue(i);
        }
        return null;
    }
    
    /**
     * Retorna la hoja en donde debería ser insertada
     * una clave, o donde podría estar esta.
     * @param key
     * @return 
     */
    private Long searchLeaf(K key) throws IOException, FileNotFoundException, ClassNotFoundException {
        Node leaf = getNode(root);
        int i;
        while(!leaf.isLeaf()){
            i = leaf.getNodeSize() - 1;
            while(i >= 0 && keysComparator.compare(key, (K) leaf.getKey(i)) < 0)
                i--;
            leaf = getNode(leaf.getChild(i + 1));
        }
        return leaf.getPos();
    }
    
    /**
     * Agrega un valor, con su respectiva clave
     * al árbol, manteniendo todos sus elementos
        int i;
        while(!leaf.isLeaf()){
            i = leaf.getNodeSize() - 1;
            while(i >= 0 && keysComparator.compare(key, (K) leaf.getKey(i)) < 0)
                i--;
            leaf = getNode(leaf.getChild(i + 1));
        }
        return leaf.getPos();
    }
    
    /**
     * Agrega un valor, con su respectiva clave
     * ordenados por clave.
     * @param key
     * @param value 
     * @throws java.io.IOException 
     * @throws java.io.FileNotFoundException 
     * @throws java.lang.ClassNotFoundException 
     * @throws edu.ucue.bptree.ObjectSizeException 
     */  
    public void add(K key, Long value)
            throws IOException, FileNotFoundException, ClassNotFoundException, ObjectSizeException 
    {
        Node leaf = getNode(searchLeaf(key));
        
        leaf.insertKeyAndValue(key, value);
        
        updateNode(leaf);
        
        if(leaf.getNodeSize() > maxKeys)       
            splitLeaf(leaf);
    }
    
    /**
     * Divide un nodo hoja, e inserta la nueva clave en su padre.
     * @param leaf
     * @throws IOException
     * @throws ObjectSizeException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    private void splitLeaf(Node leaf)
            throws IOException, ObjectSizeException, FileNotFoundException, ClassNotFoundException
    {
        Node newLeaf = new Node(true, maxKeys, keysComparator);
        saveNode(newLeaf);
        
        // Dividir claves y valores del nodo hoja
        int k = 0;
        for(int j = minKeys; j < maxKeys + 1; j++){
            newLeaf.setKey(k, leaf.getKey(j));
            newLeaf.setValue(k, leaf.getValue(j));
            k++;
        }
        
        leaf.setNodeSize(minKeys);
        newLeaf.setNodeSize(maxKeys + 1 - minKeys);
        
        updateNode(leaf);
        updateNode(newLeaf);
        
        linkNodes(leaf, newLeaf);
        
        if(leaf.getParent() == null){
            newRootWithTwoChildren(leaf, newLeaf);
        }else {
            Node parent = getNode(leaf.getParent());
            insertNewLeafInParent(newLeaf, parent);
        }
    }
    
    /**
     * Enlaza los nodos izquierdo y derecho.
     * @param leftNode
     * @param rightNode
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws ObjectSizeException 
     */
    private void linkNodes(Node leftNode, Node rightNode)
            throws IOException, FileNotFoundException, ClassNotFoundException, ObjectSizeException
    {
        rightNode.setNext(leftNode.next());
        if(leftNode.next() != null){
            Node leafNext = getNode(leftNode.next()); 
            leafNext.setPrev(rightNode.getPos());
            updateNode(leafNext);
        }
        rightNode.setPrev(leftNode.getPos());
        leftNode.setNext(rightNode.getPos());

        updateNode(leftNode);
        updateNode(rightNode);
    }
    
    /**
     * Crea una nueva raiz con dos hijos (izquierdo y derecho).
     * @param leftNode
     * @param rightNode
     * @throws IOException
     * @throws ObjectSizeException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    private void newRootWithTwoChildren(Node leftNode, Node rightNode)
            throws IOException, ObjectSizeException, FileNotFoundException, ClassNotFoundException
    {
        Node newRoot = new Node(false, maxKeys, keysComparator);
        
        newRoot.setKey(0, (K) rightNode.getKey(0));
        newRoot.setNodeSize(1);

        saveNode(newRoot);
        setNewRoot(newRoot.getPos());

        leftNode.setParent(newRoot.getPos());
        rightNode.setParent(newRoot.getPos());

        updateNode(leftNode);
        updateNode(rightNode);

        newRoot.setChild(0, leftNode.getPos());
        newRoot.setChild(1, rightNode.getPos());

        updateNode(newRoot);
    }
    
    /**
     * Inserta la clave de una nueva hoja en un padre,
     * y enlaza estos dos.
     * @param newLeaf
     * @param parent
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ObjectSizeException
     * @throws ClassNotFoundException 
     */
    private void insertNewLeafInParent(Node newLeaf, Node parent)
            throws IOException, FileNotFoundException, ObjectSizeException, ClassNotFoundException
    {
        newLeaf.setParent(parent.getPos());

        updateNode(newLeaf);

        parent.insertKeyAndChild(newLeaf.getKey(0), newLeaf.getPos());

        updateNode(parent);

        if(parent.getNodeSize() > maxKeys)
            splitInnerNode(parent.getPos());
    }
    
    /**
     * Divide un nodo de manera recursiva hasta que todos
     * los nodos tengan el numero de claves adecuado.
     * @param node 
     */
    private void splitInnerNode(Long nodePos)
            throws IOException, FileNotFoundException, ClassNotFoundException, ObjectSizeException
    {
        Node node = getNode(nodePos);
        
        Node newNode = new Node(false, maxKeys, keysComparator);
        saveNode(newNode);
        
        // Dividir claves/valores del nodo interno
        int k = 0;
        int j;
        for(j = minKeys + 1; j < maxKeys + 1; j++){
            
            Node child = getNode(node.getChild(j));
            child.setParent(newNode.getPos());
            updateNode(child);
            
            newNode.setKey(k, node.getKey(j));
            newNode.setChild(k, child.getPos());
            updateNode(newNode);

            k++;
        }
        Node child = getNode(node.getChild(j));
        child.setParent(newNode.getPos());
        updateNode(child);
        
        newNode.setChild(k, child.getPos());
        updateNode(newNode);
        
        node.setNodeSize(minKeys);
        newNode.setNodeSize(maxKeys - minKeys);
        
        newNode.setNext(node.next());
        if(node.next() != null){
            Node nextNode = getNode(node.getPos());
            nextNode.setPrev(newNode.getPos());
            updateNode(nextNode);
        }
        newNode.setPrev(node.getPos());
        node.setNext(newNode.getPos());
        
        updateNode(node);
        updateNode(newNode);
        
        // Si el nodo no tiene padre, es raiz
        if(node.getParent() == null){
            Node newRoot = new Node(false, maxKeys, keysComparator);
            
            newRoot.setKey(0, (K) node.getKey(minKeys));
            newRoot.setNodeSize(1);
            
            saveNode(newRoot);
            
            setNewRoot(newRoot.getPos());
            
            node.setParent(newRoot.getPos());
            newNode.setParent(newRoot.getPos());
            
            updateNode(node);
            updateNode(newNode);
            
            newRoot.setChild(0, node.getPos());
            newRoot.setChild(1, newNode.getPos());
            
            updateNode(newRoot);

        }else {
            Node parent = getNode(node.getParent());
            newNode.setParent(parent.getPos());
            
            updateNode(newNode);
            
            parent.insertKeyAndChild(node.getKey(minKeys), newNode.getPos());
            
            updateNode(parent);
            
            if(parent.getNodeSize() > maxKeys)
                splitInnerNode(parent.getPos());
        }
    }
    
    /**
     * Elimina una clave de la hoja del arbol.
     * @param key
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws ObjectSizeException 
     */
    public void del(K key)
            throws IOException, FileNotFoundException, ClassNotFoundException, ObjectSizeException
    {        
        // Comprobar si la clave existe
        if(search(key) == null)
            return;

        // Buscar la hoja donde pertenece la clave a eliminar
        Node leaf = getNode(searchLeaf(key));
        
        // Buscar a que nodo del padre pertenece
        int i = searchInParent(leaf);
        
        Node parent = getNode(leaf.getParent());
        
        // Eliminar clave.
        leaf.remove(key);
        updateNode(leaf);
        
        if(i > 0){
            parent.setKey(i - 1, leaf.getKey(0));
            updateNode(parent);
        }
        
        // Si es raiz o cumple con el minimo de valores. Salir.
        if(leaf.getNodeSize() >= minKeys || equalsNodesPos(leaf.getPos(), root))
            return;
        
        // Pedir prestado de hermano izquierdo
        Node leftNode = getNode(leaf.prev());
        if(leftNode != null && equalsParents(leftNode, leaf) && leftNode.getNodeSize() > minKeys){
            int last = leftNode.getNodeSize() - 1;
            leaf.insertKeyAndValue(leftNode.getKey(last), leftNode.getValue(last));
            updateNode(leaf);

            leftNode.setNodeSize(leftNode.getNodeSize() - 1);
            updateNode(leftNode);

            parent.setKey(i - 1, leaf.getKey(0));
            updateNode(parent);
            return;
        }
        
        // Pedir prestado de hermano derecho
        Node rightNode = getNode(leaf.next());
        if(rightNode != null && equalsParents(rightNode, leaf) && rightNode.getNodeSize() > minKeys){
            int first = 0;
            leaf.insertKeyAndValue(rightNode.getKey(first), rightNode.getValue(first));
            updateNode(leaf);

            rightNode.remove(rightNode.getKey(first));
            updateNode(rightNode);

            parent.setKey(i, rightNode.getKey(first));
            updateNode(parent);

            return;
        }
        
        // Merge con vecino izq
        if(leftNode != null && equalsParents(leftNode, leaf) && leftNode.getNodeSize() == minKeys){
            for(int j = 0; j < leaf.getNodeSize(); j++)
                leftNode.insertKeyAndValue(leaf.getKey(j), leaf.getValue(j));
            updateNode(leftNode);

            Node nextNode = getNode(leaf.next());

            if(nextNode != null){
                leftNode.setNext(nextNode.getPos());
                nextNode.setPrev(leftNode.getPos());

                updateNode(nextNode);
                updateNode(leftNode);
            }else {
                leftNode.setNext(null);
                updateNode(leftNode);
            }

            delNode((K) parent.getKey(i - 1), parent.getPos());

            return;
        }
        
        // Merge con vecino derecho
        if(rightNode != null && equalsParents(rightNode, leaf) && rightNode.getNodeSize() == minKeys){
            for(int j = 0; j < rightNode.getNodeSize(); j++)
                leaf.insertKeyAndValue(rightNode.getKey(j), rightNode.getValue(j));
            updateNode(leaf);
            
            Node nextNode = getNode(rightNode.next());
            
            if(nextNode != null){
                leaf.setNext(nextNode.getPos());
                nextNode.setPrev(leaf.getPos());
                
                updateNode(leaf);
                updateNode(nextNode);
            }else {
                leaf.setNext(null);
                updateNode(leaf);
            }
            
            delNode((K) parent.getKey(i), parent.getPos());
        }
    }
    
    /**
     * Elimina una clave de un nodo interno recursivamente.
     * @param key
     * @param nodePos
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws ObjectSizeException 
     */
    private void delNode(K key, Long nodePos)
            throws IOException, FileNotFoundException, ClassNotFoundException, ObjectSizeException
    {
        Node node = getNode(nodePos);
        Node parent = getNode(node.getParent());

        // Buscar posicion de hijo en padre.
        int i = searchInParent(node);
        
        node.remove(key);
        
        updateNode(node);
        
        // Nueva raiz.
        if(node.getNodeSize() == 0 && parent == null){
            Node child = getNode(node.getChild(0));
            child.setParent(null);
            updateNode(child);
            
            setNewRoot(child.getPos());
            return;
        }
        
        if(node.getNodeSize() >= minKeys || equalsNodesPos(node.getPos(), root))
            return;

        // Pedir prestado de hermano izquierdo
        Node leftNode = getNode(node.prev());
        if(leftNode != null && equalsParents(leftNode, node) && leftNode.getNodeSize() > minKeys){
            int last = leftNode.getNodeSize() - 1;
            
            // Correr 1 posicion las claves/valores
            int k = node.getNodeSize() - 1;
            if(k == -1)
                node.setChild(k + 2, node.getChild(k + 1));
            while(k >= 0) {
                node.setKey(k + 1, node.getKey(k));
                node.setChild(k + 2, node.getChild(k + 1));
                node.setChild(k + 1, node.getChild(k));
                k--;
            }
            // Insertar nuevo valor
            Node child = getNode(leftNode.getChild(last + 1));
            node.setKey(0, parent.getKey(i - 1));
            node.setChild(0, child.getPos());
            node.setNodeSize(node.getNodeSize() + 1);
            updateNode(node);

            child.setParent(node.getPos());
            updateNode(child);
            
            leftNode.setNodeSize(leftNode.getNodeSize() - 1);  
            updateNode(leftNode);
            
            // Actualizar padre
            parent.setKey(i - 1, leftNode.getKey(leftNode.getNodeSize()));
            updateNode(parent);
            
            return;
        }
        
        // Pedir prestado de hermano derecho
        Node rightNode = getNode(node.next());
        if(rightNode != null && equalsParents(rightNode, node) && rightNode.getNodeSize() > minKeys){
            int first = 0;

            // Insertar nuevo valor
            Node child = getNode(rightNode.getChild(0));
            node.setKey(node.getNodeSize(), parent.getKey(i));
            node.setChild(node.getNodeSize() + 1, child.getPos());
            node.setNodeSize(node.getNodeSize() + 1);
            updateNode(node);

            child.setParent(node.getPos());
            updateNode(child);
            
            // Actualizar padre
            parent.setKey(i, rightNode.getKey(0));
            updateNode(parent);
            
            // Correr 1 posicion las claves/valores
            int k = 0;
            while(k < rightNode.getNodeSize()) {
                rightNode.setKey(k, rightNode.getKey(k + 1));
                rightNode.setChild(k, rightNode.getChild(k + 1));
                k++;
            }
            
            rightNode.setNodeSize(rightNode.getNodeSize() - 1);
            updateNode(rightNode);
            
            return;
        }
        
        // Merge con vecino izq
        if(leftNode != null && equalsParents(leftNode, node) && leftNode.getNodeSize() == minKeys){
            Node child;
            
            leftNode.setKey(leftNode.getNodeSize(), parent.getKey(i - 1));
            
            child = getNode(node.getChild(0));
            leftNode.setChild(leftNode.getNodeSize() + 1, child.getPos());
            
            child.setParent(leftNode.getPos());
            updateNode(child);
            
            int k = leftNode.getNodeSize() + 1;
            for(int j = 0; j < node.getNodeSize(); j++){
                leftNode.setKey(k, node.getKey(j));
                
                child = getNode(node.getChild(j + 1));
                leftNode.setChild(k + 1, child.getPos());
                
                child.setParent(leftNode.getPos());
                updateNode(child);
                k++;
            }
            leftNode.setNodeSize(maxKeys);
            
            updateNode(leftNode);
            
            leftNode.setNext(node.next());
            if(node.next() != null){
                Node leafNext = getNode(node.next()); 
                leafNext.setPrev(leftNode.getPos());
                updateNode(leafNext);
            }
            updateNode(leftNode);
            
            delNode((K) parent.getKey(i - 1), parent.getPos());
            
            return;
        }
        
        // Merge con vecino derecho
        if(rightNode != null && equalsParents(rightNode, node) && rightNode.getNodeSize() == minKeys){
            
            Node child = getNode(rightNode.getChild(0));

            node.setKey(node.getNodeSize(), parent.getKey(i));
            node.setChild(node.getNodeSize() + 1, child.getPos());
            child.setParent(node.getPos());
            updateNode(child);
            
            int k = node.getNodeSize() + 1;
            for(int j = 0; j < rightNode.getNodeSize(); j++){
                node.setKey(k, rightNode.getKey(j));
                
                child = getNode(rightNode.getChild(j + 1));
                node.setChild(k + 1, child.getPos());
                child.setParent(node.getPos());
                updateNode(child);
                
                k++;
            }
            node.setNodeSize(maxKeys);
            updateNode(node);
            
            node.setNext(rightNode.next());
            if(rightNode.next() != null){
                Node leafNext = getNode(rightNode.next()); 
                leafNext.setPrev(node.getPos());
                updateNode(leafNext);
            }
            updateNode(node);
            
            delNode((K) parent.getKey(i), parent.getPos());
        }
    }
    
    private boolean equalsParents(Node n1, Node n2){
        return n1.getParent().compareTo(n2.getParent()) == 0;
    }
    
    private boolean equalsNodesPos(Long n1, Long n2){
        return n1.compareTo(n2) == 0;
    }
    
    /**
     * Retorna la posicion donde pertenece un nodo como hijo de su padre.
     * @param node
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    private int searchInParent(Node node) throws IOException, FileNotFoundException, ClassNotFoundException{
        Node parent = getNode(node.getParent());
        if(parent == null)
            return 0;
        int i;
        for(i = 0; i < parent.getNodeSize() + 1; i++){
            if(equalsNodesPos(parent.getChild(i), node.getPos()))
                break;
        }
        return i;
    }
    
    /**
     * @return the root
     */
    public Long getRoot() {
        return root;
    }

    /**
     * @return the keysComparator
     */
    public Comparator<K> getComparator() {
        return keysComparator;
    }
    

    @Override
    public String toString() {
        try {
            return toString(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    /**
     * Retorna el árbol recorrido en preorden.
     * @param node
     * @param index
     * @return 
     */
    private String toString(Long nodePos) throws IOException, FileNotFoundException, ClassNotFoundException{
        Node node = getNode(nodePos);
        String str = "";
        str += node.toString();
        
        if(node.getParent() != null)
            str += " padre: (" + node.getParent().toString() + ")";
        
        str += "\n";
        
        if(node.isLeaf())
            return str;
        
        for(int i = 0; i < node.getNodeSize() + 1; i++)
            str += toString(node.getChild(i));
        
        return str;
    }
    
    /**
     * Muestra todos los elementos de las hojas.
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public void showAll() throws IOException, FileNotFoundException, ClassNotFoundException{
        // Buscar primera hoja
        Node leaf = getNode(root);
        while(!leaf.isLeaf())
            leaf = getNode(leaf.getChild(0));
        
        while(leaf != null){
            System.out.print(leaf);
            leaf = getNode(leaf.next());
        }
    }
    
    /**
     * Retorna una coleccion de todos los elementos de las hojas.
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public Collection<Long> values() throws IOException, FileNotFoundException, ClassNotFoundException{
        ArrayList<Long> values = new ArrayList();
        
        // Buscar primera hoja.
        Node leaf = getNode(root);
        while(!leaf.isLeaf())
            leaf = getNode(leaf.getChild(0));
        
        // Recorrer todos los elementos del arbol de forma ordenada.
        while(leaf != null){
            values.addAll(leaf.values());
            leaf = getNode(leaf.next());
        }
        return values;
    }
    
    /**
     * Guarda un nodo al ultimo del archivo.
     * @param node
     * @return
     * @throws IOException
     * @throws ObjectSizeException 
     */
    private Long saveNode(Node node) throws IOException, ObjectSizeException{
        byte[] obj;
        byte[] rest;
        long pos;
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile(PATH, "rw");
            pos = raf.length();
            
            node.setPos(pos);
            
            obj = Tools.serialize(node);
            
            if(obj.length > NODE_SIZE)
                throw new ObjectSizeException(PATH);
            
            raf.seek(pos);
            raf.writeInt(obj.length);
            raf.write(obj);
            
            // Llenar de bytes
            rest = new byte[NODE_SIZE - obj.length + EXTRA_BYTES];
            raf.write(rest);
            
            return pos;
        } finally {
            if(raf != null)
                raf.close();
        }
    }
    
    /**
     * Actualiza un nodo reemplazando el contenido existente en la posicion pos.
     * @param newNode
     * @param pos
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ObjectSizeException 
     */
    private void updateNode(Node newNode, Long pos)
            throws FileNotFoundException, IOException, ObjectSizeException
    {
        byte[] obj;
        byte[] rest;
        RandomAccessFile raf = null;
        try{
            raf = new RandomAccessFile(PATH, "rw");
            newNode.setPos(pos);
            obj = Tools.serialize(newNode);
            
            if(obj.length > NODE_SIZE)
                throw new ObjectSizeException(PATH);
                
            raf.seek(pos);
            raf.writeInt(obj.length);
            raf.write(obj);
            
            // Llenar de bytes
            rest = new byte[NODE_SIZE - obj.length + EXTRA_BYTES];
            raf.write(rest);
            
        } finally {
            if(raf != null)
                raf.close();
        }
    }
    
    /**
     * Actualiza un nodo en su posicion original.
     * @param node
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ObjectSizeException 
     */
    private void updateNode(Node node) throws IOException, FileNotFoundException, ObjectSizeException{
        updateNode(node, node.getPos());
    }
    
    /**
     * Obtiene el nodo almacenado en las posicion pos del archivo.
     * @param pos
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    private Node getNode(Long pos) throws FileNotFoundException, IOException, ClassNotFoundException {
        if(pos == null)
            return null;
        RandomAccessFile raf = null;
        byte[] objByte;
        Node obj;
        try {
            raf = new RandomAccessFile(PATH, "rw");
            
            raf.seek(pos);
            objByte = new byte[raf.readInt()];
            raf.read(objByte);
            
            obj = (Node) Tools.deserialize(objByte);
            return obj;
        } finally {
            if(raf != null)
                raf.close();
        }
    }
}
