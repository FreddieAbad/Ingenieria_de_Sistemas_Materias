package logica;

import java.util.Arrays;
import tools.OperacionBinario;

/**
 *
 * @author bryan
 */
public class ALU {
    
    public String unoneg = "1111";
    public String unopos = "0001";
    /*Valores de bits para el digito A*/
    public String A0 = "0";
    public String A1 = "0";
    public String A2 = "0";
    public String A3 = "0";
    /*Valores de bits para el digito B*/
    public String B0 = "0";
    public String B1 = "0";
    public String B2 = "0";
    public String B3 = "0";
    /*Valores de bits para la direccion de operación*/
    public String S0 = "0";
    public String S1 = "0";
    public String S2 = "0";
    public String S3 = "0";
    /*Valor del bit de la entrada de control*/
    public String M = "0"; //1 si es lógica, 0 si es aritmética 
    /*Valor del bit de la entrada de control con acarreo*/
    public String CN = "0"; // en caso de M = 0, 1 si no hay acarreo y 0 si hay acarreo
    /*Resultado de la operación con valores de A y B*/
    public String F0 = "0";
    public String F1 = "0";
    public String F2 = "0";
    public String F3 = "0";
    
    public boolean uboAcarreo = false;
    /*Para operaciones binarias*/
    OperacionBinario operaciones = new OperacionBinario();

