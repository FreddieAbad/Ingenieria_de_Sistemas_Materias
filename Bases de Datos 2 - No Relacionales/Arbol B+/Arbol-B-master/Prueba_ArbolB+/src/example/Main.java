/**
 * Ejemplo de uso del árbol B+.
 */
package example;

import bptree.BPTree;
import bptree.BPTreeMap;
import bptree.Tools;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Santos Gallegos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // Ruta donde se manejará la tabla de valores.
        String dataPath = "data/persons.dat";
        
        // Ruta donde se manejara tabla de índices.
        String treePath = "data/persons_lastname_index.dat";
        
        // Ruta donde se manejara la tabla de indice secundario.
        String treePathSec = "data/persons_name_index.dat";
        
        File dir = new File("data");
        dir.mkdir();
        
        
        /********************************************************************
         * Uso del árbol B+ con archivos (tabla de índices primaria/secundaria
         * y tabla de valores).
        *********************************************************************/
        
        // Objetos de prueba.
        /*Person p1 = new Person("0003", "Perez000", 25);
        Person p2 = new Person("0002", "Perez001", 33);
        Person p3 = new Person("0001", "Perez002", 33);
        Person p4 = new Person("0000", "Perez003", 33);
               
        // Obtener tamaño del objeto serializado
        // (113 en el caso de los objetos de prueba creados).
        // * Si el objeto varía con el tiempo, escoger un tamaño
        // límite superior al obtenido.
        
        /*try {
            byte[] b;
            b = Tools.serialize(p1);
            System.out.println(b.length);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/
        
               
        // Declarar arbol con el tipo de clave y el tipo de objeto a almacenar.

        /*BPTreeMap<String, Person> bpTreeMap = null;
        try {
            // Crear arbol
            bpTreeMap = BPTreeMap.getTree(3, new ComparatorString(), dataPath, treePath, 300, 1500);
            
            // Agregar tabla de indice secundaria
            bpTreeMap.addSecIndex(treePathSec, new NombreGenerator(), 1500);
            
            // Agregamos objetos al arbol
            bpTreeMap.put(p3.lastName, p3);
            bpTreeMap.put(p4.lastName, p4);
            bpTreeMap.put(p1.lastName, p1);
            bpTreeMap.put(p2.lastName, p2);

            // Recuperamos
            System.out.println("Obtenido usuando get");
            System.out.println(bpTreeMap.get(p2.lastName));
            
            System.out.println("De tabla de indice primaria (Ordenados por apellidos).");
            for(Person p : bpTreeMap.values())
                System.out.println(p);
            
            System.out.println("De tabla de indice sec (Ordenados por nombre).");
            for(Person p : bpTreeMap.valuesOf(0))
                System.out.println(p);
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/
        
        
        /*********************************************************************
         *  Uso de árbol B+ solo con archivo de indice.
        *********************************************************************/
        
        // Prueba con claves de tipo String

        List<String> letters = Arrays.asList(new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z"
        });
        //Collections.shuffle(letters);
        
        BPTree<String> tree = null;
        
        try {
            tree = BPTree.getTree(3, new ComparatorString(), treePath, 1500);
            
            System.out.println("Orden de inserción: " + String.join(" ", letters));
            for(int i = 0; i < letters.size(); i++)
                tree.add(letters.get(i), 0L);
            
            System.out.println(tree);
            
            tree.showAll();
            System.out.println();
        
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        
        
        // Prueba con claves de tipo entero.
        
        //ArrayList<Integer> n = new ArrayList();
        /*for(int i = 0; i < 5; i++)
            n.add(i);*/
        
        //7,25,27,15,23,19,14,29,10, 50,18,22,46,17,70,33 y 58
        
        /*n.add(7);
        n.add(25);
        n.add(27);
        n.add(15);
        n.add(23);
        n.add(19);
        n.add(14);
        n.add(29);
        n.add(10);
        n.add(50);
        n.add(18);
        n.add(22);
        n.add(46);
        n.add(17);
        n.add(70);
        n.add(33);
        n.add(58);*/
        /*
        n.add(10);
        n.add(27);
        n.add(29);
        n.add(17);
        n.add(25);
        n.add(21);
        n.add(15);
        n.add(31);
        n.add(13);
        n.add(51);
        n.add(20);
        n.add(24);
        n.add(48);
        n.add(19);
        n.add(54);
        /*n.add(35);
        n.add(66);*/
        
        /*file:///C:/Users/USER/Downloads/EDD%20-%20Cap5.5%20Arboles%20B.pdf*/
        
        //Collections.shuffle(n);
        /*
        BPTree<Integer> tree2 = null;
        
        try {
            tree2 = BPTree.getTree(5, new ComparatorInt(), treePath, 1000);
            
            System.out.print("Orden de inserccion: ");
            for (Integer i : n){
                System.out.println(i + " ");
                tree2.add(i, 0L);
            }
            System.out.println();
            System.out.println(tree2);

            tree2.showAll();
            System.out.println();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/
    }
}
