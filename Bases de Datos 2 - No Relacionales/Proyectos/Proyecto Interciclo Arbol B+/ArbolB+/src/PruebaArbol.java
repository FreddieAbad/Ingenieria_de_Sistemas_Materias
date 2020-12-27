
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PruebaArbol {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

        /*List<String> letters = Arrays.asList(new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i",
            "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z"
        });
        
        Arbol<String> tree = null;
        
        try {
            tree = Arbol.getArbol(5, new ComparatorString());            
            System.out.println("Orden de inserción: " + String.join(" ", letters));
            for(int i = 0; i < letters.size(); i++)
                tree.agregar(letters.get(i));
            
            System.out.println(tree);
            tree.mostrarHojas();
            System.out.println();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/
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
        
        Arbol<Integer> tree2 = null;

        try {
            tree2 = Arbol.getArbol(5, new ComparadorEnteros());

            System.out.print("Orden de inserccion: ");
            System.out.println();
            for (Integer i : n) {
                System.out.println("\n\n\tITERACION ");
                System.out.println("Num: "+i);
                tree2.agregar(i);
                System.out.println(tree2);
            }
            System.out.println();
            //System.out.println(tree2);

            tree2.mostrarTodo();
            System.out.println();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        /*UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        VentanaPrincipal arbol = new VentanaPrincipal();
        arbol.setLocationRelativeTo(null);
        arbol.setVisible(true);*/
        
    }
}
