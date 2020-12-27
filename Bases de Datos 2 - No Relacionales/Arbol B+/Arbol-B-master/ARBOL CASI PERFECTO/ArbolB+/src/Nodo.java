
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public final class Nodo<K> {
    
    private final boolean esHoja; // Hoja
    private int sizeNodo;
    private final int maxNumClaves;
    
    Nodo padre;
    Nodo next;
    Nodo prev;
    
    private final K[] keys;
    private Nodo[] children; // hijos (valores en caso que sea hoja)
    private final Comparator<K> comparatorClaves;

    public Nodo(boolean esHoja, int maxNumClaves, Comparator<K> comparatorClaves) {
        this.esHoja = esHoja;
        this.sizeNodo = 0;
        this.maxNumClaves = maxNumClaves;
        this.comparatorClaves = comparatorClaves;
        this.keys = (K[]) new Object[this.maxNumClaves + 1];
        this.padre = null;
        this.next = null;
        this.prev = null;
        
         // Si el nodo es hoja se necesitan maxKeys, +1 para realzar la insercion.
        // Si el nodo es interno se necesitan maxKeys + 1, +1 para realizar la insercion.
        if (esHoja) {
            this.children = new Nodo[this.maxNumClaves + 1];
        } else {
            this.children = new Nodo[this.maxNumClaves + 2];
        }
    }
    
   
    public boolean isLeaf() {
        return esHoja;
    }
    
    /*retorna Tamaño actual del nodo (número de claves).*/
    public int getSizeNodo() {
        return sizeNodo;
    }
    
    public void setKey(int index, K key) {
        keys[index] = key;
    }
    
    public K getKey(int index) {
        return keys[index];
    }
    
    public Nodo getChild(int index) {
        return children[index];
    }
    
    /*Inserta una clave con su respectivo valor*/
    public void insertarClave_Valor(K key) {
        int i = getSizeNodo() - 1;
        while (i >= 0 && lessThan(key, getKey(i))) {
            keys[i + 1] = keys[i];
            children[i + 1] = children[i];
            i--;
        }
        keys[i + 1] = key;
        sizeNodo++;
    }
    
    private boolean lessThan(K k1, K k2) {
        return comparatorClaves.compare(k1, k2) < 0;
    }
    
    public Nodo getChildren(int index) {
        return children[index];
    }

    public void setChildren(int index, Nodo value) {
        children[index] = value;
    }

    /*Cambia el tamaño actual del nodo (número de claves)*/
    public void setNodeSize(int nodeSize) {
        this.sizeNodo = nodeSize;
    }
    
    /*retorna el pariente*/
    public Nodo getPadre() {
        return padre;
    }

    /*retorna the pariente to set*/
    public void setPadre(Nodo parent) {
        this.padre = parent;
    }
    
    public Nodo next() {
        return next;
    }

    /*retorna anterior nodo hoja/interno.*/
    public Nodo prev() {
        return prev;
    }
    
    /*Set el siguiente nodo*/
    public void setNext(Nodo node) {
        this.next = node;
    }

    /*Set the prev*/
    public void setPrev(Nodo prev) {
        this.prev = prev;
    }
    
    /*Inserta una clave junto a su hijo (ubicado a la derecha de la clave)*/
    public void insertKeyAndChild(K key, Nodo child) {
        int i = getSizeNodo() - 1;
        while (i >= 0 && lessThan(key, getKey(i))) {
            keys[i + 1] = keys[i];
            children[i + 2] = children[i + 1];
            children[i + 1] = children[i];
            i--;
        }
        keys[i + 1] = key;
        children[i + 2] = child;
        sizeNodo++;
    }
    
    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < getSizeNodo(); i++)
            str += keys[i] + " ";
        return str;
    }
}
