/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author USUARIO
 */
public class ImplementacionRMI extends UnicastRemoteObject implements InterfaceRMI{

    public ImplementacionRMI () throws RemoteException{
        super();
    }
    
    
    @Override
    public String saludar(String nombre) throws RemoteException {
        return "HOLA "+nombre;
    }
    
}
