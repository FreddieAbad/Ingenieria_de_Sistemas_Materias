/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.*;

/**
 *
 * @author Usuario
 */
public class sumasParciales {

    /*Listas de enteros para almacenar los números binarios*/
    ArrayList<Integer> primerNumero = new ArrayList<Integer>();
    ArrayList<Integer> segundoNumero = new ArrayList<Integer>();

    ArrayList<Integer> productoParcial = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> arrayProductosParciales = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> arraySumasParciales = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> productoFinal = new ArrayList<Integer>();

    public static void main(String[] args) {

        int primerNumBin, segundoNumBin;
        Scanner auxTexto = new Scanner(System.in);
        System.out.println("\t\tMultiplicacion mediante Sumas Parciales");
        System.out.println("\nIntegrantes: Freddy Abad, Bryan Aguilar\n\n");
        /*Guardar valores del usuario en decimal*/
        System.out.print("Ingrese el primer número (dec) : ");
        primerNumBin = auxTexto.nextInt();
        System.out.print("Ingrese el segundo número (dec): ");
        segundoNumBin = auxTexto.nextInt();

        System.out.println("\n------------------ Conversiones ------------------------");
        System.out.println(primerNumBin + " en binario: " + Integer.toBinaryString(primerNumBin));
        System.out.println(segundoNumBin + " en binario: " + Integer.toBinaryString(segundoNumBin));
        System.out.println("--------------------------------------------------------\n");

        /*Instancio mi propia clase para llamar funciones*/
        sumasParciales multiplicacion = new sumasParciales();
        /*Se almacena los números ingresados por el usuario en las listas*/
        multiplicacion.guardarNumBinarios(Integer.toBinaryString(primerNumBin), Integer.toBinaryString(segundoNumBin));
        /*Se realiza la multiplicacion binaria*/
        multiplicacion.Multiplicacion();
    }

    public void guardarNumBinarios(String primerNBin, String segundoNBin) {
        /*Se almacena cada número en binario en la lista*/
        for (int i = 0; i < primerNBin.length(); i++) {
            primerNumero.add(Character.getNumericValue(primerNBin.charAt(i)));
        }
        /*getNumericValue: devuelve el valor int que representa el carácter Unicode especificado*/
        for (int j = 0; j < segundoNBin.length(); j++) {
            segundoNumero.add(Character.getNumericValue(segundoNBin.charAt(j)));
        }
    }

    public void Multiplicacion() {
        for (int i = primerNumero.size() - 1; i >= 0; i--) {
            /*Para cada iteración inicializo la lista de productos parciales
            para la multiplicacion de cada elemento del multiplicador por el
            multiplicando*/
            productoParcial = null;
            productoParcial = new ArrayList<Integer>();
            agregarZerosIzq(primerNumero.size() - 1 - i);
            /*Se realiza la multiplicación de cada elemento del multiplicador
            por todos los elementos del multiplicador*/
            for (int j = segundoNumero.size() - 1; j >= 0; j--) {
                /*El resultado de la multiplicación se almacena en la lista de
                productos parciales*/
                productoParcial.add(primerNumero.get(i) * segundoNumero.get(j));
            }
            agregarZerosDerecha(productoParcial, primerNumero.size(), segundoNumero.size());
            /*Se ubica correctamente la lista de productos parciales*/
            Collections.reverse(productoParcial);
            /*Se agrega a la lista de productos parciales para las posteriores
            sumas parciales*/
            this.arrayProductosParciales.add(productoParcial);
        }
        System.out.println("\n--------------- Productos Parciales  -------------------");
        for (ArrayList<Integer> parcialProduct : arrayProductosParciales) {
            System.out.println(parcialProduct);
        }
        System.out.println("--------------------------------------------------------\n");
        /*Una vez que se tienen las multiplicaciones parciales de cada elemento
        del multiplicador por todos los elementos del multiplicando, se procede
        a hacer las respectivas sumas parciales de 2 en 2*/
        sumParcial();
    }

    /*Agrega el número apropiado de ceros a la izquierda para las posteriores
    sumas parciales*/
    public void agregarZerosIzq(int numZeros) {
        if (numZeros != 0) {
            for (int i = 0; i < numZeros; i++) {
                productoParcial.add(0);
            }
        }
    }

    /*Agrega el número apropiado de ceros a la derecha para las posteriores
    sumas parciales*/
    public void agregarZerosDerecha(ArrayList<Integer> list, int x, int y) {
        int numZeros = (x + y) - list.size() - 1;
        for (int i = 0; i < numZeros; i++) {
            list.add(0);
        }
    }

