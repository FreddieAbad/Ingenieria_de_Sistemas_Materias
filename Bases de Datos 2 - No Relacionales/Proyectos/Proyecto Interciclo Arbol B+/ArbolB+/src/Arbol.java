
import java.io.IOException;
import java.util.Comparator;

public class Arbol<K> {

    private static Nodo raiz;
    private final int maxClaves;
    private final int minClaves; // Mínimo de claves que puede tener un nodo (excepto el nodo raiz)
    private final Comparator<K> comparadorClaves;

    public Arbol(int order, Comparator<K> keysComparator) {
        this.maxClaves = order - 1;
        this.minClaves = (int) Math.ceil(order / 2.0) - 1;
        this.comparadorClaves = keysComparator;
    }

    /*Retorna un árbol desde un archivo, si no existe crea uno nuevo vacío.*/
    public static Arbol getArbol(int order, Comparator comparator) {
        Arbol tree = new Arbol(order, comparator);
        Arbol.raiz = new Nodo(true, order - 1, comparator);
        return tree;
    }

    private Nodo buscarHoja(K key) {
        Nodo hoja = raiz;
        int i;
        while (!hoja.isHoja()) {
            i = hoja.getTamanoNodo() - 1;
            while (i >= 0 && comparadorClaves.compare(key, (K) hoja.getClave(i)) < 0) {
                i--;
            }
            hoja = hoja.getHijo(i + 1);
        }
        return hoja;
    }

    /*Agrega un valor, con su respectiva clave al árbol, manteniendo todos sus elementos ordenados por clave. */
    public void agregar(K clave) {
        Nodo hoja = buscarHoja(clave);
        hoja.insertarClaveValor(clave);
        if (hoja.getTamanoNodo() > maxClaves) {
            dividirHoja(hoja);
        }
    }

    /*Divide un nodo hoja, e inserta la nueva clave en su padre. */
    private void dividirHoja(Nodo hoja) {
        Nodo nuevaHoja = new Nodo(true, maxClaves, comparadorClaves);
        // Dividir claves del nodo hoja
        int k = 0;
        for (int j = minClaves; j < maxClaves + 1; j++) {
            nuevaHoja.setClave(k, hoja.getClave(j));
            nuevaHoja.setHijo(k, hoja.getHijo(j));
            k++;
        }
        hoja.setTamanoNodo(minClaves);
        nuevaHoja.setTamanoNodo(maxClaves + 1 - minClaves);
        enlazarNodos(hoja, nuevaHoja);
        if (hoja.getPadre() == null) {
            nuevaRaizConDosHijos(hoja, nuevaHoja);
        } else {
            Nodo parent = hoja.getPadre();
            insertarNuevaHojaEnPadre(nuevaHoja, parent);
        }
    }

    /*Enlaza los nodos izquierdo y derecho.*/
    private void enlazarNodos(Nodo nodoIzquierdo, Nodo nodoDerecho) {
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
        Nodo nuevaRaiz = new Nodo(false, maxClaves, comparadorClaves);
        nuevaRaiz.setClave(0, (K) nodoDerecho.getClave(0));
        nuevaRaiz.setTamanoNodo(1);
        nodoIzquierdo.setPadre(nuevaRaiz);
        nodoDerecho.setPadre(nuevaRaiz);
        nuevaRaiz.setHijo(0, nodoIzquierdo);
        nuevaRaiz.setHijo(1, nodoDerecho);
        raiz = nuevaRaiz;
    }

    /*Inserta la clave de una nueva hoja en un padre, y enlaza estos dos. */
    private void insertarNuevaHojaEnPadre(Nodo nuevaHoja, Nodo padre) {
        nuevaHoja.setPadre(padre);
        padre.insertarClaveEHijo(nuevaHoja.getClave(0), nuevaHoja);
        if (padre.getTamanoNodo() > maxClaves) {
            dividirHastaNodosConClavesAdecuadas(padre);
        }
    }

    /*Divide un nodo de manera recursiva hasta que todos los nodos tengan el numero de claves adecuado.*/
    private void dividirHastaNodosConClavesAdecuadas(Nodo nodoPos) {
        Nodo nodo = nodoPos;
        Nodo nuevoNodo = new Nodo(false, maxClaves, comparadorClaves);
        // Dividir claves/valores del nodo interno
        int k = 0;
        int j;
        for (j = minClaves + 1; j < maxClaves + 1; j++) {
            Nodo hijo = nodo.getHijo(j);
            hijo.setPadre(nuevoNodo);
            nuevoNodo.setClave(k, nodo.getClave(j));
            nuevoNodo.setHijo(k, hijo);
            k++;
        }
        Nodo child = nodo.getHijo(j);
        child.setPadre(nuevoNodo);
        nuevoNodo.setHijo(k, child);
        nodo.setTamanoNodo(minClaves);
        nuevoNodo.setTamanoNodo(maxClaves - minClaves);
        nuevoNodo.setNext(nodo.next());
        if (nodo.next() != null) {
            Nodo nextNode = nodo.next();
            nextNode.setPrev(nuevoNodo);
        }
        nuevoNodo.setPrev(nodo);
        nodo.setNext(nuevoNodo);

        // Si el nodo no tiene padre, es raiz
        if (nodo.getPadre() == null) {
            Nodo nuevaRaiz = new Nodo(false, maxClaves, comparadorClaves);
            nuevaRaiz.setClave(0, (K) nodo.getClave(minClaves));
            nuevaRaiz.setTamanoNodo(1);
            nodo.setPadre(nuevaRaiz);
            nuevoNodo.setPadre(nuevaRaiz);
            nuevaRaiz.setHijo(0, nodo);
            nuevaRaiz.setHijo(1, nuevoNodo);
            raiz = nuevaRaiz;
        } else {
            Nodo padre = nodo.getPadre();
            nuevoNodo.setPadre(padre);
            padre.insertarClaveEHijo(nodo.getClave(minClaves), nuevoNodo);
            if (padre.getTamanoNodo() > maxClaves) {
                dividirHastaNodosConClavesAdecuadas(padre);
            }
        }
    }
    
    @Override
    public String toString() {
        try {
            return "\t" + toString(raiz);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    /*Retorna el árbol recorrido en preorden.*/
    private String toString(Nodo nodo) throws IOException {
        String str = "  ";
        str += nodo.toString();

        if (nodo.getPadre() != null) {
            str += "\tSu padre es: "+ nodo.getPadre().toString();
        }

        str += "\n";
        
        /*if (node.isHoja()) {
            return str;
        } else {
            str += "\n";
        }*/
        
        if (nodo.isHoja()) {
            return str;
        }

        for (int i = 0; i < nodo.getTamanoNodo() + 1; i++) {
            str += toString(nodo.getHijo(i));
        }

        return str;
    }

    /*Muestra todos los elementos de las hojas.*/
    public void mostrarTodo() {
        // Buscar primera hoja
        Nodo hoja = raiz;
        while (!hoja.isHoja()) {
            hoja = hoja.getHijo(0);
        }

        while (hoja != null) {
            System.out.print(hoja);
            hoja = hoja.next();
        }
    }
}