    /*Operaciones lógicas*/
 /*Puerta AND (A y B)*/
    public String AND(String A, String B) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += logicaAND(A.charAt(i), B.charAt(i));
        }
        return result;
    }

    /*Puerta NOR (ni A, ni B, ni ambos)*/
    public String NOR(String A, String B) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += logicaNOR(A.charAt(i), B.charAt(i));
        }
        return result;
    }

    /*Puerta XNOR*/
    public String XNOR(String A, String B) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += logicaXNOR(A.charAt(i), B.charAt(i));
        }
        return result;
    }

    /*Puerta XNOR*/
    public String NOT_XNOR(String A, String B) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            char xnor = logicaXNOR(A.charAt(i), B.charAt(i));
            result += logicaNOT(xnor);
        }
        return result;
    }

    /*Puerta OR (A o B o ambos)*/
    public String OR(String A, String B) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += logicaOR(A.charAt(i), B.charAt(i));
        }
        return result;
    }

    /*Puerta NAND (No A y B)*/
    public String NAND(String A, String B) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += logicaNAND(A.charAt(i), B.charAt(i));
        }
        return result;
    }

    /*Puerta NOT (no X)*/
    public String NOT_X(String X) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += logicaNOT(X.charAt(i));
        }
        return result;
    }

    /*Puerta XOR (A o B, pero no ambos)*/
    public String XOR(String A, String B) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += logicaXOR(A.charAt(i), B.charAt(i));
        }
        return result;
    }

    /*Puerta NOT (no A)*/
    public String NOT_X_AND_Y(String X, String Y) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            char notx = logicaNOT(X.charAt(i));
            result += logicaAND(notx, Y.charAt(i));
        }
        return result;
    }

    /*Puerta NOT (no A)*/
    public String X_AND_NOT_Y(String X, String Y) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            char noty = logicaNOT(Y.charAt(i));
            result += logicaAND(X.charAt(i), noty);
        }
        return result;
    }

    /*Puerta NOT (no A)*/
    public String A_OR_NOT_B(String X, String Y) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            char noty = logicaNOT(Y.charAt(i));
            result += logicaOR(X.charAt(i), noty);
        }
        return result;
    }

    /*Puerta NOTA or B (no A or B)*/
    public String NOT_X_OR_Y(String X, String Y) {
        String result = "";
        for (int i = 0; i < 4; i++) {
            char notx = logicaNOT(X.charAt(i));
            result += logicaOR(notx, Y.charAt(i));
        }
        return result;
    }

    /*Lógica binaria*/
    public char logicaAND(char x, char y) {
        char resultLogic = ' ';
        if (x == '0' && y == '0') {
            resultLogic = '0';
        }
        if (x == '0' && y == '1') {
            resultLogic = '0';
        }
        if (x == '1' && y == '0') {
            resultLogic = '0';
        }
        if (x == '1' && y == '1') {
            resultLogic = '1';
        }
        return resultLogic;
    }
    
    public char logicaNOR(char x, char y) {
        char resultLogic = ' ';
        if (x == '0' && y == '0') {
            resultLogic = '1';
        }
        if (x == '0' && y == '1') {
            resultLogic = '0';
        }
        if (x == '1' && y == '0') {
            resultLogic = '0';
        }
        if (x == '1' && y == '1') {
            resultLogic = '0';
        }
        return resultLogic;
    }
    
    public char logicaXNOR(char x, char y) {
        char resultLogic = ' ';
        if (x == '0' && y == '0') {
            resultLogic = '1';
        }
        if (x == '0' && y == '1') {
            resultLogic = '0';
        }
        if (x == '1' && y == '0') {
            resultLogic = '0';
        }
        if (x == '1' && y == '1') {
            resultLogic = '1';
        }
        return resultLogic;
    }
    
    public char logicaOR(char x, char y) {
        char resultLogic = ' ';
        if (x == '0' && y == '0') {
            resultLogic = '0';
        }
        if (x == '0' && y == '1') {
            resultLogic = '1';
        }
        if (x == '1' && y == '0') {
            resultLogic = '1';
        }
        if (x == '1' && y == '1') {
            resultLogic = '1';
        }
        return resultLogic;
    }
    
    public char logicaNAND(char x, char y) {
        char resultLogic = ' ';
        if (x == '0' && y == '0') {
            resultLogic = '1';
        }
        if (x == '0' && y == '1') {
            resultLogic = '1';
        }
        if (x == '1' && y == '0') {
            resultLogic = '1';
        }
        if (x == '1' && y == '1') {
            resultLogic = '0';
        }
        return resultLogic;
    }
    
    public char logicaNOT(char x) {
        char resultLogic = ' ';
        if (x == '0') {
            resultLogic = '1';
        }
        if (x == '1') {
            resultLogic = '0';
        }
        return resultLogic;
    }
    
    public char logicaXOR(char x, char y) {
        char resultLogic = ' ';
        if (x == '0' && y == '0') {
            resultLogic = '0';
        }
        if (x == '0' && y == '1') {
            resultLogic = '1';
        }
        if (x == '1' && y == '0') {
            resultLogic = '1';
        }
        if (x == '1' && y == '1') {
            resultLogic = '0';
        }
        return resultLogic;
    }
    
    public String identificarCodigoOperacionLogica(String S, String A, String B) {
        String result = "";
        switch (S) {
            case "0000":
                result = NOT_X(A);
                break;
            case "0001":
                result = NOR(A, B);
                break;
            case "0010":
                result = NOT_X_AND_Y(A, B);
                break;
            case "0011":
                result = "0000";
                break;
            case "0100":
                result = NAND(A, B);
                break;
            case "0101":
                result = NOT_X(B);
                break;
            case "0110":
                result = XNOR(A, B);
                break;
            case "0111":
                result = X_AND_NOT_Y(A, B);
                break;
            case "1000":
                result = NOT_X_OR_Y(A, B);
                break;
            case "1001":
                result = NOT_XNOR(A, B);
                break;
            case "1010":
                result = B;
                break;
            case "1011":
                result = AND(A, B);
                break;
            case "1100":
                result = "0001";
                break;
            case "1101":
                result = A_OR_NOT_B(A, B);
                break;
            case "1110":
                result = OR(A, B);
                break;
            case "1111":
                result = A;
                break;
        }
        return result;
    }
    
    public String identificarCodigoOperacionAritmeticaCN1(String S, String A, String B) {
        String result = "";
        uboAcarreo = false;
        switch (S) {
            case "0000":
                uboAcarreo = false;
                result = A;
                break;
            case "0001":
                
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(A.split(""), B.split("")));
                uboAcarreo = operaciones.isUboAcarreo();
                break;
            case "0010":
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(A.split(""), NOT_X(B).split("")));
                uboAcarreo = operaciones.isUboAcarreo();
                //result = A_OR_NOT_B(A,B);
                break;
            case "0011":
                result = "1111";
                break;
            case "0100":
                //result = OR(A,X_AND_NOT_Y(A,B));
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(A.split(""), X_AND_NOT_Y(A, B).split("")));
                uboAcarreo = operaciones.isUboAcarreo();
                break;
            case "0101":
                String[] suma1 = operaciones.ejecutarSuma(A.split(""), B.split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma1, X_AND_NOT_Y(A, B).split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "0110":
                String resta1[] = operaciones.ejecutarSuma(A.split(""), operaciones.complemento2(B).split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(resta1, unoneg.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                /*PIlas con la resta*/
 /*result = */
                break;
            case "0111":
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(X_AND_NOT_Y(A, B).split(""), unoneg.split("")));
                uboAcarreo = operaciones.isUboAcarreo();
                /*PIlas con la resta*/
 /*result = */
                break;
            case "1000":
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(A.split(""), AND(A, B).split("")));//AND(A, B));
                uboAcarreo = operaciones.isUboAcarreo();
                break;
            case "1001":
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(A.split(""), B.split("")));
                uboAcarreo = operaciones.isUboAcarreo();
                break;
            case "1010":
                String[] suma2 = operaciones.ejecutarSuma(A.split(""), NOT_X(B).split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma2, AND(A, B).split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "1011":
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(AND(A, B).split(""), unoneg.split("")));//AND(A, B));
                uboAcarreo = operaciones.isUboAcarreo();
                /*PIlas con la resta*/
 /*result = */
                break;
            case "1100":
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(A.split(""), A.split("")));//AND(A, B));
                uboAcarreo = operaciones.isUboAcarreo();
                break;
            case "1101":
                String[] suma3 = operaciones.ejecutarSuma(A.split(""), B.split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma3, A.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "1110":
                String[] suma4 = operaciones.ejecutarSuma(A.split(""), NOT_X(B).split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma4, A.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "1111":
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(A.split(""), unoneg.split("")));//AND(A, B));
                uboAcarreo = operaciones.isUboAcarreo();
                /*PIlas con la resta*/
 /*result = */
                break;
        }
        return result;
    }
    
    public String identificarCodigoOperacionAritmeticaCN0(String S, String A, String B) {
        String result = "";
        uboAcarreo = false;
        //String unoBinario[] = {"0", "0", "0", "1"};
        switch (S) {
            case "0000":
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(A.split(""), unoBinario));
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(A.split(""), unopos.split("")));//AND(A, B));
                uboAcarreo = operaciones.isUboAcarreo();
                break;
            case "0001":
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(OR(A, B).split(""), unoBinario));
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(operaciones.ejecutarSuma(A.split(""), B.split("")), unoBinario));
                String[] suma3 = operaciones.ejecutarSuma(A.split(""), B.split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma3, unopos.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "0010":
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarResta(operaciones.ejecutarSuma(A.split(""), NOT_X(B).split("")), unoBinario));
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(A_OR_NOT_B(A,B).split(""), unoBinario));
                String[] suma4 = operaciones.ejecutarSuma(A.split(""), NOT_X(B).split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma4, unopos.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "0011":
                result = "0000";
                break;
            case "0100":
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(OR(A, X_AND_NOT_Y(A, B)).split(""), unoBinario));
                String[] suma5 = operaciones.ejecutarSuma(A.split(""), X_AND_NOT_Y(A, B).split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma5, unopos.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "0101":
                //result = OR(OR(A, B), X_AND_NOT_Y(A, B));
                String[] suma1 = operaciones.ejecutarSuma(A.split(""), B.split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                String[] suma6 = operaciones.ejecutarSuma(suma1, X_AND_NOT_Y(A, B).split(""));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma6, unopos.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "0110":
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(A.split(""), operaciones.complemento2(B).split("")));
                uboAcarreo = operaciones.isUboAcarreo();   
                /*PIlas con la resta*/
 /*result = */
                break;
            case "0111":
                result = X_AND_NOT_Y(A, B);
                uboAcarreo = false;
                break;
            case "1000":
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(OR(A, AND(A, B)).split(""), unoBinario));
                String[] suma7 = operaciones.ejecutarSuma(A.split(""), AND(A, B).split(""));//AND(A, B));
                uboAcarreo = operaciones.isUboAcarreo();
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma7, unopos.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "1001":
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(OR(A, B).split(""), unoBinario));
                String[] suma8 = operaciones.ejecutarSuma(A.split(""), B.split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma8, unopos.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "1010":
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(OR(A_OR_NOT_B(A, B), AND(A, B)).split(""), unoBinario));
                String[] suma2 = operaciones.ejecutarSuma(A.split(""), NOT_X(B).split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                String[] suma9 = (operaciones.ejecutarSuma(suma2, AND(A, B).split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma9, unopos.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "1011":
                result = AND(A, B);
                uboAcarreo = false;
                break;
            case "1100":
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(OR(A, A).split(""), unoBinario));
                String[] suma10 = (operaciones.ejecutarSuma(A.split(""), A.split("")));//AND(A, B));
                uboAcarreo = operaciones.isUboAcarreo();
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma10, unopos.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "1101":
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(OR(OR(A, B), A).split(""), unoBinario));
                String[] suma11 = operaciones.ejecutarSuma(A.split(""), B.split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                String[] suma12 = (operaciones.ejecutarSuma(suma11, A.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma12, unopos.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "1110":
                //result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(OR(A_OR_NOT_B(A, B), A).split(""), unoBinario));
                String[] suma13 = operaciones.ejecutarSuma(A.split(""), NOT_X(B).split(""));
                uboAcarreo = operaciones.isUboAcarreo();
                String[] suma14 = (operaciones.ejecutarSuma(suma13, A.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                result = operaciones.convertArrayToStringMethod(operaciones.ejecutarSuma(suma14, unopos.split("")));
                if (!uboAcarreo) {
                    uboAcarreo = operaciones.isUboAcarreo();
                }
                break;
            case "1111":
                result = A;
                uboAcarreo = false;
                break;
        }
        return result;
    }
}
