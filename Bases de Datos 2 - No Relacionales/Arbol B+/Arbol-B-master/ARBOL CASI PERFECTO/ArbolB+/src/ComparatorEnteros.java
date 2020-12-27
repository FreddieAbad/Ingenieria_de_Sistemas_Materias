

import java.io.Serializable;
import java.util.Comparator;

class ComparatorEnteros implements Comparator<Integer>, Serializable {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
