/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.InputStreamReader;
import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Cliente {
    public static void main(String[] args) {
        try{
            InterfaceRMI i=(InterfaceRMI)Naming.lookup("rmi://localhost//saludo");
            String nombre;
            Scanner sc= new Scanner(new InputStreamReader(System.in));
            nombre=sc.next();
            
            System.out.println(i.saludar(nombre));
        }catch(Exception e){
            
        }
    }
}
