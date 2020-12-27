/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Naming;

/**
 *
 * @author USUARIO
 */
public class Servidor {
    public Servidor(){
        try {
            InterfaceRMI i= new ImplementacionRMI();
            Naming.rebind("rmi://localhost//saludo", i);
        }catch(Exception e){
            
        }
    }
    public static void main(String[] args){
        new Servidor();
        
    }
}
