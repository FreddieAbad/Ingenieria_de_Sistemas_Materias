package ejerciciosarquitectura;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class DivisionRestauracion {

    public static int getTamBits(int x) {
        int c = 2;
        if (x <= 1) {
            c = 2;
        } else if (x < 4) {
            c = 2;
        } else if (x < 8) {
            c = 3;
        } else if (x < 16) {
            c = 4;
        } else if (x < 32) {
            c = 5;
        } else if (x < 64) {
            c = 6;
        } else if (x < 128) {
            c = 7;
        } else if (x < 256) {
            c = 8;
        } else if (x < 512) {
            c = 9;
        }
        return c;
    }

    public static int numBitsResultado(int x, int y) {
        if (x < y) {
            return (y);
        } else {
            return (x);
        }
    }

    public static void main(String args[]) {
        Scanner src = new Scanner(System.in);
        int Q, numBitsResultado, M, c1, i, tamDivisor, tamDividendo, bitSignificativoA, S, G, P;
        int[] A = new int[24];
        int[] binarioDivisor = new int[12];
        int[] binarioDivisorCompA2 = new int[12];
        int acarreo = 0, count = 0;
        long num;

        System.out.print("\t\tDivisión con restauración\n");
        System.out.print("\n\nIngrese el dividendo\t: ");
        Q = src.nextInt();
        tamDividendo = getTamBits(Q);
        System.out.print("Ingrese el divisor\t: ");
        M = src.nextInt();
        tamDivisor = getTamBits(M);
        numBitsResultado = numBitsResultado(tamDivisor, tamDividendo);
        System.out.print("\nBits para  resultado    : " + (2 * numBitsResultado + 1));
        for (i = numBitsResultado; i >= 0; i--) {
            binarioDivisorCompA2[i] = binarioDivisor[i] = M % 2;
            M = M / 2;
            binarioDivisorCompA2[i] = 1 - binarioDivisorCompA2[i];
        }
        acarreo = 1;
        for (i = numBitsResultado; i >= 0; i--) {
            c1 = binarioDivisorCompA2[i] ^ acarreo;
            acarreo = binarioDivisorCompA2[i] & acarreo;
            binarioDivisorCompA2[i] = c1;
        }
        for (i = 2 * numBitsResultado; i > numBitsResultado; i--) {
            A[i] = Q % 2;
            Q = Q / 2;
        }
        System.out.print("\n\nDivisor\t\t(M)\t: ");
        for (i = 0; i <= numBitsResultado; i++) {
            System.out.print(binarioDivisor[i] + " ");
        }
        System.out.print("\nDivisor C'2\t(M)\t: ");
        for (i = 0; i <= numBitsResultado; i++) {
            System.out.print(binarioDivisorCompA2[i] + " ");
        }
        System.out.print("\nDividendo\t(Q)\t: ");
        for (i = numBitsResultado + 1; i <= 2 * numBitsResultado; i++) {
            System.out.print(A[i] + " ");
        }
        
        System.out.print("\n\n                   [A]      [Q]      ");
        
        
        System.out.print("\nInit             ");
        for (i = 0; i <= numBitsResultado; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.print(" ");
        for (i = numBitsResultado + 1; i <= 2 * numBitsResultado; i++) {
            System.out.print(A[i] + " ");
        }
        
        count = numBitsResultado;
        do {
            for (i = 0; i < 2 * numBitsResultado; i++) {
                A[i] = A[i + 1];
            }
            System.out.print("\nLeft Shift       ");
            for (i = 0; i <= numBitsResultado; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.print(" ");
            for (i = numBitsResultado + 1; i < 2 * numBitsResultado; i++) {
                System.out.print(A[i] + " ");
            }
            acarreo = 0;
            for (i = numBitsResultado; i >= 0; i--) {
                S = A[i] ^ (binarioDivisorCompA2[i] ^ acarreo);
                G = A[i] & binarioDivisorCompA2[i];
                P = A[i] ^ binarioDivisorCompA2[i];
                acarreo = G | (P & acarreo);
                A[i] = S;
            }
            System.out.print("\nA=A-M            ");
            for (i = 0; i <= numBitsResultado; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.print(" ");
            for (i = numBitsResultado + 1; i < 2 * numBitsResultado; i++) {
                System.out.print(A[i] + " ");
            }
            bitSignificativoA = A[0];
            System.out.print("\nBIT A:" + bitSignificativoA);
            switch (bitSignificativoA) {
                case 0:
                    A[2 * numBitsResultado] = 1;
                    System.out.print(" Q[-]= 1  ");
                    for (i = 0; i <= numBitsResultado; i++) {
                        System.out.print(A[i] + " ");
                    }
                    System.out.print(" ");
                    for (i = numBitsResultado + 1; i <= 2 * numBitsResultado; i++) {
                        System.out.print(A[i] + " ");
                    }
                    break;

                case 1:
                    A[2 * numBitsResultado] = 0;
                    System.out.print(" Q[-]= 0  ");
                    for (i = 0; i <= numBitsResultado; i++) {
                        System.out.print(A[i] + " ");
                    }
                    System.out.print(" ");
                    for (i = numBitsResultado + 1; i < 2 * numBitsResultado; i++) {
                        System.out.print(A[i] + " ");
                    }
                    acarreo = 0;
                    for (i = numBitsResultado; i >= 0; i--) {
                        S = A[i] ^ (binarioDivisor[i] ^ acarreo);
                        G = A[i] & binarioDivisor[i];
                        P = A[i] ^ binarioDivisor[i];
                        acarreo = G | (P & acarreo);
                        A[i] = S;
                    }
                    System.out.print("\nA=A+M            ");
                    for (i = 0; i <= numBitsResultado; i++) {
                        System.out.print(A[i] + " ");
                    }
                    System.out.print(" ");
                    for (i = numBitsResultado + 1; i <= 2 * numBitsResultado; i++) {
                        System.out.print(A[i] + " ");
                    }
                    break;
            }
            count--;
        } while (count != 0);
        num = 0;
        
        
        System.out.print("\n\nCociente en bits     :\t");
        for (i = numBitsResultado + 1; i <= 2 * numBitsResultado; i++) {
            System.out.print(A[i] + " ");
            num = num + (int) Math.pow(2, 2 * numBitsResultado - i) * A[i];
        }
        System.out.print("\tCociente en decimal  :\t" + num);
        num = 0;
        System.out.print("\nResiduo en bits      :\t");
        for (i = 0; i <= numBitsResultado; i++) {
            System.out.print(A[i] + " ");
            num = num + (int) Math.pow(2, numBitsResultado - i) * A[i];
        }
        System.out.print("\tResiduo en decimal   :\t" + num+"\n\n");
    }
}
