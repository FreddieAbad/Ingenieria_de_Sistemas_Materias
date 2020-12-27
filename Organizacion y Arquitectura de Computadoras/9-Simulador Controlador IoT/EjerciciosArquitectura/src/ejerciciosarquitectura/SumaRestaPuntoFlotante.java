package ejerciciosarquitectura;
import java.util.Scanner;

public class SumaRestaPuntoFlotante {

    public static String expe1 = null;
    public static String expe2 = null;
    public static int e1 = 0;
    public static int e2 = 0;

    public static void main(String[] args) {
        
        int firstBinaryNumber, secondBinaryNumber;
        Scanner txt = new Scanner(System.in);
        System.out.print("Ingrese el primer número  (dec): ");
        firstBinaryNumber = txt.nextInt();
        System.out.print("Ingrese el segundo número (dec): ");
        secondBinaryNumber = txt.nextInt();
        System.out.println("\n------------------ Conversiones ------------------------");
        System.out.println(firstBinaryNumber + " en binario: " + Integer.toBinaryString(firstBinaryNumber));
        System.out.println(secondBinaryNumber + " en binario: " + Integer.toBinaryString(secondBinaryNumber));
        System.out.println("--------------------------------------------------------\n");
        expe1 = Integer.toBinaryString(firstBinaryNumber);
        expe2 = Integer.toBinaryString(secondBinaryNumber);
        operaciones();
    }

    public static void operaciones() {
        String smenor = "", smayor = "", expBinario1 = "", expBinario2 = "", expBin = "";
        
        if (expe1.length() < expe2.length()) {
            smenor = expe1;
            smayor = expe2;
            e1 = smenor.length() - 1;
            e2 = smayor.length() - 1;
        } else {
            smenor = expe2;
            smayor = expe1;
            e1 = smenor.length() - 1;
            e2 = smayor.length() - 1;
        }
        
        expBinario1 = Integer.toBinaryString(e1);
        expBinario2 = Integer.toBinaryString(e2);
        
        smenor = shiftMantiza(smenor);
        System.out.println("Menor: " + quitarCeros(smenor) + " * 2^" + expBinario1);
        smayor = smayor.substring(0, 1) + "," + smayor.substring(1);
        System.out.println("Mayor: " + quitarCeros(smayor) + " * 2^" + expBinario2);
        smenor = smenor.replace(",", "");
        smayor = smayor.replace(",", "");
        int sumaBinaria = Integer.parseInt(smenor, 2) + Integer.parseInt(smayor, 2);
        String sumaBin = Integer.toBinaryString(sumaBinaria);
        /*Colocar bien exponentes del resultado*/
        expBin = normExponentes(sumaBin);
        int restaBinaria = Integer.parseInt(smayor, 2) - Integer.parseInt(smenor, 2);
        String restaBin = Integer.toBinaryString(restaBinaria);
        /*Colocar bien exponentes del resultado*/
        expBin = normExponentes (restaBin);
        restaBin = restaBin.substring(0, 1) + "," + restaBin.substring(1);
        restaBin = quitarCeros(restaBin);
        System.out.println("\nRESTA = " + restaBin + " * 2^" + expBin);
        System.out.println("SUMA  = " + sumaBin + " * 2^" + expBin+"\n");
        
    }
    
    public static String shiftMantiza (String num){ //desplazar mantisa a derecha tantas veces como indique la diferencia en módulo de los exponentes
        String desp = "";
        for (int i = 0; i < Math.abs(e1-e2); i++) {
            if (i == 1) {
                desp += ",0";
            } else {
                desp += "0";
            }
        }
        return desp + num;
    }
    
    public static String normExponentes (String num){
        String expBin = Integer.toBinaryString(num.length() - 1);
        return expBin;
    }

    public static String quitarCeros(String num) {
        int indice = 0;
        for (int i= num.length()-1; i>=0; i--) {
            if (num.charAt(i)=='1'){
                indice = i;
                break;
            }
        }
        num = num.substring(0, indice+1);
        return num;
    }
    
    
}
