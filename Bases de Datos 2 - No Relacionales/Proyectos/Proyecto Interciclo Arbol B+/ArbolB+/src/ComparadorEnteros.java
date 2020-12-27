
import java.util.Comparator;

class ComparadorEnteros implements Comparator<Integer> {

    @Override
    public int compare(Integer num1, Integer num2) {
        return num1.compareTo(num2);
    }
}
