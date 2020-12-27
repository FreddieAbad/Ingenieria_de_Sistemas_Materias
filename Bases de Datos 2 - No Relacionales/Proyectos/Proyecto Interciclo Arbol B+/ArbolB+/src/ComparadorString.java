
import java.util.Comparator;

class ComparadorString implements Comparator<String> {

    @Override
    public int compare(String caracter1, String caracter2) {
        return caracter1.compareToIgnoreCase(caracter2);
    }   
}
