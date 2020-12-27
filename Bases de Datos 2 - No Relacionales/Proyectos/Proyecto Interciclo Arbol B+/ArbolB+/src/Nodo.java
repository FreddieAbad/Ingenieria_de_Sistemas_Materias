
import java.util.Comparator;

public final class Nodo<K> {
    
    private final boolean esHoja; // Hoja
    private int tamanoNodo;
    private final int maxNumClaves;
    
    Nodo padre;
    Nodo next;
    Nodo prev;
    
    private final K[] claves;
    private final Nodo[] hijo; // hijos (valores en caso que sea hoja)
    private final Comparator<K> comparadorClaves;

    public Nodo(boolean esHoja, int maxNumClaves, Comparator<K> comparatorClaves) {
        this.esHoja = esHoja;
        this.tamanoNodo = 0;
        this.maxNumClaves = maxNumClaves;
        this.comparadorClaves = comparatorClaves;
        this.claves = (K[]) new Object[this.maxNumClaves + 1];
        this.padre = null;
        this.next = null;
        this.prev = null;
        
         // Si el nodo es hoja se necesitan maxKeys, +1 para realzar la insercion.
        // Si el nodo es interno se necesitan maxKeys + 1, +1 para realizar la insercion.
        if (esHoja) {
            this.hijo = new Nodo[this.maxNumClaves + 1];
        } else {
            this.hijo = new Nodo[this.maxNumClaves + 2];
        }
    }
    
   
    public boolean isHoja() {
        return esHoja;
    }
    
    /*retorna Tamaño actual del nodo (número de claves).*/
    public int getTamanoNodo() {
        return tamanoNodo;
    }
   
    public void setClave(int index, K key) {
        claves[index] = key;
    }
    
    public K getClave(int index) {
        return claves[index];
    }
    
    /*Inserta una clave con su respectivo valor*/
    public void insertarClaveValor(K key) {
        int i = getTamanoNodo() - 1;
        while (i >= 0 && menorQue(key, getClave(i))) {
            claves[i + 1] = claves[i];
            hijo[i + 1] = hijo[i];
            i--;
        }
        claves[i + 1] = key;
        tamanoNodo++;
    }
    
    private boolean menorQue(K k1, K k2) {
        return comparadorClaves.compare(k1, k2) < 0;
    }
    
    public Nodo getHijo(int index) {
        return hijo[index];
    }

    public void setHijo(int index, Nodo value) {
        hijo[index] = value;
    }

    /*Cambia el tamaño actual del nodo (número de claves)*/
    public void setTamanoNodo(int nodeSize) {
        this.tamanoNodo = nodeSize;
    }
    
    /*retorna el pariente*/
    public Nodo getPadre() {
        return padre;
    }

    /*retorna the pariente to set*/
    public void setPadre(Nodo padre) {
        this.padre = padre;
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
    public void insertarClaveEHijo(K key, Nodo child) {
        int i = getTamanoNodo() - 1;
        while (i >= 0 && menorQue(key, getClave(i))) {
            claves[i + 1] = claves[i];
            hijo[i + 2] = hijo[i + 1];
            hijo[i + 1] = hijo[i];
            i--;
        }
        claves[i + 1] = key;
        hijo[i + 2] = child;
        tamanoNodo++;
    }
    
    @Override
    public String toString() {
        String str = "|";
        for(int i = 0; i < getTamanoNodo(); i++)
            str += claves[i]+"|";
        return str;
    }
}
