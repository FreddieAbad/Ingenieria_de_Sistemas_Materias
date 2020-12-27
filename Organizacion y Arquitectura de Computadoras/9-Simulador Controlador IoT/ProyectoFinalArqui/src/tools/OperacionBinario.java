/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

/**
 *
 * @author bryan
 */
public class OperacionBinario {
    
    private boolean uboAcarreo = false;
    
    public String dec2hexString(int decimal) {
        String hexStr = Integer.toString(decimal, 16);
        return hexStr;
    }
    
    public String cambiarDecimalBinario(int decimal){
        String binario = "";
        while(decimal > 1){
            binario = String.valueOf(decimal % 2) + binario;
            decimal = decimal / 2;
        }
        binario = "1" + binario;
        return binario;
    }
    
    public int cambiarBinarioDecimal(String binario){
        String []binarioVector = binario.split("");
        int entero = 0;
        for (int i = 0; i < binarioVector.length; i++) {
            int numero = Integer.valueOf(binarioVector[i]);
            int potencia = (int)Math.pow(2 ,  binarioVector.length - 1 - i);
            entero += numero * potencia;
        }
        return entero;
    }
    
    public String[] ejecutarSuma(String sumando[] , String sumando2[]) {
        String acarreo = "0";
        uboAcarreo = false;
        String resultado[] = new String[sumando.length];
        for (int i = sumando.length - 1; i >= 0; i--) {
            //Reglas de la suma binaria
            // 0 + 0 = 0
            if (sumando[i].equals("0") && sumando2[i].equals("0")) {
                if (acarreo.equals("0")) {
                    resultado[i] = "0";
                } else {
                    resultado[i] = "1";
                    acarreo = "0";
                }
            }//0 + 1 = 1 o 1 + 0 = 1
            else if (sumando[i].equals("1") && sumando2[i].equals("0") || sumando[i].equals("0") && sumando2[i].equals("1")) {
                if (acarreo.equals("0")) {
                    resultado[i] = "1";
                } else {
                    resultado[i] = "0";
                    acarreo = "1";
                }
            }//1 + 1 = 0
            else if (sumando[i].equals("1") && sumando2[i].equals("1")) {
                if (acarreo.equals("0")) {
                    resultado[i] = "0";
                    acarreo = "1";
                } else {
                    resultado[i] = "1";
                    acarreo = "1";
                }
            }
        }
        if (acarreo.equals("1") && resultado[0].equals("1")) {
            uboAcarreo = true;
        }
        
        return resultado;
        
    }
    
    
    public String[] ejecutarResta(String minuendo[] , String sustraendo[]){
        String resto[] = new String[minuendo.length];
        String acarreo = "0";
        for (int i = minuendo.length - 1; i >= 0; i--) {
            //Reglas de la suma binaria
            // 0 - 0 = 0
            if (minuendo[i].equals("0") && sustraendo[i].equals("0")) {
                if (acarreo.equals("0")) {
                    resto[i] = "0";
                } else {
                    resto[i] = "1";
                    acarreo = "1";
                }
            }//0 - 1 = 1
            else if (minuendo[i].equals("0") && sustraendo[i].equals("1")) {
                if (acarreo.equals("0")) {
                    resto[i] = "1";
                    acarreo = "1";
                } else {
                    resto[i] = "0";
                    acarreo = "1";
                }
            }//1 - 0 = 1
            else if (minuendo[i].equals("1") && sustraendo[i].equals("0")) {
                if (acarreo.equals("0")) {
                    resto[i] = "1";
                } else {
                    resto[i] = "0";
                    acarreo = "0";
                }
            }//1 - 1 = 0         
            else if (minuendo[i].equals("1") && sustraendo[i].equals("1")) {
                if (acarreo.equals("0")) {
                    resto[i] = "0";
                } else {
                    resto[i] = "1";
                    acarreo = "1";
                }
            }
        }
        
        return resto;
    }
    
    
    public String resultadoBinario(String []binario){
        String resultado = "";
        for (int i = 0; i < binario.length; i++) {
            resultado += binario[i];
        }
        
        return resultado;
    }
    
    public String[] cambiarLogitudPalabra(String binario , int longitud){
        int ceros = longitud - binario.length();
        for (int i = 0; i < ceros; i++) {
            binario = "0" + binario; 
        }     
        return binario.split("");
    }
    
    public String[] moverDerecha(String binario[] , boolean guardarSigno){
        for (int i = binario.length - 1; i > 0; i--) {
            binario[i] = binario[i-1];
        }
        
        if (!guardarSigno) {
            binario[0] = "0";
        }
        
        return binario;
    }
    
    public String[] moverIzquierda(String binario[]){
        for (int i = 0; i < binario.length - 1; i++) {
            binario[i] = binario[i+1];
        }
        binario[binario.length - 1] = "0";
        
        return binario;
    }
    
    public void llenarCeros(String vector[]){
        for (int i = 0; i < vector.length; i++) {
            vector[i] = "0";
        }
    }
    
    public boolean mayorQue(String bin1 , String bin2){
        int dec1 = cambiarBinarioDecimal(bin1);
        int dec2 = cambiarBinarioDecimal(bin2);
        if (dec1 >= dec2) {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String crearLinea(String[] vec){
        String linea = "-";
        
        for (int i = 0; i < vec.length; i++) {
            linea += "-";
        }
        
        return linea;
    }
    
    public String partelFraccionaria(String parteFraccioneria , int presicion){
        String numeroTxt = "0." + parteFraccioneria;
        float numero = Float.valueOf(numeroTxt);
        String numeroBinario = ""; 
        
        for (int i = 0; i < presicion; i++) {
            numero = numero * 2;
            int parteEntera = (int)numero;
            numeroBinario = String.valueOf(parteEntera) + numeroBinario;
            numero = Float.valueOf("0" + String.valueOf(numero).substring(1));
        }
        
        return numeroBinario;
    }
    
    public String deDecimalFracionarioBinario(float numero , int presicion){
        String numeroDecimalFraccionario = String.valueOf(numero);
        String binarioVec[] = numeroDecimalFraccionario.split("\\.");
        String decimal = binarioVec[0];
        String fraccionaria = binarioVec[1];
        
        String decimalBinario = cambiarDecimalBinario(Integer.valueOf(decimal));
        String fraccionariaBinario = partelFraccionaria(fraccionaria, presicion);
        
        return decimalBinario + "." + fraccionariaBinario;
    }
    
    public String complemento2(String binario){
        System.out.println("Original: " + binario);
        
        binario = binario.replace("0", "2");
        binario = binario.replace("1", "0");
        binario = binario.replace("2", "1");
        System.out.println("Remplazo 1 por 0 y 0 por 1: " + binario);
        String binFinal = "1";
        for (int i = 0; i < binario.length()-1; i++) {
            binFinal = "0" + binFinal;
        } 
        String resultado = resultadoBinario(ejecutarSuma(binario.split(""), binFinal.split("")));
        System.out.println("Sumo: " + binario + " + " + "1 = " + resultado);
        return resultado;
    }

    /**
     * @return the uboAcarreo
     */
    public boolean isUboAcarreo() {
        return uboAcarreo;
    }
    
    public String convertArrayToStringMethod(String[] strArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArray.length; i++) {
            stringBuilder.append(strArray[i]);
        }
        return stringBuilder.toString();
    }   
}