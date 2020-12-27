
public class algorithm_2_9 {
    public static void main(String[] args) {
        Double n = 13.0;
        Double M = Math.pow(2, n) - 1;
        Double S = 4.0;
        for (int i = 2; i < n ; i++) {
            S = (S * S - 2) % M;
        }
        if (S == 0) {
            System.out.println("El número M = " + M + " es primo");
        }else{
            System.out.println("El número M = " + M + " no es primo");
        }
    }
}
