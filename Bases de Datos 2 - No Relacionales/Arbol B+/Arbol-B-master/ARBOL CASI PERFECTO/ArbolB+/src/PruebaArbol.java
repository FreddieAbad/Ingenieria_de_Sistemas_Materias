
import java.util.ArrayList;

public class PruebaArbol {

    public static void main(String[] args) {
        ArrayList<Integer> n = new ArrayList();

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
        
        /*n.add(10);
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
        */
        
        n.add(2);
        n.add(3);
        n.add(5);
        n.add(7);
        n.add(11);
        n.add(17);
        n.add(19);
        n.add(23);
        n.add(29);
        n.add(31);
        
        

        //Collections.shuffle(n);
        Arbol<Integer> tree2 = null;

        try {
            //tree2 = Arbol.getArbol(5, new ComparatorEnteros());
            tree2 = Arbol.getArbol(3, new ComparatorEnteros());

            System.out.print("Orden de inserccion: ");
            System.out.println();
            for (Integer i : n) {
                System.out.println("INGRESA: "+i + " ");
                tree2.agregar(i);
                System.out.println(tree2);
            }
            System.out.println();
            System.out.println(tree2);

            tree2.mostrarHojas();
            System.out.println();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
