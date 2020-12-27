package ejerciciosarquitectura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BinaryMultiplication {

    /*Listas de enteros para almacenar los números binarios*/
    ArrayList<Integer> firstNumber = new ArrayList<Integer>();
    ArrayList<Integer> secondNumber = new ArrayList<Integer>();

    ArrayList<Integer> parcialProduct = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> listOfParcialProducts = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> listOfParcialSums = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> finalProduct = new ArrayList<Integer>();

    public static void main(String[] args) {

        int firstBinaryNumber, secondBinaryNumber;
        Scanner txt = new Scanner(System.in);
        /*Guardar valores del usuario en decimal*/
        System.out.print("Ingrese el primer número  (dec): ");
        firstBinaryNumber = txt.nextInt();
        System.out.print("Ingrese el segundo número (dec): ");
        secondBinaryNumber = txt.nextInt();

        System.out.println("\n------------------ Conversiones ------------------------");
        System.out.println(firstBinaryNumber + " en binario: " + Integer.toBinaryString(firstBinaryNumber));
        System.out.println(secondBinaryNumber + " en binario: " + Integer.toBinaryString(secondBinaryNumber));
        System.out.println("--------------------------------------------------------\n");

        /*Se crea una instancia de la clase BinaryMultiplication*/
        BinaryMultiplication multiply = new BinaryMultiplication();
        /*Se almacena los números ingresados por el usuario en las listas*/
        multiply.saveBinaryNumbers(Integer.toBinaryString(firstBinaryNumber), Integer.toBinaryString(secondBinaryNumber));
        /*Se realiza la multiplicacion binaria*/
        multiply.Multiplication();
    }

    public void saveBinaryNumbers(String firstBinaryNumber, String SecondBinaryNumber) {
        /*Se almacena cada número en binario en la lista*/
        for (int i = 0; i < firstBinaryNumber.length(); i++) {
            firstNumber.add(Character.getNumericValue(firstBinaryNumber.charAt(i)));
        }
        /*getNumericValue: devuelve el valor int que representa el carácter Unicode especificado*/
        for (int j = 0; j < SecondBinaryNumber.length(); j++) {
            secondNumber.add(Character.getNumericValue(SecondBinaryNumber.charAt(j)));
        }
    }

    public void Multiplication() {
        for (int i = firstNumber.size() - 1; i >= 0; i--) {
            /*Para cada iteración inicializo la lista de productos parciales
            para la multiplicacion de cada elemento del multiplicador por el
            multiplicando*/
            parcialProduct = null;
            parcialProduct = new ArrayList<Integer>();
            addZerosLeft(firstNumber.size() - 1 - i);
            /*Se realiza la multiplicación de cada elemento del multiplicador
            por todos los elementos del multiplicador*/
            for (int j = secondNumber.size() - 1; j >= 0; j--) {
                /*El resultado de la multiplicación se almacena en la lista de
                productos parciales*/
                parcialProduct.add(firstNumber.get(i) * secondNumber.get(j));
            }
            addZerosRight(parcialProduct, firstNumber.size(), secondNumber.size());
            /*Se ubica correctamente la lista de productos parciales*/
            Collections.reverse(parcialProduct);
            /*Se agrega a la lista de productos parciales para las posteriores
            sumas parciales*/
            this.listOfParcialProducts.add(parcialProduct);
        }
        System.out.println("\n--------------- Productos Parciales  -------------------");
        for (ArrayList<Integer> parcialProduct : listOfParcialProducts) {
            System.out.println(parcialProduct);
        }
        System.out.println("--------------------------------------------------------\n");
        /*Una vez que se tienen las multiplicaciones parciales de cada elemento
        del multiplicador por todos los elementos del multiplicando, se procede
        a hacer las respectivas sumas parciales de 2 en 2*/
        parcialAddition();
    }

    /*Agrega el número apropiado de ceros a la izquierda para las posteriores
    sumas parciales*/
    public void addZerosLeft(int numZeros) {
        if (numZeros != 0) {
            for (int i = 0; i < numZeros; i++) {
                parcialProduct.add(0);
            }
        }
    }

    /*Agrega el número apropiado de ceros a la derecha para las posteriores
    sumas parciales*/
    public void addZerosRight(ArrayList<Integer> list, int x, int y) {
        int numZeros = (x + y) - list.size() - 1;
        for (int i = 0; i < numZeros; i++) {
            list.add(0);
        }
    }

    /*Se encarga de hacer las sumas parciales de 2 en 2 con los productos parciales
    obtenidos anteriormente*/
    public void parcialAddition() {
        if (listOfParcialProducts.size() > 1) {
            /*Se suman los 2 primeros elementos de la lista de productos parciales
            y el resultado se almacena en la lista finalProdcut*/
            sumParcialProducts(listOfParcialProducts.get(0), listOfParcialProducts.get(1));
            /*Una vez sumados los 2 primeros elementos de los productos parciales
            se suma el resultados de los 2 primeros con el siguiente elemento y asi4
            sucesivamente hasta completar con la lsita de productos parciales*/
            for (int i = 2; i < listOfParcialProducts.size(); i++) {
                sumParcialProducts(listOfParcialProducts.get(i), finalProduct);
            }
        } else {
            /*En caso de que solo exista un bit en el multiplicador*/
            for (int i = 0; i < listOfParcialProducts.get(0).size(); i++) {
                finalProduct.add(listOfParcialProducts.get(0).get(i));
            }
        }
        System.out.println("\n----------------- Sumas Parciales  ---------------------");
        for (ArrayList<Integer> sum : listOfParcialSums) {
            System.out.println(sum);
        }
        System.out.println("--------------------------------------------------------\n");

        System.out.println("\n------------------ Resultado ---------------------------");
        String result = "";
        for (Integer j : listOfParcialSums.get(listOfParcialSums.size() - 1)) {
            result+=""+j;
        }
        int numDec=Integer.parseInt(result,2);
        System.out.println(result+" en decimal: "+numDec);
        System.out.println("--------------------------------------------------------\n");
    }

    public void sumParcialProducts(ArrayList<Integer> elemnto1, ArrayList<Integer> elemento2) {
        /*Para cada iteración inicializo la lista de dinalProduct*/
        finalProduct = null;
        finalProduct = new ArrayList<Integer>();
        /*Almacena el resultado de sumar 2 bits*/
        String result = "";
        /*Los acarreos se controlan con una lista*/
        ArrayList<Integer> listAcarreo = new ArrayList<Integer>();
        for (int i = elemnto1.size() - 1; i >= 0; i--) {
            result = sumBits(elemnto1.get(i), elemento2.get(i));
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
                finalProduct.add(Integer.parseInt(result));
            } else {
                /*En caso de que el resultado de la suma sea 1 | 0 simplemente
                se agrega a la lista de producto final*/
                finalProduct.add(Integer.parseInt(result));
            }
            result = "";
            /*En caso de existir un acarreo en el primer bit del resultado, se 
            agrega el bit de acarreo al producto final*/
            if (i == 0 && listAcarreo.size() != 0) {
                for (int j = 0; j < listAcarreo.size(); j++) {
                    finalProduct.add(listAcarreo.get(j));
                }
            }
        }
        /*Se colocan correctamente la lista*/
        Collections.reverse(finalProduct);
        //System.out.println("Suma Parcial: " + finalProduct);
        listOfParcialSums.add(finalProduct);
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
