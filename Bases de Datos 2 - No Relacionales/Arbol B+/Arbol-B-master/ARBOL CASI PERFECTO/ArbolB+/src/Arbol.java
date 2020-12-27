
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;

public class Arbol<K> {
    private  static Nodo raiz;
    private final int maxClaves;
    private final int minClaves; // Mínimo de claves que puede tener un nodo (excepto el nodo raiz)
    private final Comparator<K> keysComparator;

    public Arbol(int order, Comparator<K> keysComparator) {
        this.maxClaves = order - 1;
        this.minClaves = (int) Math.ceil(order / 2.0) - 1;
        this.keysComparator = keysComparator;
    }
    
    /*Retorna un árbol desde un archivo, si no existe crea uno nuevo vacío.*/
    public static Arbol getArbol(int order, Comparator comparator) {
        Arbol tree = new Arbol(order, comparator);
        Arbol.raiz = new Nodo(true, order - 1, comparator);
        return tree;
    }
    
    
    private Nodo buscarHoja(K key) {
        Nodo leaf = raiz;
        int i;
        while (!leaf.isLeaf()) {
            i = leaf.getSizeNodo() - 1;
            while (i >= 0 && keysComparator.compare(key, (K) leaf.getKey(i)) < 0) {
                i--;
            }
            leaf = leaf.getChild(i + 1);
        }
        return leaf;
    }
    
    /*Agrega un valor, con su respectiva clave al árbol, manteniendo todos sus elementos ordenados por clave. */
    public void agregar(K clave) {
        Nodo hoja = buscarHoja(clave);
        hoja.insertarClave_Valor(clave);
        if (hoja.getSizeNodo() > maxClaves) {
            dividirHoja(hoja);
        }
    }
    
    /*Divide un nodo hoja, e inserta la nueva clave en su padre. */
    private void dividirHoja(Nodo hoja) {
        Nodo nuevaHoja = new Nodo(true, maxClaves, keysComparator);
        // Dividir claves y valores del nodo hoja
        int k = 0;
        for (int j = minClaves; j < maxClaves + 1; j++) {
            nuevaHoja.setKey(k, hoja.getKey(j));
            nuevaHoja.setChildren(k, hoja.getChildren(j));
            k++;
        }
        hoja.setNodeSize(minClaves);
        nuevaHoja.setNodeSize(maxClaves + 1 - minClaves);
        enlazarNodos(hoja, nuevaHoja);
        if (hoja.getPadre()== null) {
            nuevaRaizConDosHijos(hoja, nuevaHoja);
        } else {
            Nodo parent = hoja.getPadre();
            insertNewLeafInParent(nuevaHoja, parent);
        }
    }
    
    /*Enlaza los nodos izquierdo y derecho.*/
    private void enlazarNodos(Nodo nodoIzquierdo, Nodo nodoDerecho){
        nodoDerecho.setNext(nodoIzquierdo.next());
        if (nodoIzquierdo.next() != null) {
            Nodo leafNext = nodoIzquierdo.next();
            leafNext.setPrev(nodoDerecho);
        }
        nodoDerecho.setPrev(nodoIzquierdo);
        nodoIzquierdo.setNext(nodoDerecho);
    }
    
    /*Crea una nueva raiz con dos hijos (izquierdo y derecho). */
    private void nuevaRaizConDosHijos(Nodo nodoIzquierdo, Nodo nodoDerecho) {
        Nodo newRoot = new Nodo(false, maxClaves, keysComparator);
        newRoot.setKey(0, (K) nodoDerecho.getKey(0));
        newRoot.setNodeSize(1);
        nodoIzquierdo.setPadre(newRoot);
        nodoDerecho.setPadre(newRoot);
        newRoot.setChildren(0, nodoIzquierdo);
        newRoot.setChildren(1, nodoDerecho);
        raiz=newRoot;
    }
    
    /*Inserta la clave de una nueva hoja en un padre, y enlaza estos dos. */
    private void insertNewLeafInParent(Nodo newLeaf, Nodo parent){
        newLeaf.setPadre(parent);
        parent.insertKeyAndChild(newLeaf.getKey(0), newLeaf);
        if (parent.getSizeNodo() > maxClaves) {
            splitInnerNode(parent);
        }
    }
    
    /*Divide un nodo de manera recursiva hasta que todos los nodos tengan el numero de claves adecuado.*/
    private void splitInnerNode(Nodo nodePos) {
        Nodo node = nodePos;
        Nodo nuevoNodo = new Nodo(false, maxClaves, keysComparator);
        // Dividir claves/valores del nodo interno
        int k = 0;
        int j;
        for (j = minClaves + 1; j < maxClaves + 1; j++) {
            Nodo child = node.getChild(j);
            child.setPadre(nuevoNodo);
            nuevoNodo.setKey(k, node.getKey(j));
            nuevoNodo.setChildren(k, child);
            k++;
        }
        Nodo child = node.getChild(j);
        child.setPadre(nuevoNodo);
        nuevoNodo.setChildren(k, child);
        node.setNodeSize(minClaves);
        nuevoNodo.setNodeSize(maxClaves - minClaves);
        nuevoNodo.setNext(node.next());
        if (node.next() != null) {
            Nodo nextNode = node.next();
            nextNode.setPrev(nuevoNodo);
        }
        nuevoNodo.setPrev(node);
        node.setNext(nuevoNodo);
        
        // Si el nodo no tiene padre, es raiz
        if (node.getPadre()== null) {
            Nodo newRoot = new Nodo(false, maxClaves, keysComparator);
            newRoot.setKey(0, (K) node.getKey(minClaves));
            newRoot.setNodeSize(1);
            node.setPadre(newRoot);
            nuevoNodo.setPadre(newRoot);
            newRoot.setChildren(0, node);
            newRoot.setChildren(1, nuevoNodo);
            raiz=newRoot;
        } else {
            Nodo parent = node.getPadre();
            nuevoNodo.setPadre(parent);
            parent.insertKeyAndChild(node.getKey(minClaves), nuevoNodo);
            if (parent.getSizeNodo() > maxClaves) {
                splitInnerNode(parent);
            }
        }
    }
    
    /*Muestra todos los elementos de las hojas. */
    public void mostrarHojas() throws IOException, FileNotFoundException, ClassNotFoundException {
        // Buscar primera hoja
        Nodo hoja = raiz;
        while (!hoja.isLeaf()) {
            hoja = hoja.getChild(0);
        }
        while (hoja != null) {
            System.out.print(hoja);
            hoja = hoja.next();
        }
    }
    
    
    @Override
    public String toString() {
        try {
            return toString(raiz);
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
    private String toString(Nodo node) throws IOException, FileNotFoundException, ClassNotFoundException{
        String str = "";
        str += node.toString();
        
        if(node.getPadre()!= null)
            str += " padre: (" + node.getPadre().toString() + ")";
        
        str += "\n";
        
        if(node.isLeaf())
            return str;
        
        for(int i = 0; i < node.getSizeNodo()+ 1; i++)
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
        Nodo leaf = raiz;
        while(!leaf.isLeaf())
            leaf = leaf.getChild(0);
        
        while(leaf != null){
            System.out.print(leaf);
            leaf = leaf.next();
        }
    }
    
    /**
     * Retorna una coleccion de todos los elementos de las hojas.
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    
    
}
