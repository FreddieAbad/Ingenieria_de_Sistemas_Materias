import java.util.*;
/**
 *
 * @author freddy
 */
class DivisionSinRestauracion{

    static int a[] = {0,0,0,0,0}, q[] = new int[4], b[] = new int[5], bComplemento2[] = new int[5];

    public static void complementoBin() {
        int i = 4;
        do {
            bComplemento2[i] = b[i];
            i--;
        } while (b[i + 1] != 1);
        while (i >= 0) {
            bComplemento2[i] = (b[i] + 1) % 2;
            i--;
        }
        System.out.print("\n\tComplemento:");
        for (i = 0; i < 5; i++)
            System.out.print(bComplemento2[i]);
        System.out.print("\n");
    }

    public static void funResDiv() {
        moverIzquierda();
        if (a[0] == 0)
            a_menos_b();
        else
            a_mas_b();
        q[3] = (a[0] + 1) % 2;
    }

    public static void moverIzquierda() {
        int i;
        for (i = 0; i < 4; i++)
            a[i] = a[i + 1];
        a[4] = q[0];
        for (i = 0; i < 3; i++)
            q[i] = q[i + 1];
    }

    public static void a_menos_b() {
        int i, acarreo = 0, sum = 0;
        for (i = 4; i >= 0; i--) {
            sum = (a[i] + bComplemento2[i] + acarreo);
            a[i] = sum % 2;
            acarreo = sum / 2;
        }
    }

    public static int[] convertirBinario(int valor){
        int i;
        int[] arrayBinario={0,0,0,0};
        String valorBinString = Integer.toBinaryString(valor);
        char[] auxiliarArray=valorBinString.toCharArray();
        int limite = Math.abs(arrayBinario.length - auxiliarArray.length);
        int j = 0 ;
        for (i=3;i>=limite;i--){
            arrayBinario[i]=Integer.parseInt(String.valueOf(auxiliarArray[j]));
        }
        return (arrayBinario);
    }

    public static int[] convertirBinario5(int valor){
        int i;
        int[] arrayBinario={0,0,0,0,0};
        String valorBinString = Integer.toBinaryString(valor);
        char[] auxiliarArray=valorBinString.toCharArray();
        int limite = Math.abs(arrayBinario.length - auxiliarArray.length);
        int j = 0 ;
        for (i=4;i>=limite;i--){
            arrayBinario[i]=Integer.parseInt(String.valueOf(auxiliarArray[j]));
        }
        return (arrayBinario);
    }

    public static void a_mas_b() {
        int i, acarreo = 0, sum = 0;
        for (i = 4; i >= 0; i--) {
            sum = (a[i] + b[i] + acarreo);
            a[i] = sum % 2;
            acarreo = sum / 2;
        }
    }

    public static void main(String args[]) {
        Scanner src = new Scanner(System.in);
        int i, j, k;
        System.out.print("Ingrese el dividendo\t: ");
        Scanner lectura = new Scanner( System.in );
        int dividendo = lectura.nextInt();
        q=convertirBinario(dividendo);
        System.out.print("Ingrese el divisor\t: ");
        int divisor = lectura.nextInt();
        b=convertirBinario5(divisor);
        System.out.println();
        complementoBin();
        System.out.print("\n\t[Residuo]\t[Cociente]\n");
        for (i = 0; i < 4; i++) {
            funResDiv();
            System.out.print("\t");
            for (j = 0; j < 5; j++)
            {
                System.out.print(a[j]);
            }
            System.out.print("\t\t");
            for (k = 0; k < 4; k++){
                System.out.print(q[k]);
            }
            System.out.print("\n");
        }
        if (a[0] == 1){
            a_mas_b();
        }
        System.out.print("\t");
        for (j = 0; j < 5; j++){
            System.out.print(a[j]);
        }
        System.out.print("\t");
        for (k = 0; k < 4; k++){
            System.out.print(q[k]);
        }
        System.out.print("\n");
        System.out.print("\n\t\tCociente\n");
        String aux="";
        for (k = 0; k < 4; k++){
            aux=aux+q[k];
        }
        System.out.println("\n\nRespuesta: \nBase 10: "+Integer.parseInt(aux,2)+" \t Base 2: "+aux);
        System.out.print("\n\tResiduo\t: ");
        aux="";
        for (j = 0; j < 5; j++){
            aux=aux+a[j];
        }
        System.out.println("\n\nRespuesta: \nBase 10: "+Integer.parseInt(aux,2)+" \t Base 2: "+aux);
        
    }
    
}