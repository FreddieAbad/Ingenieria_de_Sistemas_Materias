package bptree;

import java.util.Comparator;

/**
 * Clase para especificar que valor tomar de indice de un objeto dado,
 * util para especificar claves secundarias del arbol B+.
 * Nota* Usar con cuidado, tener en cuenta que la clave secundaria debe
 * ser única por cada objeto, se recomienda mezclar con clave primaria.
 * @author Santos Gallegos
 * @param <E> Tipo de objeto
 * @param <V> Tipo de dato del objeto que va a ser indexado.
 */
public interface IndexGenerator<E, V> {
    /**
     * Retorna una clave a partir de un objeto.
     * @param obj
     * @return 
     */
    public V getKey(E obj);
    
    /**
     * Retorna un Comparator que servirá para
     * comparar las claves generadas por getKey.
     * @return 
     */
    public Comparator<V> getComparator();
}
