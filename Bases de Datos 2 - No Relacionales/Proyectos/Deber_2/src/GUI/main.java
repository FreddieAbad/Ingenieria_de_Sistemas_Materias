/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Negocio.OracleServidor;
import java.util.Scanner;

/**
 *
 * @author ediss
 */
public class main {
    
    public static OracleServidor dbserver = OracleServidor.getInstance();
    
    public static void main(String[] args) {
        
        /*PARAMETROS
        1.ID_ORDEN
        2.ID_CLIENTE
        3.ID_EMPLEADO
        4.FECHA_ORDEN*/
        //dbserver.insertOrder(13, 71, 1, "16/08/2017");
        
        /*PARAMETROS 
        1.ID_ORDEN
        2.ID_PRODUCTO
        3.CANTIDAD*/
        //dbserver.insertOrderDetails(8, 6, 2);
        Scanner sc = new Scanner(System.in);
        String opc = "";
        do {
            System.out.println("\t\tMENU DE REGISTRO");
            System.out.println("\t1.INGRESAR ORDEN");
            System.out.println("\t2.SALIR");
            System.out.print("\tIngrese una opcion: ");
            opc = sc.nextLine();
            if (opc.equals("1")) {
                ingresar_orden();
            }
        } while (!opc.equals("2")); 
        
        System.out.println("\tCOMPRA REGISTRADA!!");
    }
    
    public static void ingresar_orden () {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\tIngrese el ID de la Orden: ");
        int ord = sc.nextInt();
        System.out.print("\tIngrese el ID del Cliente: ");
        int cli = sc.nextInt();
        System.out.print("\tIngrese el ID del Empleado: ");
        int empl = sc.nextInt();
        sc = new Scanner(System.in);
        System.out.print("\tIngrese la fecha de la orden en formato (DD/MM/YYYY): ");
        String fec = sc.nextLine();
        
        
        dbserver.insertOrder(ord, cli, empl, fec);
        
        String opc = "";
        do {
            System.out.println("\n\t\tMENU DE AGREGADO DE PRODUCTOS");
            System.out.println("\t1.INGRESAR NUEVO PRODUCTO");
            System.out.println("\t2.SALIR");
            System.out.print("\tIngrese una opcion: ");
            sc = new Scanner(System.in);
            opc = sc.nextLine();
            if (opc.equals("1")) {
                System.out.print("\n\tIngrese el ID del Producto: ");
                int prod = sc.nextInt();
                System.out.print("\tIngrese la Cantidad: ");
                int cant = sc.nextInt();
                dbserver.insertOrderDetails(ord, prod, cant);
                System.out.println("\tProducto agregado");
            }
        } while (!opc.equals("2")); 
        
        
        
        
    }
    
}