    /*Se encarga de hacer las sumas parciales de 2 en 2 con los productos parciales
    obtenidos anteriormente*/
    public void sumParcial() {
        if (arrayProductosParciales.size() > 1) {
            /*Se suman los 2 primeros elementos de la lista de productos parciales
            y el resultado se almacena en la lista finalProdcut*/
            sumParcialProducts(arrayProductosParciales.get(0), arrayProductosParciales.get(1));
            /*Una vez sumados los 2 primeros elementos de los productos parciales
            se suma el resultados de los 2 primeros con el siguiente elemento y asi4
            sucesivamente hasta completar con la lsita de productos parciales*/
            for (int i = 2; i < arrayProductosParciales.size(); i++) {
                sumParcialProducts(arrayProductosParciales.get(i), productoFinal);
            }
        } else {
            /*En caso de que solo exista un bit en el multiplicador*/
            for (int i = 0; i < arrayProductosParciales.get(0).size(); i++) {
                productoFinal.add(arrayProductosParciales.get(0).get(i));
            }
        }
        System.out.println("\n----------------- Sumas Parciales  ---------------------");
        for (ArrayList<Integer> sum : arraySumasParciales) {
            System.out.println(sum);
        }
        System.out.println("--------------------------------------------------------\n");

        System.out.println("\n------------------ Resultado ---------------------------");
        String result = "";
        for (Integer j : arraySumasParciales.get(arraySumasParciales.size() - 1)) {
            result += "" + j;
        }
        int numDec = Integer.parseInt(result, 2);
        System.out.println(result + " en decimal: " + numDec);
        System.out.println("--------------------------------------------------------\n");
    }

    public void sumParcialProducts(ArrayList<Integer> elemento1, ArrayList<Integer> elemento2) {
        /*Para cada iteración inicializo la lista de dinalProduct*/
        productoFinal = null;
        productoFinal = new ArrayList<Integer>();
        /*Almacena el resultado de sumar 2 bits*/
        String result = "";
        /*Los acarreos se controlan con una lista*/
        ArrayList<Integer> listAcarreo = new ArrayList<Integer>();
        for (int i = elemento1.size() - 1; i >= 0; i--) {
            result = sumBits(elemento1.get(i), elemento2.get(i));
            /*Controla los acarreos en caso de existir*/
            if (listAcarreo.size() != 0) {
                /*Cuando existe un acarreo, se suma dicho acarreo con los valores
                de las sumas parciales y se asigna al resultado*/
                result = sumBits(Integer.parseInt(result), listAcarreo.get(listAcarreo.size() - 1));
                /*Una vez se haya realizado la suma con el bit de acarreo, se
                elimina de la lista de acarreos*/
                listAcarreo.remove(listAcarreo.size() - 1);
            }

            /*Controla que el resultado de sumar 2 bits de como resultado 10 | 11*/
            if (result.length() == 2) {
                /*En caso de que el resultado sea 10 | 11, se agrega el bit de
                acarreo a la lista de acarreos*/
                listAcarreo.add(Integer.parseInt(result.substring(0, 1)));
                /*Se asigna al resultado el bit menos significativo*/
                result = Character.toString(result.charAt(1));
                /*Finalmente en la lista de producto final se agrega el bit menos
                significativo*/
                productoFinal.add(Integer.parseInt(result));
            } else {
                /*En caso de que el resultado de la suma sea 1 | 0 simplemente
                se agrega a la lista de producto final*/
                productoFinal.add(Integer.parseInt(result));
            }
            result = "";
            /*En caso de existir un acarreo en el primer bit del resultado, se 
            agrega el bit de acarreo al producto final*/
            if (i == 0 && listAcarreo.size() != 0) {
                for (int j = 0; j < listAcarreo.size(); j++) {
                    productoFinal.add(listAcarreo.get(j));
                }
            }
        }
        /*Se colocan correctamente la lista*/
        Collections.reverse(productoFinal);
        //System.out.println("Suma Parcial: " + productoFinal);
        arraySumasParciales.add(productoFinal);
    }

    /*Permite sumar los bits y ayuda a controlar los acarreos*/
    public String sumBits(int x, int y) {
        String returnValue = "";
        if (x == 0 && y == 0) {
            returnValue = "0";
        } else if (x == 1 && y == 0) {
            returnValue = "1";
        } else if (x == 0 && y == 1) {
            returnValue = "1";
        } else if (x == 1 && y == 1) {
            returnValue = "10";
        } else if (x == 1 && y == 10) {
            returnValue = "11";
        } else if (x == 10 && y == 1) {
            returnValue = "11";
        }
        return returnValue;
    }
}
