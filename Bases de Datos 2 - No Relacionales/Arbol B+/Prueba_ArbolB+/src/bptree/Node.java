/**
 * Node / Nodo
 */
package bptree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

/**
 *
 * @author Santos Gallegos
 * @param <K> Clave
 */
public final class Node<K> implements Serializable {
    private final boolean leaf; // Hoja
    
    private int nodeSize;
    private Long parent;
    private Long next; 
    private Long prev;
    
    private Long pos; // Posicion del nodo dentro del archivo.
    private final K[] keys;
    private final Long[] children; // hijos (valores en caso que sea hoja)
    
    private final int maxKeys;
    private final Comparator<K> keysComparator;

    public Node(boolean leaf, int keysNumber, Comparator<K> comparator) {
        this.leaf = leaf;
        this.nodeSize = 0;
        this.maxKeys = keysNumber;
        this.keys = (K[]) new Object[this.maxKeys + 1];
        this.keysComparator = comparator;
        this.parent = null;
        
        // Si el nodo es hoja se necesitan maxKeys, +1 para realzar la insercion.
        // Si el nodo es interno se necesitan maxKeys + 1, +1 para realizar la insercion.
        if(leaf){
            this.children = new Long[this.maxKeys + 1];
        }else {
            this.children = new Long[this.maxKeys + 2];
        }
    }

    /**
     * Cambia la posicion del nodo.
     * @param pos 
     */
    public void setPos(Long pos) {
        this.pos = pos;
    }
    
    /**
     * 
     * @return posicion del nodo
     */
    public Long getPos() {
        return pos;
    }
    
    /**
     * 
     * @return siguiente nodo hoja/interno.
     */
    public Long next(){
        return next;
    }
    
    /**
     * 
     * @return anterior nodo hoja/interno.
     */
    public Long prev(){
        return prev;
    }
    
    /**
     * Set the next
     * @param node 
     */
    public void setNext(Long node){
        this.next = node;
    }

    /**
     * Set the prev
     * @param prev 
     */
    public void setPrev(Long prev) {
        this.prev = prev;
    }

    /**
     * Cambia el tamaño actual del nodo (número de claves).
     * @param nodeSize 
     */
    public void setNodeSize(int nodeSize) {
        this.nodeSize = nodeSize;
    }
    
    public Long getValue(int index){
        return children[index];
    }

    public void setValue(int index, Long value){
        children[index] = value;
    }
    
    public K getKey(int index){
        return keys[index];
    }
    
    public void setKey(int index, K key){
        keys[index] = key;
    }
    
    public Long getChild(int index){
        return children[index];
    }
    
    public void setChild(int index, Long child){
        children[index] = child;
    }

    /**
     * 
     * @return Tamaño actual del nodo (número de claves).
     */
    public int getNodeSize() {
        return nodeSize;
    }

    public boolean isLeaf() {
        return leaf;
    }
    
    /**
     * Inserta una clave con su respectivo valor.
     * @param key
     * @param value 
     */
    public void insertKeyAndValue(K key, Long value){
        int i = getNodeSize() - 1;
        while(i >= 0 && lessThan(key, getKey(i))){
            keys[i + 1] = keys[i];
            children[i + 1] = children[i];
            i--;
        }
        keys[i + 1] = key;
        children[i + 1] = value;
        nodeSize++;
    }
    
    /**
     * Inserta una clave junto a su hijo (ubicado a la derecha de la clave).
     * @param key
     * @param child 
     */
    public void insertKeyAndChild(K key, Long child){
        int i = getNodeSize() - 1;
        while(i >= 0 && lessThan(key, getKey(i))){
            keys[i + 1] = keys[i];
            children[i + 2] = children[i + 1];
            children[i + 1] = children[i];
            i--;
        }
        keys[i + 1] = key;
        children[i + 2] = child;
        nodeSize++;
    }
    
    /**
     * Elimina una clave; si el nodo es hoja, se elimina su valor;
     * si el nodo no es hoja (interno), se elimina su hijo ubicado
     * a la derecha del nodo.
     * @param key 
     */
    public void remove(K key){
        int i;
        for(i = 0; i < getNodeSize(); i++){
            if(equalsKeys(keys[i], key))
                break;
        }
        
        if(i >= getNodeSize())
            return;
        
        for(int j = i + 1; j < getNodeSize(); j++){
            keys[j - 1] = keys[j];
            if(leaf){
                children[j -1] = children[j];
            }else {
                children[j] = children[j + 1];
            }
        }
        nodeSize--;
    }
    
    private boolean lessThan(K k1, K k2){
        return keysComparator.compare(k1, k2) < 0;
    }
        
    private boolean equalsKeys(K k1, K k2){
        return keysComparator.compare(k1, k2) == 0;
    }
    
    /**
     * @return the parent
     */
    public Long getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(Long parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < getNodeSize(); i++)
            str += keys[i] + " ";
        return str;
    }

    /**
     * Retorna una coleccion con todos los valores del nodo en orden.
     * @return 
     */
    public Collection<Long> values() {
        ArrayList<Long> v = new ArrayList<>();
        for(int i = 0; i < nodeSize; i++)
            v.add(children[i]);
        return v;
    }
}
