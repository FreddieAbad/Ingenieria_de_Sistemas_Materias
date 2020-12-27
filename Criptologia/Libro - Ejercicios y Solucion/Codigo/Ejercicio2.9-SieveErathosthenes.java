/*
*   Algoritmo 2.3 - Sieve Erathosthenes
*
*/
package algorithms;
import java.util.Arrays;
public class algorithm_2_3 {
    public static void algorithm (Integer n) {
        Integer [] a = new Integer[n+1];
        for (int i = 2; i <= n; i++) 
            a[i] = i;
        Integer j = 2;
        while ( ((int) Math.pow(j,2)) <= n) {
            if (a[j] != 0) { 
                Integer i = 2*j;
                while (i <= n) {
                    a[i]=0;
                    i+=j;
                }
            }
            j++;
        }
        System.out.println("Input: "+n);
        for (int i = 2; i <= n; i++)
            if (a[i] != 0)
                System.out.println("Next Prime: "+a[i]);
    }
    public static void main(String[] args) {
        algorithm(5000);
    }
}
