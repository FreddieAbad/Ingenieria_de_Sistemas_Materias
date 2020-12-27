package javaapplication9;
import java.util.ArrayList;
public class eje213 {
    private static ArrayList<Integer> distriPri = new ArrayList<>();
    private static int num1 = 0;
    public static int primos[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
        31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
        73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
        127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
        179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
        233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
        283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
        353, 359, 367, 373, 379, 383, 389, 397, 401, 409,
        419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
        467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
        547, 557, 563, 569, 571, 577, 587, 593, 599, 601,
        607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
        661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
        739, 743, 751, 757, 761, 769, 773, 787, 797, 809,
        811, 821, 823, 827, 829, 839, 853, 857, 859, 863,
        877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
        947, 953, 967, 971, 977, 983, 991, 997};
    public static void trialDivision(int[] num, int[] primos) {
        int aux = 0;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < primos.length; j++) {
                if (num[i] % primos[j] == 0) {
                    aux = 1;
                    //2.13 parte 1
                    boolean entre = false;
                    if (distriPri.size() == 0) {
                        distriPri.add(primos[j]);
                    }else if(!distriPri.contains(primos[j])){
                        int cont = 0;
                        for (Integer p : distriPri) {

                            if (p < primos[j]) {
                                distriPri.add(cont , primos[j]);
                                entre  = true;
                                break;
                            }
                            cont++;
                        }
                        if (!entre) {
                            distriPri.add(primos[j]);
                        }    
                    }
                    //parte 2 3.13
                    /*if (primos[j] >= Math.pow(num[i], 1 / 3D)) { //cambiar por 3/4 1/2 1/3
                        System.out.println(primos[j] + " -- " + num[i] + " -- " + Math.pow(num[i], 1 / 3D));
                        num1++;
                        break;
                    }*/
                    //comentar hasta aqui

                }
            }
            if (aux == 0) {
                //System.out.println("El num: "+num[i]+" es primo");     
            }
            aux = 0;
        }

    }

    public static void parte3(int num[], int np) {
        int ni = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] % np == 0) {
                System.out.println(num[i]);
                ni = 158;
            }
        }
        int aux = 0;
        for (int j = 0; j < primos.length; j++) {
            if (ni % primos[j] == 0) {
                //System.out.println("El num: "+num[i]+" es compuesto, por lo tanto no es primo");
                aux = 1;

                //2.13 parte 1
                boolean entre = false;//descomente para realizar la primera parte del 2.13
                if (distriPri.size() == 0) {
                    distriPri.add(primos[j]);
                } else if (!distriPri.contains(primos[j])) {

                    int cont = 0;
                    for (Integer p : distriPri) {

                        if (p < primos[j]) {
                            distriPri.add(cont, primos[j]);
                            entre = true;
                            break;
                        }
                        cont++;
                    }
                    if (!entre) {
                        distriPri.add(primos[j]);
                    }
                }

            }
        }

    }

    public static void main(String[] args) {

        int vectorRango[] = {1000001, 1000002, 1000003, 1000004, 1000005, 1000006, 1000007, 1000008, 1000009, 1000010,
            1000011, 1000012, 1000013, 1000014, 1000015, 1000016, 1000017, 1000018, 1000019, 1000020, 1000021, 1000022,
            1000023, 1000024, 1000025, 1000026, 1000027, 1000028, 1000029, 1000030, 1000031, 1000032, 1000033, 1000034,
            1000035, 1000036, 1000037, 1000038, 1000039, 1000040, 1000041, 1000042, 1000043, 1000044, 1000045, 1000046,
            1000047, 1000048, 1000049, 1000050, 1000051, 1000052, 1000053, 1000054, 1000055, 1000056, 1000057, 1000058,
            1000059, 1000060, 1000061, 1000062, 1000063, 1000064, 1000065, 1000066, 1000067, 1000068, 1000069, 1000070,
            1000071, 1000072, 1000073, 1000074, 1000075, 1000076, 1000077, 1000078, 1000079, 1000080, 1000081, 1000082,
            1000083, 1000084, 1000085, 1000086, 1000087, 1000088, 1000089, 1000090, 1000091, 1000092, 1000093, 1000094,
            1000095, 1000096, 1000097, 1000098, 1000099, 1000100};

        trialDivision(vectorRango, primos);
        //2.13 parte 1
        int cont = 1;
        for (Integer p : distriPri) {
            if(cont % 1 == 0){
                System.out.println("");
                cont = 1;
            }
            cont++;
            System.out.print(p);
        }
        //2.13 parte 2
        //System.out.println(num1);
        //2.13 parte 3
       /* parte3(vectorRango, 947);
        System.out.println(distriPri);*/

    }

}
