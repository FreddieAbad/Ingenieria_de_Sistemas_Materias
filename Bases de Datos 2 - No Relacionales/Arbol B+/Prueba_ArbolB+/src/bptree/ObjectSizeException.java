package bptree;

import java.io.File;

/**
 * 
 * @author Santos Gallegos
 */
public class ObjectSizeException extends Exception {

    public ObjectSizeException(File path) {
        super("Tamaño de objeto mayor al asignado. " + path);
    }
    
}
