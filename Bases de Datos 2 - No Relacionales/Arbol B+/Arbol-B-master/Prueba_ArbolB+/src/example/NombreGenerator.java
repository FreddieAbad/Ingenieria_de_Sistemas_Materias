package example;

import bptree.IndexGenerator;
import java.util.Comparator;

/**
 *
 * @author Santos Gallegos
 */
public class NombreGenerator implements IndexGenerator<Person, String>{

    @Override
    public String getKey(Person obj) {
        return obj.name + obj.lastName;
    }

    @Override
    public Comparator<String> getComparator() {
        return new ComparatorString();
    }
}
