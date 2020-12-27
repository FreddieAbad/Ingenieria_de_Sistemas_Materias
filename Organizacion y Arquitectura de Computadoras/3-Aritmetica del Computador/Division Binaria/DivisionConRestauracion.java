package ejerciciosarquitectura;

import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class DivisionRestauracion {

    public static int getsize(int x) {
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

    public static int max(int x, int y) {
        if (x < y) {
            return (y);
        } else {
            return (x);
        }
    }

    public static void main(String args[]) {
        Scanner src = new Scanner(System.in);
        int B, Q, Z, M, c1, i, x, y, ch, S, G, P;
        int[] a = new int[24];
        int[] b = new int[12];
        int[] b1 = new int[12];
        int[] q = new int[12];
        int carry = 0, count = 0;
        long num;

        System.out.print("\t\tDivisión con restauración\n");
        System.out.print("\n\nIngrese el dividendo\t: ");
        Q = src.nextInt();
        y = getsize(Q);
        System.out.print("Ingrese el divisor\t: ");
        M = src.nextInt();
        x = getsize(M);
        Z = max(x, y);
        System.out.print("\nBits para  resultado    : " + (2 * Z + 1));
        for (i = Z; i >= 0; i--) {
            b1[i] = b[i] = M % 2;
            M = M / 2;
            b1[i] = 1 - b1[i];
        }
        carry = 1;
        for (i = Z; i >= 0; i--) {
            c1 = b1[i] ^ carry;
            carry = b1[i] & carry;
            b1[i] = c1;
        }
        for (i = 2 * Z; i > Z; i--) {
            a[i] = Q % 2;
            Q = Q / 2;
        }
        System.out.print("\n\nDivisor\t\t(M)\t: ");
        for (i = 0; i <= Z; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.print("\nDivisor C'2\t(M)\t: ");
        for (i = 0; i <= Z; i++) {
            System.out.print(b1[i] + " ");
        }
        System.out.print("\nDividendo\t(Q)\t: ");
        for (i = Z + 1; i <= 2 * Z; i++) {
            System.out.print(a[i] + " ");
        }
        
        System.out.print("\n\n                   [A]      [Q]      ");
        
        
        System.out.print("\nInit            ");
        for (i = 0; i <= Z; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.print(" ");
        for (i = Z + 1; i <= 2 * Z; i++) {
            System.out.print(a[i] + " ");
        }
        
        count = Z;
        do {
            for (i = 0; i < 2 * Z; i++) {
                a[i] = a[i + 1];
            }
            System.out.print("\nLeft Shift      ");
            for (i = 0; i <= Z; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.print(" ");
            for (i = Z + 1; i < 2 * Z; i++) {
                System.out.print(a[i] + " ");
            }
            carry = 0;
            for (i = Z; i >= 0; i--) {

                //An attempt of using Carry LookAhead Logic for Addition
                S = a[i] ^ (b1[i] ^ carry);
                G = a[i] & b1[i];
                P = a[i] ^ b1[i];
                carry = G | (P & carry);
                a[i] = S;
            }
            System.out.print("\nA=A-M           ");
            for (i = 0; i <= Z; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.print(" ");
            for (i = Z + 1; i < 2 * Z; i++) {
                System.out.print(a[i] + " ");
            }
            ch = a[0];
            System.out.print("\nBIT Q:" + ch);
            switch (ch) {
                case 0:
                    a[2 * Z] = 1;
                    System.out.print(" Q0= -1  ");
                    for (i = 0; i <= Z; i++) {
                        System.out.print(a[i] + " ");
                    }
                    System.out.print(" ");
                    for (i = Z + 1; i <= 2 * Z; i++) {
                        System.out.print(a[i] + " ");
                    }
                    break;

                case 1:
                    a[2 * Z] = 0;
                    System.out.print(" Q0= 0   ");
                    for (i = 0; i <= Z; i++) {
                        System.out.print(a[i] + " ");
                    }
                    System.out.print(" ");
                    for (i = Z + 1; i < 2 * Z; i++) {
                        System.out.print(a[i] + " ");
                    }
                    carry = 0;
                    for (i = Z; i >= 0; i--) {
                        S = a[i] ^ (b[i] ^ carry);
                        G = a[i] & b[i];
                        P = a[i] ^ b[i];
                        carry = G | (P & carry);
                        a[i] = S;
                    }
                    System.out.print("\nA= -A+M         ");
                    for (i = 0; i <= Z; i++) {
                        System.out.print(a[i] + " ");
                    }
                    System.out.print(" ");
                    for (i = Z + 1; i <= 2 * Z; i++) {
                        System.out.print(a[i] + " ");
                    }
                    break;
            }
            count--;
        } while (count != 0);
        num = 0;
        System.out.print("\n\nCociente en bits     :\t");
        for (i = Z + 1; i <= 2 * Z; i++) {
            System.out.print(a[i] + " ");
            num = num + (int) Math.pow(2, 2 * Z - i) * a[i];
        }
        System.out.print("\tCociente en decimal  :\t" + num);
        num = 0;
        System.out.print("\nResiduo en bits      :\t");
        for (i = 0; i <= Z; i++) {
            System.out.print(a[i] + " ");
            num = num + (int) Math.pow(2, Z - i) * a[i];
        }
        System.out.print("\tResiduo en decimal   :\t" + num+"\n\n");
    }
}
